import acm.program.*;

public class FibonacciSequence extends ConsoleProgram {
	public void run() {
		println("This program lists the Fibonacci sequence.");
		Fibonacci(10000);
	}
	
	private void Fibonacci(int MAX_TERM_VALUE) {
		int first = 0, second = 1;
		if (MAX_TERM_VALUE <= 0) return;
		if (MAX_TERM_VALUE == 1) {
			println(first);
			return;
		}
		
		println(first);
		while (second < MAX_TERM_VALUE) {
			println(second);
			int tmp = first + second;
			first = second;
			second = tmp;
		}
	}
}