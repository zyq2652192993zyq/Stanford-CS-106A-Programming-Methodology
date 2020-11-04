/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	public void Move(int stepNum){
		try {
			for (int i = 0; i < stepNum; ++i) {
				move();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}	
	}

	
	public void run() {
		try {
			turnRight();
			Move(1);
			turnLeft();
			Move(3);
			
			pickBeeper();
			
			// back to its initial position
			turnAround();
			Move(3);	
			turnRight();
			Move(1);
			turnRight();
		} 
		catch (Exception e) {
			e.printStackTrace();
		}	
	}
}
