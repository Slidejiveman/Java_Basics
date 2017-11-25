import java.util.Scanner;

public class ComputeChange {
	public static void main(String args[]) {
		// Create a Scanner
		Scanner input = new Scanner(System.in);
		
		// Receive the amount
		System.out.print("Enter an amount in double, for example 11.56: ");
		double amount = input.nextDouble();
		
		// We get the same result if we remove the decimal.
		// We want to do integer division for modulus anyway.
		int remainingAmount = (int)(amount * 100);
		
		// Find the number of dollars
		int numberOfOneDollars = remainingAmount / 100; // 100 cents
		remainingAmount = remainingAmount % 100;
		
		// Find the number of quarters in the new remaining amount
		int numberOfQuarters = remainingAmount / 25;
		remainingAmount %= 25; // more concise
		
		// Find number of dimes in the remaining amount
		int numberOfDimes = remainingAmount / 10;
		remainingAmount %= 10;
		
		// Find number of nickels in the remaining amount
		int numberOfNickels = remainingAmount / 5;
		remainingAmount %= 5;
		
		// Find the number of nickels in the remainingAmount
		int numberOfPennies = remainingAmount;
		
		// Display results
		String output = "Your amount " + amount + " consists of \n" +
		    "\t" + numberOfOneDollars  + " dollars\n" +
			"\t" + numberOfQuarters    + " quarters\n" +
			"\t" + numberOfDimes       + " dimes\n" +
			"\t" + numberOfNickels     + " nickels\n" +
			"\t" + numberOfPennies     + " pennies.";
		System.out.println(output);
	}
}