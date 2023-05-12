package hust.soict.ict.lab01;

import java.util.Scanner;

public class AddMatrices {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter num of rows: ");
		int rows = keyboard.nextInt();
		System.out.println("Enter num of cols: ");
		int cols = keyboard.nextInt();
		
		int matrix1[][] = new int[rows][cols];
		int matrix2[][] = new int[rows][cols];
		int sum[][] = new int[rows][cols];
		
		System.out.println("Enter first matrix: ");
		for (int i=0; i<rows; i++)
			for (int j=0; j<cols; j++) {
				System.out.println("Enter row " + (i+1) + " col " + (j+1) + ": ");
				matrix1[i][j] = keyboard.nextInt();
			}
		
		System.out.println("Enter second matrix: ");
		for (int i=0; i<rows; i++)
			for (int j=0; j<cols; j++) {
				System.out.println("Enter row " + (i+1) + " col " + (j+1) + ": ");
				matrix2[i][j] = keyboard.nextInt();
			}
		
		System.out.println("Sum of two matrices: ");
		for (int i=0; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				sum[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(sum[i][j] + " ");
			}
			System.out.println();
		}
			
	}

}
