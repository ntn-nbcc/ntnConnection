package com.ntn.beans;

import java.util.ArrayList;




public class FormattedMessage {
	private String message ="";
	private String messageId ="";
 	private String emailTo ="";
	private ArrayList emailCc = new ArrayList(1);
   	private String subject ="";
 
 	private String attachment_name ="";
 	private String emailBCc ="";
 	private String ExceptionEmailTo ="";
	private String exceptionSubject ="";
	private String emailFrom ="";
	private String filename_Name = "";
	
	public FormattedMessage() {
		
	} 

	public void setMessage (String msg) {
		this.message = msg;
	}	
	
	public void setEmailTo (String emailto) {
		this.emailTo = emailto;
	}
	public void setEmailCc (String emailcc) {
		this.emailCc.add(emailcc);
	}
	
	public void removeEmailCc (String emailcc) {
		for (int i=0 ; i< this.getEmailCc().size() ; i++){
			String newEmail  = this.getEmailcc(i);
			if(newEmail.trim().equals(emailcc.trim())){
				this.emailCc.remove(i);
			}
		}
		
	}
	
	public void setSubject (String subject ) {
		this.subject = subject;
	}
	
	public void setAttachment_name (String attach ) {
		this.attachment_name = attach;
	}
	

	public String getMessage() {
    	 return message;
  	}		
	
	public String getEmailTo() {
		return emailTo;
	}
	
	public ArrayList getEmailCc() {
		return emailCc;
	}
	
	public String getEmailcc (int i) {
		String email = " ";
		try {
			email= (String) emailCc.get(i);
		}
		catch (Exception ex) {
		}	
		return email;
	}	
	

	public String getSubject() {
		return subject;
	}
	
	public String getAttachment_Name() {
		return attachment_name;
	}

	public String getEmailBCc() {
		return emailBCc;
	}

	public void setEmailBCc(String emailBCc) {
		this.emailBCc = emailBCc;
	}

	public String getExceptionEmailTo() {
		return ExceptionEmailTo;
	}

	public void setExceptionEmailTo(String exceptionEmailTo) {
		ExceptionEmailTo = exceptionEmailTo;
	}

	public String getEmailFrom() {
		return emailFrom;
	}

	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public String getExceptionSubject() {
		return exceptionSubject;
	}

	public void setExceptionSubject(String exceptionSubject) {
		this.exceptionSubject = exceptionSubject;
	}

	public String getFilename_Name() {
		return filename_Name;
	}

	public void setFilename_Name(String filenameName) {
		filename_Name = filenameName;
	}
}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
				