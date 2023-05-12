package hust.soict.ict.lab01;

import java.util.Scanner;

public class DoubleArithmetic {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter a,b: ");
		double a = keyboard.nextDouble();
		double b = keyboard.nextDouble();
		
		double sum = a + b;
		double difference = a - b;
		double product = a * b;
		double quotient;
		
		if (b != 0) {
			quotient = a / b;
			System.out.println("sum = " + sum + " difference = " + difference + " product = " + product + " quotient = " + quotient);
		}
		else {
			System.out.println("sum = " + sum + " difference = " + difference + " product = " + product + " Cannot divide 0");
		}
			

	}

}
