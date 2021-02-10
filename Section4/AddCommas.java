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