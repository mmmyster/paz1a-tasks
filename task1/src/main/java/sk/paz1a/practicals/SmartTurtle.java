package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.*;

public class SmartTurtle extends Turtle {

	// put new methods here
	public void square(double size) {
		for (int i = 0; i < 4; i++) {
			this.step(size);
			this.turn(90);
		}
	}

	public void triangel(double size) {
		for (int i = 0; i < 3; i++) {
			this.step(size);
			this.turn(120);
		}
	}

	public void rgbTriangel(double size) {
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				this.setPenColor(Color.RED);
			} else if (i == 2) {
				this.setPenColor(Color.BLUE);
			} else {
				this.setPenColor(Color.GREEN);
			}

			this.setPenWidth(2);
			this.step(size);
			this.turn(120);

		}

	}

	public void house(double size) {
		this.square(size);
		this.step(size);
		this.turn(30);
		this.triangel(size);
		this.turn(-30);
		this.step(-size);

	}

	public void dashDotDash(double length) {
		this.step(length / 2);
		this.penUp();
		this.step(length / 2);
		this.penDown();
		this.setFillColor(Color.YELLOW);
		this.dot(length / 4);
		this.penUp();
		this.step(length / 2);
		this.penDown();
		this.step(length / 2);
	}

	public void sun(double radius) {
		this.setFillColor(Color.YELLOW);
		this.setPenColor(Color.YELLOW);
		this.dot(radius);
		for (int i = 0; i < 36; i++) {
			this.step(radius * 2);
			this.step(-radius * 2);
			this.turn(10);
		}

	}

	public void pinwheel(double size) {
		for (int i = 0; i < 8; i++) {
			this.step(size);
			this.turn(45);
			this.step(10);
			this.step(-10);
			this.turn(-45);
			this.step(-size);
			this.turn(45);

		}
	}

	public void cross(double size) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 3; j++) {
				this.step(size);
				this.turn(90);
			}
			this.turn(-90);
		}
	}

	public void squareDrawing(double size) {
		for (int i = 0; i < 10; i++) {
			this.square(size);
			this.turn(90);
			this.step(size / 2);
			this.turn(-36);
		}

	}

	public void centeredSquare(double sideLength) {
		this.penUp();
		this.step(-sideLength / 2);
		this.turn(-90);
		this.step(sideLength / 2);
		this.turn(90);
		this.penDown();

		this.square(sideLength);

		this.penUp();
		this.step(sideLength / 2);
		this.turn(90);
		this.step(sideLength / 2);
		this.turn(-90);

	}

	public void fence(double height, double spacing) {
		for (int i = 0; i < 5; i++) {
			this.step(height);
			this.setDirection(-90);
			this.step(spacing);
			this.setDirection(-180);
			this.step(height);
			this.setDirection(0);
		}
	}

}
