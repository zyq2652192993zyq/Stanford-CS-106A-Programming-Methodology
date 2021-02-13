/*
 * File: HangmanCanvas.java
 * ------------------------
 * This file keeps track of the Hangman display.
 */

import acm.graphics.*;
import java.util.*;

public class HangmanCanvas extends GCanvas {
	private HangmanLexicon hangmanLexicon = new HangmanLexicon();

/** Resets the display so that only the scaffold appears */
	public void reset() {
		removeAll();
	}

/**
 * Updates the word on the screen to correspond to the current
 * state of the game.  The argument string shows what letters have
 * been guessed so far; unguessed letters are indicated by hyphens.
 */
	private static double xOffset, yOffset;
	
	public void displayWord(String word) {
		xOffset = FOOT_LENGTH * 2;
		double x = getWidth() / 2 - BEAM_LENGTH - xOffset;
		yOffset = FOOT_LENGTH * 0.5;
		double upLength = ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH / 2;
		double y = getHeight() + SCAFFOLD_HEIGHT - upLength + yOffset;
		
		GLabel wordLabel = new GLabel(word, x, y);
		if (getElementAt(x, y) != null) {
			remove(getElementAt(x, y));
		}
		add(wordLabel);
	}

/**
 * Updates the display to correspond to an incorrect guess by the
 * user.  Calling this method causes the next body part to appear
 * on the scaffold and adds the letter to the list of incorrect
 * guesses that appears at the bottom of the window.
 */
	public void noteIncorrectGuess(String word, int wrongAnswerTimes) {
		switch (wrongAnswerTimes) {
			case 1: drawHead(); break;
			case 2: drawBody(); break;
			case 3: drawLeftArm(); break;
			case 4: drawRightArm(); break;
			case 5: drawLeftLeg(); break;
			case 6: drawRightLeg(); break;
			case 7: drawLeftFoot(); break;
			case 8: drawRightFoot(); break;
			default: drawRope();
		}
		
		GLabel wordLabel = new GLabel(word, xOffset, yOffset + FOOT_LENGTH * 2);
		if (getElementAt(xOffset, yOffset + FOOT_LENGTH * 2) != null) {
			getElementAt(xOffset, yOffset + FOOT_LENGTH * 2);
		}
		add(wordLabel);
	}
	
	private void drawHead() {
		double x = getWidth() / 2 - HEAD_RADIUS;
		double y = getHeight() / 2 - BODY_LENGTH / 2 - 2 * HEAD_RADIUS;
		GOval circle = new GOval(x, y, 2 * HEAD_RADIUS, 2 * HEAD_RADIUS);
		add(circle);
	}
	
	private void drawBody() {
		GLine line = new GLine(getWidth() / 2, getHeight() / 2 - BODY_LENGTH / 2, 
				getWidth() / 2, getHeight() / 2 + BODY_LENGTH / 2);
		add(line);
	}
	
	private void drawLeftArm() {
		GLine shoulder = new GLine(getWidth() / 2 - UPPER_ARM_LENGTH, 
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD);
		add(shoulder);
		GLine arm = new GLine(getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH,
				getWidth() / 2 - UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD);
		add(arm);
	}
	
	private void drawRightArm() {
		GLine shoulder = new GLine(getWidth() / 2 + UPPER_ARM_LENGTH, 
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD,
				getWidth() / 2,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD);
		add(shoulder);
		GLine arm = new GLine(getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD + LOWER_ARM_LENGTH,
				getWidth() / 2 + UPPER_ARM_LENGTH,
				getHeight() / 2 - BODY_LENGTH / 2 + ARM_OFFSET_FROM_HEAD);
		add(arm);
	}

	private void drawLeftLeg() {
		GLine thight = new GLine(getWidth() / 2,
				getHeight() / 2 + BODY_LENGTH / 2,
				getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2);
		add(thight);
		GLine shank = new GLine(getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2,
				getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH);
		add(shank);
	}

	private void drawRightLeg() {
		GLine thight = new GLine(getWidth() / 2,
				getHeight() / 2 + BODY_LENGTH / 2,
				getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2);
		add(thight);
		GLine shank = new GLine(getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2,
				getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH);
		add(shank);
	}

	private void drawLeftFoot() {
		GLine foot = new GLine(getWidth() / 2 - HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH,
				getWidth() / 2 - HIP_WIDTH - FOOT_LENGTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH);
		add(foot);
	}

	private void drawRightFoot() {
		GLine foot = new GLine(getWidth() / 2 + HIP_WIDTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH,
				getWidth() / 2 + HIP_WIDTH + FOOT_LENGTH,
				getHeight() / 2 + BODY_LENGTH / 2 + LEG_LENGTH);
		add(foot);
	}
	
	private void drawRope() {
		double upLength = ROPE_LENGTH + 2 * HEAD_RADIUS + BODY_LENGTH / 2;
		GLine verticalRope = new GLine(getWidth() / 2 - BEAM_LENGTH,
				getHeight() / 2 + SCAFFOLD_HEIGHT - upLength,
				getWidth() / 2 - BEAM_LENGTH,
				getHeight() / 2 - upLength);
		add(verticalRope);
		GLine horizationalRope = new GLine(getWidth() / 2 - BEAM_LENGTH,
				getHeight() / 2 - upLength,
				getWidth() / 2,
				getHeight() / 2 - upLength);
		add(horizationalRope);
		GLine headRope = new GLine(getWidth() / 2,
				getHeight() / 2 - upLength,
				getWidth() / 2,
				getHeight() / 2 - 2 * HEAD_RADIUS - BODY_LENGTH / 2);
		add(headRope);
	}

/* Constants for the simple version of the picture (in pixels) */
	private static final int SCAFFOLD_HEIGHT = 360;
	private static final int BEAM_LENGTH = 144;
	private static final int ROPE_LENGTH = 18;
	private static final int HEAD_RADIUS = 36;
	private static final int BODY_LENGTH = 144;
	private static final int ARM_OFFSET_FROM_HEAD = 28;
	private static final int UPPER_ARM_LENGTH = 72;
	private static final int LOWER_ARM_LENGTH = 44;
	private static final int HIP_WIDTH = 36;
	private static final int LEG_LENGTH = 108;
	private static final int FOOT_LENGTH = 28;

}
