package DAO;

import static DAO.DAOUtilitaire.fermeturesSilencieuses;
import static DAO.DAOUtilitaire.initialisationRequetePreparee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.mysql.jdbc.Statement;

import Beans.Article;

public class ArticleDaoImpl implements ArticleDao {
	 private DAOFactory          daoFactory;
	
	 private static final String SQL_SELECT_ARTICLE="select * from article where id_article= ? ";
	 private static final String SQL_SELECT_ARTICLE1="select * from article ";
	 private static final String SQL_SELECT_ARTICLE_BY_CATEG="select * from article where idCategorie = (select idCategorie from categorie where libCategorie = ?)";
			 public ArticleDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
			public ArticleDaoImpl() {
			      
			    }
	 private static Article map( ResultSet resultSet ) throws SQLException {
		 Article article = new Article();
		
		 article.setDescription( resultSet.getString( "description" ));
		 article.setImage( resultSet.getString( "image" ));
		 article.setNom_a( resultSet.getString( "nom_a" ) );
		 article.setPrix( resultSet.getDouble( "prix" ) );
		 article.setQuantite( resultSet.getInt( "quantité" ));
		
	     return article;
	 }

	
	   /* Implémentation de la méthode trouver() définie dans l'interface ArticleDao */
  
    public Article trouver(String id_article) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article = null;
     
        try {
            /* Récupération d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
           preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ARTICLE, false,id_article);
           
            		resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
            if ( resultSet.next() ) {
            	article = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
     
        return article;
    }
    public Vector<Article> getAll() throws SQLException{
    	 Connection connexion = null;
       // PreparedStatement preparedStatement1 = null;
         ResultSet resultSet = null;
         Article article = null;
        
         
		Vector<Article> listeArticle =new Vector<Article>();
		
		try{
			System.out.println("vvvv");
			connexion=daoFactory.getConnection();
			
			System.out.println("vvvv22");
			 resultSet = initialisationRequetePreparee( connexion, SQL_SELECT_ARTICLE1);
			while(resultSet.next()){
			//Article article1= this.trouver(resultSet.getString("id_article"));
				
				//listeArticle.add(article1);
				 article = map( resultSet );
				listeArticle.add(article);
			}
		
			}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listeArticle;
	}
    public Vector<Article> getByCategorie(String categ) throws SQLException{
   	 Connection connexion = null;
       PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Article article = null;
       
		Vector<Article> listeArticle =new Vector<Article>();
		try{
			connexion=daoFactory.getConnection();
			
			
			preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_ARTICLE_BY_CATEG,false,categ);
			
			resultSet = preparedStatement.executeQuery();
			System.out.println( SQL_SELECT_ARTICLE_BY_CATEG);
			 while(resultSet.next()){
				 article = map( resultSet );
				 listeArticle.add(article);
			}
		
			}
		catch(SQLException e){
			e.printStackTrace();
		}
		return listeArticle;
	}
	
    
    
}
