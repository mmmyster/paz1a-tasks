package sk.paz1a.practicals;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.Scanner;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class ClickPane extends WinPane {
	private int[][] xy = new int[1000][2];
	private double[] radiuses = new double[1000];
	private int count;

	@Override
	protected void onMouseClicked(int x, int y, MouseEvent detail) {
		double r = 2 + Math.random() * 3;
		createDot(x, y, r);
	}

	public void createDot(int x, int y, double r) {
		// graficka cast
		Turtle t = new Turtle();
		this.add(t);
		t.setPosition(x, y);
		t.dot(r);
		this.remove(t);

		// datova cast
		xy[count][0] = x;
		xy[count][1] = y;
		radiuses[count] = r;
		count++;
	}

	public void saveClicksToFile(File file) {
		PrintWriter viktor = null;
		try {
			viktor = new PrintWriter(file);
			viktor.println(count);
			for (int i = 0; i < count; i++) {
				viktor.print(xy[i][0] + " ");
				viktor.print(xy[i][1] + " ");
				viktor.println(radiuses[i]);
			}
		} catch (FileNotFoundException e) {
			System.err.println("problem with file");
		} finally {
			if (viktor != null) {
				viktor.close();
			}
		}
	}

	public void loadClicksFromFile(File file) {
		Scanner reader = null;
		try {
			reader = new Scanner(file);
			reader.useLocale(Locale.US);
			int numberOfClicks = reader.nextInt();
			for (int i = 0; i < numberOfClicks; i++) {
				int x = reader.nextInt();
				int y = reader.nextInt();
				double r = reader.nextDouble();
				createDot(x, y, r);
			}
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}
