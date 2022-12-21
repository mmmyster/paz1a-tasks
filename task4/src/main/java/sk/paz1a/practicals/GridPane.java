package sk.paz1a.practicals;

import java.awt.Color;

import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class GridPane extends WinPane {

	private Color colorOfLastDot = Color.RED;

	public void drawGrid() {
		Turtle alica = new Turtle();
		this.add(alica);

		// kreslime
		// kreslime vertikalne ciary || zhora dole
		for (int i = 0; i < (this.getWidth() / 50); i++) {
			alica.setPosition(50 * i, 0);
			alica.moveTo(50 * i, this.getHeight());
		}

		// kreslime horizontalne ciary = zlava doprava
		for (int i = 0; i < (this.getHeight() / 50); i++) {
			alica.setPosition(0, 50 * i);
			alica.moveTo(this.getWidth(), 50 * i);
		}

		this.remove(alica);
	}

	public void drawDot(int column, int row, Color dotColor) {
		Turtle kika = new Turtle();
		this.add(kika);

		kika.setFillColor(dotColor);
		kika.setPosition(column * 50 + 25, row * 50 + 25);
		kika.dot(20);

		this.remove(kika);
	}

	protected void onMouseClicked(int x, int y, MouseEvent detail) {
		super.onMouseClicked(x, y, detail);

		int column = x / 50;
		int row = y / 50;

		if (this.colorOfLastDot.equals(Color.RED)) {
			this.drawDot(column, row, Color.BLUE);
			this.colorOfLastDot = Color.BLUE;
		} else {
			this.drawDot(column, row, Color.RED);
			this.colorOfLastDot = Color.RED;
		}

	}

	public String unicharString(char c, int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += c;
		}
		return s;
	}

	// public boolean isUnicharString(String s) {
	// for (int i; i < s.length();) {

	// }
	// }

	// public String duplicateChars(String s)

	// public String removeExtraSpaces(String s)

	// public int countWords(String s)

}
