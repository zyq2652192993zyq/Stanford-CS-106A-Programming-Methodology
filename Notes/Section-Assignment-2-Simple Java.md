> # Section-Assignment-2-Simple Java

在`Section`目录下存放`acm.jar`包，然后在Eclipse里依次选择`Build Path -> Configure Build Path -> Libraries -> Add JARs`，然后选择`acm.jar`即可完成`jar`包的导入。

## The Fibonacci sequence

打印斐波那契数，实际上就是一个算法题，注意考虑边界条件即可。

```java
import acm.program.*;

public class FibonacciSequence extends ConsoleProgram {
	public void run() {
		println("This program lists the Fibonacci sequence.");
		Fibonacci(10000);
	}
	
	private void Fibonacci(int MAX_TERM_VALUE) {
		int first = 0, second = 1;
		if (MAX_TERM_VALUE <= 0) return;
		if (MAX_TERM_VALUE == 1) {
			println(first);
			return;
		}
		
		println(first);
		while (second < MAX_TERM_VALUE) {
			println(second);
			int tmp = first + second;
			first = second;
			second = tmp;
		}
	}
}
```

效果如下：

![image.png](https://i.loli.net/2021/02/07/PLG3X7l52n1pBaV.png)

## Drawing a face

所需要的只有矩形和椭圆，重点是确定好坐标，然后再调整宽度和高度来美化，另外因为画`head`和画`mouse`都是画矩形，存在可复用的代码。

```java
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
```

效果如下：

![Snipaste_2021-02-07_20-51-21.png](https://i.loli.net/2021/02/07/84pQ7bU5vXsxzcR.png)