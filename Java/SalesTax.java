/**
* This program accepts two arguments and calculates the sales tax.
*/

public class SalesTax {
    public static void main(String args[]) {
		double purchaseAmount = Double.parseDouble(args[0]);
		double tax            = purchaseAmount * Double.parseDouble(args[1]);
		System.out.println( "Sales tax is " + (int)(tax * 100) / 100.0);
	}
}