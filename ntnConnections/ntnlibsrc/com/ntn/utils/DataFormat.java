/*
 * Created on Aug 16, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;



/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DataFormat {
	NTNLogger logger = new NTNLogger("DataFormat");
	private  DecimalFormat dfWithComma = new DecimalFormat("$#,##0.00;$-#,##0.00");
	private  DecimalFormat dfWithCommaIndeneted = new DecimalFormat("$      #,##0.00;$-#,##0.00");
	private  DecimalFormat dfNoComma = new DecimalFormat("$###0.00;($###0.00)");
	private  DecimalFormat dfSuppressZero = new DecimalFormat("###0.00;-###0.00");
	private  DecimalFormat dfSuppressTOFiveZero = new DecimalFormat("###0.00000;-###0.00000");
	private  DecimalFormat dfSuppressZeroWithComma = new DecimalFormat("#,##0.00;-#,##0.00");
	private  DecimalFormat dfFourDecimalSuppressZeroWithComma = new DecimalFormat("#,##0.0000;-#,##0.0000");
	private  DecimalFormat dfSuppressZeroWithCommaInt = new DecimalFormat("#,##0;-#,##0");
	private  DecimalFormat dfOneDecimalOnly = new DecimalFormat("###0.0;-###0.0");
	private  DecimalFormat dfSuppressZeroWithCommaPerc = new DecimalFormat("#,##0.00%;-#,##0.00%");
	private static char[] specialCharacters = { '&', '<','>', '\'','\"'};
    private static String[] replacementStrings = { "&amp;", "&lt;","&gt;", "&apos;","&quot;" };
    private static char[] backslashapostropheCharacters = {'\''};
    private static String[] replacementbackslashapostropheStrings = { "''"};
   

	/**
	 * 
	 */
	public DataFormat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNumberWithComma(double amt){
		return dfWithComma.format(amt);
	}
	
	public String getNumberWithCommaIndent(double amt){
		return dfWithCommaIndeneted.format(amt);
	}
		
	public String getNumberSuppressZeroWithCommaPerc(double amt){
		return dfSuppressZeroWithCommaPerc.format(amt);
	}
	
	public String getNumberWithNoComma(double amt){
		return dfNoComma.format(amt);
	}
	
	public String getNumberWithSuppressZero(double amt){
		
		return dfSuppressZero.format(amt);
	}
	
	public String getNumberWithSuppressToFiveZero(double amt){
		
		return dfSuppressTOFiveZero.format(amt);
	}
	
	public String getNumberWithSuppressZeroWithComma(double amt){
		return dfSuppressZeroWithComma.format(amt);
	}
	
	public String getFourDecimalNumberWithSuppressZeroWithComma(double amt){
		return dfFourDecimalSuppressZeroWithComma.format(amt);
	}
	
	public String getIntWithSuppressZeroWithComma(int  amt){
		return dfSuppressZeroWithCommaInt.format(amt);
	}
	
	public String getLongWithSuppressZeroWithComma(long  amt){
		return dfSuppressZeroWithCommaInt.format(amt);
	}
	
	public String getDateFormat_mmddyy_WithSlash(String yy , String mm, String dd){
		String newDate = "";
	 	newDate = mm+"/"+dd+"/"+yy; 
		return newDate;
	}
	
	public String getDateFormat_mmddyyyy_WithDash(String yy , String mm, String dd){
		String newDate = "";
	 	newDate = yy+"-"+mm+"-"+dd; 
		return newDate;
	}
	
	public String  getDateYYYYMMDFormatted(String yyyymmdd){
		int yy = Integer.valueOf(yyyymmdd.substring(0,4)).intValue();
		int mm = Integer.valueOf(yyyymmdd.substring(4,6)).intValue();
		int dd = Integer.valueOf(yyyymmdd.substring(6,8)).intValue();
		//System.out.println("yy :"+yy+"  mm:"+mm+" dd :"+dd);
		String newDate = getStringwith1LeadingZeroOnlyUpToTen(mm)+"/"+getStringwith1LeadingZeroOnlyUpToTen(dd)+"/"+String.valueOf(yy).toString();
		//	System.out.println("newDate :"+newDate);
		return newDate;
	}
	
	public String  getTimeHHSSFormatted(String hhss){
		int hh = Integer.valueOf(hhss.substring(0,2)).intValue();
		int ss = Integer.valueOf(hhss.substring(2,4)).intValue();
		
		//System.out.println("hh :"+hh+"  mm:"+mm+" dd :"+dd);
		String newTime = getStringwith1LeadingZeroOnlyUpToTen(hh)+":"+getStringwith1LeadingZeroOnlyUpToTen(ss);
		//	System.out.println("newDate :"+newTime);
		return newTime;
	}
	
	public String  getTimeHHMMSSFormatted(String hhmmss){
		if(hhmmss.length()<6){
			hhmmss = "0"+hhmmss;
		}
		int hh = Integer.valueOf(hhmmss.substring(0,2)).intValue();
		int mm = Integer.valueOf(hhmmss.substring(2,4)).intValue();
		
		//System.out.println("hh :"+hh+"  mm:"+mm+" dd :"+dd);
		String newTime = getStringwith1LeadingZeroOnlyUpToTen(hh)+":"+getStringwith1LeadingZeroOnlyUpToTen(mm);
		//	System.out.println("newDate :"+newTime);
		return newTime;
	}
	
	public String  getHHMMSSFormatted(String hhmmss){
		if(hhmmss.length()<6){
			hhmmss = "0"+hhmmss;		
		}
		int hh = Integer.valueOf(hhmmss.substring(0,2)).intValue();
		int mm = Integer.valueOf(hhmmss.substring(2,4)).intValue();
		int ss = Integer.valueOf(hhmmss.substring(4,6)).intValue();
		
		//System.out.println("hh :"+hh+"  mm:"+mm+" dd :"+dd);
		String newTime = getStringwith1LeadingZeroOnlyUpToTen(hh)+":"+getStringwith1LeadingZeroOnlyUpToTen(mm)+":"+getStringwith1LeadingZeroOnlyUpToTen(ss);
		//	System.out.println("newDate :"+newTime);
		return newTime;
	}
	

	public String getDateFormat_mmddyyyy_twodigityear(String mmddyyyy){
		String newDate = "";
		String twoDigitYr = mmddyyyy.substring(8,10);
		String mm = mmddyyyy.substring(0,2);
		String dd = mmddyyyy.substring(3,5);
		newDate =  mm+"/"+dd+"/"+twoDigitYr;
		return newDate;
	}
	
	public String getDateFormat_yyyymmdd(String yyyymmdd){
		String newDate = "";
		int yy = Integer.valueOf(yyyymmdd.substring(0,4)).intValue();
		int mm = Integer.valueOf(yyyymmdd.substring(4,6)).intValue();
		int dd = Integer.valueOf(yyyymmdd.substring(6,8)).intValue();
		newDate =  yy+"/"+getStringwith1LeadingZeroOnlyUpToTen(mm)+"/"+getStringwith1LeadingZeroOnlyUpToTen(dd);
		return newDate;
	}
	
	public String getDateFormat_yyyymmddslash(String yyyymmdd){
		String newDate = "";
		int yy = Integer.valueOf(yyyymmdd.substring(0,4)).intValue();
		int mm = Integer.valueOf(yyyymmdd.substring(4,6)).intValue();
		int dd = Integer.valueOf(yyyymmdd.substring(6,8)).intValue();
		newDate =  yy+"-"+getStringwith1LeadingZeroOnlyUpToTen(mm)+"-"+getStringwith1LeadingZeroOnlyUpToTen(dd);
		return newDate;
	}
	
	public String getDateFormat_yyyymmdd_slash(String mmddyyyy){
		String newDate = "";
		int yy = Integer.valueOf(mmddyyyy.substring(4,8)).intValue();
		int mm = Integer.valueOf(mmddyyyy.substring(0,2)).intValue();
		int dd = Integer.valueOf(mmddyyyy.substring(2,4)).intValue();
		newDate =  yy+"-"+getStringwith1LeadingZeroOnlyUpToTen(mm)+"-"+getStringwith1LeadingZeroOnlyUpToTen(dd);
		return newDate;
	}
	
	public String getDateFormat_mmddyyyy(String mmddyyyy){
		String newDate = "";
		String twoDigitYr = mmddyyyy.substring(4,8);
		String mm = mmddyyyy.substring(0,2);
		String dd = mmddyyyy.substring(2,4);
		newDate =  mm+"/"+dd+"/"+twoDigitYr;
		return newDate;
	}
	
	

	public String getDateFormat_yyyy_mm_dd(String yymmdd){
		String newDate = "";
		String twoDigitYr = yymmdd.substring(0,2);
		twoDigitYr  = "20"+twoDigitYr;
		String mm = yymmdd.substring(2,4);
		String dd = yymmdd.substring(4,6);
		newDate =  twoDigitYr+"-"+mm+"-"+dd;
		return newDate;
	}
	
	public String getStringwith1LeadingZero(int input){
		String output = "";
		String leadingZero = "";
		if (input < 10) leadingZero = "0";
		if(input > 10 && input < 100) leadingZero = "0";
		if(input < 100000 && input > 10000) leadingZero = "0";
		output = leadingZero + String.valueOf(input);
		return output;
	}
	
	public String getStringwith1LeadingZeroOnlyUpToTen(int input){
		String output = "";
		String leadingZero = "";
		if (input < 10) leadingZero = "0";
		output = leadingZero + String.valueOf(input);
		return output;
	}
	
	public String getStringwith1LeadingZeroOnlyUpToSix(int input,int inpuLength){
		String output = "";
		String leadingZero = "";
		
		if (inpuLength < 6){
			for (int i =inpuLength ; i<6 ;i++)
			leadingZero += "0";
		}
		output = leadingZero + String.valueOf(input);
		return output;
	}
	
	public String getStringwith1LeadingZeroUpToAny(String input,int inpuLength,int totLength){
		String output = "";
		String leadingZero = "";
		
		if (inpuLength < totLength){
			for (int i =inpuLength ; i<totLength ;i++)
			leadingZero += "0";
		}
		output = leadingZero + input;
		return output;
	}
	
	public String getStringwith1LeadingZeroForDate(int input){
		String output = "";
		String leadingZero = "";
		if (input < 10) leadingZero = "0";
		if(input < 100000 && input > 10000) leadingZero = "0";
		output = leadingZero + String.valueOf(input);
		return output;
	}
	
	public String getStringwithLeadingZero(int len ,String input, int width){
		
		String output = "";
		String leadingZero = "";
		
		for ( int i = len;  i < width;  i++ ) {
			 leadingZero += "0";
			}
		
		output = leadingZero + String.valueOf(input);
		
		return output;
	}
	
	
	
	public String removeCharactersFromString(String input){
		String output = "";
		String ch;       // One of the characters in str.
		
		for ( int i = 0;  i < input.length();  i++ ) {
			ch = String.valueOf(input.charAt(i)).toString();
			if(!ch.equals("$") && !ch.equals(",") && !ch.equals("'")&& !ch.equals("/")){
				output = output + ch;
			}
		}
		return output;
	}
	
	public String removeSpecialCharactersFromString(String input){
		String output = "";
		String ch;       // One of the characters in str.
		
		for ( int i = 0;  i < input.length();  i++ ) {
			ch = String.valueOf(input.charAt(i)).toString();
			if(!ch.equals(">") && !ch.equals("=") &&!ch.equals("<")){
				output = output + ch;
			}
		}
		return output;
	}
	

	public String removeSpecialCharactersStar(String input){
		String output = "";
		String ch;       // One of the characters in str.
		
		for ( int i = 0;  i < input.length();  i++ ) {
			ch = String.valueOf(input.charAt(i)).toString();
			if(!ch.equals("'\"'") && !ch.equals("=") &&!ch.equals("<")){
				output = output + ch;
			}
		}
		return output;
	}
	
	
	public String  CheckStringChar(String input,int index){
		String ch;    
		ch = String.valueOf(input.charAt(index)).toString();
		return ch;
	
	}
	
	public String  ReplaceStringWithString(String input,String repString, String newString){
		String output = input.replaceAll(repString,newString);
		return output;
	}
	
	public String  ReplaceStringInPhone(String input){
		String output = input.replaceAll("[^a-zA-Z0-9]", "");
		return output;
	}
	
	public String  RemoveSpacesFromString(String input){
		//String output = input.replaceAll(repString,newString);
		String output  = input.replaceAll("\\s{2,}"," ");
		//System.out.println("output :"+output.trim());
		return output.trim();
	}
	
	public String  RemoveSpacesFromString_A(String input){
		//String output = input.replaceAll(repString,newString);
		String output  = input.replaceAll("\\s","");
		//System.out.println("output :"+output.trim());
		return output.trim();
	}
	
	public boolean  CheckStringEndsWithStar(String input){
		boolean output = input.endsWith("*");
		return output;
	}
	
	public boolean  CheckStringBeginsWithStar(String input){
		String ch;    
		boolean output = false;
		ch = String.valueOf(input.charAt(0)).toString();
		if(ch.equals("*")){ output = true; }
		return output;
	}
	
	public boolean  CheckStringEndsWithPercentage(String input){
		boolean output = input.endsWith("%");
		return output;
	}
	
	public boolean  CheckStringBeginsWithPercentage(String input){
		String ch;    
		boolean output = false;
		ch = String.valueOf(input.charAt(0)).toString();
		if(ch.equals("%")){ output = true; }
		return output;
	}
	
	public String  CheckStringBeginsWithWord(String input,String word){
		String output = "";
		if (input.toUpperCase().startsWith(word))	output =  input.substring(3); 
		else output= input;
		
		return output;
	}
	
	public String replaceCharactersFromString(String input){
		String output = "";
		String ch;       // One of the characters in str.
		String percentageSign = "%";
		for ( int i = 0;  i < input.length();  i++ ) {
			ch = String.valueOf(input.charAt(i)).toString();
			if(ch.equals("*")){
				output = output + percentageSign;
			}
			else{
				output = output + ch;
			}
		}
		return output;
	}
	
	public String replaceStarFromString(String input){
		String output = "";
		String ch;       // One of the characters in str.
		String percentageSign = "%";
		for ( int i = 0;  i < input.length();  i++ ) {
			ch = String.valueOf(input.charAt(i)).toString();
			if(!ch.equals("*")){
				output = output + ch;
			}
			
		}
		return output;
	}
			
	public int getLinesForString(String input,int lineLength){
		int output = 0;
		int totalLength = input.length();
		output = (totalLength/lineLength)+1;
		return output;
	}
	
	public int getLinesForStringNew(String input,int lineLength){
		int output = 0;
		String inputTrim = input.trim();
		int totlen = 0;
		int totalLength = input.length();
		output = (totalLength/lineLength)+1;
		
		return output;
	}
	
	public String checkForNullValue(String input){
		String output = "";
		if ((input!=null) && !input.equals("null") && !input.equals("")){
			output = input;
		}
	
		return output;
	}	
	
	public String roundToTwoDecimals(double val){
		double val_x = val/10000;
        DecimalFormat df = new DecimalFormat("#.00");
        String new_val= df.format(val_x);
        return new_val;
	}
	
	public String roundToTwoDecimalFormatted(double val){
		double val_x = val;
        DecimalFormat df = new DecimalFormat("#.00");
        val_x = Double.valueOf(df.format(val_x));
        String new_val= getNumberWithComma(val_x);
        return new_val;
	}
	
	public String getRoundToTwoDecimals(double val){
		double val_x = val;
        DecimalFormat df = new DecimalFormat("#.00");
        String new_val= df.format(val_x);
     //   System.out.println(new_val);
        return new_val;
	}
	
	public double roundPriceToTwoDecimals(double val){
		double val_x = val/10000;
        DecimalFormat df = new DecimalFormat("#.00");
        String new_val= df.format(val_x);
        double new_double = Double.valueOf(new_val).doubleValue();
        return new_double;
	}
	
	public String roundPriceToTwoDecimalsFormatted(double val){
		double val_x = val;
        DecimalFormat df = new DecimalFormat("#.0000");
        String new_val= df.format(val_x);
        val_x = Double.valueOf(df.format(val_x));
       // double new_double = Double.valueOf(new_val).doubleValue();
        String new_val_fmt= getNumberWithComma(val_x);
        
        return new_val_fmt;
	}
	
	public double roundAmountToTwoDecimals(double val){
		double val_x = val/100;
        DecimalFormat df = new DecimalFormat("#.00");
        String new_val= df.format(val_x);
        double new_double = Double.valueOf(new_val).doubleValue();
        return new_double;
	}
	
	public double round(double val, int places) {
		long factor = (long)Math.pow(10,places);
	
		// Shift the decimal the correct number of places
		// to the right.
		
		val = val * factor;
		
		String lessThanZeroFlg = "";
		if (val < 0){
			lessThanZeroFlg = "Y";
			val = val * -1;
		}
				
		// Round to the nearest integer.
		long tmp = Math.round(val);
		
		if (!lessThanZeroFlg.equals("")){
			tmp = tmp*-1;
		}
		
	//	System.out.println("tmp :"+tmp);
		// Shift the decimal the correct number of places
		// back to the left.
		return (double)tmp / factor;
	}
	
	public double getDecimalVal(double amt,int compVal, double addVal){	
		String line = String.valueOf(amt).toString();
	//	System.out.println("line :"+line);
		int d = 0;
		int pos = line.indexOf('.');
		if (pos >= 0)
		    d = (int) Double.parseDouble(line.substring(pos+1));
	//	System.out.println("d :"+d);
		
		if (d<compVal){
			if(amt < 0){
				amt = amt*-1;
				amt +=addVal;
				amt = amt*-1;
			}
			else{
			amt = amt+addVal;
			}
		}	
		return amt;
	}
	public String getOneDecimalOnly(double amt){
		
		return dfOneDecimalOnly.format(amt);
	}
	
	public boolean methodIsNum(String s){
		try {
			Integer.parseInt(s);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static String parseSpecialChar( String text ) {
        StringBuffer buffer = new StringBuffer( text );
 
        for( int i = 0; i < buffer.length(); i++ ) {
            for( int k = 0; k < specialCharacters.length; k++ ) {
                if( buffer.charAt(i) == specialCharacters[k] ) {
                     buffer.replace( i, i + 1, replacementStrings[k] );
                     i += replacementStrings[k].length();
                } else if( (int)buffer.charAt(i) > 128 ) {
                     String replacement = "&#" + (int)buffer.charAt(i) + ";";
                     buffer.replace( i, i + 1, replacement );
                     i += replacement.length();
                }
            }
        }
        return buffer.toString();
    }
	
	public static String parseBackslashApostropheSpecialChar( String text ) {
        StringBuffer buffer = new StringBuffer( text );
 
        for( int i = 0; i < buffer.length(); i++ ) {
            for( int k = 0; k < backslashapostropheCharacters.length; k++ ) {
                if( buffer.charAt(i) == backslashapostropheCharacters[k] ) {
                     buffer.replace( i, i + 1, replacementbackslashapostropheStrings[k] );
                     i += replacementbackslashapostropheStrings[k].length();
                } else if( (int)buffer.charAt(i) > 128 ) {
                     String replacement = "&#" + (int)buffer.charAt(i) + ";";
                     buffer.replace( i, i + 1, replacement );
                     i += replacement.length();
                }
            }
        }
        return buffer.toString();
    }
	
	public static String parseSpecialCharWithBlank( String text ) {
        StringBuffer buffer = new StringBuffer( text );
 
        for( int i = 0; i < buffer.length(); i++ ) {
            for( int k = 0; k < specialCharacters.length; k++ ) {
                if( buffer.charAt(i) == specialCharacters[k] ) {
                     buffer.replace( i, i + 1, " " );
                     i += 2;
                } else if( (int)buffer.charAt(i) > 128 ) {
                     String replacement = "&#" + (int)buffer.charAt(i) + ";";
                     buffer.replace( i, i + 1, replacement );
                     i += replacement.length();
                }
            }
        }
        return buffer.toString();
    }
	
	public boolean methodIsFloat(String s){
		try {
			Float.parseFloat(s);
		}
		catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	
	public boolean methodIsInt(String s){
		try {
			Integer.parseInt(s);
		}
		catch (NumberFormatException nfe){
			return false;
		}
		return true;
	}
	
	public boolean methodIsDouble(String s){
		try {
			Double.parseDouble(s);
		}
		catch (NumberFormatException nfe){
			//System.out.println("return false in methodIsInt");
			return false;
		}
		return true;
	}
	
	public String  removeSpacesInString(String input){
		String output = input.replaceAll(" +", " ");
		return output;
	}
	
	
	
	public String  removeSingleQuote(String input){
		//System.out.println("input :"+input);
		String output = input.replaceAll("'", "");
	//	System.out.println("output :"+output);
		return output;
	}
	
	public String  truncateString(String input,int len){
	
		if(input.length()>len){
			input = input.substring( 0,len);
		}
		return input;
	}
		
	
	public void checkBigdecilma(){
		double x_weight = 123456756;
		double d_weight = x_weight/100;
		System.out.println("d_weight :"+d_weight);
		BigDecimal tot_weight = new BigDecimal(d_weight); 
		 BigDecimal weight_twodecimal = new BigDecimal(0.0);
		 weight_twodecimal    = tot_weight.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		 System.out.println("weight_twodecimal :"+weight_twodecimal);
		
	}
	
	
	public String removePackageCode(String input){
		//System.out.println("find char [ :"+input.indexOf("["));
		String subInput= "";
		int findchar = input.indexOf("[");
		if (findchar!=-1){
			subInput = input.substring(0,findchar);
			
		}
		else{
			subInput = input;
		}
		//System.out.println("subInput :"+subInput);
		return subInput;
	}
	
	
	public static void main(String args[])
	{
		
		DataFormat x = new DataFormat();
		//DateConverter dateConverter = new DateConverter();
		//String input="This is test' for 'single quote";
		//x.getIntWithSuppressZeroWithComma(0);
		//	x.getDateFormat_mmddyyyy_twodigityear("10/30/2007");
	//	x.dateToJulian(yy,mm,dd);
	//	x.dateToJulian(yy,mm,dd);
	//	x.julianToJulian(106110,-60);
		
	//	String xx = "null";			
						
	//	x.getLinesForString("THIS IS A TEST" +
	//						" PLEASE WAIT. " +
	//						"WE WILL TAKE YOUR" +
	//						" CALL AS SOONLL MAY" +
	//						" BE MONITORED. THIS " +
	//						"IS A TEST. PLEASE WAIT. WE WILL T",85);
	//
	//	x.checkForNullValue(xx);
		//x.getDecimalVal(3.20,10,0.01);
	//	x.getDateFormat_mmddyyyy("08252009");
	//String xval = x.RemoveSpacesFromString_A("30-Industrial Aftermarket     ");
	//System.out.println("xval :"+xval);
	//	String testString  = "CARDINAL   GROUND     286042     CO" ;
	//	String parsedString = x.removeSpacesInString(testString);
	//	parsedString = x.truncateString(parsedString, 30);
	//	String doco="154709";
		
	//	String y = x.getStringwithLeadingZero(doco.length(),doco,8);
	//	boolean i = x.methodIsDouble("9058");
	//	System.out.println("i :"+i);
		///x.removeSingleQuote(input);
		//boolean isinteger = x.methodIsInt("12x");
		//System.out.println("isinteger :"+isinteger);
		//double prc_conv= x.round(6.5979,100);
		//System.out.println("prc_conv :"+prc_conv);
		// double xx= x.roundPriceToTwoDecimals(65979264);
		 //String  xxy= x.getRoundToTwoDecimals(374.6);
		//System.out.println("xxy :"+xxy);
	//	String newDate = "2015/07/07";
	//	String xphone = "*";
	//	String xnewphone  = x.replaceStarFromString(xphone);
		//xnewphone  = x.ReplaceStringWithString(xphone, ")", "");
	//System.out.println("xnewphone :"+xnewphone);
	//	int juldate  = dateConverter.getJulianDate(newDate);
	//	System.out.println("juldate :"+juldate);
		// String s = x.ReplaceStringInPhone(xphone);
		 //   s = s.replaceAll("[^a-zA-Z0-9]", "");
	//	    System.out.println(s);
	//int lnid = 9000;
	//int innLnid = String.valueOf(lnid).length();
	//	String y  = x.getStringwith1LeadingZeroOnlyUpToSix(lnid,innLnid);
		
	//	System.out.println(y);
		
		//x.checkBigdecilma();
		//x.findchar("72188CPW3VW2[H100]");
	
		//String nstringx = "Val'd&o#r";
		 String xx= "<?xml version='1.0' encoding='UTF-8' ?><DirectVendorAccess><MessageType>IR</MessageType><SenderID>2059561122</SenderID><RequestorLocationID>ON11</RequestorLocationID><TransactionID>123456789</TransactionID><RequestDate>20010101</RequestDate><ResponseTime>104346</ResponseTime><IDCode>3446</IDCode><HeaderErrorCode>0</HeaderErrorCode><HeaderErrorDesc>Success</HeaderErrorDesc><Details><Detail><ProductQualifier>VP</ProductQualifier><Product>7004</Product><QuantityRequested>1</QuantityRequested><UnitOfMeasure>EA</UnitOfMeasure><DetailErrorCode>0</DetailErrorCode><DetailErrorDesc>Successful</DetailErrorDesc><ResponseDetails><ResponseDetail><LocationID>119346</LocationID><ProductQualifier>VP</ProductQualifier><Product>7004</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>EDMONTON</CityName><StateCode>AB</StateCode><CountryCode>AB</CountryCode><PostalCode>T6E 5N9</PostalCode><AvailableQty>10864</AvailableQty><PriceType>Future</PriceType><Price>35.23</Price><Warehouse>EDM</Warehouse></ResponseDetail><ResponseDetail><LocationID>119348</LocationID><ProductQualifier>VP</ProductQualifier><Product>7004</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>MISSISSAUGA</CityName><StateCode>ON</StateCode><CountryCode>ON</CountryCode><PostalCode>L5W 1Y4</PostalCode><AvailableQty>10588</AvailableQty><PriceType>Future</PriceType><Price>35.23</Price><Warehouse>HO</Warehouse></ResponseDetail></ResponseDetails></Detail><Detail><ProductQualifier>VP</ProductQualifier><Product>w12</Product><QuantityRequested>1</QuantityRequested><UnitOfMeasure>EA</UnitOfMeasure><DetailErrorCode>0</DetailErrorCode><DetailErrorDesc>Successful</DetailErrorDesc><ResponseDetails><ResponseDetail><LocationID>119346</LocationID><ProductQualifier>VP</ProductQualifier><Product>w12</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>EDMONTON</CityName><StateCode>AB</StateCode><CountryCode>AB</CountryCode><PostalCode>T6E 5N9</PostalCode><AvailableQty>0</AvailableQty><PriceType>Future</PriceType><Price>3.45</Price><Warehouse>EDM</Warehouse></ResponseDetail><ResponseDetail><LocationID>119348</LocationID><ProductQualifier>VP</ProductQualifier><Product>w12</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>MISSISSAUGA</CityName><StateCode>ON</StateCode><CountryCode>ON</CountryCode><PostalCode>L5W 1Y4</PostalCode><AvailableQty>0</AvailableQty><PriceType>Future</PriceType><Price>3.45</Price><Warehouse>HO</Warehouse></ResponseDetail></ResponseDetails></Detail><Detail><ProductQualifier>VP</ProductQualifier><Product>xxx</Product><QuantityRequested>1</QuantityRequested><UnitOfMeasure>EA</UnitOfMeasure><DetailErrorCode>0</DetailErrorCode><DetailErrorDesc>Successful</DetailErrorDesc><ResponseDetails><ResponseDetail><LocationID>119346</LocationID><ProductQualifier>VP</ProductQualifier><Product>xxx</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>EDMONTON</CityName><StateCode>AB</StateCode><CountryCode>AB</CountryCode><PostalCode>T6E 5N9</PostalCode><AvailableQty>0</AvailableQty><PriceType>Future</PriceType><Price>0.00</Price><Warehouse>EDM</Warehouse></ResponseDetail><ResponseDetail><LocationID>119348</LocationID><ProductQualifier>VP</ProductQualifier><Product>xxx</Product><UnitOfMeasure>EA</UnitOfMeasure><DateAvailable>20191011</DateAvailable><AvailableCutOffTime>104346</AvailableCutOffTime><CityName>MISSISSAUGA</CityName><StateCode>ON</StateCode><CountryCode>ON</CountryCode><PostalCode>L5W 1Y4</PostalCode><AvailableQty>0</AvailableQty><PriceType>Future</PriceType><Price>0.00</Price><Warehouse>HO</Warehouse></ResponseDetail></ResponseDetails></Detail></Details><CntOfItmsRtrnd>3</CntOfItmsRtrnd><CntOfItmsRtrndByLoc>6</CntOfItmsRtrndByLoc></DirectVendorAccess>";
		 String newstr = x.ReplaceStringWithString(xx, "'", "");
		//String newstr = x.parseBackslashApostropheSpecialChar(nstringx);
		System.out.println("newstr: "+newstr);
		
		
	//	nstringx = "Vald'or";
	//	newstr = x.parseBackslashApostropheSpecialChar(nstringx);
	//	System.out.println("newstr: "+newstr);
		
		//double amt = x..round(123454, 2);
		//System.out.println("amt: "+amt);
		
	}
}
