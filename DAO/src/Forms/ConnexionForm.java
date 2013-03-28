package Forms;

import java.util.HashMap;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
 
import Beans.Client;
import DAO.ClientDao;
 
public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
 
    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
	private ClientDao clientDao;
 
    public String getResultat() {
        return resultat;
    }
 
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    public ConnexionForm( ClientDao clientDao ) {
        this.clientDao = clientDao;
    }
 
    public Client connecterClient( HttpServletRequest request ) {
        /* R�cup�ration des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motdepasse = getValeurChamp( request, CHAMP_PASS );
 
        Client client = new Client();
 
        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( email );
 
        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motdepasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        client.setMotDePasse( motdepasse );
 
        /* Initialisation du r�sultat global de la validation. */
        if ( erreurs.isEmpty() ) {
        	Client client1 =clientDao.getClient( email,motdepasse);
        	if(client1!=null)
            resultat = "Succ�s de la connexion.";
        } else {
            resultat = "�chec de la connexion.";
        }
 
        return client;
    }
 
    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }
 
    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caract�res." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
 
    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
 
    /*
     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
