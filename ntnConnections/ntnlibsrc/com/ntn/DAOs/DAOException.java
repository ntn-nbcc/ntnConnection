/*
 * Created on Apr 14, 2007
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.DAOs;

import java.io.IOException;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DAOException extends IOException {
	Throwable cause;
	/**
	 * 
	 */
	public DAOException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public DAOException(String message, Throwable p_cause) {
		super(message);
		cause = p_cause;
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public DAOException(Throwable p_cause) {
		super();
		cause = p_cause;
		// TODO Auto-generated constructor stub
	}

}
