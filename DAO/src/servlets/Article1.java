package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import Beans.Article;
import DAO.*;


/**
 * Servlet implementation class Article
 */
@WebServlet("/Article1")
public class Article1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public static final String CONF_DAO_FACTORY = "daofactory";
	 public static final String ATT_FORM         = "form";
	 public static final String ATT_art        = "article";
	 public static final String VUE              = "/Article1.jsp";
	    private static final String ALGO_CHIFFREMENT = "SHA-256";
	    private ArticleDao     	articleDao;
	    Vector<Beans.Article> listeArticle;
	  public void init() throws ServletException {
	        /* Récupération d'une instance de notre DAO Article */
	        this.articleDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getArticleDao();
	       
	  }
    public Article1() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listeArticle=articleDao.getAll();
			System.out.println("************************");
			for (int j = 0; j <listeArticle.size(); j++) {
				
				System.out.println(listeArticle.get(j).getNom_a());
			}
			request.setAttribute("listeArticles",listeArticle);
System.out.println("aaaaaa");
			request.getServletContext().getRequestDispatcher(VUE).forward(request, response);
			System.out.println("aaaaaa");
			//response.sendRedirect("www.google.com");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
	}

}
