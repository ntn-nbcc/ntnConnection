/**
 * 
 */
package com.ntn.utils;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ntn.singletons.commands.SystemConstantsSingleton;

/**
 * @author sjhaveri
 *
 */
public class ConnectionOracleBroker {
	static NTNLogger logger = new NTNLogger("ConnectionOracleBroker");
	InitialContext context;
	DataSource dataSource;
	
//	 this is the instance reference for the class
	private static ConnectionOracleBroker instance;
	
//	 a calling class can first check the value of initialized to
//	 determine if an array of branches has been successfully created
	private static boolean initialized = false;

	
	// MUST be REMVOED after testing
		/*static{
			Connection[] connections = new Connection[30];
			try
			{
				ConnectionBroker broker = getInstance();
				
				for (int i = 0; i < 30; i++){
				
					connections[i] = broker.getConnection();
					com.ntn.DAOs.NTNStatement statement = new NTNStatement(connections[i].createStatement());
					statement.executeQuery("SELECT count(*)	 FROM NTNDTA.F584201");
				
				}
			
				// release 100 connections
				for (int i =0; i < 30; i++){
					broker.freeConnection(connections[i]);
				}
			}catch(Exception e)
			{
				logger.error("Testing Connection Pool", e);
			}
		}*/
	
	/**
	 * 
	 */
	protected ConnectionOracleBroker() {
		// TODO Auto-generated constructor stub
		super();
		SystemConstantsSingleton scs = SystemConstantsSingleton.getInstance();
		String datasource = scs.getDatasource();
		System.out.println("datasource :"+datasource);
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup(datasource);
		} catch (Exception e) {
			logger.error("Failed to connect to oracle database", e);
		}
		try{
			setInitialized(true); // construction was successful
		}
		catch(Exception e){
		      logger.error("NTNConnectionPool::NTNConnectionPool - error instantiating: " , e);
		      setInitialized(false); // bad construction
		}
	}

	
	/**
	 * Called  in order to destroy the Branches singleton instance.
	 *
	 */
	public static synchronized void destroyInstance() {
	   instance = null;
	}

	/**
	 * Method to return the NTNConnectionPool singleton instance.
	 *
	 */
	public static synchronized ConnectionOracleBroker getInstance() {
	   if(instance == null){
	      instance = new ConnectionOracleBroker();
	   }
	   return instance;
	}   
	
	public static boolean isInitialized() {
		   return initialized;
		}
	public Connection getConnection() {
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			
			// Establises connection to the database
			
			System.out.println("Connection Created");
		} catch (Exception e) {
			logger.error("Exception :", e);
		}
		return connection;
	}
	
	public  void freeConnection(Connection connection){
		if (connection != null){
			try{
				connection.close();
				//System.out.println("Oracle Connection Freed");
			}
			catch (Exception e){
				logger.error("Exception :",e);
			}
		}
	}
	
	public static void setInitialized(boolean newInitialized) {
		   initialized = newInitialized;
		}

}
