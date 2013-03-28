


package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Beans.Client;

import static DAO.DAOUtilitaire.*;

public class ClientDaoImpl implements ClientDao{
	 private DAOFactory          daoFactory;
	 private static final String SQL_SELECT_PAR_EMAIL = "SELECT  email, nom, motdepasse,login FROM client1 WHERE email = ?";
	 private static final String SQL_INSERT = "INSERT INTO client1 (email,nom,motdepasse,login) VALUES (?,?,?,?)";
	 private static final String SQL_SELECT_PAR_EMAIL_pass="select * from client1 where email = ? and motdepasse = ?";
			 ClientDaoImpl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	    }
	 private static Client map( ResultSet resultSet ) throws SQLException {
		 Client client = new Client();
		// client.setId( resultSet.getInt( "id" ) );
		 client.setEmail( resultSet.getString( "email" ) );
		 client.setMotDePasse( resultSet.getString( "motdepasse" ) );
		 client.setNom( resultSet.getString( "nom" ) );
		 client.setLogin( resultSet.getString( "login" ));
		
	     return client;
	 }

	
	   /* Impl�mentation de la m�thode trouver() d�finie dans l'interface ClientDao */
  
    public Client trouver( String email ) throws DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Client client = null;
     
        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL, false, email );
            resultSet = preparedStatement.executeQuery();
            /* Parcours de la ligne de donn�es de l'�ventuel ResulSet retourn� */
            if ( resultSet.next() ) {
            	client = map( resultSet );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( resultSet, preparedStatement, connexion );
        }
     
        return client;
    }
    /**affichage des articles**/
    
   public Client getClient(String email , String motdepasse){
    	 Connection connexion = null;
         PreparedStatement preparedStatement = null;
        // ResultSet resultSet1 = null;
         Client client = null;
        try {
           
        	preparedStatement = initialisationRequetePreparee( connexion, SQL_SELECT_PAR_EMAIL_pass, false, email,motdepasse );
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, motdepasse);
            ResultSet resultSet = preparedStatement.executeQuery();
           // resultSet.next();
           if(resultSet.next()){
            client= new Client();
            client.setEmail(resultSet.getString("email"));
            client.setNom(resultSet.getString("nom"));
            client.setLogin(resultSet.getString("login"));
            client.setMotDePasse(resultSet.getString("motdepasse"));
            client.setId(resultSet.getInt("id"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            client = null;
        }
        
        return client;
    }
 
    /* Impl�mentation de la m�thode creer() d�finie dans l'interface ClientDao */
  
    public void creer( Client client ) throws IllegalArgumentException, DAOException {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;
        ResultSet valeursAutoGenerees = null;
     
        try {
            /* R�cup�ration d'une connexion depuis la Factory */
            connexion = daoFactory.getConnection();
            if(connexion == null){
            	System.out.println("ddfed");
            	
            }
            preparedStatement = initialisationRequetePreparee( connexion, SQL_INSERT, true, client.getEmail(),client.getNom(), client.getMotDePasse(),client.getLogin() );
            int statut = preparedStatement.executeUpdate();
            /* Analyse du statut retourn� par la requ�te d'insertion */
            if ( statut == 0 ) {
                throw new DAOException( "�chec de la cr�ation du client, aucune ligne ajout�e dans la table." );
            }
            /* R�cup�ration de l'id auto-g�n�r� par la requ�te d'insertion */
            valeursAutoGenerees = preparedStatement.getGeneratedKeys();
            if ( valeursAutoGenerees.next() ) {
                /* Puis initialisation de la propri�t� id du bean Utilisateur avec sa valeur */
            	client.setId( valeursAutoGenerees.getInt( 1 ) );
            } else {
                throw new DAOException( "�chec de la cr�ation du client en base, aucun ID auto-g�n�r� retourn�." );
            }
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            fermeturesSilencieuses( valeursAutoGenerees, preparedStatement, connexion );
        }
    }
 
    
    

}
