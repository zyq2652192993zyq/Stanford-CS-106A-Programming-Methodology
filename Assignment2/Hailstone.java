/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int number;
		while (true) {
			number = readInt("Enter a number: ");
			if (number <= 0) continue;
			else break;
		}

		int stepNum = 0;
		while (number != 1) {
			++stepNum;
			if (number % 2 == 0) number = evenCase(number);
			else number = oddCase(number);
		}
		
		showResult(stepNum);
	}

	private void showResult(int stepNum) {
		print("The program took ");
		print(stepNum);
		println(" to reach 1");
	}

	private int oddCase(int number) {
		int res = number * 3 + 1;
		print(number);
		print(" is odd so I make 3n + 1: ");
		println(res);

		return res;
	}

	private int evenCase(int number) {
		int res = number / 2;
		print(number);
		print(" is even so I take half: ");
		println(res);

		return res;
	}
}

