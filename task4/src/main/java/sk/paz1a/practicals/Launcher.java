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

		StringTurtle jeffrey = new StringTurtle();
		oi.inspect(jeffrey);

		GridPane gp = new GridPane();
		oi.inspect(gp);

		HomeTurtle albert = new HomeTurtle();
		oi.inspect(albert);

		ClickPane cp = new ClickPane();
		oi.inspect(cp);

		System.out.println(albert.countAcronyms("Čo vieš o TCP a UDPAAA?"));
	}
}
