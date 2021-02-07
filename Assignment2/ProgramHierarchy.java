/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
//import java.awt.*;

public class ProgramHierarchy extends GraphicsProgram {	
	private static final double RECTANGLE_WIDTH = 130.0;
	private static final double RECTANGLE_HEIGHT = 40.0;
	private static final double GAP = RECTANGLE_WIDTH / 4;

	public void run() {
		double centerX = getWidth() / 2.0;
		double centerY = getHeight() / 2.0;

		GRect highRec = addRectangle(centerX - RECTANGLE_WIDTH / 2, centerY - RECTANGLE_HEIGHT * 3 / 2, 
			RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
		GRect low1 = addRectangle(centerX - RECTANGLE_WIDTH * 3 / 2 - GAP, centerY + RECTANGLE_HEIGHT / 2,
			RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
		GRect low2 = addRectangle(centerX - RECTANGLE_WIDTH / 2, centerY + RECTANGLE_HEIGHT / 2,
			RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
		GRect low3 = addRectangle(centerX + RECTANGLE_WIDTH / 2 + GAP, centerY + RECTANGLE_HEIGHT / 2,
			RECTANGLE_WIDTH, RECTANGLE_HEIGHT);

		addLink(highRec, low1);
		addLink(highRec, low2);
		addLink(highRec, low3);

		addLabel(highRec, "Program");
		addLabel(low1, "GraphicsProgram");
		addLabel(low2, "ConsoleProgram");
		addLabel(low3, "DialogProgram");
	}

	private GRect addRectangle(double xPos, double yPos, double width, double height) {
		GRect rectangle = new GRect(xPos, yPos, width, height);
		add(rectangle);

		return rectangle;
	}

	private void addLink(GRect startRec, GRect endRec) {
		double startX = startRec.getLocation().getX() + RECTANGLE_WIDTH / 2.0;
		double startY = startRec.getLocation().getY() + RECTANGLE_HEIGHT;
		double endX = endRec.getLocation().getX() + RECTANGLE_WIDTH / 2.0;
		double endY = endRec.getLocation().getY();

		GLine line = new GLine(startX, startY, endX, endY);
		add(line);
	}

	private void addLabel(GRect rectangle, String words) {
		GLabel label = new GLabel(words);
		double labelHeight = label.getHeight();
		double labelWidth = label.getWidth();

		GPoint rectanglePos = rectangle.getLocation();
		double rectangleX = rectanglePos.getX();
		double rectangleY = rectanglePos.getY();
		double recHeight = rectangle.getHeight();
		double recWidth = rectangle.getWidth();

		label.setLocation(rectangleX + (recWidth - labelWidth) / 2, 
			rectangleY + recHeight - (recHeight - labelHeight) / 2);
		add(label);
	}
}

