/*
 * File: Breakout.java
 * -------------------
 * Name:
 * Section Leader:
 * 
 * This file will eventually implement the game of Breakout.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Breakout extends GraphicsProgram {

/** Width and height of application window in pixels */
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;

/** Dimensions of game board (usually the same) */
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;

/** Dimensions of the paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;

/** Offset of the paddle up from the bottom */
	private static final int PADDLE_Y_OFFSET = 30;

/** Number of bricks per row */
	private static final int NBRICKS_PER_ROW = 10;

/** Number of rows of bricks */
	private static final int NBRICK_ROWS = 10;

/** Separation between bricks */
	private static final int BRICK_SEP = 4;

/** Width of a brick */
	private static final int BRICK_WIDTH =
	  (WIDTH - (NBRICKS_PER_ROW - 1) * BRICK_SEP) / NBRICKS_PER_ROW;

/** Height of a brick */
	private static final int BRICK_HEIGHT = 8;

/** Radius of the ball in pixels */
	private static final int BALL_RADIUS = 10;

/** Offset of the top brick row from the top */
	private static final int BRICK_Y_OFFSET = 70;

/** Number of turns */
	private static final int NTURNS = 3;
	
	private static int totalBrickNum;
	
	private GRect paddle;
	private GOval ball;
	
	private double vx, vy;
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static int DELAY = 10;
	
	private static double leftWall, rightWall, topWall, bottomWall;
	
	private AudioClip bounceClip = MediaTools.loadAudioClip("bounce.au");

/* Method: run() */
/** Runs the Breakout program. */
	public void run() {
		for (int i = 0; i < NTURNS; ++i) {
			setUpGame();
			startGame();
			
			if (totalBrickNum == 0) {
				removeAll();
				showWinMessage();
				return;
			}
			removeAll();
		}
		
		showFailMessage();
	}
	
	private void setUpGame() {
		createWall();
		createBricks();
		createPaddle();
		cretaeBall();
	}
	
	private void createWall() {
		GRect obj = new GRect(getWidth() / 2 - WIDTH / 2, getHeight() / 2 - HEIGHT / 2,
				WIDTH, HEIGHT);
		obj.setColor(Color.BLACK);
		add(obj);
		
		leftWall = getWidth() / 2 - WIDTH / 2;
		rightWall = getWidth() / 2 + WIDTH / 2;
		bottomWall = getHeight() / 2 + HEIGHT / 2;
		topWall = getHeight() / 2 - HEIGHT / 2;
	}
	
	private void createBricks() {
		totalBrickNum = NBRICKS_PER_ROW * NBRICK_ROWS;
		double bricksRowLength = NBRICKS_PER_ROW * BRICK_WIDTH + (NBRICKS_PER_ROW - 1) * BRICK_SEP;
		double x = getWidth() / 2 - bricksRowLength / 2;
		double y = getHeight() / 2 - HEIGHT / 2 + BRICK_Y_OFFSET;
		
		for (int i = 0; i < NBRICK_ROWS; ++i) {
			Color brickColor;
			if (i < 2) brickColor = Color.RED;
			else if (i < 4) brickColor = Color.ORANGE;
			else if (i < 6) brickColor = Color.YELLOW;
			else if (i < 8) brickColor = Color.GREEN;
			else brickColor = Color.CYAN;
			
			double brick_y = y + i * (BRICK_HEIGHT + BRICK_SEP);
			for (int j = 0; j < NBRICKS_PER_ROW; ++j) {
				GRect tmpBrickObj = new GRect(x + j * (BRICK_WIDTH + BRICK_SEP), brick_y, BRICK_WIDTH, BRICK_HEIGHT); 
				tmpBrickObj.setFillColor(brickColor);
				tmpBrickObj.setFilled(true);
				tmpBrickObj.setColor(brickColor);
				add(tmpBrickObj);
			}
		}
	}
	
	private void createPaddle() {
		paddle = new GRect(getWidth() / 2 - PADDLE_WIDTH / 2, 
						   getHeight() / 2 + WIDTH / 2 - PADDLE_Y_OFFSET - PADDLE_HEIGHT,
						   PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFillColor(Color.BLACK);
		paddle.setFilled(true);
		paddle.setColor(Color.BLACK);
		add(paddle);
		addMouseListeners();
	}
	
	private void cretaeBall() {
		ball = new GOval(getWidth() / 2 - BALL_RADIUS, getHeight() / 2 - BALL_RADIUS, 
						 BALL_RADIUS * 2, BALL_RADIUS * 2);
		ball.setFillColor(Color.BLACK);
		ball.setFilled(true);
		ball.setColor(Color.BLACK);
		add(ball);
		
	}
	
	public void mouseMoved(MouseEvent e) {
		if ((e.getX() <= getWidth() - PADDLE_WIDTH/2) && (e.getX() >= PADDLE_WIDTH/2)) {
			paddle.setLocation(e.getX() - PADDLE_WIDTH/2, getHeight() / 2 + WIDTH / 2 - PADDLE_Y_OFFSET - PADDLE_HEIGHT);
		}
	}
	
	private void startGame() {
		waitForClick();
		setBallVelocity();
		
		while (true) {
			moveBall();
			if (totalBrickNum == 0 || ball.getY() + BALL_RADIUS * 2 >= bottomWall) {
				break;
			}
		}	
	}
	
	private void setBallVelocity() {
		vy = -3.0;
		vx = rgen.nextDouble(1.0, 3.0);
		if (rgen.nextBoolean(0.5)) vx = -vx;
	}
	
	private void moveBall() {
		ball.move(vx, vy);

		double ball_x = ball.getX(), ball_y = ball.getY();	
		if (ball_x < leftWall || ball_x + 2 * BALL_RADIUS > rightWall) {
			vx = -vx;
			bounceClip.play();
		}
		if (ball_y < topWall) {
			vy = -vy;
			bounceClip.play();
		}
		
		GObject collider = getCollidingObject();
		if (collider == paddle) {
			double paddle_y = paddle.getY();
			if (ball_y + 2 * BALL_RADIUS > paddle_y|| ball_y < paddle_y + PADDLE_HEIGHT) {
				vy = -vy;
				bounceClip.play();
			}
		}
		else if (collider != null) {
			remove(collider);
			--totalBrickNum;
			vy = -vy;
			bounceClip.play();
		}
		
		pause(DELAY);
	}
	
	private GObject getCollidingObject() {
		double x = ball.getX(), y = ball.getY();
		
		if (getElementAt(x, y) != null) {
			return getElementAt(x, y);
		}
		else if (getElementAt(x, y + 2 * BALL_RADIUS) != null) {
			return getElementAt(x, y + 2 * BALL_RADIUS);
		}
		else if (getElementAt(x + 2 * BALL_RADIUS, y) != null) {
			return getElementAt(x + 2 * BALL_RADIUS, y);
		}
		else if (getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS) != null) {
			return getElementAt(x + 2 * BALL_RADIUS, y + 2 * BALL_RADIUS);
		}
		else return null;
	}
	
	private void showWinMessage() {
		GLabel label = new GLabel("Congratulation! You win the game!");
		label.setLocation(getWidth() / 2 - label.getWidth() / 2, getHeight() / 2 - label.getHeight() / 2);
		add(label);
	}
	
	private void showFailMessage() {
		GLabel label = new GLabel("Sorry! You lose the game!");
		label.setLocation(getWidth() / 2 - label.getWidth() / 2, getHeight() / 2 - label.getHeight() / 2);
		add(label);
	}
}
