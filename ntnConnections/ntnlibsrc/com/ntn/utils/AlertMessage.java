package com.ntn.utils;

import com.ntn.utils.StringFunctions;

public class AlertMessage {
   private java.lang.String errMessageId;
   private java.lang.String severity;
   private java.lang.String description;
   private java.lang.String shortDescription;
   private java.lang.String subject;
   private java.lang.String[] params;
/**
 * AlertMessage constructor comment.
 */
public AlertMessage(String msgId, String description)
{
   super();
   setProperties(msgId,"0" ,description, "", new String[0], "");
}
/**
 * AlertMessage constructor comment.
 */
public AlertMessage(String msgId, String severity, String description)
{
   super();
   setProperties(msgId,severity ,description, "", new String[0], "");
}
/**
 * AlertMessage constructor
 */
public AlertMessage(String msgId, String message,String shortDescription, String subject)
{
   super();
    
   setProperties(msgId,"",message, "", new String[0],subject);
}
/**
 * AlertMessage constructor
 */

public AlertMessage(String msgId, String severity, String description, String shortDescription, String[] args)
{
   super();
   setProperties(msgId, severity,description,shortDescription, args, "");

}
/**
 * @return java.lang.String
 */
public java.lang.String getDescription() {
   String description = getRawDescription();
   if(description != null){
      String [] params = getParams();
      if(params != null) {
         int numberOfTokens = params.length;
         for (int i = 0; i < numberOfTokens; i++){
            description = StringFunctions.replace(description, "&" + (i+1), params[i]);
         }
      }
   }
   return description;
}
/**
 * Description together with the message id
 *
 * @return java.lang.String
 */
public String getLongDescription()
{
   return getDescription();
}

/**
 */
public java.lang.String getErrMessageId() {
   return errMessageId;
}

/**
 */
public java.lang.String[] getParams() {
   return params;
}

/**
 */
public String getRawDescription() {
   return description;
}

/**
 */
public java.lang.String getSeverity() {
   return severity;
}

/**
 */
public java.lang.String getShortDescription() {
   return shortDescription;
}
/**
 */
public java.lang.String getSubject() {
   return subject;
}

/**
 */
private void setDescription(java.lang.String newDescription) {
   description = newDescription;
}

/**
 */
private void setErrMessageId(java.lang.String newErrMessageId) {
   errMessageId = newErrMessageId;
}

/**
 */
public void setParams(java.lang.String[] newParams) {
   params = newParams;
}

/**
 * AlertMessage constructor comment.
 */
private void setProperties(String msgId, String severity, String description, String shortDescription, String[] args,String subject)
{
   setErrMessageId(msgId);
   setSeverity(severity);
   setDescription(description);
   setShortDescription(shortDescription);
   setParams(args);
   setSubject(subject);
}

/**
 */
private void setSeverity(java.lang.String newSeverity) {
   severity = newSeverity;
}
/**
 */
private void setShortDescription(java.lang.String newShortDescription) {
   shortDescription = newShortDescription;
}

/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
   return super.toString();
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public void setSubject(String newSubject) {
   subject = newSubject;
}

}
