package com.ntn.processes;

import javax.mail.MessagingException;

import com.ntn.beans.FormattedMessage;
import com.ntn.utils.AlertMessage;
import com.ntn.utils.NTNLogger;
import com.ntn.utils.SupportAlert;

public class QuickEmail {
	NTNLogger logger = new NTNLogger ("QuickEmail");
	
	public QuickEmail() {
		super();
	}

	public void execute(FormattedMessage formatmsg) {
		SupportAlert supportAlert = null;
		AlertMessage alertmessage = null;
		alertmessage = new AlertMessage(formatmsg.getMessageId(), formatmsg.getMessage(),"", formatmsg.getSubject());
		
		// set up the email alert system
		try {
			supportAlert = SupportAlert.getInstance();
			supportAlert.setHost ("domino.ntn.ca");
			supportAlert.initialize();
			supportAlert.setFrom(formatmsg.getEmailFrom());
			supportAlert.setTo(formatmsg.getEmailTo());
			supportAlert.setBCC(formatmsg.getEmailBCc());
			supportAlert.setCc(formatmsg.getEmailCc());
			supportAlert.setFrom(formatmsg.getEmailFrom());
			supportAlert.setHost ("domino.ntn.ca");
			supportAlert.setAttacment_Name(formatmsg.getAttachment_Name());
			supportAlert.setFilename_Name(formatmsg.getFilename_Name());
			supportAlert.getInstance().sendAlert(alertmessage);
		
		}	
		catch (MessagingException ex){
			System.out.println("Exception in QuickMail execute :"+ex);
			String subject = "Error sending email to "+ formatmsg.getEmailTo();
			supportAlert.setAttacment_Name(formatmsg.getAttachment_Name());
			supportAlert.setFilename_Name(formatmsg.getFilename_Name());
			alertmessage.setSubject(formatmsg.getExceptionSubject());			

			try{
				supportAlert.getInstance().setTo (formatmsg.getExceptionEmailTo());
				supportAlert.setBCC(formatmsg.getEmailBCc());
				supportAlert.setAttacment_Name(formatmsg.getAttachment_Name());
				supportAlert.setFilename_Name(formatmsg.getFilename_Name());
				supportAlert.getInstance().sendAlert(alertmessage);
			}
			catch (Exception e){
				System.out.println("Exception in QuickMail :"+e);
			}	
		}	
		catch ( Exception ex ) {
			System.out.println("QueueMonitor:monitor - exception msg: " + ex );

		}
		

	}					
	public static void main(String[] args) throws Exception {
		QuickEmail qMonitor = new QuickEmail();
		int an8=220900;
		String inv_nm="invoice-20110510"+"-"+an8;
		//qMonitor.execute(an8,inv_nm );		
	}
}	
