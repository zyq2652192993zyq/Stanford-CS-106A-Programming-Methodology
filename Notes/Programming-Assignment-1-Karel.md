> # Programming-Assignment-1-Karel

## 环境配置

首先进入[课程网站](https://see.stanford.edu/Course/CS106A)下载与操作系统对应的IDE和JRE。最好使用课程提供的IDE和JRE，过高版本的JRE将无法正常运行。

### Windows下配置

首先安装好`Java 1.6 JRE`，然后将下载的`stanford_eclipse32_windows.zip`解压缩，修改`eclipse.ini`文件，在`-vmargs`前增加：

```
-vm
<Your java 1.6 JRE path>\bin\javaw.exe
```

这样即可正常启动。

## 入门demo

在lecture`06-karel-in-eclipse`里展示了第一个assignment如何运行。首先打开`CollectNewspaperKarel.java`文件，增加程序文件里标红的两个位置，然后点击最上方的两个按钮中右边的即可。

![image-20201103163934478.png](https://i.loli.net/2021/02/10/fNkqMC4wOSLAHuj.png)



```java
/*
 * File: CollectNewspaperKarel.java
 * --------------------------------
 * At present, the CollectNewspaperKarel subclass does nothing.
 * Your job in the assignment is to add the necessary code to
 * instruct Karel to walk to the door of its house, pick up the
 * newspaper (represented by a beeper, of course), and then return
 * to its initial position in the upper left corner of the house.
 */

import stanford.karel.*;

public class CollectNewspaperKarel extends SuperKarel {
	// You fill in this part
	public void run() {
		move();
		turnRight();
		move();
		turnLeft();
		move();
		pickBeeper();	
	}
}
```

程序运行后效果：

![image-20201103164151963.png](https://i.loli.net/2021/02/10/pz75do4MTfARXs3.png)

点击`Start Program`后左上角的小人开始移动，因为程序少了一个`move`导致还差一个位置才能达到，所以出现`logic error`。

![image-20201103164331579.png](https://i.loli.net/2021/02/10/C3acZwdFKBVlP7O.png)



















