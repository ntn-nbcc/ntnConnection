package com.ntn.utils;




/**
 * This class has only static methods whose primary intention is the manipulation
 * of strings.
 *
 */
public class StringFunctions
{
/**
 * Replace the first occurence of the substringToBeReplaced with the replacementString.
 */
public static String replace( String source, String substringToBeReplaced, String replacementString ){
   
   int index = source.indexOf( substringToBeReplaced );
   if ( index == -1 )
      // not found
      return source;
   
   String result = source.substring( 0, index ) + replacementString + source.substring( index + substringToBeReplaced.length(), source.length() );
   return result;
}
}
