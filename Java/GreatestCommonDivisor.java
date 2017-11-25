import java.util.Scanner;

public class GreatestCommonDivisor {
	/** Main Method */
	public static void main(String args[]) {
		// Create Scanner
		Scanner input = new Scanner(System.in);
		
		// Prompt the user to enter two integers
		System.out.print("Enter first integer: ");
		int n1 = input.nextInt();
		System.out.print("Enter second integer: ");
		int n2 = input.nextInt();
		
		// This portion is the algorithm. Improve it!
		int gcd = 1;
		int k = 2;
		while (k <= n1 && k <= n2) {
			if (n1 % k == 0 && n2 % k == 0) {
				gcd = k;
			}
			k++;
		}
		
		System.out.println("The greatest common divisor of " + n1 +
							" and " + n2 + " is " + gcd);
	}
}