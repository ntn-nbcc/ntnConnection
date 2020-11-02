/*
 * Created on Feb 13, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.commands;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ntn.DAOs.NTNPreparedStatement;
import com.ntn.DAOs.NTNStatement;
import com.ntn.singletons.commands.SystemConstantsSingleton;
import com.ntn.utils.NTNLogger;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonOracleCommand {
	protected static NTNLogger logger = new NTNLogger("CommonOracleCommand");
	InitialContext context;
	DataSource dataSource;
	//protected static Connection connection;
	/**	
	 * 
	 */
	public CommonOracleCommand() {
		super();
		
		SystemConstantsSingleton scs = SystemConstantsSingleton.getInstance();
		String datasource = scs.getDatasource();
		//System.out.println("datasource :"+datasource);
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup(datasource);
		} catch (Exception e) {
			logger.error("Failed to connect to oracle database", e);
		}
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() {
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			
			// Establises connection to the database
			
			//System.out.println("Connection Created");
		} catch (Exception e) {
			System.out.println("Connection Error :"+e);
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
	
	public void closeStmtRs (NTNStatement stmt, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stmt);
	}
	
	public void closePreparedStmtRs (NTNPreparedStatement pstmt, ResultSet rs) {
		closeResultSet(rs);
		closePreparedStatement(pstmt);
	}
}
