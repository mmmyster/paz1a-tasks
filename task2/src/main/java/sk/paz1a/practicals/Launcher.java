package sk.paz1a.practicals;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// create new "sandbox" - a place where turtles can live
		WinPane sandbox = new WinPane();

		// create new turtle and add it to the "sandbox"
		SmartTurtle franklin = new SmartTurtle();
		// sandbox.add(franklin);

		// create new object inspector
		ObjectInspector oi = new ObjectInspector();
		// ask the inspector to inspect "franklin" and "sandbox"
		oi.inspect(franklin);
		oi.inspect(sandbox);

		// you can put other initialization commands here
		HomeTurtle jefry = new HomeTurtle();
		sandbox.add(jefry);
		oi.inspect(jefry);

	}
}