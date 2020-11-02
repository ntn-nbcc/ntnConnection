/*
 * Created on Feb 13, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ntn.DAOs.NTNPreparedStatement;
import com.ntn.DAOs.NTNStatement;
import com.ntn.singletons.commands.SystemConstantsSingleton;
import com.ntn.utils.ConnectionSQLBroker;
import com.ntn.utils.NTNLogger;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonSQLConnection {
	protected static NTNLogger logger = new NTNLogger("CommonSQLCommand");
	protected Connection connection;
	//protected static Connection connection;
	/**	
	 * 
	 */
	public CommonSQLConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() {
		connection = null;
		SystemConstantsSingleton scs = SystemConstantsSingleton.getInstance();
		String sqlurl=scs.getSqlUrl();
		
		try {
			String url = sqlurl;
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// Establises connection to the database
			connection = DriverManager.getConnection(url, "Interface",
					"DataCollect5!");
			//System.out.println("Connection Created");
		} catch (Exception e) {
			logger.error("Exception :", e);
		}
		return connection;
	}
	
	
	
	public void closeAll (NTNStatement stmt, ResultSet rs,Connection connection) {
		closeResultSet(rs);
		closeStatement(stmt);
		freeConnection(connection);
	}
public void closeResultSet(ResultSet rs) {
		
		if (rs!= null)
			try  
			{
				rs.close();
				//System.out.println("ResultSet closed");
			}
			catch (Exception e){
				logger.error("Exception Error closing ResultSet",e);
			}
			
	}
	
	public void closePreparedStatement(NTNPreparedStatement pstmt) {
		if (pstmt!= null)
			try  
			{
				pstmt.close();
			}
			catch (Exception e){
				logger.error("Exception Error closing preStatement",e);
			}
	}

	public void closeStatement(NTNStatement stmt) {
		if (stmt!= null)
			try  
			{
				stmt.close();
				//System.out.println("Statement closed");
			}
			catch (Exception e){
				logger.error("Exception Error closing Statement",e);
			}
	}
	public void freeConnection (Connection connection) {
		if (connection != null) {
			try{
				ConnectionSQLBroker.getInstance().freeConnection(connection);
				System.out.println("connection closed");
			}
			catch (Exception e){
				logger.error("Exception Error closing connection",e);
			}
			finally {
				connection = null;
			}
		}
	}
	
	
	
}
