package com.ntn.DAOs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ntn.utils.NTNLogger;

public class NTNStatement {
	
	NTNLogger logger = new NTNLogger ("NTNStatement");
	
	private Statement st;
	
	public NTNStatement(){}
	
	public NTNStatement(Statement st){
		this.st = st;
	}
	
	public int executeUpdate(String sqlstatement) throws SQLException{
		logger.info("executeUpdate:" + sqlstatement);
		return st.executeUpdate(sqlstatement);
	}
	
	public ResultSet executeQuery(String sqlstatement) throws SQLException{
		logger.info("executeQuery:" + sqlstatement);
		return st.executeQuery(sqlstatement);
	}
	
	public void close() throws SQLException{
		logger.info("Statement Closed");
		st.close();
	}

}
