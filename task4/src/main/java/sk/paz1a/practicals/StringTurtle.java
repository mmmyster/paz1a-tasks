package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

public class StringTurtle extends Turtle {

	public int countChar(String s, char c) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			char letter = s.charAt(i);
			if (letter == c) {
				count++;
			}
		}
		return count;
	}

	public boolean isPalindrome(String s) {
		boolean palindrome = false;
		String r = "";
		for (int i = s.length() - 1; i >= 0; i--) {
			char letter = s.charAt(i);
			r += letter;

			if (s.equals(r)) {
				palindrome = true;
			}
		}
		return palindrome;
	}

	public boolean containsDoubleSpace(String s) {
		boolean doubleSpace = false;
		char space = ' ';

		for (int i = 1; i < s.length() - 1; i++) {
			char letter = s.charAt(i - 1);
			char letterAfter = s.charAt(i);

			if (letter == space && letterAfter == space) {
				doubleSpace = true;
			}
		}
		return doubleSpace;
	}

}
