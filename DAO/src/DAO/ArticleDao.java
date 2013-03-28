package DAO;

import java.sql.SQLException;
import java.util.Vector;

import Beans.Article;

public interface ArticleDao {
	
	Article trouver(String id_article) throws DAOException;
	  Vector<Article> getAll() throws SQLException;
	  Vector<Article> getByCategorie(String categ) throws SQLException;
	

}
