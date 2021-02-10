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
