/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute Pythagorean theorem.");
		double a = readInt("a: ");
		double b = readInt("b: ");
		print("c = ");
		println(Math.sqrt(a * a + b * b));
	}
}
