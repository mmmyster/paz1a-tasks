package sk.paz1a.practicals;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		WinPane sandbox = new WinPane();

		SmartTurtle franklin = new SmartTurtle();
		sandbox.add(franklin);

		ObjectInspector oi = new ObjectInspector();
		oi.inspect(franklin);
		oi.inspect(sandbox);

		ScientificTurtle jeffrey = new ScientificTurtle();
		sandbox.add(jeffrey);
		oi.inspect(jeffrey);

		HomeTurtle albert = new HomeTurtle();
		sandbox.add(albert);
		oi.inspect(albert);

		System.out.println(albert.isUniDigitNumber(1600));

	}
}
