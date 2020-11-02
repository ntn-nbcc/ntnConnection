package com.ntn.DAOs;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class NTNPreparedStatement extends NTNStatement {
	private PreparedStatement pst;
	
	public NTNPreparedStatement(PreparedStatement pst){
		this.pst = pst;
	}
	
	public void setString(int index, String value) throws SQLException{
		pst.setString(index, value);
	}
	
	public void setInt(int index, int value) throws SQLException{
		pst.setInt(index, value);
	}
	
	public ResultSet executeQuery() throws SQLException{
		//Add log
		return pst.executeQuery();
	}
	            
	public void close() throws SQLException{
		logger.debug("PreparedStatement Closed");
		pst.close();
	}
}
