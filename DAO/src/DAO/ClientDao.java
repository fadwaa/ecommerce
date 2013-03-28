package DAO;

import Beans.Client;

public interface ClientDao {
	
	void creer( Client client ) throws DAOException;
	 
    Client trouver( String email ) throws DAOException;
    Client getClient( String email,String motdepasse ) throws DAOException;

}
