package sk.paz1a.practicals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SpolocnePrednasky {

	public Set<String> prednasky(File file) {
		Scanner lineReader = null;
		Scanner stringReader = null;
		Set<String> predmety = new HashSet<String>();
		Set<String> novePredmety = new HashSet<String>();

		try {
			lineReader = new Scanner(file);
			while (lineReader.hasNextLine()) {
				String line = lineReader.nextLine();
				stringReader = new Scanner(line);
				novePredmety.clear();
				while (stringReader.hasNext()) {
					String word = new String();
					word = stringReader.next();
					novePredmety.add(word);
				}
				predmety.retainAll(novePredmety);
			}
		} catch (FileNotFoundException e) {
			System.err.println("chora subor");
		} finally {
			if (lineReader != null) {
				lineReader.close();
			}
			if (stringReader != null) {
				stringReader.close();
			}
		}
		return predmety;
	}
}