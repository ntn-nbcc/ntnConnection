package com.ntn.utils;

/* sample usage

import com.ntn.dsi.utils.AlertMessage;
import com.ntn.dsi.utils.SupportAlert;

         AlertMessage alertMessage = new AlertMessage("EC-999", "bad stuff has happened - call 911");
         SupportAlert.getInstance().sendAlert(alertMessage);
 */

/**
 * This class is used to send alerts to the NTN Support desk using
 * the JavaMail API
 */

import java.util.ArrayList;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;



public class SupportAlert {
	private static SupportAlert instance;
	private javax.mail.Session session;
	private javax.mail.internet.InternetAddress to ;
	private javax.mail.internet.InternetAddress [] arrayTo ;
	private javax.mail.internet.InternetAddress from;
	private javax.mail.internet.InternetAddress[] arrayCc ;
	private javax.mail.internet.InternetAddress cc ;
	private javax.mail.internet.InternetAddress bcc ;
	private javax.mail.internet.InternetAddress cc1;
	private javax.mail.internet.InternetAddress cc2;
	private javax.mail.internet.InternetAddress cc3;
	private javax.mail.internet.InternetAddress cc4;
	private javax.mail.internet.InternetAddress cc5;
	private String attachment_Name = "";
	private String filename_Name = "";
	

	private boolean alertEnabled = false;
	private String host= null;
	/**
	 * SupportAlert constructor comment.
	 */
	private SupportAlert() {

		super();
		//initialize();
	}
	/**
	 * Returns the email address from which the alert should be sent
	 * @return javax.mail.internet.InternetAddress
	 */
	private javax.mail.internet.InternetAddress getFrom() {
		return from;
	}
	/**
	 * Returns the SupportAlert object - instantiating it if necessary
	 * @return SupportAlert
	 */
	public static synchronized SupportAlert getInstance() {
		if(instance == null){
			instance = new SupportAlert();
		}
		return instance;  
	}
	/**
	 * Return the mail session
	 * @return javax.mail.Session
	 */
	private javax.mail.Session getSession() {
		return session;
	}
	/**
	 * Return the email address to which the alert should be sent
	 * @return javax.mail.internet.InternetAddress
	 */
	private javax.mail.internet.InternetAddress getTo() {
		return to;
	}
	private javax.mail.internet.InternetAddress getCc() {
		return cc;
	}
	private javax.mail.internet.InternetAddress getCc1() {
		return cc1;
	}
	private javax.mail.internet.InternetAddress getCc2() {
		return cc2;
	}
	private javax.mail.internet.InternetAddress getCc3() {
		return cc3;
	}
	private javax.mail.internet.InternetAddress getCc4() {
		return cc4;
	}
	private javax.mail.internet.InternetAddress getCc5() {
		return cc5;
	}
	private javax.mail.internet.InternetAddress getBcc() {
		return bcc;
	}
	

