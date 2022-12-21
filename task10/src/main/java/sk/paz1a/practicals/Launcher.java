package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.*;

public class Launcher {

	// public static void main(String[] args) {
	// WinPane pane = new WinPane();
	// Kruh k = new Kruh(150, 150, 30, Color.PINK);
	// k.vykresliSa(pane);
	// }

	public static void main(String[] args) {
		WinPane plocha = new WinPane();
		// Tvar t;
		// if (Math.random() < 0.5) {
		// t = new Kruh(50, 150, 30, Color.PINK);
		// } else {
		// t = new Obdlznik(100, 50, 40, 20, Color.CYAN);
		// }

		// t.vykresliSa(plocha);

		ZoznamTvarov zt = new ZoznamTvarov();
		Kruh k = new Kruh(150, 150, 30, Color.PINK);
		Obdlznik o = new Obdlznik(100, 50, 40, 20, Color.CYAN);
		zt.pridajTvar(k);
		zt.pridajTvar(o);
		zt.nakresliVsetky(plocha);
		zt.odstranTvar(o);
		zt.nakresliVsetky(plocha);
	}
}