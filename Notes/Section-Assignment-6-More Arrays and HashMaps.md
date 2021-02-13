> # Section-Assignment-6-More Arrays and HashMaps

## Image processing

```java
import acm.graphics.*;

public class FlipImage {
	public GImage flipHorizontal(GImage image) {
		int[][] arr = image.getPixelArray();
		int m = arr.length, n = arr.length;
		for (int i = 0; i < m; ++i) {
			int start = 0, end = n - 1;
			while (start < end) {
				int tmp = arr[i][start];
				arr[i][start] = arr[i][end];
				arr[i][end] = tmp;
				++start;
				--end;
			}
		}
		
		return new GImage(arr);
	}
}
```

## Name Counts

```java
import acm.program.*;
import java.util.*;

public class CountNames extends ConsoleProgram {
	public void run() {
		HashMap<String, Integer> um = new HashMap<String, Integer>();
		getNames(um);
		printMap(um);
	}
	
	private void getNames(HashMap<String, Integer> um) {
		String name;
		while ((name = readLine("Enter name: ")) != null && name.length() != 0) {
			Integer num = um.get(name);
			if (num == null) {
				num = new Integer(1);
			}
			else {
				num = new Integer(num + 1);
			}
			um.put(name, num);
		}
	}
	
	private void printMap(HashMap<String, Integer> um) {
		Iterator<String> it = um.keySet().iterator();
		while (it.hasNext()) {
			String name = it.next();
			int num = um.get(name);
			println("Entry [" + name + "] has count " + num);
		}
	}
}
```

![image.png](https://i.loli.net/2021/02/13/VyPJOk2iozWLrEm.png)

