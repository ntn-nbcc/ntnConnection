/**
 * LeapYear.java - 
 *   Given a year it is calculated if that year
 *   is a leap year.  Leap year calculation was 
 *   one of the big issues in the Y2K problem.  
 *
 *   The specific rules for determining leap years are:
 *
 *     1) If a year is divisible by 4 it is a
 *        leap year if #2 does not apply.
 *     2) If a year is divisible by 100 it is 
 *        not a leap year unless #3 applies.
 *     3) If a year is divisible by 400 it is
 *        a leap year.
 *
 *   Many programs are believed to have incorrect 
 *   logic for computing leap years due to the 
 *   omission of #2 and/or #3.
 *
 *   The handling of the 1900's vs. 2000's is
 *   done by a technique called windowing.  This
 *   is a common strategy that was used to "solve"
 *   the Y2K problem.  However, the problem has
 *   realy just been postponed by some number
 *   of years.
 * 
 *   NOTE: This program ignores changes in the 
 *         Gregorian calendar and only applies
 *         correctly to dates after 1582.
 *
 * @author Grant William Braught
 * @author Dickinson College
 * @version 9/17/2001
 */


/*
 * Created on Jun 20, 2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.ntn.utils;



/**
 * @author sjhaveri
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CheckLeapYear {

	/**
	 * 
	 */
	public CheckLeapYear() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
	}

	public boolean checkLeapYear(int year){
		boolean leapYear_YN = false;
		
		if (year < 100) {
		    // If the year is greater than 40 assume it
		    // is from 1900's.  If the year is less than
		    // 40 assume it is from 2000's.
		    if (year > 40) {
			year = year + 1900;
		    }
		    else {
			year = year + 2000;
		    }
		}

		// Is year Divisible by 4?
		if (year % 4 == 0) {
		    // Is year Divisible by 4 but not 100?
		    if (year % 100 != 0) {
		    	leapYear_YN  = true;
			 }
		    // Is year Divisible by 4 and 100 and 400?
		    else if (year % 400 == 0) {
		    	leapYear_YN  = true;
			
		    }
		    // It is Divisible by 4 and 100 but not 400!
		    else {
		    	leapYear_YN  = false;
		    }
		}
		// It is not divisible by 4.
		else {
			leapYear_YN  = false;
		}	
		return leapYear_YN;
	}
}
