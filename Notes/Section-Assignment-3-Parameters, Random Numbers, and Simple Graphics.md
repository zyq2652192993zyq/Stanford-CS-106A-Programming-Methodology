> # Section-Assignment-3-Parameters, Random Numbers, and Simple Graphics

## True/False questions

* The value of a local variable named `i` has no direct relationship with that of a variable named `i` in its caller.

Answer: True.

* The value of a parameter named `x` has no direct relationship with that of a variable named `x` in its caller.

Answer: True.

## Tracing method execution

输出下面程序的打印内容：

```java
/*
* File: Hogwarts.java
* -------------------
* This program is just testing your understanding of parameter passing.
*/
import acm.program.*;
public class Hogwarts extends ConsoleProgram {
    public void run() {
        bludger(2001);
    }
    
    private void bludger(int y) {
        int x = y / 1000;
        int z = (x + y);
        x = quaffle(z, y);
        println("bludger: x = " + x + ", y = " + y + ", z = " + z);
    }
    
    private int quaffle(int x, int y) {
        int z = snitch(x + y, y);
        y /= z;
        println("quaffle: x = " + x + ", y = " + y + ", z = " + z);
        return z;
    }
    
    private int snitch(int x, int y) {
        y = x / (x % 10);
        println("snitch: x = " + x + ", y = " + y);
        return y;
    }
}
```

考察的是对于传递参数的理解：

```
snitch: x = 4004, y = 1001
quaffle: x = 2003, y = 1, z = 1001
bludger: x = 1001, y = 2001, z = 2003
```

实际运行结果：

![image.png](https://i.loli.net/2021/02/09/zL1frtsA3qESKlc.png)

## Random circles

```java
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
```



效果图如下：

![image.png](https://i.loli.net/2021/02/09/Ubs9Cm6PeWvYwg1.png)

在某些特殊情况下，可能看到的园的数量少于10个，是因为小圆被大圆覆盖住了。

## Drawing lines

对鼠标事件进行监听，对鼠标点击和拖拽这两个事件进行处理即可。

```java
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

```

效果图如下：

![image.png](https://i.loli.net/2021/02/09/iDrxRyEO3CIgoBM.png)