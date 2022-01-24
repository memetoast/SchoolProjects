//Andrew Moore
//Advanced Java 2463
//Professor Goulden
//Jan 23 2022
//This is a base conversion program

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.math.BigInteger;

public class BaseConvert {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		//Display a friendly greeting to the user
		System.out.println("Hello! Welcome to the base conversion program. ");
		System.out.println();
		System.out.println();
		//Prompt the user for the value to convert (a String)
		System.out.println("Please enter the value you would like to convert. ");
		String theValue = input.nextLine().toUpperCase();
		//Prompt the user for the value of the initial base (an integer)
		System.out.println("Please enter the intial base. It must be between 2 and 36.");
		int initialBase = Integer.parseInt(input.nextLine());
		//Prompt the user for the desired base of the output (an integer)
		System.out.println("Please enter the final base. ");
		int finalBase = Integer.parseInt(input.nextLine());

		//If the String is not a legal expression of a number in the initial base, display an error
		//message and exit the program.
		if (!validInt(theValue, initialBase)) {
			System.out.println("Invalid number entered for base " + initialBase);
			return;

		}
		//Display result
		System.out.println(convertInteger(theValue, initialBase, finalBase));

		input.close();
	}

	public static boolean validInt(String number, int base) {
		List<Character> validNum = new ArrayList<Character>();

		for (int i = 0; i < 10 && i < base; i++) {
			validNum.add((char) ('0' + i));
		}

		if (base >= 10) {
			for (int i = 0; i <= base - 10; i++) {
				validNum.add((char) ('A' + i));
			}
		}

		for (char c : number.toCharArray()) {
			if (!validNum.contains(c)) {
				return false;
			}
		}

		return true;
	}
	//Getting decimal value of character
	private static int charValueInDecimal(char c) {
		if (c <= '9' && c >= '0') {
			return c - '0';
		}
		return c - 'A' + 10;
	}

	private static char digitInChar(int c) {
		if (c <= 9 && c >= 0) {
			return (char) (c + '0');
		}
		return (char) ((c - 10) + 'A');
	}
	//Convert the value represented by the String in the initial base to the desired base.
	public static String convertInteger(String theValue, int initialBase, int finalBase) {
		BigInteger initialNum = BigInteger.ZERO;

		for (char c : theValue.toCharArray()) {
			BigInteger n = initialNum.multiply(new BigInteger(String.valueOf(initialBase)));
			initialNum = n.add(new BigInteger(String.valueOf(charValueInDecimal(c))));
		}

		String result = "";
		//Actual conversion
		BigInteger desiredBase = new BigInteger(String.valueOf(finalBase));

		while (!initialNum.equals(BigInteger.ZERO)) {
			BigInteger remainder = initialNum.mod(desiredBase);
			result = digitInChar(remainder.intValue()) + result;
			initialNum = initialNum.divide(desiredBase);
		}

		return result;
	}

}