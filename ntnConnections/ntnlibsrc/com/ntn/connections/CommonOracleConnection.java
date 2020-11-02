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
import com.ntn.utils.NTNLogger;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonOracleConnection {
	protected static NTNLogger logger = new NTNLogger("CommonOracleConnection");
	
	//protected static Connection connection;
	/**	
	 * 
	 */
	public CommonOracleConnection() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Connection getConnection() {
		Connection connection = null;
		SystemConstantsSingleton scs = SystemConstantsSingleton.getInstance();
		String sysUrl=scs.getJdeUrl();
		String jdeUrlPass=scs.getUrlPassword();
		//System.out.println("jdeUrlPass :+ "+jdeUrlPass);
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = sysUrl;
			//String url = "jdbc:oracle:thin:@129.147.16.130:1521/jdorclpy.netjiuwoz.vcnzgqox.oraclevcn.com";
			String username = "C_NTN2";
			String password = jdeUrlPass;
			//String username = "SELANGO";
			//String password = "JnTy_65";
			
			// Establises connection to the database
			connection = DriverManager.getConnection(url, username, password); 
			//System.out.println("Connection Created");
		} catch (Exception e) {
			logger.error("Exception :", e);
			System.out.println("Exception in CommonOracleConnection :"+ e);
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
