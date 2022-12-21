package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.*;

public class SmartTurtle extends Turtle {

	public void chain(int beadCount, double beadRadius) {
		this.penUp();
		for (int i = 0; i < beadCount; i++) {
			this.dot(beadRadius);
			this.step(beadRadius * 2);
		}
	}

	public void ngon(int n, double sideLength) {
		for (int i = 0; i < n; i++) {
			this.step(sideLength);
			this.turn(360.0 / n);
		}
	}

	public void dashedLine(int n, double segmentLength) {
		for (int i = 0; i < n; i++) {
			this.step(segmentLength / 4);
			this.penUp();
			this.step(segmentLength / 2);
			this.penDown();
		}
	}

	public void isosceles(double legLength, double angle) {
		// Do premennych startX a startY si ulozime
		// poziciu korytnacky pri zavolani tejto metody
		double startX = this.getX();
		double startY = this.getY();
		// Do premennej natocenie si ulozime natocenie (smer)
		// korytnacky pri zavolani tejto metody
		double direction = this.getDirection();

		// Kreslenie
		this.turn(-angle / 2);
		this.step(legLength);

		// Sme v bode A, ulozime si teda x-ovu a y-ovu suradnicu
		// tohto bodu (pouzijeme ich neskor)

		// Vytvorime premennu xCoord na hodnoty typu double
		double xCoord;
		// Do premennej xCoord ulozime aktualnu x-ovu suradnicu
		// pozicie korytnacky - ziskame ju tak, ze sa "sami seba" spytame
		// na x-ovu suradnicu
		xCoord = this.getX();

		// Ako predosle, ale s y-ovou suradnicou. Kombinujeme vytvorenie
		// premennej aj inicializaciu hodnoty do jedneho prikazu
		double yCoord = this.getY();

		// Dalsie kreslenie
		this.step(-legLength);
		this.turn(angle);
		this.step(legLength);

		// Na zaver sa presunieme na ulozenu poziciu bodu A
		this.moveTo(xCoord, yCoord);

		// Korytnacku presunieme tam, kde bola na zaciatku, a natocime smerom,
		// akym bola natocena na zaciatku (pri volani tejto metody)
		this.setPosition(startX, startY);
		this.setDirection(direction);
	}

	public void mill(int n, double legLength) {
		for (int i = 0; i < n; i++) {
			this.isosceles(legLength, 360 / (n * 2));
			this.turn(360 / n);
		}
	}

	public void rgbChain(int beadCount, double beadRadius) {
		this.penUp();

		for (int i = 0; i < beadCount; i++) {
			if (i % 3 == 0) {
				this.setFillColor(Color.BLUE);
			}
			if (i % 3 == 1) {
				this.setFillColor(Color.RED);
			}
			if (i % 3 == 2) {
				this.setFillColor(Color.GREEN);
			}
			this.dot(beadRadius);
			this.step(beadRadius * 2);
		}
	}

	public void circleWalk(int stepCount, double radius) {
		double startX = this.getX();
		double startY = this.getY();

		for (int i = 0; i < stepCount; i++) {
			this.turn(Math.random() * 360);

			this.step(5);

			if (this.distanceTo(startX, startY) > radius) {
				this.step(-5);
			}
		}
		this.setPosition(startX, startY);
	}

	public void tripleCircleWalk(int stepCount, double radius) {
		double startX = this.getX();
		double startY = this.getY();

		for (int i = 0; i < stepCount; i++) {

			boolean notPaint = this.distanceTo(startX, startY) < radius / 3;

			if (notPaint) {
				this.penUp();
			} else {
				this.penDown();
			}

			boolean blue = this.distanceTo(startX, startY) < 2 * radius / 3;

			if (blue) {
				this.setPenColor(Color.BLUE);
			} else {

				this.setPenColor(Color.RED);
			}

			this.turn(Math.random() * 360);

			this.step(5);

			if (this.distanceTo(startX, startY) > (radius / 3)) {
				this.step(-5);
			}
		}
		this.setPosition(startX, startY);
	}

	public void squareWalk(int stepCount, double sideLength) {
		double startX = this.getX();
		double startY = this.getY();

		for (int i = 0; i < stepCount; i++) {
			this.turn(Math.random() * 360);

			this.step(5);

			boolean right = this.getX() > startX + sideLength / 2;
			boolean left = this.getX() < startX - sideLength / 2;
			boolean up = this.getY() > startY + sideLength / 2;
			boolean down = this.getY() < startY - sideLength / 2;

			boolean area = right || left || up || down;

			if (area) {
				this.step(-5);
			}

		}

		this.setPosition(startX, startY);
	}
}