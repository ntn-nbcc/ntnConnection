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
public class CommonSQLCommand {
	protected static NTNLogger logger = new NTNLogger("CommonSQLCommand");
	InitialContext context;
	DataSource dataSource;
	//protected static Connection connection;
	/**	
	 * 
	 */
	public CommonSQLCommand() {
		super();
		SystemConstantsSingleton scs = SystemConstantsSingleton.getInstance();
		String sqldataSource=scs.getSQLdatasource();
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup(sqldataSource);
		} catch (Exception e) {
			logger.error("Failed to connect to sql database Interface", e);
		}
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() {
		Connection connection = null;
		try {
			
			connection = dataSource.getConnection();
			
			// Establises connection to the database
			
			System.out.println("SQL Connection Created");
		} catch (Exception e) {
			logger.error("Exception :", e);
			System.out.println("Exception in get connection:"+e);
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
	public  void freeConnection(Connection connection){
		if (connection != null){
			try{
				connection.close();
				System.out.println("SQL Connection Freed");
			}
			catch (Exception e){
				logger.error("Exception :",e);
				System.out.println("Exception in free connection:"+e);
			}
		}
	}
}
