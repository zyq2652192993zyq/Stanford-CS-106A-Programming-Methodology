import acm.program.*;
import acm.util.*;
import acm.graphics.*;
import java.awt.*;

public class RandomCircles extends GraphicsProgram {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private static final int CIRCLENUM = 10;
	private static final double MINPIXEL = 5.0;
	private static final double MAXPIXEL = 50.0;
	
	public void run() {
		double x = getWidth(), y = getHeight();
		
		for (int i = 0; i < CIRCLENUM; ++i) {
			double radius = rgen.nextDouble(MINPIXEL, MAXPIXEL);
			double circle_x = rgen.nextDouble(0, x - radius * 2);
			double circle_y = rgen.nextDouble(0, y - radius * 2);
			Color color = rgen.nextColor();
			
			drawCircle(circle_x, circle_y, radius * 2, radius * 2, color, color);
		}
	}
	
	private void drawCircle(double x, double y, double width, double height, 
		Color filledColor, Color frameColor) {
		GOval circle = new GOval(x, y, width, height);
		circle.setFillColor(filledColor);
		circle.setFilled(true);
		circle.setColor(frameColor);
		add(circle);
	}
}