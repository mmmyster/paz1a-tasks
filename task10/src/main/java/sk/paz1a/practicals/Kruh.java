package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.Pane;
import sk.upjs.jpaz2.Turtle;

public class Kruh extends Tvar {
	private double r;

	public void setR(double r) {
		this.r = r;
	}

	public double getR() {
		return r;
	}

	public Kruh(double x, double y, double r, Color color) {
		super(x, y, color);
		this.r = r;
	}

	public Kruh(double x, double y, double r) {
		super(x, y);
		this.r = r;
	}

	@Override
	public void vykresliSa(Pane plocha) {
		super.vykresliSa(plocha);

		Turtle franklin = new Turtle();
		plocha.add(franklin);
		franklin.setPosition(getX(), getY());
		franklin.setFillColor(getColor());
		franklin.dot(r);
		plocha.remove(franklin);
	}

	@Override
	public boolean jeVnutornyBod(double x, double y) {
		// return super.jeVnutornyBod(x, y);
		double a = this.getX() - x;
		double b = this.getY() - y;
		return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2)) < r;
	}
}