package sk.paz1a.practicals;

import java.awt.Color;
import java.awt.geom.Point2D;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class Korytnackovo extends WinPane {
	Turtle[] turtles;

	public Korytnackovo() {
		turtles = new Turtle[10];
		for (int i = 0; i < turtles.length; i++) {
			Turtle jeffrey = new Turtle();
			this.add(jeffrey);
			turtles[i] = jeffrey;
			turtles[i].setPosition(Math.random() * 300, Math.random() * 300);
		}
	}

	public void nahodneFarby() {
		for (int i = 0; i < turtles.length; i++) {
			turtles[i]
					.setPenColor(new Color((int) Math.random() * 256, (int) Math.random() * 256, (int) Math.random() * 256));
		}
	}

	Color sFarbouVon(int index) {
		if (!(index >= 0 && index <= 10)) {
			return Color.BLACK;
		}
		return turtles[index].getPenColor();

	}

	public void krok() {
		Point2D nextPosition = null;
		for (int i = 0; i < turtles.length; i++) {
			if (i != turtles.length - 1) {
				nextPosition = turtles[i + 1].getPosition();
			} else {
				nextPosition = turtles[0].getPosition();
			}
			turtles[i].setDirectionTowards(nextPosition);
			turtles[i].step(turtles[i].distanceTo(nextPosition) / 10);
		}
	}

	public String prefix(String s1, String s2) {
		Turtle albert = new Turtle();
		this.add(albert);
		String result = "";
		int i = 0;

		while (i < s1.length()) {
			if (s1.charAt(i) != s2.charAt(i)) {
				break;
			} else {
				result += s1.charAt(i);
			}
			i++;
		}
		return result;
	}

}
