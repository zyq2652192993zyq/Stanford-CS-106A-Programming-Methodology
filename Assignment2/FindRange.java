/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int sentinel = 0;

	public void run() {
		showMessage("This program finds the largest and smallest numbers.");

		int firstNumber = readInt("?");
		if (firstNumber == sentinel) {
			showMessage("No number has been inputed. Input another integer.");
		}

		int largestNum = firstNumber, smallestNum = firstNumber;
		while (true) {
			int value = readInt("?");
			if (value == 0) break;

			smallestNum = Math.min(smallestNum, value);
			largestNum = Math.max(largestNum, value);
		}

		showResult("smallest: ", smallestNum);
		showResult("largest: ", largestNum);
	}

	private void showMessage(String words) {
		println(words);
	}

	private void showResult(String words, int value) {
		print(words);
		println(value);
	}
}

