> # Programming-Assignment-4-Hangman

## Part I—Playing a console-based game

```java
/*
 * File: HangmanLexicon.java
 * -------------------------
 * This file contains a stub implementation of the HangmanLexicon
 * class that you will reimplement for Part III of the assignment.
 */

import acm.util.*;
import acm.program.*;

public class HangmanLexicon extends ConsoleProgram {
	private RandomGenerator rgen = RandomGenerator.getInstance();
	public void run() {
		showWelcomeMessage();
		
		String acturalWord = generateWord();

		int len = acturalWord.length();
		int opportunityLeft = 8;

		char guessWord[] = new char[len];
		for (int i = 0; i < len; ++i) {
			guessWord[i] = '-';
		}

		while (true) {
			print("The word now looks like this: ");
			for (int i = 0; i < len; ++i) {
				print(guessWord[i]);
			}
			println();
			println("You have " + opportunityLeft + " guesses left.");
			String inputChar = readLine("Your guess: ");

			if (inputChar.length() == 0) continue;
			else if (inputChar.length() > 1) {
				--opportunityLeft;
			}
			else if (inputChar.length() == 1 
					&& !Character.isLetter(Character.toUpperCase(inputChar.charAt(0)))) {
				--opportunityLeft;
			}
			else {
				char ch = Character.toUpperCase(inputChar.charAt(0));
				if (contain(acturalWord, ch)) {
					println("The guess is correct");
					for (int i = 0; i < len; ++i) {
						if (acturalWord.charAt(i) == ch) {
							guessWord[i] = ch;
						}
					}
				}
				else {
					--opportunityLeft;
					println("There are no " + ch + "'s in the word.");
				}
				
				boolean isAllGuessed = true;
				for (int i = 0; i < len; ++i) {
					if (guessWord[i] == '-') {
						isAllGuessed = false;
						break;
					}
				}
				if (isAllGuessed) {
					println("You guessed the word: " + acturalWord);
					println("You win.");
					break;
				}
			}
			
			if (opportunityLeft == 0) {
				println("You're completely hung.");
				println("The word was: " + acturalWord);
				println("You lose.");
				break;
			}
		}

	}
	
	private String generateWord() {
		int index = rgen.nextInt() % getWordCount();
		if (index < 0) index = -index;
		
		String acturalWord = getWord(index);
		return acturalWord;
	}
	
	private boolean contain(String acturalWord, char ch) {
		int len = acturalWord.length();
		for (int i = 0; i < len; ++i) {
			if (acturalWord.charAt(i) == ch) return true;
		}
		
		return false;
	}

	private void showWelcomeMessage() {
		println("Welcome to Hangman!");
	}
	

/** Returns the number of words in the lexicon. */
	public int getWordCount() {
		return 10;
	}

/** Returns the word at the specified index. */
	public String getWord(int index) {
		switch (index) {
			case 0: return "BUOY";
			case 1: return "COMPUTER";
			case 2: return "CONNOISSEUR";
			case 3: return "DEHYDRATE";
			case 4: return "FUZZY";
			case 5: return "HUBBUB";
			case 6: return "KEYHOLE";
			case 7: return "QUAGMIRE";
			case 8: return "SLITHER";
			case 9: return "ZIRCON";
			default: throw new ErrorException("getWord: Illegal index");
		}
	};
}

```



![image.png](https://i.loli.net/2021/02/11/iDZPeyz9J2lgrjk.png)

![image.png](https://i.loli.net/2021/02/11/r9d2RXpc3Yye46E.png)