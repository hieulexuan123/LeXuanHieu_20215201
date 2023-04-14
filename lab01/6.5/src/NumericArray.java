import java.util.Arrays;
import java.util.Scanner;

public class NumericArray {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter number of elements: ");
		int n = keyboard.nextInt();
		
		int arr[] = new int[n];
		int sum = 0;
		for (int i=0; i<n; i++) {
			System.out.println("Enter number" + (i+1));
			arr[i] = keyboard.nextInt();
			sum += arr[i];
		}
		
		Arrays.sort(arr);
		
		double average = (double)sum/n;
		
		System.out.println("Sorted array: " + Arrays.toString(arr));
		System.out.println("Sum is " + sum);
		System.out.println("Average is " + average);

	}

}
