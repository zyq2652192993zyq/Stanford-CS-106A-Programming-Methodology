> # Programming-Assignment-2-Simple_Java_Programs

## Pyramid

这个作业就是在`Pyramid`类里面指定了底层的砖块的个数，每想上一层，砖块的个数减一，直到最上层为1块时停止，需要这个锥形塔处于画布的正中央。思路是先通过`getWidth()`和`getHight()`两个函数获得画布的长和宽，画一个矩形其基准点是每个小矩形的左上角点的位置。

对于每一层，先获得每一层最左边的点的横坐标，也就是用画布的宽度减去该层砖块的个数与砖块宽度的乘积，差值就是两边空白的部分，所以差值除以2就是横坐标的启示位置。

```java
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
import java.awt.*;

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
```

效果图：

![image-20201219194913120.png](https://i.loli.net/2021/02/27/2uzlKBvLwPS4xV9.png)

## Target

需求：画三个圆，需要按照一定的顺序来画，因为如果最后画大圆的话，会把前面的小圆覆盖，三个圆的尺寸有限制，图案需要处于画布的中心。

需要参考[GOval](https://cs.stanford.edu/people/eroberts/jtf/javadoc/student/#acm/graphics/GOval.html)，[Color](https://docs.oracle.com/javase/6/docs/api/java/awt/Color.html)

对于每个圆，实际上仍然是通过矩形的左上角点来确定位置，另外每个圆填充的时候有轮廓线和内部区域两个部分，如果不改变轮廓线的颜色，会出现黑色的轮廓线，如下图所示：

![image-20201220103248855.png](https://i.loli.net/2021/02/27/vUpnyK5P9truHIg.png)

所以需要通过`setColor`来进行调整。

```java
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

```

调整完后效果图：

![image-20201220103401388.png](https://i.loli.net/2021/02/27/joBVhMRHldwiZcm.png)

## ProgramHierarchy

需要让图形处于画布的中心，这里设置上下两个矩形的间距为一个矩形的高度，相邻两个矩形之间的`gap`设置为宽度的`1/4`，然后就是计算坐标了。注意`label`实际上是字符串外面用一个矩形包裹，所以是先建立`label`，然后获得建立好的`label`的矩形的长和宽，注意`label`是以矩形的左下点作为基准点，影响的就是坐标的确定。

```java
/*
 * File: ProgramHierarchy.java
 * Name: 
 * Section Leader: 
 * ---------------------------
 * This file is the starter file for the ProgramHierarchy problem.
 */

import acm.graphics.*;
import acm.program.*;
import java.awt.*;

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
```

效果图：

![image-20201220155354457.png](https://i.loli.net/2021/02/27/GWOX9JtYfhL3oIS.png)

## PythagoreanTheorem

简单的输入输出。

```java
/*
 * File: PythagoreanTheorem.java
 * Name: 
 * Section Leader: 
 * -----------------------------
 * This file is the starter file for the PythagoreanTheorem problem.
 */

import acm.program.*;

public class PythagoreanTheorem extends ConsoleProgram {
	public void run() {
		println("Enter values to compute Pythagorean theorem.");
		double a = readInt("a: ");
		double b = readInt("b: ");
		print("c = ");
		println(Math.sqrt(a * a + b * b));
	}
}

```

结果：

![image-20201220160507478.png](https://i.loli.net/2021/02/27/fkPc5AnuHJhmFIS.png)

## FindRange

查找序列的最大值和最小值。要求里提示了需要处理输入的第一个数字是结束标志的`0`的情况。

```java
/*
 * File: FindRange.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the FindRange problem.
 */

import acm.program.*;

public class FindRange extends ConsoleProgram {
	private static final int sentinel = 0;

	public void run() {
		showMessage("This program finds the largest and smallest numbers.");

		int firstNumber = readInt("?");
		if (firstNumber == sentinel) {
			showMessage("No number has been inputed. Input another integer.");
		}

		int largestNum = firstNumber, smallestNum = firstNumber;
		while (true) {
			int value = readInt("?");
			if (value == 0) break;

			smallestNum = Math.min(smallestNum, value);
			largestNum = Math.max(largestNum, value);
		}

		showResult("smallest: ", smallestNum);
		showResult("largest: ", largestNum);
	}

	private void showMessage(String words) {
		println(words);
	}

	private void showResult(String words, int value) {
		print(words);
		println(value);
	}
}
```

结果：

![image-20201220161742480.png](https://i.loli.net/2021/02/27/vAOYpb1MoskTfy8.png)



## Hailstone

奇数乘上3然后加一，偶数则减半，注意处理小于1的情况。

```java
/*
 * File: Hailstone.java
 * Name: 
 * Section Leader: 
 * --------------------
 * This file is the starter file for the Hailstone problem.
 */

import acm.program.*;

public class Hailstone extends ConsoleProgram {
	public void run() {
		int number;
		while (true) {
			number = readInt("Enter a number: ");
			if (number <= 0) continue;
			else break;
		}

		int stepNum = 0;
		while (number != 1) {
			++stepNum;
			if (number % 2 == 0) number = evenCase(number);
			else number = oddCase(number);
		}
		
		showResult(stepNum);
	}

	private void showResult(int stepNum) {
		print("The program took ");
		print(stepNum);
		println(" to reach 1");
	}

	private int oddCase(int number) {
		int res = number * 3 + 1;
		print(number);
		print(" is odd so I make 3n + 1: ");
		println(res);

		return res;
	}

	private int evenCase(int number) {
		int res = number / 2;
		print(number);
		print(" is even so I take half: ");
		println(res);

		return res;
	}
}
```

结果：

![image-20201220163142274.png](https://i.loli.net/2021/02/27/aDNypmb12SnqZu4.png)





































