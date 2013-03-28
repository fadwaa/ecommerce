package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jasypt.util.password.ConfigurablePasswordEncryptor;

import Beans.Client;
import DAO.DAOException;
import DAO.DAOFactory;
import DAO.ClientDao;
import Forms.FormValidationException;
import Forms.InscriptionForm;
import Forms.InscriptionForm.*;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String CONF_DAO_FACTORY = "daofactory";
	    public static final String ATT_USER         = "client";
	    public static final String ATT_FORM         = "form";
	    public static final String VUE              = "/WEB-INF/inscription.jsp";
	    private static final String ALGO_CHIFFREMENT = "SHA-256";
	    private ClientDao     clientDao;
	 
	    public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Utilisateur */
	        this.clientDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getClientDao();
	    }
  
    public Inscription() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 /* Affichage de la page d'inscription */
		//response.sendRedirect(VUE);
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/* Préparation de l'objet formulaire */
        InscriptionForm form = new InscriptionForm( clientDao );
 
        /* Traitement de la requête et récupération du bean en résultant */
        Client client = form.inscrireClient( request );
 
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_USER, client );
        // response.sendRedirect(VUE);
        this.getServletContext().getRequestDispatcher( VUE ).forward(request, response);
        
	}

	

}
