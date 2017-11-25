import java.util.Scanner; // Scanner is in java.util, and is used to read input

/**
 * The point of this class is to practice using a Scanner object.
 * You use this to read in things sort of like an iterator. However,
 * the Scanner object uses whitespace delimiters, and what is read in
 * is type sensitive.
 * @author RyderDale
 *
 */
public class TestScanner {
	public static void main(String args[]) {
		//Create a Scanner
		Scanner input = new Scanner(System.in); // needs System.in
		
		//Prompt user to enter an integer
		System.out.print("Enter an integer: ");
		int intValue = input.nextInt();
		System.out.println("You entered the integer " + intValue);
		
		//Prompt user to enter a double value
		System.out.print("Enter a double value: ");
		double doubleValue = input.nextDouble();
		System.out.println("You entered the double value " + doubleValue);
		
		//Prompt user to enter a string
		//Note that scanner reads whitespace delimited stuff
		System.out.print("Enter a string without space: ");
		String string = input.next();
		System.out.println("You entered the string " + string);
		
		//Scanner objects need to be closed to prevent leaks.
		input.close();
	}
}