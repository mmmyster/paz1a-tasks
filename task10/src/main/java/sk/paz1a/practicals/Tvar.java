package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.Pane;

public class Tvar {
	private double x;
	private double y;
	private Color color;

	public Tvar() {
		super();
	}

	public Tvar(double x, double y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Tvar(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void vykresliSa(Pane plocha) {
		System.err.println("chora veta");
	}

	public boolean jeVnutornyBod(double x, double y) {
		System.err.println("chora veta");
		return false;
	}

	public void posun(double dx, double dy) {
		setX(dx + getX());
		setY(dy + getY());
	}

}
