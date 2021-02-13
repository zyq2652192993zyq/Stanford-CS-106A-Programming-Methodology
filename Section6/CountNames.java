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
