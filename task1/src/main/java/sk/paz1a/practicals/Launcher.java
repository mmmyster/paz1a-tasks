package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		AnimatedWinPane sandbox = new AnimatedWinPane();

		// create new turtle and add it to the "sandbox"
		SmartTurtle franklin = new SmartTurtle();
		// sandbox.add(franklin);

		// create new object inspector
		ObjectInspector oi = new ObjectInspector();
		// ask the inspector to inspect "franklin" and "sandbox"
		oi.inspect(franklin);
		oi.inspect(sandbox);

		// you can put other initialization commands here
		franklin.setPosition(100, 150);
		franklin.setPenColor(Color.BLUE);

		// Turtle cecil = new Turtle();
		// sandbox.add(cecil);
		// oi.inspect(cecil);
		// cecil.setPosition(200, 150);
		// cecil.setPenColor(Color.RED);

		// SmartTurtle albert = new SmartTurtle();
		// sandbox.add(albert);
		// oi.inspect(albert);
		// albert.setPosition(150, 150);
		// albert.setPenColor(Color.GREEN);

		HomeTurtle jefry = new HomeTurtle();
		sandbox.add(jefry);
		oi.inspect(jefry);

	}
}