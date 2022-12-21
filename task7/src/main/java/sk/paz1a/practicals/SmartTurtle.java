package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

public class SmartTurtle extends Turtle {
	public int stringToInt(String s, int defaultValue) {
		int num = 0;
		try {
			num = Integer.parseInt(s);
		} catch (NumberFormatException e) {
			num = defaultValue;
		} finally {
			return num;
		}
	}
}
