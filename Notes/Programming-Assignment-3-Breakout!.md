> # Programming-Assignment-3-Breakout!

这个`assignment`需要做一个很经典的打砖块的游戏，总体上根据第19个`handout`的内容，加上查阅`ACM packages`接口的内容，很快就可以完成，`bounus`部分选作。

## Starter file

游戏在名为`BreakOut.java`的程序内实现，程序初始给出了对于`application, paddle, brick, ball`的尺寸信息，并提前帮助我们导入了需要导入的包。

程序的入口为`run`函数。首先根据`application`的尺寸信息创建四面墙`wall`，并提前计算出左右两堵墙的`x`值，以及上下两堵墙的`y`值备用。

## Set up bricks

* 砖块需要关注的是砖块的高度，宽度，填充颜色，边框颜色，位置。
* 需要注意的是，砖块之间存在间隔，间隔的大小被`BRICK_SEP`定义，末尾不存在间隔。
* 最顶层的砖块和`apllication`的最顶端存在`BRICK_Y_OFFSET`的距离
* 每两层颜色进行变换，依次是`RED, ORANGE, YELLOW, GREEN, CYAN`。
* 全部砖块构成的整体处于水平居中。

## Create the paddle

* `paddle`对应的就是一个指定尺寸的矩形，特殊点在于其`y`坐标的值是确定的，还需要跟随鼠标的移动变换位置。
* 在创建完`paddle`之后，利用`addMouseListeners`对鼠标进行监听，然后通过对`mouseMoved`事件进行响应，通过函数`setLocation`改变`paddle`的位置。
* 需要注意`paddle`的左端点不能超过左墙`leftWall`，右端点不超过`rightWall`。

## Create a ball and get it to bounce off the walls

* 创建一个小球，对应一个`GOval`对象，初始处于画布的中心。
* 对于小球的运动，以及反弹的描述，通过速度分解为水平速度和垂直速度，就很容易的描述反弹。
* 小球反弹中碰到左右两堵墙改变的是水平速度方向，碰到上部的墙改变垂直速度方向
* 小球初始的垂直速度是3.0，水平方向速度对应一个随机值，根据`handout`的内容进行完善即可。

## Checking for collisions

* 碰撞检测，主要是碰到砖块，碰到`paddle`，根据`handout`的提示通过函数`getElementAt`捕获对应位置的对象，如果不为`null`，则进行相应的处理。
* 如果遇到`paddle`，精细的处理在`bounus`部分提到了，实际上只需要处理垂直方向的速度即可。
* 如果遇到`brick`，则砖块数量`toalBrickNum`减一，然后`y`速度方向改变。

## Add sounds

* 给碰撞增加声音，根据提示，一种简单的处理就是每当速度方向改变的时候，就触发`bounceClip.play()`，就会发出`bang`的声音表示撞击。

## Add in the "kicker"

提示说当消除的砖块到了某一个数量，垂直速度可以变为二倍，实际上可以维护两个全局变量，一个记录初始的数量，一个记录当前数量，比如差值为7的倍数的时候，垂直速度增加一倍。

## Keep score

维护一个全局变量记录分数，每当消除一个砖块增加分数即可。

## Other detail

* 游戏结束存在的可能性：
  * 砖块的都消除了，直接获得胜利，所以在`run`函数里对应`return`，在`return`之前展示获胜信息
  * 小球碰到了底部墙壁
* 无论游戏获胜还是失败，都需要在展示信息前清楚画布的全部内容。





































