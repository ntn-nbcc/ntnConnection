/*
 * Created on May 25, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DateConverter {
	NTNLogger logger = new NTNLogger("DateConverter");
	DataFormat dataFormat = new DataFormat();
	CheckLeapYear chkLeapYear = new CheckLeapYear();
	Calendar date;
	/**
	 * 
	 */
	public DateConverter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	   public int getJulianDate(String inDate){
			int yy = Integer.valueOf(inDate.substring(0,4)).intValue();
			int mm = Integer.valueOf(inDate.substring(5,7)).intValue();
			int dd = Integer.valueOf(inDate.substring(8,10)).intValue();
			String dateConvert = dateToJulian(yy,mm,dd);
			int julianDate = Integer.valueOf(dateConvert).intValue();

			return julianDate;	
	    }
	   
	   public String getJulianDate(int inDate){
		   String strInDate = String.valueOf(inDate).toString();
			int yy = Integer.valueOf(strInDate.substring(0,4)).intValue();
			int mm = Integer.valueOf(strInDate.substring(5,7)).intValue();
			int dd = Integer.valueOf(strInDate.substring(8,10)).intValue();
			String dateConvert = dateToJulian(yy,mm,dd);
			//int julianDate = Integer.valueOf(dateConvert).intValue();

			return dateConvert;	
	    }
	   
	   public int getJulianDateYYYYMMDD(String inDate){
			int yy = Integer.valueOf(inDate.substring(0,4)).intValue();
			int mm = Integer.valueOf(inDate.substring(4,6)).intValue();
			int dd = Integer.valueOf(inDate.substring(6,8)).intValue();
			String dateConvert = dateToJulian(yy,mm,dd);
			int julianDate = Integer.valueOf(dateConvert).intValue();

			return julianDate;	
	    }

	public String dateToJulian(int yy, int mm, int dd)
	{
	 	GregorianCalendar gcalendar = new GregorianCalendar(yy,mm-1,dd);
		int dayofyear = gcalendar.get(Calendar.DAY_OF_YEAR);
		//System.out.println("yearcc :"+gcalendar.get(Calendar.YEAR)+" mm :"+gcalendar.get(Calendar.MONTH));
		int firstpart=gcalendar.get(Calendar.YEAR)-1900;
		String stringDayOfYear = String.valueOf(dayofyear);
				
		if (dayofyear < 10)
			stringDayOfYear = "00"+stringDayOfYear;
		else if(dayofyear<100)
			stringDayOfYear = "0"+stringDayOfYear;
		
		String newJulian = String.valueOf(firstpart)+stringDayOfYear;
				
		return(newJulian);
	}
	
	public String julianToDate(int julianDate){
		GregorianCalendar  gdate = new GregorianCalendar();
	
		CheckLeapYear chkLeapYear = new CheckLeapYear();
				
		String julDate = dataFormat.getStringwith1LeadingZeroForDate(julianDate);
		int julYear = Integer.valueOf(julDate.substring(0,3)).intValue();
		int julDay = Integer.valueOf(julDate.substring(3,6)).intValue();

		String newDate = "";
		int newDateYear = 0;
		int newDateMonth = 0;
		int newDateDay = 0;
		
		int[] monthOffSet = {0,31,59,90,120,151,181,212,243,273,304,334,365}; 
		int[] monthOffSetLeapYear = {0,31,60,91,121,152,182,213,244,274,305,335,366}; 
		int[] monthLength = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		
		if (julYear < 100 ){
			newDateYear  = julYear+1900;
		}
		else{
			newDateYear = julYear-100+2000;
		}
		boolean  leapYear = chkLeapYear.checkLeapYear(newDateYear);	
		
		if (julDay < 32) {
			newDateMonth = 1;
			newDateDay = julDay;
		}
		else{
			for (int i=1 ; i<12 ; i++){
				if (leapYear){			
					if (julDay > monthOffSetLeapYear[i] && julDay <= monthOffSetLeapYear[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSetLeapYear[i];
						break;
					}	
				}
				else{
					if (julDay > monthOffSet[i] && julDay <= monthOffSet[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSet[i];
						break;
					}
				}
			}
			
		}
		String stringDay = dataFormat.getStringwith1LeadingZeroForDate(newDateDay);
		String stringMonth = dataFormat.getStringwith1LeadingZeroForDate(newDateMonth);
		String stringYear = String.valueOf(newDateYear);
		newDate = dataFormat.getDateFormat_mmddyy_WithSlash(stringYear, stringMonth,stringDay );
		
		return newDate;
	}
	
	public String julianToNormalDate(int julianDate){
		GregorianCalendar  gdate = new GregorianCalendar();
	
		CheckLeapYear chkLeapYear = new CheckLeapYear();
				
		String julDate = dataFormat.getStringwith1LeadingZeroForDate(julianDate);
		int julYear = Integer.valueOf(julDate.substring(0,3)).intValue();
		int julDay = Integer.valueOf(julDate.substring(3,6)).intValue();

		String newDate = "";
		int newDateYear = 0;
		int newDateMonth = 0;
		int newDateDay = 0;
		
		int[] monthOffSet = {0,31,59,90,120,151,181,212,243,273,304,334,365}; 
		int[] monthOffSetLeapYear = {0,31,60,91,121,152,182,213,244,274,305,335,366}; 
		int[] monthLength = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		
		if (julYear < 100 ){
			newDateYear  = julYear+1900;
		}
		else{
			newDateYear = julYear-100+2000;
		}
		boolean  leapYear = chkLeapYear.checkLeapYear(newDateYear);	
		
		if (julDay < 32) {
			newDateMonth = 1;
			newDateDay = julDay;
		}
		else{
			for (int i=1 ; i<12 ; i++){
				if (leapYear){			
					if (julDay > monthOffSetLeapYear[i] && julDay <= monthOffSetLeapYear[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSetLeapYear[i];
						break;
					}	
				}
				else{
					if (julDay > monthOffSet[i] && julDay <= monthOffSet[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSet[i];
						break;
					}
				}
			}
			
		}
		String stringDay = dataFormat.getStringwith1LeadingZeroForDate(newDateDay);
		String stringMonth = dataFormat.getStringwith1LeadingZeroForDate(newDateMonth);
		String stringYear = String.valueOf(newDateYear);
		newDate = stringYear+stringMonth+stringDay;
		
		return newDate;
	}
	
	public String julianToYYYY_MM_DDFormat(int julianDate){
		String newDate = "";
		String formatedDate="";
		newDate = julianToNormalDate(julianDate);
		formatedDate = dataFormat.getDateFormat_yyyymmddslash(newDate);
		
		return formatedDate;
	}
	
	public String julianToYYYY_MM_DDFormatSlash(int julianDate){
		String newDate = "";
		String formatedDate="";
		newDate = julianToNormalDate(julianDate);
		formatedDate = dataFormat.getDateFormat_yyyymmdd(newDate);
		
		return formatedDate;
	}


	public String julianToDueDate(int julianDate, int addDays){
		GregorianCalendar  gdate = new GregorianCalendar();
		
		CheckLeapYear chkLeapYear = new CheckLeapYear();
		
		String julDate = dataFormat.getStringwith1LeadingZeroForDate(julianDate);
		int julYear = Integer.valueOf(julDate.substring(0,3)).intValue();
		int julDay = Integer.valueOf(julDate.substring(3,6)).intValue();
		String julStringYear = julDate.substring(0,3);
		String lastDateOfYear = "";

		String newDate = "";
		int newDateYear = 0;
		int newDateMonth = 0;
		int newDateDay = 0;
		
		int[] monthOffSet = {0,31,59,90,120,151,181,212,243,273,304,334,365}; 
		int[] monthOffSetLeapYear = {0,31,60,91,121,152,182,213,244,274,305,335,366}; 
		int[] monthLength = {31,28,31,30,31,30,31,31,30,31,30,31}; 
		
		if (julYear < 100 ){
			newDateYear  = julYear+1900;
		}
		else{
			newDateYear = julYear-100+2000;
		}
		boolean  leapYear = chkLeapYear.checkLeapYear(newDateYear);	
		
		if (leapYear) {
			lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_LEAP_YEAR;
		}
		else{
			lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_YEAR;
		}
	//	System.out.println("lastDateOfYear :"+lastDateOfYear+"julDate :"+julDate);
		if (Integer.valueOf(lastDateOfYear).intValue()-Integer.valueOf(julDate).intValue()< addDays){
			
			julDay = addDays-(Integer.valueOf(lastDateOfYear).intValue()-Integer.valueOf(julDate).intValue());
			julYear = Integer.valueOf(julDate.substring(0,3)).intValue()+1;
			newDateYear = newDateYear+1;
		//	System.out.println("julYear :"+julYear);
		}
		else{
			julDay = Integer.valueOf(julDate.substring(3,6)).intValue()+addDays;
		}
		
		if (julDay < 32) {
			newDateMonth = 1;
			newDateDay = julDay;
		}
		else{
			for (int i=1 ; i<12 ; i++){
				if (leapYear){			
					if (julDay > monthOffSetLeapYear[i] && julDay <= monthOffSetLeapYear[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSetLeapYear[i];
						break;
					}	
				}
				else{
					if (julDay > monthOffSet[i] && julDay <= monthOffSet[i+1]){
						newDateMonth = i+1;
						newDateDay = julDay-monthOffSet[i];
						break;
					}
				}
			}
			
		}
		String stringDay = dataFormat.getStringwith1LeadingZeroForDate(newDateDay);
		String stringMonth = dataFormat.getStringwith1LeadingZeroForDate(newDateMonth);
		String stringYear = String.valueOf(newDateYear);
		newDate = dataFormat.getDateFormat_mmddyy_WithSlash(stringYear, stringMonth,stringDay );
		return newDate;
	}
	
	public int julianToJulian(int julianDate, int addDays){
	
		int newJulian = 0;
		int newYear = 0;
		String julDate = dataFormat.getStringwith1LeadingZeroForDate(julianDate);
		
		int julDay = Integer.valueOf(julDate.substring(3,6)).intValue();
		int julYear = Integer.valueOf(julDate.substring(0,3)).intValue();
		String julStringYear = julDate.substring(0,3);
		String lastDateOfYear = " ";
		
		if (julYear < 100 ){newYear  = julYear+1900;}
		else{newYear = julYear-100+2000;}
		
		boolean  leapYear = chkLeapYear.checkLeapYear(newYear);	
		
		if (leapYear) {lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_LEAP_YEAR;}
		else{lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_YEAR;}
		
		if ((julDay+addDays)<=0){
			newYear -=1;
			leapYear = chkLeapYear.checkLeapYear(newYear);	
			julStringYear = String.valueOf((Integer.valueOf(julStringYear).intValue()-1)).toString();
			
			if (leapYear) {lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_LEAP_YEAR;}
			else{lastDateOfYear = julStringYear+Constants.INVOICE_LAST_DAY_OF_YEAR;}
			
			
			newJulian = Integer.valueOf(lastDateOfYear).intValue() +(julDay+addDays);
			
		}
		else{
			if(julianDate+addDays>Integer.valueOf(lastDateOfYear).intValue()){
				julStringYear = String.valueOf((Integer.valueOf(julStringYear).intValue()+1)).toString();
				String  newStringDate = dataFormat.getStringwith1LeadingZeroForDate((julianDate+addDays)-Integer.valueOf(lastDateOfYear).intValue());
				newStringDate = dataFormat.getStringwithLeadingZero(newStringDate.length(), newStringDate, 3);
				//System.out.println("newStringDate date :"+newStringDate);
			//	String  newStringJulian = julStringYear + dataFormat.getStringwith1LeadingZeroForDate((julianDate+addDays)-Integer.valueOf(lastDateOfYear).intValue());
				String  newStringJulian = julStringYear + newStringDate;

				//System.out.println("formatted date :"+dataFormat.getStringwith1LeadingZeroForDate((julianDate+addDays)));
				//System.out.println("lastDateOfYear :"+Integer.valueOf(lastDateOfYear).intValue());
				newJulian = Integer.valueOf(newStringJulian).intValue();
				
			}
			else{
				newJulian = julianDate + addDays;
			}
		}	
	
		return newJulian;
	}
	
	public String toString()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		return (formatter.format( date.getTime() ));
	}

	
	public String getCurDate(){
		String newDate = "";
		String futDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		GregorianCalendar futcalendar = new GregorianCalendar();
		futcalendar.add(getCurMonth(), 6);
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		futDate = String.valueOf(yr).substring(2,4).toString()+stringMn+stringDay;
		newDate = String.valueOf(yr).substring(2,4).toString()+stringMn+stringDay;
		return newDate;	
	}
	
	
	public int getintCurDate(){
		String newDate = "";
		int intnewDate = 0;
		String futDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		GregorianCalendar futcalendar = new GregorianCalendar();
		futcalendar.add(getCurMonth(), 6);
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		futDate = String.valueOf(yr).substring(2,4).toString()+stringMn+stringDay;
		newDate = String.valueOf(yr).substring(2,4).toString()+stringMn+stringDay;
		
		intnewDate = Integer.valueOf(newDate).intValue();
		return intnewDate;	
	}
	
	
	public boolean CompareDatewithCurDate(String inDate) {
		boolean datePastDue=false;
		String  newdate = dataFormat.ReplaceStringWithString(inDate, "-", "");
		int intNewdate = Integer.valueOf(newdate).intValue();
		int currentDate = Integer.valueOf(this.getCurDateYYYYMMDD()).intValue();
		
		
		System.out.println("intNewdate :"+intNewdate+" currentDate :"+currentDate);
		if(intNewdate<currentDate) {
			datePastDue = true;
		}
		
		System.out.println("datePastDue :"+datePastDue);
		return datePastDue;
		
		
	}

	public String getCurDateYYYYMMDD(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);

		newDate = String.valueOf(yr).toString()+stringMn+stringDay;
		return newDate;	
	}
	
	public int getCurJulianDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		newDate = String.valueOf(yr).toString()+"/"+stringMn+"/"+stringDay;
		int newJulianDate = getJulianDate(newDate);
		return newJulianDate;	
	}
	
	public int getJulianLastDayOfMonthDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = this.getLastDayOfMonth(1);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		newDate = String.valueOf(yr).toString()+"/"+stringMn+"/"+stringDay;
		int newJulianDate = getJulianDate(newDate);
		return newJulianDate;	
	}
	
	public int getJulianFirstDayOfMonthDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		int day = 1;
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		newDate = String.valueOf(yr).toString()+"/"+stringMn+"/"+stringDay;
		int newJulianDate = getJulianDate(newDate);
		return newJulianDate;	
	}
	
	public int getJulianLastDayOfNextMonthDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=2;
		
		int day = this.getLastDayOfMonth(0);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		newDate = String.valueOf(yr).toString()+"/"+stringMn+"/"+stringDay;
		int newJulianDate = getJulianDate(newDate);
		return newJulianDate;	
	}
	
	public int getJulianFirstDayOfNextMonthDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=2;
		int day = 1;
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
		newDate = String.valueOf(yr).toString()+"/"+stringMn+"/"+stringDay;
		int newJulianDate = getJulianDate(newDate);
		return newJulianDate;	
	}
	
	public String getFormattedCurDate(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);

		newDate = stringMn+"/"+stringDay+"/"+String.valueOf(yr).substring(2,4).toString();
		return newDate;	
	}
	
	public String getFormattedCurDateYYYYMMDD(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);

		newDate = yr+"/"+stringMn+"/"+stringDay;
		return newDate;	
	}
	
	public String getFormattedDashCurDateYYYYMMDD(){
		String newDate = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH); 
		//System.out.println("mn :"+mn);
		mn+=1;
		
		int day = gcalendar.get(Calendar.DAY_OF_MONTH);
		int yr = gcalendar.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);

		newDate = yr+"-"+stringMn+"-"+stringDay;
		return newDate;	
	}
	
	public String getFormattedDashCurDateYYYYMMDD(String dat1){
		
		int datLen = dat1.length();
		String newDate="";
		if (datLen ==8){
			String stringMn = (dat1.substring(0,2));
			String stringDay = (dat1.substring(3,5));
			String yr = (dat1.substring(6,8));
			String stringYr = "20"+yr;
			System.out.println("stringMn :"+stringMn);
			System.out.println("stringDay :"+stringDay);
			System.out.println("stringYr"+stringYr);
			GregorianCalendar gcalendar = new GregorianCalendar();
			
			
		
			//int day = gcalendar.get(Calendar.DAY_OF_MONTH);
			//int yr = gcalendar.get(Calendar.YEAR);
			//String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
			//String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);
			

			newDate = stringYr+"-"+stringMn+"-"+stringDay;
			System.out.println("newDate :"+newDate);
		}	
		return newDate;	
	}
	
	public String getCurTime(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int hh =  gcalendar.get(Calendar.HOUR);
		int min = gcalendar.get(Calendar.MINUTE);
		int ampm = gcalendar.get(Calendar.AM_PM);
	
 	 	if (ampm==1) hh +=12 ;
		String stringHour = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(hh);
		String stringMinute = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(min);
		newTime = stringHour+stringMinute;
		return newTime;	
	}
	
	public String getCurTimeHHMMSS(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int hh =  gcalendar.get(Calendar.HOUR);
		int min = gcalendar.get(Calendar.MINUTE);
		int sec   = gcalendar.get(Calendar.SECOND);
		int ampm = gcalendar.get(Calendar.AM_PM);
	
 	 	if (ampm==1) hh +=12 ;
		String stringHour = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(hh);
		String stringMinute = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(min);
		String stringSecond = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(sec);
		newTime = stringHour+stringMinute+stringSecond;
		return newTime;	
	}
	
	public int getIntCurTimeHHMMSS(){
		String newTime = "";
		int intNewTime =0;
		GregorianCalendar gcalendar = new GregorianCalendar();
		int hh =  gcalendar.get(Calendar.HOUR);
		int min = gcalendar.get(Calendar.MINUTE);
		int sec   = gcalendar.get(Calendar.SECOND);
		int ampm = gcalendar.get(Calendar.AM_PM);
	
 	 	if (ampm==1) hh +=12 ;
		String stringHour = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(hh);
		String stringMinute = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(min);
		String stringSecond = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(sec);
		newTime = stringHour+stringMinute+stringSecond;
		intNewTime = Integer.valueOf(newTime).intValue();
		return intNewTime;	
	}
	
	public int  getCurHour(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentHour =  gcalendar.get(Calendar.HOUR);
		int ampm = gcalendar.get(Calendar.AM_PM);

 	 	if (ampm==1) currentHour +=12 ;
		
		return currentHour;	
	}
	
	public String  getStringCurHour(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentHour =  gcalendar.get(Calendar.HOUR);
		int ampm = gcalendar.get(Calendar.AM_PM);

 	 	if (ampm==1) currentHour +=12 ;
 	 	String strCurrentHour = String.valueOf(dataFormat.getStringwith1LeadingZeroOnlyUpToTen(currentHour));
		
		return strCurrentHour;	
	}
	
	public int getCurMin(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentMin = gcalendar.get(Calendar.MINUTE);
				
		return currentMin;	
	}
	
	public String  getStringCurMin(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentMin = gcalendar.get(Calendar.MINUTE);
		String strCurrentMin = String.valueOf(dataFormat.getStringwith1LeadingZeroOnlyUpToTen(currentMin));
		
		return strCurrentMin;	
	}
	
	public String getStringCurSecond(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentSec = gcalendar.get(Calendar.SECOND);
		String strCurrentSec = String.valueOf(dataFormat.getStringwith1LeadingZeroOnlyUpToTen(currentSec));
		return strCurrentSec;	
	}
	
	public int getCurSecond(){
		String newTime = "";
		GregorianCalendar gcalendar = new GregorianCalendar();
		int currentMin = gcalendar.get(Calendar.SECOND);
		
				
		return currentMin;	
	}
	
	public int getCurMonth(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		mn+=1;
		return mn;	
	}
	
	public int getCurMonthForJavaUtil(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int mn    = gcalendar.get(Calendar.MONTH);  
		
		return mn;	
	}
	
	public int getCurDay(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int dd    = gcalendar.get(Calendar.DAY_OF_MONTH);  
	
		return dd;	
	}
	
	public int getCurYear(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int year  = gcalendar.get(Calendar.YEAR);
		return year;	
	}
	
	public int getCurYear2Digit(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int year  = gcalendar.get(Calendar.YEAR)%100;
		return year;	
	}
	
	public String  getCurMonthName(int mn){
		String mnName = "";
		if (mn == 0) mnName = "January";
		if (mn == 1) mnName = "February";
		if (mn == 2) mnName = "March";
		if (mn == 3) mnName = "April";
		if (mn == 4) mnName = "May";
		if (mn == 5) mnName = "June";
		if (mn == 6) mnName = "July";
		if (mn == 7) mnName = "August";
		if (mn == 8) mnName = "September";
		if (mn == 9) mnName = "October";
		if (mn == 10) mnName = "November";
		if (mn == 11) mnName = "December";
		return mnName;	
	}
	
	public String  getDayName(int day){
		String dayName = "";
		if (day == 1) dayName = "Sunday";
		if (day == 2) dayName = "Monday";
		if (day == 3) dayName = "Tuesday";
		if (day == 4) dayName = "Wednsday";
		if (day == 5) dayName = "Thursday";
		if (day == 6) dayName = "Friday";
		if (day == 7) dayName = "Saturday";
		return dayName;	
	}
	//	 get day of year for a current date
	public int getDayOfYear(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int dayOfYear = gcalendar.get(Calendar.DAY_OF_YEAR);
		return dayOfYear;
	}
	//	 get day of  year for a particular date
	public int getDayOfYear(int yyyy, int mm, int dd){
		GregorianCalendar gcalendar = new GregorianCalendar(yyyy,mm-1,dd);
		int dayOfYear = gcalendar.get(Calendar.DAY_OF_YEAR);
		return dayOfYear;
	}
	//	 get day of month for a current date
	public int getDayOfMonth(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int dayOfMonth = gcalendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}
	// get day of month for a particular date
	public int getDayOfMonth(int yyyy, int mm, int dd){
		GregorianCalendar gcalendar = new GregorianCalendar(yyyy,mm-1,dd);
		int dayOfMonth = gcalendar.get(Calendar.DAY_OF_MONTH);
		return dayOfMonth;
	}
	
	public String getDayName(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int dayOfWeek = gcalendar.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		String dayName = getDayName(dayOfWeek);
		return dayName;
	}
	
	public String getNameOfDay(){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int dayOfWeek = gcalendar.get(Calendar.DAY_OF_WEEK);
		String dayName = getDayName(dayOfWeek);
		return dayName;
	}
	
	public String getDayName(int yyyy, int mm, int dd){
		GregorianCalendar gcalendar = new GregorianCalendar(yyyy,mm-1,dd);
		int dayOfWeek = gcalendar.get(Calendar.DAY_OF_WEEK);
		String dayName = getDayName(dayOfWeek);
		return dayName;
	}
	
	
	public int  getLastDayOfMonth(int yyyy, int mm, int dd){
		GregorianCalendar gcalendar = new GregorianCalendar(yyyy,mm-1,dd);
		int lastDayOfMonth = gcalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDayOfMonth;
	}
	
	public int  getLastDayOfMonth(int monthAdj){
		int yyyy = this.getCurYear();
		int mm = this.getCurMonth();
		int dd= 1;
		
		GregorianCalendar gcalendar = new GregorianCalendar(yyyy,mm-monthAdj,dd);
		int lastDayOfMonth = gcalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return lastDayOfMonth;
	}
	

	public ArrayList  getPeriodArrayList(String strPr, String endPr){
		ArrayList period = new ArrayList(1);
		int stryy = Integer.valueOf(strPr.substring(0,4)).intValue();
		int endyy = Integer.valueOf(endPr.substring(0,4)).intValue();
		int strmm = Integer.valueOf(strPr.substring(5,7)).intValue();
		int endmm = Integer.valueOf(endPr.substring(5,7)).intValue();
		
		if(stryy==endyy){
			for (int i=strmm;i <= endmm ; i++){
				String nextpr = String.valueOf(stryy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(i);
				period.add(nextpr);
			}
			
		}
		if(stryy!=endyy){
			
				for (int i=strmm;i <= 12 ; i++){
					String nextpr = String.valueOf(stryy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(i);
					period.add(nextpr);
				}
		///////////
			for (int j = stryy+1 ; j<endyy ; j++){
				for (int i=1;i <= 12 ; i++){
					String nextpr = String.valueOf(j).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(i);
					period.add(nextpr);
				}
				
			}
		///////////	
			
			
			
		for (int i=1;i <= endmm ; i++){
				String nextpr = String.valueOf(endyy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(i);
				period.add(nextpr);
			}
		}
		return period;
	}
	
	public ArrayList  getYearArrayList(String strPr, String endPr){
		ArrayList period = new ArrayList(1);
		int stryy = Integer.valueOf(strPr.substring(0,4)).intValue();
		int endyy = Integer.valueOf(endPr.substring(0,4)).intValue();
	
		if(stryy!=endyy){
			for (int j = stryy ; j<=endyy ; j++){
				int nextyy = j;
				String nextpr = String.valueOf(nextyy).toString();
		//		System.out.println("nextpr :"+nextpr);
				period.add(nextpr);
			}
		}
		
		return period;
	}
	
	public String  getPeriod(String yyyymmdd){
		int yy = Integer.valueOf(yyyymmdd.substring(0,4)).intValue();
		int mm = Integer.valueOf(yyyymmdd.substring(4,6)).intValue();
		String pr = String.valueOf(yy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mm);
		return pr;
	}
	
	public String  getmmddyyyyformat(String yyyymmdd){
		String yy = yyyymmdd.substring(0,4);
		String mm = yyyymmdd.substring(4,6);
		String dd = yyyymmdd.substring(6,8);
		
		System.out.println("yy: "+yy+" mm: "+mm+" dd: "+dd);
		String finaldate = mm+dd+yy;
		return finaldate;
	}
	
	
	public String  getYear(String yyyymmdd){
		String yy = yyyymmdd.substring(0,4);
		return yy;
	}
	
	public String  getYearFromPeriod(String yyyymm){
		//System.out.println("yyyymm :"+yyyymm);
		int yy = Integer.valueOf(yyyymm.substring(0,4)).intValue();
		String yr = String.valueOf(yy).toString();
		//System.out.println("yr :"+yr);
		return yr;
	}
	
	public String  getLastYearPeriod(String yyyymmdd){
		int prvyy = Integer.valueOf(yyyymmdd.substring(0,4)).intValue()-1;
		int strmm = Integer.valueOf(yyyymmdd.substring(5,7)).intValue();
		String pr = String.valueOf(prvyy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(strmm);
		return pr;
	}
	
	public String getDateFormattedYYYYMMDD(Calendar ddmmyywithslash){
		int mn    = ddmmyywithslash.get(Calendar.MONTH);  
		mn+=1;
		
		int day = ddmmyywithslash.get(Calendar.DAY_OF_MONTH);
		int yr = ddmmyywithslash.get(Calendar.YEAR);
		String stringMn = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mn);
		String stringDay = dataFormat.getStringwith1LeadingZeroOnlyUpToTen(day);

		String newDate = yr+stringMn+stringDay;
		return newDate;
	}
	
	public String addDaysToToday()
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE,365); // Adding 5 days
		String output = sdf.format(c.getTime());
		String newDate = getDateFormattedYYYYMMDD(c);
		//System.out.println(newDate);
		return newDate;
	}

	public  Date JulianDateToJavaDate(Integer julianDate) {
		Date date = null;
		String j = julianDate.toString();
		try {
			date = new SimpleDateFormat("Myydd").parse(j);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
		return date;
	}
	
//	public String  getFormattedyyyymmdd(String yyyy_mm_dd){
//		int yy = Integer.valueOf(yyyy_mm_dd.substring(0,4)).intValue();
//		int mm = Integer.valueOf(yyyy_mm_dd.substring(5,7)).intValue();
//		int dd = Integer.valueOf(yyyy_mm_dd.substring(7,10)).intValue();
//		System.out.println("yy :"+yy+" mm :"+mm+" dd :"+dd);
//		String dt = String.valueOf(yy).toString()+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(mm)+dataFormat.getStringwith1LeadingZeroOnlyUpToTen(dd);
//		System.out.println("dt :"+dt);
//		return dt;
//	}
	
	
	public static void main(String args[]){
		GregorianCalendar gcalendar = new GregorianCalendar();
		int j = 124;
		int yy= 2019;
		int mm= 10;
		int dd= 4;
		String strpr = "200801";
		String endpr = "200902";
		DateConverter x = new DateConverter();
			//x.dateToJulian(yy,mm,dd);
			//String xx = x.getmmddyyyyformat("20191104");
			//System.out.println("xx: "+xx);
//			int lst = x.getJulianFirstDayOfMonthDate();
//			System.out.println("lst :"+lst);
			//int lst = x.getJulianLastDayOfMonthDate();
			//System.out.println("lst :"+lst);
			//lst = x.getJulianFirstDayOfMonthDate();
			//System.out.println("Fst :"+lst);
			
			//Date xx = x.JulianDateToJavaDate(120091);
			//System.out.println("xx :"+xx);
//			lst = x.getJulianLastDayOfNextMonthDate();
//			System.out.println("lst :"+lst);
		//	x.dateToJulian(yy,mm,dd);
			//String curdt= x.getCurDateYYYYMMDD();
		//System.out.println("curdt : "+curdt);
			
			//x.CompareDatewithCurDate("2019-10-10");
	//	x.getFutureDate();
		//	x.getCurTime();
		//	x.getlastday(yy,mm, dd);
		//	x.getDayOfYear(yy,mm,dd);
	//	int y = x.getCurMonth();
	//	for (int i=y; i<12+y;i+=1){
	//		String mnnm = "";
	//		int yr = 0;
	//		if(i <= 12){
	//			mnnm = x.getCurMonthName(i-1);
	//			yr = x.getCurYear();
	//			
	//		}
	//		if (i>12){
	//			mnnm = x.getCurMonthName(i-13);
	//			yr = x.getCurYear()+1;
	//					
	//		}
	//		String year = String.valueOf(yr).toString().substring(2);
			
			//String dt = x.julianToDueDate(112061,183);
//		//	String title = mnnm.substring(0, 3)+"'"+year;
		//	String sdt = x.julianToNormalDate(112046);
		//	int juldate_12 = x.julianToJulian(112254, 183);
			
	//		System.out.println("juldate_12 :"+juldate_12);
			
		//	String normaldate = x.julianToNormalDate(juldate_12);
		//	System.out.println("normaldate :"+normaldate);
		 String per = x.getPeriod("20200501");
		 System.out.println("per :"+per);
			//String dt  = x.julianToNormalDate(115230);
			//System.out.println("dt :"+dt);
			//String xyy = dt.substring(0, 4);
			//String xmm = dt.substring(4, 6);
			//String xdd = dt.substring(6, 8);
			//System.out.println("xyy :"+xyy);
			//System.out.println("xmm :"+xmm);
			//System.out.println("xdd :"+xdd);
			//int intyy = Integer.valueOf(xyy).intValue();
			//int intmm = Integer.valueOf(xmm).intValue();
			//int intdd = Integer.valueOf(xdd).intValue();
			//int lastdt = x.getLastDayOfMonth(intyy, intmm, intdd);
			
			//System.out.println("lastdt :"+lastdt);
			//String lastday = xyy+xmm+String.valueOf(lastdt).toString();
			//System.out.println("lastday :"+lastday);
			//String curdt = x.getCurDateYYYYMMDD();
			//System.out.println("curdt :"+curdt);
			
// intdt  = 116053; 
			//String datemmddyy = x.julianToYYYY_MM_DDFormatSlash(intdt);
			//System.out.println("datemmddyy :"+datemmddyy);
			//x.addDaysToToday();
		//	String ndt = x.getCurDateYYYYMMDD();
			//System.out.println(ndt);
	}	//
}
