import acm.graphics.*;
import acm.program.*;
import java.awt.*;

public class Face extends GraphicsProgram {
	private static final double HEAD_HEIGHT = 200;
	private static final double HEAD_WIDTH = 123.6;
	private static final double EYE_RADIUS = 15;
	private static final double MOUSE_HEIGHT = 30;
	private static final double MOUSE_WIDTH = 80;
	
	public void run() {
		double x = getWidth();
		double y = getHeight();
		
		drawHead(x / 2 - HEAD_WIDTH / 2, y / 2 - HEAD_HEIGHT / 2, Color.GRAY, Color.BLACK);
		drawEye(x / 2 - HEAD_WIDTH / 4 - EYE_RADIUS, y / 2 - HEAD_HEIGHT / 4 - EYE_RADIUS, Color.YELLOW, Color.YELLOW);
		drawEye(x / 2 + HEAD_WIDTH / 4 - EYE_RADIUS, y / 2 - HEAD_HEIGHT / 4 - EYE_RADIUS, Color.YELLOW, Color.YELLOW);
		drawMouse(x / 2 - MOUSE_WIDTH / 2, y / 2 + HEAD_HEIGHT / 4 - MOUSE_HEIGHT, Color.WHITE, Color.WHITE);
	}
	
	private void drawRectangle(double x, double y, 
			double width, double height, Color filledColor, Color frameColor) {
		GRect obj = new GRect(x, y, width, height);
		obj.setFillColor(filledColor);
		obj.setFilled(true);
		obj.setColor(frameColor);
		add(obj);
	}
	
	private void drawCircle(double x, double y, 
			double width, double height, Color filledColor, Color frameColor) {
		GOval obj = new GOval(x, y, width, height);
		obj.setFillColor(filledColor);
		obj.setFilled(true);
		obj.setColor(frameColor);
		add(obj);
	}
	
	private void drawHead(double x, double y, Color filledColor, Color frameColor) {
		drawRectangle(x, y, HEAD_WIDTH, HEAD_HEIGHT, filledColor, frameColor);
	}
	
	private void drawEye(double x, double y, Color filledColor, Color frameColor) {
		drawCircle(x, y, 2 * EYE_RADIUS, 2 * EYE_RADIUS, filledColor, frameColor);
	}
	
	private void drawMouse(double x, double y, Color filledColor, Color frameColor) {
		drawRectangle(x, y, MOUSE_WIDTH, MOUSE_HEIGHT, filledColor, frameColor);
	}
}