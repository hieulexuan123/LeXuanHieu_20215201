package hust.soict.ict.lab01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MonthDays {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int month = 0, year = 0;
		
		boolean isValid = false;
		do {
			System.out.println("Enter month: ");
			String monthString = scanner.next();
			switch (monthString) {
				case "January":
				case "Jan":
				case "Jan.":
				case "1": 
					month = 1;
					isValid = true;
					break;
					
				case "February":
				case "Feb":
				case "Feb.":
				case "2": 
					month = 2;
					isValid = true;
					break;
				
				case "March":
				case "Mar":
				case "Mar.":
				case "3": 
					month = 3;
					isValid = true;
					break;
					
				case "April":
				case "Apr":
				case "Apr.":
				case "4": 
					month = 4;
					isValid = true;
					break;
					
				case "May":
				case "5": 
					month = 5;
					isValid = true;
					break;
					
				case "June":
				case "Jun":
				case "6": 
					month = 6;
					isValid = true;
					break;
				
				case "July":
				case "Jul":
				case "7": 
					month = 7;
					isValid = true;
					break;
					
				case "August":
				case "Aug":
				case "Aug.":
				case "8": 
					month = 8;
					isValid = true;
					break;
					
				case "September":
				case "Sep":
				case "Sep.":
				case "9": 
					month = 9;
					isValid = true;
					break;
					
				case "October":
				case "Oct":
				case "Oct.":
				case "10": 
					month = 10;
					isValid = true;
					break;
					
				case "November":
				case "Nov":
				case "Nov.":
				case "11": 
					month = 11;
					isValid = true;
					break;
					
				case "December":
				case "Dec":
				case "Dec.":
				case "12": 
					month = 12;
					isValid = true;
					break;
					
				default: System.out.println("Invalid month. Enter again! ");
			}
		} while (!isValid);	
		
		isValid = false;
		do {
			try {
                System.out.print("Enter a year (yyyy): ");
                year = scanner.nextInt();
                if (year >= 1000) {
                    isValid = true;
                } else {
                    System.out.println("Invalid year. Enter again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid year. Enter again!");
                scanner.nextLine();
            }      
		} while (!isValid);
		
		int numDays = 0;
		
		switch(month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10: 
		case 12:
			numDays = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numDays = 30;
			break;
		case 2:
			if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
				numDays = 29;
			}
			else {
				numDays = 28;
			}
		}
		
		System.out.println("Month " + month + " of " + year + " has " + numDays + " days.");

	}

}
