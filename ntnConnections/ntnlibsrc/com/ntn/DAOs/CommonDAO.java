/*
 * Created on Aug 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.DAOs;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.ntn.utils.ConnectionOracleBroker;


/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public abstract class CommonDAO {
	protected static Logger logger = Logger.getLogger(CommonDAO.class);
	protected Connection connection;
	

	/**
	 * 
	 */
	public CommonDAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Connection getConnection() throws SQLException{
		if (connection == null){
			try{
			connection = ConnectionOracleBroker.getInstance().getConnection();
			}
			catch (Exception e){
				System.out.println("Exception Error getConnection connection"+e);
			}
		}	
		return connection;
	}
	
	public NTNPreparedStatement getPreparedStatement(String sql) throws SQLException {
		if (connection != null){
			return new NTNPreparedStatement(connection.prepareStatement(sql));
		}	
		return null;
	}
	
	public NTNStatement getStatement() throws SQLException {
		if (connection != null){
			return new NTNStatement(connection.createStatement());
		}	
		return null;
	}
	
	public void freeConnection () {
		if (connection != null) {
			try{
				ConnectionOracleBroker.getInstance().freeConnection(connection);
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
	
	public void closeAll (NTNStatement stmt, ResultSet rs) {
		closeResultSet(rs);
		closeStatement(stmt);
		freeConnection();
	}
	
	public void closeResultSet(ResultSet rs) {
		
		if (rs!= null)
			try  
			{
				rs.close();
				System.out.println("ResultSet closed");
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
				System.out.println("Statement closed");
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
