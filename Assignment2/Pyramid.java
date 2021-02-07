/*
 * File: Pyramid.java
 * Name: 
 * Section Leader: 
 * ------------------
 * This file is the starter file for the Pyramid problem.
 * It includes definitions of the constants that match the
 * sample run in the assignment, but you should make sure
 * that changing these values causes the generated display
 * to change accordingly.
 */

import acm.graphics.*;
import acm.program.*;
//import java.awt.*;

public class Pyramid extends GraphicsProgram {

/** Width of each brick in pixels */
	private static final int BRICK_WIDTH = 30;

/** Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;

/** Number of bricks in the base of the pyramid */
	private static final int BRICKS_IN_BASE = 14;
	
	public void run() {
		double X = getWidth();
		double Y = getHeight();
		
		for (int i = 0; i < BRICKS_IN_BASE; ++i) {
			int currentBrickNum = BRICKS_IN_BASE - i;
			double xPos = (X - currentBrickNum * BRICK_WIDTH) / 2.0;
			double yPos = Y - (i + 1) * BRICK_HEIGHT;
			
			for (int j = 0; j < currentBrickNum; ++j) {
				GRect obj = new GRect(xPos + j * BRICK_WIDTH, yPos, BRICK_WIDTH, BRICK_HEIGHT);
				add(obj);
			}
		}	
	}
}

