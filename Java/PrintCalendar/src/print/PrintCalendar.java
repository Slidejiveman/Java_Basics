package print;

import java.util.Scanner;
// TODO: Put in a while loop to keep program running until
//       successful completion
public class PrintCalendar {
    /** Main method */
	public static void main(String args[]) {
		// prompt user to enter year
		Scanner input = new Scanner(System.in);
		System.out.print("Enter full year (e.g., 2001): ");
		int year = input.nextInt();
		
		// prompt user to enter month
		System.out.print("Enter month in number between 1 and 12: ");
		int month = input.nextInt();
		
		// validate input
		if(year < 1800 || (month < 1 || month > 12)) {
			System.out.println("Please enter a year more recent " +
					 "than 1800 and a month value in range 1-12.");
		} else {
		    // Print calendar for the month of the year
			printMonth( year, month );
		}
		// Close input
		input.close();
	}
	
	static void printMonth(int year, int month) {
		// Print the headings of the calendar
		printMonthTitle(year, month);
		
		// Print the body of the calendar
		printMonthBody(year, month);
	}
	
	/** Print the month title, e.g., May, 1999 */
	static void printMonthTitle(int year, int month) {
		System.out.println("         " + getMonthName(month) +
				             " " + year);
		System.out.println("------------------------------");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
	}
	
	/** Get the English name for the month */
	static String getMonthName(int month) {
		String monthName = null;
		switch (month) {
		  case 1:  monthName = "January"   ; break;
		  case 2:  monthName = "February"  ; break;
		  case 3:  monthName = "March"     ; break;
		  case 4:  monthName = "April"     ; break;
		  case 5:  monthName = "May"       ; break;
		  case 6:  monthName = "June"      ; break;
		  case 7:  monthName = "July"      ; break;
		  case 8:  monthName = "August"    ; break;
		  case 9:  monthName = "September" ; break;
		  case 10: monthName = "October"   ; break;
		  case 11: monthName = "Novemenber"; break;
		  case 12: monthName = "December"  ;
		}
		return monthName;
	}
	
	/** Print month body */
	static void printMonthBody(int year, int month) {
		// Get start day of the week for the first date in the month
		int startDay = getStartDay(year, month);
		
		//Get number of days in Month
		int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);
		
		// Pad space before the first day of the month
		for(int i = 0; i < startDay; i++) {
			System.out.print("    "); // 4 spaces is required to line up
		}
		
		for(int i = 1; i <= numberOfDaysInMonth; i++) {
			if(i < 10) {
				System.out.print("   " + i); // singles need 3
			} else {
				System.out.print("  " + i);  // doubles need 2
			}
			if(( i + startDay) % 7 == 0) {   // there are 7 days in a week
				System.out.println();
			}
		}
		
		System.out.println();
	}
	
	/** Get the start day of month/1/year */
	static int getStartDay(int year, int month) {
		
		// Hard coding in a start day to calculate offsets from
		final int START_DAY_FOR_JAN_1_1800 = 3;
		
		// Get total number of days from 1/1/1800 to month/1/year
		int totalNumberOfDays = getTotalNumberOfDays(year,month);
		
		// Return the start day for month/1/year
		return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
	}
	
	/** Get the total number of days since January 1, 1800 */
	static int getTotalNumberOfDays(int year, int month) {
		int total = 0;
		
		// Get the total days from 1800 to 1/1/year
		for(int i = 1800; i < year; i++) {
			if(isLeapYear(i)) {
				total += 366;
			} else {
				total += 365;
			}
		}
		
		// Add days from Jan to the month prior to the calendar month
		for (int i = 1; i < month; i++) {
			total += getNumberOfDaysInMonth(year, i);
		}
		return total;
	}
	
	/** Get the number of days in a month */
	static int getNumberOfDaysInMonth(int year, int month) {
		if(month == 1 || month == 3 || month == 5 || month == 7 ||
				month == 8 || month == 10 || month == 12) {
			return 31;
		} else if (month == 4 || month == 6 || month ==9 || 
				month == 11) {
			return 30;
		} else if (month == 2) {
			// if leap year, return 29, otherwise 28
			return isLeapYear(year) ? 29 : 28;
		} else {
			return 0; // month is incorrect
		}
	}
	
	/** Determine if it is a leap year */
	static boolean isLeapYear(int year) {
		return year % 400 == 0 || (year % 4 == 0 && year % 100 !=0);
	}
}
