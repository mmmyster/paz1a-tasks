package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {

	public void flower(double radius) {
		for (int i = 0; i < 10; i++) {
			this.penUp();
			this.step(radius);
			this.setFillColor(Color.RED);
			this.dot(radius / 2);
			this.step(-radius);
			this.turn(360 / 10);
		}
		this.setFillColor(Color.YELLOW);
		this.dot(radius);
	}

	public void arrow(double size) {
		penUp();
		this.openPolygon();
		this.turn(-90);
		this.step(size / 2);
		for (int i = 0; i < 2; i++) {
			this.turn(120);
			this.step(size);
		}
		this.turn(120);
		this.step(size / 2);
		this.turn(90);
		this.closePolygon();
	}

	public void navigationArrow(double size) {
		this.penUp();
		this.arrow(size);
		for (int i = 0; i < 4; i++) {
			this.step(size / 2);
			this.arrow(size);
		}
		this.step((-size / 2) * 4);
	}

	public void hexagon(double size) {
		this.penUp();
		this.step(size);
		this.penDown();
		this.turn(120);
		for (int i = 0; i < 6; i++) {
			this.step(size);
			this.turn(360 / 6);
		}
		this.turn(-120);
		this.penUp();
		this.step(-size);
		this.penDown();
	}

	public void beehive(double size) {
		this.setPenColor(Color.GREEN);
		this.hexagon(size);
		this.penUp();
		this.turn(360 / 6);
		this.step(size);
		this.turn(-360 / 6);
		this.step(size);
		this.hexagon(size);
		for (int i = 0; i < 5; i++) {
			this.penUp();
			this.step(-size);
			this.turn(360 / 6);
			this.step(-size);
			this.turn(360 / 6);
			this.step(size);
			this.turn(-360 / 6);
			this.step(size);
			this.hexagon(size);
		}
		this.penUp();
		this.step(-size);
		this.turn(360 / 6);
		this.step(-size);
	}

	public void smartWatch(double radius, int hh, int mm) {
		this.setFillColor(Color.BLUE);
		this.dot(radius);
		this.setFillColor(Color.LIGHT_GRAY);
		this.dot(radius * 3 / 4);
		this.setFillColor(Color.BLUE);
		this.dot(radius / 10);

		for (int i = 0; i < 12; i++) {
			this.setPenColor(Color.BLACK);
			this.setPenWidth(1);
			this.penUp();
			this.step(radius * 3 / 4);
			this.penDown();
			this.step(-radius / 4);
			this.penUp();
			this.step(-radius * 2 / 4);
			this.turn(360 / 12);
		}

		this.penDown();
		this.setPenColor(Color.RED);

		this.setDirection((360 / 60) * mm);
		this.setPenWidth(3);
		this.step(2 * radius / 3);
		this.step(-2 * radius / 3);

		this.setDirection((360.0 / 12) * (hh + mm / 60.0));
		this.setPenWidth(5);
		this.step(radius / 3);
		this.step(-radius / 3);

		this.setDirection(0);
	}
}
