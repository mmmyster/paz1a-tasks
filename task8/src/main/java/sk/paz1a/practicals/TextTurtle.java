package sk.paz1a.practicals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import sk.upjs.jpaz2.Turtle;

public class TextTurtle extends Turtle {
	public double average(File file) {
		Scanner reader = null;
		double sum = 0;
		double count = 0;
		try {
			reader = new Scanner(file);
			while (reader.hasNextInt()) {
				count++;
				sum += reader.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
		return sum / count;
	}
}
