/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {
	private HangmanCanvas canvas;
	private HangmanLexicon hangmanLexicon = new HangmanLexicon();
	private String incorrectLetter;
	
	public void init() {
		canvas = new HangmanCanvas();
		add(canvas);
	}
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	private char guessWord[];
	private static final int OPPORTUNITY = 8;
	
    public void run() {
    	showWelcomeMessage();	
		String acturalWord = generateWord();	
		setUpGame(acturalWord);
		startGame(acturalWord);
	}
    
    private void display(String actualWord, int wrongAnswerTimes) {
    	String tmp = "";
    	for (int i = 0; i < actualWord.length(); ++i) {
    		tmp += guessWord[i];
    	}
    	canvas.displayWord(tmp);
    	canvas.noteIncorrectGuess(incorrectLetter, wrongAnswerTimes);
    }
    
    private void startGame(String acturalWord) {
		int opportunityLeft = OPPORTUNITY;
		int len = acturalWord.length();
		
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
				display(acturalWord, OPPORTUNITY - opportunityLeft);
			}
			else if (inputChar.length() == 1 
					&& !Character.isLetter(Character.toUpperCase(inputChar.charAt(0)))) {
				--opportunityLeft;
				display(acturalWord, OPPORTUNITY - opportunityLeft);
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
					display(acturalWord, OPPORTUNITY - opportunityLeft);
				}
				else {
					--opportunityLeft;
					incorrectLetter += inputChar;
					display(acturalWord, OPPORTUNITY - opportunityLeft);
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
				display(acturalWord, OPPORTUNITY + 1);
				println("You're completely hung.");
				println("The word was: " + acturalWord);
				println("You lose.");
				break;
			}
		}
	}
	
	private void setUpGame(String acturalWord) {
		incorrectLetter = "";
		int len = acturalWord.length();
		guessWord = new char[len];
		
		for (int i = 0; i < len; ++i) {
			guessWord[i] = '-';
		}
	}
	
	private String generateWord() {
		String acturalWord = "";
		int n = hangmanLexicon.getWordCount();
		if (n != 0) {
			int index = rgen.nextInt(0, n - 1);	
			index = 4;
			acturalWord = hangmanLexicon.getWord(index);
		} 
		
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

}
