> # Section-Assignment-5-Files, Arrays, and ArrayLists

## Word count

```
Poor naked wretches, wheresoe'er you are,
That bide the pelting of this pitiless storm,
How shall your houseless heads and unfed sides,
Your loop'd and window'd raggedness, defend you
From seasons such as these?  O, I have ta'en
Too little care of this!
```

这里有个注意点，如果直接从`pdf`文件粘贴到`txt`文件内，会发现字符的个数为247，这是因为在第5行，`these?`与`O`之间是两个空格。

```java
import acm.program.*;
import java.io.*;


public class WordCount extends ConsoleProgram {
	public void run(){
		String fileName = readLine("File: ");
		fileName = "./" + fileName;
			
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String str;
			int lines = 0, words = 0, chars = 0;
			
			while ((str = in.readLine()) != null) {
				++lines;
				int len = str.length();
				boolean isWord = false;
				chars += len;
				for (int i = 0; i < len; ++i) {
					if (Character.isLetterOrDigit(str.charAt(i))) {
						isWord = true;
					}
					else {
						if (isWord) ++words;
						isWord = false;
					}
				}
				if (isWord) ++words;
			}
			
			println("Lines = " + lines);
			println("Words = " + words);
			println("Chars = " + chars);
		} catch (IOException ex) {
			println("I/O Exception!");
		}		
	}
}
```

![image.png](https://i.loli.net/2021/02/10/A1vPTFdQ2jZ36rL.png)

## Histograms

观察发现决定每个数字落入某个区间和这个数字是几位数字，以及数字的最高位有关，并且因为可以提前知道数据的范围，所以可以用固定长度的`Array`来存储落入每个区间的数量，统计完成后打印`star`即可。

```java
import acm.program.*;
import java.io.*;

public class Histograms extends ConsoleProgram {
	public void run() {
		String fileName = "./MidtermScores.txt";
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			int [] arr = new int[11];
			String score;
			while ((score = in.readLine()) != null) {
				if (score.length() == 1) ++arr[0];
				else if (score.length() == 3) ++arr[10];
				else {
					int pos = score.charAt(0) - '0';
					++arr[pos];
				}
			}
			
			for (int i = 0; i < 11; ++i) {
				if (i == 10) {
					print("  100: ");
					printStar(arr[i]);
				}
				else {
					print(i + "0-" + i + "9: ");
					printStar(arr[i]);
				}
			}
		} catch (IOException ex) {
			println("IO Exception!");
		}
	}
	
	private void printStar(int num) {
        String res = "";
		for (int i = 0; i < num; ++i) {
			res += '*';
		}
		println(res);
	}
}
```

![image.png](https://i.loli.net/2021/02/10/eakNEGmAI2JLn1r.png)

## Unique Names

这个问题如果放在C++里面，其实可以考虑C++11新特性的`unordered_set`的，这样查找重复元素的效率更高。在本问题中，因为题目提示使用`ArrayList`，使用效果和`C++`的`vector`很类似。

```java
import acm.program.*;
import java.util.*;


public class UniqueNames extends ConsoleProgram{
	public void run() {
		String name;
		ArrayList<String> arr = new ArrayList<String>();
		while ((name = readLine("Enter name: ")) != null && name.length() != 0) {
			if (arr.contains(name)) continue;
			arr.add(name);
		}
		
		println("Unique name list contains:");
		for (int i = 0; i < arr.size(); ++i) {
			println(arr.get(i));
		}
	}
}

```

![image.png](https://i.loli.net/2021/02/10/I4GlovhsTb9cYf8.png)