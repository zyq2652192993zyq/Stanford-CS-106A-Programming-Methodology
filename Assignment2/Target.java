/*
 * File: Target.java
 * Name: 
 * Section Leader: 
 * -----------------
 * This file is the starter file for the Target problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Target extends GraphicsProgram {		
	public void run() {
		drawOutterCircle();
		drawMiddleCircle();
		drawInnerCircle();
	}

	private void drawCircle(double r, Color color)
	{
		GOval obj = new GOval(getWidth() / 2 - r, getHeight() / 2 - r, 2 * r, 2 * r);
		obj.setFillColor(color);
		obj.setColor(color);
		obj.setFilled(true);
		add(obj);
	}

	private void drawOutterCircle() {
		drawCircle(72, Color.RED);
	}

	private void drawMiddleCircle() {
		drawCircle(72 * 0.65, Color.WHITE);
	}


	private void drawInnerCircle() {
		drawCircle(72 * 0.3, Color.RED);
	}
}
