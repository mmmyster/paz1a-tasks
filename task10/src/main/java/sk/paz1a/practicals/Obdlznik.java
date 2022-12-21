package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;

public class Obdlznik extends Tvar {
	private double width;
	private double height;

	public void setWidth(double width) {
		this.width = width;
	}

	public double getWidth() {
		return width;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getHeight() {
		return height;
	}

	public Obdlznik(double x, double y, double width, double height, Color color) {
		super(x, y, color);
		this.width = width;
		this.height = height;
	}

	@Override
	public void vykresliSa(Pane plocha) {
		super.vykresliSa(plocha);

		Turtle albert = new Turtle();
		plocha.add(albert);
		albert.setDirectionTowards(getX(), getY());
		albert.penUp();
		albert.turn(90);
		albert.setFillColor(getColor());
		albert.openPolygon();
		for (int i = 0; i < 2; i++) {
			albert.step(width);
			albert.turn(90);
			albert.step(height);
			albert.turn(90);
		}
		albert.closePolygon();
		plocha.remove(albert);
	}

	// @Override
	// public boolean jeVnutornyBod(double x, double y) {
	// // return super.jeVnutornyBod(x, y);
	// double a = this.getX() - x;
	// double b = this.getY() - y;
	// return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) < ;
	// }

}
