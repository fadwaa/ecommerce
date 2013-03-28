package listes;
import java.sql.SQLException;
import java.util.Vector;

import Beans.Article;
import DAO.ArticleDao;
import DAO.ArticleDaoImpl;
//import DAO.DAOFactory;
public class Catalogue {
	Vector<Article> listeArticle = new Vector<Article>();
	private ArticleDao articledao;

	public Catalogue(ArticleDao articledao) throws SQLException{
        
        this.articledao = articledao;
        listeArticle=articledao.getAll();
        
	}
	
	public Vector<Article> getListeArticle() {
		return listeArticle;
	}
	
	public Vector<Article> getListeArticleByCategorie(String cat) throws SQLException {
		listeArticle=articledao.getByCategorie(cat);
		return listeArticle;
	}
	
	
	public void setListeArticle(Vector<Article> listeArticle) {
		this.listeArticle = listeArticle;
	}
	
	 
}





