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
			in.close();
			
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
