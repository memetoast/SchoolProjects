//Andrew Moore
//Advanced Java 2463
//Professor Goulden
//Spring 2021
//This is a magic 8 ball program

import java.util.Random;
import java.util.Scanner;
public class Magic8Ball {

	public static void main(String[] args) {
		//Get information from the user
		Scanner scans = new Scanner(System.in);		
		System.out.println("What is the question? ");
		String question = scans.nextLine();

		//Array containing answers
		String[] answers = {
				"It is certain.", "It is decidedly so.", "Without a doubt.",
				"Yes, definitely.", "You may rely on it.", "Reply hazy, try again.",
				"Ask again later.", "Dont count on it.", "Sure.", "Not even close.",
				"Outlook not so good."
		};
		//While loop to restart game and keep count of questions answered
		int count = 0;
		while(question.length() > 1) {
			Random randomGenerator = new Random();
			System.out.println(answers[randomGenerator.nextInt(11)]);
			System.out.println();
			System.out.println();
			System.out.println("Ask another question. Or, press enter to exit the program. ");
			question = scans.nextLine();
			count ++;
		}
		//End program and display number of questions asked
		System.out.println("The all knowing 8 Ball has answered " + count + " questions. ");
		System.out.println();
		System.out.println();
		scans.close();
	}

}
