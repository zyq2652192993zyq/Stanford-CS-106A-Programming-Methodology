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