import java.util.Scanner;

public class MakeChangeApp {

	public static Scanner kb;
	public static double twentyDollar = 20;
	public static int twentyDollarCount = 0;

	public static double tenDollar = 10;
	public static int tenDollarCount = 0;

	public static double fiveDollar = 5;
	public static int fiveDollarCount = 0;

	public static double oneDollar = 1;
	public static int oneDollarCount = 0;

	public static double twentyFiveCent = .25;
	public static int twentyFiveCentCount = 0;

	public static double tenCent = .10;
	public static int tenCentCount = 0;

	public static double fiveCent = .05;
	public static int fiveCentCount = 0;

	public static double oneCent = .01;
	public static int oneCentCount = 0;

	public static double amountGiven;
	public static double change;

	public static void main(String[] args) {
		// MAIN METHOD
		kb = new Scanner(System.in);
		double itemPrice = askingPrice();
		System.out.println(calculateChange(itemPrice));
		kb.close();
	}

	public static double askingPrice() {
		System.out.println("Whats the price of the item: ");
		double itemPrice = kb.nextDouble();
		return itemPrice;
	}

	public static String calculateChange(double itemPrice) {

		String lastLine = "";

		System.out.println("How much money did the customer give: ");
		amountGiven = kb.nextDouble();
		change = amountGiven - itemPrice;

		// check if amount given is enough
		if (itemPrice > amountGiven) {
			System.out.println("Customer did not give you enough money.");
			System.out.println("DO NOT GIVE THEM THE ITEM!!!");
			System.exit(0);
		} else if (itemPrice == amountGiven) {
			System.out.println("Customer gave exact change");
			System.out.println("DO NOT GIVE THEM ANY MONEY BACK!!!");
			System.exit(0);
		}

		if (change != 0) {
// check for twenty dollars
			while (twentyDollar <= change) {
				twentyDollarCount++;
				change -= twentyDollar;
			}
			if (twentyDollarCount > 0) {
				lastLine = lastLine + "Give them " + twentyDollarCount + " $20" + "\n";
			}

// check for ten dollars
			while (tenDollar <= change) {
				tenDollarCount++;
				change -= tenDollar;
			}
			if (tenDollarCount > 0) {
				lastLine = lastLine + "Give them " + tenDollarCount + " $10" + "\n";
			}
// check for 5 dollars			
			while (fiveDollar <= change) {
				fiveDollarCount++;
				change -= fiveDollar;
			}
			if (fiveDollarCount > 0) {
				lastLine = lastLine + "Give them " + fiveDollarCount + " $5" + "\n";
			}
// check for 1 dollars
			while (oneDollar <= change) {
				oneDollarCount++;
				change -= oneDollar;
			}
			if (oneDollarCount > 0) {
				lastLine = lastLine + "Give them " + oneDollarCount + " $1" + "\n";
			}
// check for 25 cents			
			while (twentyFiveCent <= change) {
				twentyFiveCentCount++;
				change -= twentyFiveCent;
			}
			if (twentyFiveCentCount > 0) {
				lastLine += "Give them " + twentyFiveCentCount + " ¢25" + '\n';
			}
//check for 10 cents			
			while (tenCent <= change) {
				tenCentCount++;
				change -= tenCent;
			}
			if (tenCentCount > 0) {
				lastLine += "Give them " + tenCentCount + " ¢10" + '\n';
			}
//check for 5 cents			
			while (fiveCent <= change) {
				fiveCentCount++;
				change -= fiveCent;
			}
			if (fiveCentCount > 0) {
				lastLine += "Give them " + fiveCentCount + " ¢5" + '\n';
			}
// check for one cents			
			while (oneCent <= change) {
				oneCentCount++;
				change -= oneCent;
			}
			if (change > .001) {
				oneCentCount++;
			}
			if (oneCentCount > 0) {
				lastLine += "Give them " + oneCentCount + " ¢1" + '\n';
			}

			// exited if with the correct change.
		}
		return lastLine;
	}

}
