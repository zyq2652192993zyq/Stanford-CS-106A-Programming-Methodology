/*
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends SuperKarel {
	public void Move(int stepNum) {
		for (int i = 0; i < stepNum; ++i) move();
	}
	
	public void BackToUnderline() {
		turnAround();
		while (frontIsClear()) move();
	}

	public void run() {
		turnLeft();		
		while (true) {
			while (true) {
				if (noBeepersPresent()) putBeeper();
				if (frontIsClear()) move();
				else break;
			}
			
			BackToUnderline();

			if (frontIsBlocked() && leftIsBlocked()) {
				break;
			}
			else {
				turnLeft();
				Move(4);
				turnLeft();
			}
		}
		turnLeft();
	}
	

}
