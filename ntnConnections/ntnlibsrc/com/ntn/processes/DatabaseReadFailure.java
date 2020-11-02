/**
 * 
 */
package com.ntn.processes;

import java.awt.Font;
import java.util.Date;

import com.ntn.beans.FormattedMessage;
import com.ntn.processes.QuickEmail;


/**
 * @author sjhaveri
 *
 */
public class DatabaseReadFailure {
	private QuickEmail qe = new QuickEmail();
	
	/**
	 * 
	 */
	public DatabaseReadFailure() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Exception err = new Exception();
		DatabaseReadFailure dbFailure = new DatabaseReadFailure();
		dbFailure.databaseReadFailure("CARS: xxx MOT: yyy", "F42199Command", "getsqlmethod", err);
	}

	public void databaseReadFailure(String criteria,String progname, String sqlmethod,Exception err) {
				   StringBuffer message = new StringBuffer();
		   
		   FormattedMessage formatmsg = new FormattedMessage();
		   Date dt = new Date();
		   Font font=new Font("Courier",Font.BOLD,12);
			 
		   final String CRLF="\r\n";
		   
		   try {
			
			
			String subject = "Database Read error - "+ criteria;
			String msgid = String.valueOf(criteria).toString();
		    
		   
		    
			message.append ("Criteria        : " +criteria + CRLF);
			message.append ("PRogram Name    : " +progname + CRLF);
		 	message.append ("Method Name    : " +sqlmethod + CRLF);
		 	message.append ("Error    : " +err + CRLF);
		
		 	formatmsg.setMessage(message.toString());
			//formatmsg.setEmailTo("inyashanu@ntn.ca");
			formatmsg.setEmailTo("sjhaveri@ntn.ca");
			//formatmsg.setEmailCc("sjhaveri@ntn.ca");
			formatmsg.setSubject(subject);
			formatmsg.setExceptionSubject("Error sending email -"+subject);
			
			formatmsg.setMessageId(msgid);
			//formatmsg.setAttachment_name("//176.16.1.15//Public//DailyInvoices//EmailInvoices//"+inv_nm+".pdf");
			qe.execute(formatmsg);
		   }
		   catch (Exception ex) {
		   }
		   
		}
}
