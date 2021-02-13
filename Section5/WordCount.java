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
			in.close();
			
			println("Lines = " + lines);
			println("Words = " + words);
			println("Chars = " + chars);
		} catch (IOException ex) {
			println("I/O Exception!");
		}		
	}


}