	/**
	 * Insert the method's description here.
	 * Creation date: (1/19/2002 2:00:47 PM)
	 */
	public void initialize() {
		// get our SMTP server
		// get the necessary properties  
		this.cc =  new javax.mail.internet.InternetAddress();
		this.cc1 =  new javax.mail.internet.InternetAddress();
		this.arrayCc  = new  javax.mail.internet.InternetAddress[1] ;
		this.arrayTo  = new  javax.mail.internet.InternetAddress[1] ;
		this.attachment_Name = "";
	
		java.util.Properties props = System.getProperties();
		props.setProperty("mail.smtp.host", host);
		// we need to debug
		props.setProperty("mail.debug", "false");

		// assemble an Authenticator (since our SMTP server requires authentication)
		javax.mail.Authenticator auth = null;

		Session session = Session.getDefaultInstance(props, auth);
		setSession(session);

		try{
			String to = "sjhaveri@ntn.ca";
			String from = "sjhaveri@ntn.ca";
			String cc = "";

			if (to.equals("none"))
				setAlertEnabled(false);
			else {
				setAlertEnabled(true);
				setTo(to);
				setFrom(from);
				//        setCc(cc);
			}
		}catch(Exception ae){
			throw new NTNProcessingException("Unable to establish To/From address for support alert email", ae);
		}


	}
	/**
	 * Insert the method's description here.
	 * Creation date: (30/04/2002 10:09:15 AM)
	 * @return boolean
	 */
	public boolean isAlertEnabled() {
		return alertEnabled;
	}
	/**
	 * Use passed String to construct an email to Support.
	 * @param message AlertMessage
	 */
	public void sendAlert(AlertMessage message) throws MessagingException {

		if (isAlertEnabled()) {

			javax.mail.internet.MimeMessage mailMessage =
				new javax.mail.internet.MimeMessage(getSession());

			try {
				//String filename = "//Nbccsvr//public//DailyInvoices//BOORD.CSV";	
				String filename = this.filename_Name;
				String attach_name = this.attachment_Name;
				
				mailMessage.setFrom(getFrom());
				if (this.to !=null && !this.to.equals("")){
					mailMessage.addRecipient(Message.RecipientType.TO, getTo());
				}
				
				if (getBcc()!=null && !getBcc().equals("")){
					mailMessage.addRecipient(Message.RecipientType.BCC, getBcc());
				}
				for (int i = 0; i< arrayCc.length ; i++){
					if (arrayCc [i]!=null && !arrayCc [i].equals("")){
						mailMessage.addRecipient(Message.RecipientType.CC, arrayCc [i]);
					}
				}
				
				for (int i = 0; i< arrayTo.length ; i++){
					if (arrayTo [i]!=null && !arrayTo [i].equals("")){
						mailMessage.addRecipient(Message.RecipientType.TO, arrayTo [i]);
					}
				}
					
				mailMessage.setSubject(message.getSubject());

				StringBuffer messageText = new StringBuffer();
				messageText.append(message.getLongDescription());

				////
				// Set the email message text.
				MimeBodyPart messagePart = new MimeBodyPart();
				messagePart.setText(messageText.toString());
				
				
				MimeBodyPart attachmentPart = new MimeBodyPart();
				Multipart multipart = new MimeMultipart();
				multipart.addBodyPart(messagePart);
				
				// Set the email attachment file
				if(!attach_name.equals("")){
					FileDataSource fileDataSource = new FileDataSource(attach_name) {
						public String getContentType() {
							return "application/octet-stream";
						}
					};
					attachmentPart.setDataHandler(new DataHandler(fileDataSource));
				}
				if(!filename.equals("")){
					
					attachmentPart.setFileName(filename);
				}
				if(!attach_name.equals("")){
					multipart.addBodyPart(attachmentPart);
				} 

				////      
		//		MimeBodyPart htmlPart = new MimeBodyPart();
			//	htmlPart.setContent("<h1>Hello world</h1>", "text/html");
		//		htmlPart.setContent("<a href='http://176.16.1.16/ntn/ntnmnt/LostSalesFollowUp.jsp?track=4'>Alert Followup</A>", "text/html");
		//		multipart.addBodyPart(htmlPart);
				
				// mailMessage.setText(messageText.toString());
				mailMessage.setContent(multipart);
				
				//System.out.println("Sending email");
				Transport.send(mailMessage);
			} 
			catch (MessagingException me) {
				//         // may want to consider logging - log4j or other implementation here
				System.err.println ("Could not send Alert exception msg:" + me.getMessage());
			}
		}
	}
	/**
	 * Sets the boolean value that determines if alerts are enabled
	 * @param newAlertEnabled boolean
	 */
	public void setAlertEnabled(boolean newAlertEnabled) {
		alertEnabled = newAlertEnabled;
	}

	public void setHost(String smtp) {
		host  = smtp;
	}

	/**
	 * Set the email 'From' address to be used for alerts.
	 * @param newFrom javax.mail.internet.InternetAddress
	 */
	public void setFrom(String newFrom) {
		try {	
			from = new javax.mail.internet.InternetAddress ( newFrom );
		}
		catch (Exception e) {
		}	
	}
	/**
	 * Set the mail session
	 * @param newSession javax.mail.Session
	 */
	private void setSession(javax.mail.Session newSession) {
		session = newSession;
	}
	/**
	 * Set the email 'To' address to be used for alerts
	 * @param newTo javax.mail.internet.InternetAddress
	 */
	public void setTo(String newTo) throws Exception {
		// try {
		to = new javax.mail.internet.InternetAddress ( newTo );
		// }
		//  catch (Exception e) {
//		System.out.println("Invalid emailTo");
//		}
	}

	public void setCc(ArrayList emailcc) throws Exception {
		this.arrayCc  = new  javax.mail.internet.InternetAddress[emailcc.size()] ;
		for (int i = 0; i< emailcc.size(); i++){
			arrayCc [i] = new javax.mail.internet.InternetAddress ((String) emailcc.get(i));

		}
	}
	
	public void setTo(ArrayList emailto) throws Exception {
		this.arrayTo  = new  javax.mail.internet.InternetAddress[emailto.size()] ;
		for (int i = 0; i< emailto.size(); i++){
			arrayTo [i] = new javax.mail.internet.InternetAddress ((String) emailto.get(i));

		}
	}

	public void setCC(String newCc) throws Exception {
		cc = new javax.mail.internet.InternetAddress ( newCc );
	}
	
	public void setBCC(String newBcc) throws Exception {
		if(newBcc!=null && !newBcc.equals("")){
			bcc = new javax.mail.internet.InternetAddress ( newBcc );
		}	
	}

	public void setCC1(String newCc1) throws Exception {

		cc1 = new javax.mail.internet.InternetAddress ( newCc1 );
	}
//	public void setCc2(String newCc2) throws Exception {
	// 
	// 		cc2= new javax.mail.internet.InternetAddress ( newCc2);
//	}
//	public void setCc3(String newCc3) throws Exception {
	// 
	// 		cc3= new javax.mail.internet.InternetAddress ( newCc3);
//	}
//	public void setCc4(String newCc4) throws Exception {
	// 
	// 		cc4 = new javax.mail.internet.InternetAddress ( newCc4 );
//	}


	public void setAttacment_Name(String attach_nm){
		this.attachment_Name = attach_nm;
		
	}
	
	public String getEmailTo(){
		return to.getAddress();
	}
	public String getFilename_Name() {
		return filename_Name;
	}
	public void setFilename_Name(String filenameName) {
		filename_Name = filenameName;
	}	

}
