package com.ntn.utils;

public class NTNProcessingException extends Error {
   private java.lang.Exception wrappedException;
   private java.lang.String errorPage;

public NTNProcessingException() {
   super();
}
/**
 * NTNProcessingException constructor comment.
 * @param s java.lang.String
 */
public NTNProcessingException(String s) {
   super(s);
}
/**
 * NTNProcessingException constructor comment.
 * @param s java.lang.String
 */
public NTNProcessingException(String s, Exception e) {
   super(s);
   setWrappedException(e);
}
/**
 * NTNProcessingException constructor comment.
 * @param s java.lang.String
 */
public NTNProcessingException(String s, Exception e, String errorPage) {
   super(s);
   setWrappedException(e);
   setErrorPage(errorPage);
}
/**
 * Insert the method's description here.
 * Creation date: (1/22/2002 12:03:16 PM)
 * @return java.lang.String
 */
public java.lang.String getErrorPage() {
   return errorPage;
}
/**
 * Insert the method's description here.
 * Creation date: (12/02/2001 2:36:06 PM)
 * @return java.lang.Exception
 */
public java.lang.Exception getWrappedException() {
   return wrappedException;
}
/**
 * Insert the method's description here.
 * Creation date: (1/22/2002 12:03:16 PM)
 * @param newErrorPage java.lang.String
 */
private void setErrorPage(java.lang.String newErrorPage) {
   errorPage = newErrorPage;
}
/**
 * Insert the method's description here.
 * Creation date: (12/02/2001 2:36:06 PM)
 * @param newWrappedException java.lang.Exception
 */
public void setWrappedException(java.lang.Exception newWrappedException) {
   wrappedException = newWrappedException;
}
}

