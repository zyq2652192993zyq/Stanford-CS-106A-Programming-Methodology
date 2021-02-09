import acm.program.*;
import acm.graphics.*;
import java.awt.event.*;


public class DrawingLines extends GraphicsProgram{
	private GLine line;
	
	public void run() {
		addMouseListeners();
	}
	
	public void mousePressed(MouseEvent e) {
		double x = e.getX(), y = e.getY();
		line = new GLine(x, y, x, y);
		add(line);
	}
	
	public void mouseDragged(MouseEvent e) {
		double x = e.getX(), y = e.getY();
		line.setEndPoint(x, y);
	}
}
