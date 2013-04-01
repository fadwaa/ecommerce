package Forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import Beans.Client;
import DAO.DAOException;
import DAO.DAOFactory;
import DAO.ClientDao;
import Forms.FormValidationException;
import Forms.InscriptionForm;

public final class InscriptionForm {
    private static final String CHAMP_EMAIL      = "email";
    private static final String CHAMP_PASS       = "motdepasse";
    private static final String CHAMP_CONF       = "confirmation";
    private static final String CHAMP_NOM        = "nom";
    private static final String CHAMP_login        = "login";

    private static final String ALGO_CHIFFREMENT = "SHA-256";

    private String              resultat;
    private Map<String, String> erreurs          = new HashMap<String, String>();
    private ClientDao      clientDao;

    public InscriptionForm( ClientDao clientDao ) {
        this.clientDao = clientDao;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public String getResultat() {
        return resultat;
    }

    public Client inscrireClient( HttpServletRequest request ) {
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        String confirmation = getValeurChamp( request, CHAMP_CONF );
        String nom = getValeurChamp( request, CHAMP_NOM );
        String login= getValeurChamp( request, CHAMP_login );
        
        Client client = new Client();
        client.setLogin(login);
        try {
            traiterEmail( email, client );
            traiterMotsDePasse( motDePasse, confirmation, client );
            traiterNom( nom, client );

            if ( erreurs.isEmpty() ) {
                clientDao.creer( client );
                resultat = "SuccÈe de l'inscription.";
            } else {
                resultat = "Echec de l'inscription.";
            }
        } catch ( DAOException e ) {
            resultat = "Echec de l'inscription : une erreur  est survenue, merci de rÈssayer dans quelques instants.";
            e.printStackTrace();
        }

        return client;
    }

    /*
     * Appel √  la validation de l'adresse email re√ßue et initialisation de la
     * propri√©t√© email du bean
     */
    private void traiterEmail( String email, Client client ) {
        try {
            validationEmail( email );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        client.setEmail( email );
    }

    /*
     * Appel √  la validation des mots de passe re√ßus, chiffrement du mot de
     * passe et initialisation de la propri√©t√© motDePasse du bean
     */
    private void traiterMotsDePasse( String motDePasse, String confirmation, Client client ) {
        try {
            validationMotsDePasse( motDePasse, confirmation );
        } catch ( FormValidationException e ) {
        	System.out.println("jj");
            setErreur( CHAMP_PASS, e.getMessage() );
            setErreur( CHAMP_CONF, null );
        }

        /*
         * Utilisation de la biblioth√®que Jasypt pour chiffrer le mot de passe
         * efficacement.
         * 
         * L'algorithme SHA-256 est ici utilis√©, avec par d√©faut un salage
         * al√©atoire et un grand nombre d'it√©rations de la fonction de hashage.
         * 
         * La String retourn√©e est de longueur 56 et contient le hash en Base64.
         */
        ConfigurablePasswordEncryptor passwordEncryptor = new ConfigurablePasswordEncryptor();
        passwordEncryptor.setAlgorithm( ALGO_CHIFFREMENT );
        passwordEncryptor.setPlainDigest( false );
        String motDePasseChiffre = passwordEncryptor.encryptPassword( motDePasse );

        client.setMotDePasse( motDePasseChiffre );
    }

    /*
     * Appel √  la validation du nom re√ßu et initialisation de la propri√©t√© nom
     * du bean
     */
    private void traiterNom( String nom, Client client ) {
        try {
            validationNom( nom );
        } catch ( FormValidationException e ) {
            setErreur( CHAMP_NOM, e.getMessage() );
        }
        client.setNom( nom );
    }

    /* Validation de l'adresse email */
    private void validationEmail( String email ) throws FormValidationException {
        if ( email != null ) {
            if ( !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
                throw new FormValidationException( "Merci de saisir une adresse mail valide." );
            } else if ( clientDao.trouver( email ) != null ) {
                throw new FormValidationException( "Cette adresse email est dÈja utilisÈe, merci d'en choisir une autre." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir une adresse mail valide." );
        }
    }

    /* Validation des mots de passe */
    private void validationMotsDePasse( String motDePasse, String confirmation ) throws FormValidationException {
        if ( motDePasse != null && confirmation != null ) {
            if ( !motDePasse.equals( confirmation ) ) {
                throw new FormValidationException( "Les mots de passe entrÈes sont diffÈrents, merci de les saisir ‡ nouveau." );
            } else if ( motDePasse.length() < 3 ) {
                throw new FormValidationException( "Les mots de passe doivent contenir au moins 3 caract√®res." );
            }
        } else {
            throw new FormValidationException( "Merci de saisir et confirmer votre mot de passe." );
        }
    }

    /* Validation du nom */
    private void validationNom( String nom ) throws FormValidationException {
        if ( nom != null && nom.length() < 3 ) {
            throw new FormValidationException( "Le nom d'utilisateur doit contenir au moins 3 caract√®res." );
        }
    }

    /*
     * Ajoute un message correspondant au champ sp√©cifi√© √  la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M√©thode utilitaire qui retourne null si un champ est vide, et son contenu
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
