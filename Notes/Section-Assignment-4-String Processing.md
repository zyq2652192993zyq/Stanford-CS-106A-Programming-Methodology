> # Section-Assignment-4-String Processing

## Adding commas to numeric strings

每隔三位数字增加一个逗号，注意首部不能出现逗号。

```java
import acm.program.*;


public class AddCommas extends ConsoleProgram {
	public void run() {
		while (true) {
			String digits = readLine("Enter a numeric string: ");
			if (digits.length() == 0) break;
			println(addCommasToNumericString(digits));
		}
	}

	private String addCommasToNumericString(String digits) {
		int n = digits.length();
		String res = "";
		for (int i = 0; i < n; ++i) {
			if ((n - i) % 3 == 0 && i != 0) res += ",";
			res += digits.charAt(i);
		}
		
		return res;
	}
}
```

![Snipaste_2021-02-07_20-51-21.png](https://i.loli.net/2021/02/10/Y8XgcKGyD6pST59.png)

## Deleting characters from a string

```java
import acm.program.*;


public class DeleteCharacters extends ConsoleProgram {
	public void run() {
		test("This is a test", 't');
		test("Summer is here!", 'e');
		test("---0---", '-');
	}

	private void test(String str, char ch) {
		println("Former string is: " + str);
		println("After delete the " + ch  + 
			" character, the string is: " + removeAllOccurrences(str, ch));
	}

	public String removeAllOccurrences(String str, char ch) {
		int n = str.length();
		String res = "";
		for (int i = 0; i < n; ++i) {
			if (str.charAt(i) == ch) continue;
			res += str.charAt(i);
		}

		return res;
	}
}
```

![image.png](https://i.loli.net/2021/02/10/1CYzJNKQa8rhgSo.png)

## Heap/stack diagrams

需要参考教材《The Art and Science of Java》中的第七章内容。

```java
public void run() {
    Rational r = new Rational(1, 2);
    r = raiseToPower(r, 3);
    println("r ^ 3 = " + r);
}

private Rational raiseToPower(Rational x, int n)
    Rational result = new Rational(1);
    for (int i = 0; i < n; i++) {
        result = result.multiply(x);
    }
    return result;
}
```

![image-20210210155057717](F:\Project\Stanford-CS-106A-Programming-Methodology\Notes\Section-Assignment-4-String Processing.assets\image-20210210155057717.png)



## Tracing method execution

```java
/*
* File: Mystery.java
* ------------------
* This program doesn't do anything useful and exists only to test
* your understanding of method calls and parameter passing.
*/

import acm.program.*;


public class Mystery extends ConsoleProgram {
    public void run() {
        ghost(13);
    }
    
    private void ghost(int x) {
        int y = 0;
        for (int i = 1; i < x; i *= 2) {
            y = witch(y, skeleton(x, i));
        }
        println("ghost: x = " + x + ", y = " + y);
    }
    
    private int witch(int x, int y) {
        x = 10 * x + y;
        println("witch: x = " + x + ", y = " + y);
        return x;
    }
    
    private int skeleton(int x, int y) {
        return x / y % 2;
    }
}
```

还是考察的参数传递的知识，直接写出答案：

```
witch: x = 1, y = 1
witch: x = 10, y = 0
witch: x = 101, y = 1
witch: x = 1011, y = 1
ghost: x = 13, y = 1011
```

![image.png](https://i.loli.net/2021/02/10/PMZxIz3A4CYkOej.png)









