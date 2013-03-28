package servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import listes.Catalogue;

import DAO.ArticleDao;
import DAO.DAOFactory;
import Beans.*;

@WebServlet(name = "PasserDAO", loadOnStartup = 1, urlPatterns = { "/index",
		"/panier", "/categorie" })
public class Controlleur extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String CONF_DAO_FACTORY = "daofactory";
	public static final String ATT_FORM = "form";
	public static final String ATT_art = "article";
	// public static final String VUE = "/WEB-INF/test.jsp";
	private ArticleDao articleDao;
	Vector<Beans.Article> listeArticle;
	Catalogue c;

	public Controlleur() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		super.init();
		this.articleDao = ((DAOFactory) getServletContext().getAttribute(
				CONF_DAO_FACTORY)).getArticleDao();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			c = new Catalogue(articleDao);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String userPath = request.getServletPath();
		if (userPath.equals("/index")) {
		listeArticle = c.getListeArticle();
		request.setAttribute("listeArticles", listeArticle);

		request.getServletContext().getRequestDispatcher("/index.jsp")
				.forward(request, response);
		}
		if (userPath.equals("/categorie")) {
			String categ = request.getParameter("cat");
			try {
				listeArticle = c.getListeArticleByCategorie(categ);
				System.out.println("taiile == "+listeArticle.size());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("listeArticles", listeArticle);

			request.getServletContext().getRequestDispatcher("/index.jsp")
					.forward(request, response);
			}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
