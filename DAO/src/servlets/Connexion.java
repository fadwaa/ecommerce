package servlets;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
import Beans.Client;
import DAO.ClientDao;
import DAO.DAOFactory;
import Forms.ConnexionForm;
 
public class Connexion extends HttpServlet {
    public static final String ATT_USER         = "utilisateur";
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_FORM         = "form";
    public static final String ATT_SESSION_USER = "sessionUtilisateur";
    public static final String VUE              = "/WEB-INF/connexion.jsp";
    private ClientDao     clientDao;
    public void init() throws ServletException {
        /* Récupération d'une instance de notre DAO Utilisateur */
        this.clientDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getClientDao();
    }
    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Affichage de la page de connexion */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
 
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /* Préparation de l'objet formulaire */
        ConnexionForm form = new ConnexionForm(clientDao);
 
        /* Traitement de la requête et récupération du bean en résultant */
        Client client = form.connecterClient( request );
 
        /* Récupération de la session depuis la requête */
      //  HttpSession session = request.getSession();
 
        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */
       /* if ( form.getErreurs().isEmpty() ) {
            session.setAttribute( ATT_SESSION_USER, client );
        } else {
            session.setAttribute( ATT_SESSION_USER, null );
        }*/
 
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );
 
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }
}