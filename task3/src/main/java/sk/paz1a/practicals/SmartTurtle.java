package sk.paz1a.practicals;

import sk.upjs.jpaz2.*;

import java.awt.Color;

public class SmartTurtle extends Turtle {

	// put new methods here
	public void mystery() {
		for (int i = 0; i < 256; i++) {
			Color c = new Color(i, 100, 100);
			this.setPenColor(c);
			this.setPosition(i, 0);
			this.moveTo(i, 150);
		}
	}

	public void concentricCircles(double radius) {
		this.penUp();
		int i = 0;
		double sumArea = 0;

		while (radius > 1) {
			if (i % 3 == 0) {
				this.setFillColor(Color.RED);
			} else if (i % 3 == 1) {
				this.setFillColor(Color.BLUE);
			} else if (i % 3 == 2) {
				this.setFillColor(Color.GRAY);
			}
			this.dot(radius);
			i++;
			double area = Math.PI * radius * radius;
			sumArea += area;
			radius = radius * 0.8;
		}
		System.out.println(sumArea);
	}

}
