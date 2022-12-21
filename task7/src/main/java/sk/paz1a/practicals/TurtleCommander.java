package sk.paz1a.practicals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import sk.upjs.jpaz2.Turtle;

public class TurtleCommander extends Turtle {
	public void listDirectory(File adresar) {
		File[] listOfFiles = adresar.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			System.out.println(listOfFiles[i].getName());
		}
	}

	public int countFiles(File adresar) {
		File[] listOfFiles = adresar.listFiles();
		int count = 0;

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				count++;
			}
		}
		return count;
	}

	public long totalSizeOfFilesInDirectory(File adresar) {
		File[] listOfFiles = adresar.listFiles();
		long size = 0;

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				size += listOfFiles[i].length();
			}
		}
		return size;
	}

	public boolean containEqualFilenames(File adresar1, File adresar2) {
		File[] listOFiles1 = adresar1.listFiles();
		File[] listOFiles2 = adresar2.listFiles();
		boolean sameName = false;

		if (listOFiles1.length > listOFiles2.length) {
			for (int i = 0; i < listOFiles2.length; i++) {
				for (int j = 0; j < listOFiles1.length; j++) {
					if (listOFiles2[i].isFile() && listOFiles1[j].isFile()) {
						if ((listOFiles2[i].getName()).equals(listOFiles1[j].getName())) {
							sameName = true;
							break;
						}
					}
				}
			}
		} else {
			for (int i = 0; i < listOFiles1.length; i++) {
				for (int j = 0; j < listOFiles2.length; j++) {
					if (listOFiles1[i].isFile() && listOFiles2[j].isFile()) {
						System.out.println(listOFiles1[i].getName() + listOFiles2[j].getName());
						if ((listOFiles1[i].getName()).equals(listOFiles2[j].getName())) {
							sameName = true;
							break;
						}
					}
				}
			}
		}
		return sameName;
	}

	public void punishment(File output, String message, int n) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(output);

			for (int i = 0; i < n; i++) {
				writer.print(message);
			}
		} catch (FileNotFoundException e) {
			System.err.println("dumb");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}
	}

	public void generateUnicodeFile(File output, int fromCode, int toCode) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(output);
			for (int i = fromCode; i < toCode; i++) {
				writer.println(i + " = " + (char) i);
			}
		} catch (FileNotFoundException e) {
			System.err.println("dumber");
		} finally {
			if (writer != null) {
				writer.close();
			}
		}

	}
}
