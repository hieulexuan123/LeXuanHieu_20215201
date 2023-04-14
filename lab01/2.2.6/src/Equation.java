import java.util.Scanner;

public class Equation {

	public static void main(String[] args) {
		 Scanner keyboard = new Scanner(System.in);

        String choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Solve first-degree equation");
            System.out.println("2. Solve system of first-degree equation");
            System.out.println("3. Solve second-degree-equation");
            System.out.println("q. Quit");

            System.out.print("Enter your choice: ");
            choice = keyboard.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("ax + b = 0");
                    int a, b;
                    
                    do {
                    	System.out.println("enter a: ");
                        a = keyboard.nextInt();
                    } while (a==0);
                    System.out.println("enter b: ");
                    b = keyboard.nextInt();
                    
                    System.out.println("x = " + (double) -b /a);    
                    
                    keyboard.nextLine();
                    
                    break;
                case "2":
                    System.out.println("a11x1 + a12x2 = b1");
                    System.out.println("a21x1 + a22x2 = b2");
                    
                    System.out.println("Enter a11 a12 a21 a22 b1 b2: ");
                    int a11 = keyboard.nextInt();
                    int a12 = keyboard.nextInt();
                    int a21 = keyboard.nextInt();
                    int a22 = keyboard.nextInt();
                    int b1 = keyboard.nextInt();
                    int b2 = keyboard.nextInt();
                    
                    int D = a11 * a22 - a12 * a21;
                    int D1 = b1 * a22 - b2 * a12;
                    int D2 = a11 * b2 - a21 * b1;
                    
                    if (D!=0) {
                    	System.out.println("x1 = " + (double)D1 / D + " x2 = " + (double)D2 / D);
                    }
                    else if ((D1!=0)||(D2!=0)) {
                    	System.out.println("System has no solution");
                    }
                    else {
                    	System.out.println("System has infinite solutions");
                    }
                    
                    keyboard.nextLine();
                    
                    break;
                case "3":
                    System.out.println("ax^2 + bx + c = 0");
                    do {
                    	System.out.println("enter a: ");
                        a = keyboard.nextInt();
                    } while (a==0);
                    System.out.println("enter b: ");
                    b = keyboard.nextInt();
                    System.out.println("enter c: ");
                    int c = keyboard.nextInt();
                    
                    int delta = b*b - 4*a*c;
                    if (delta < 0) {
                    	System.out.println("Equation has no solution");
                    }
                    else if (delta == 0) {
                    	System.out.println("Equation has double solution x = " + (double)-b / (2*a));
                    }
                    else {
                    	System.out.println("x1 = " +  ((double)-b + Math.sqrt(delta)) / (2*a) + " x2 = " + ((double)-b - Math.sqrt(delta)) / (2*a));
                    }
                    
                    keyboard.nextLine();
                    
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equals("q"));

	}

}
