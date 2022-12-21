package sk.paz1a.practicals;

import java.awt.Color;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class ClickPane extends WinPane {
	private int dotCount; // premenná na počítanie bodiek
	private double beforeX; // premenná na ukladanie súradnice x predchádzajúcej bodky
	private double beforeY; // premenná na ukladanie súradnice y predchádzajúcej bodky
	private double firstX; // premenná, ktorá drží súradnicu x prvej bodky
	private double firstY; // premenná, ktorá drží súradnicu y prvej bodky

	public void dot(double x, double y) {
		// pridanie objektu korytnačky
		Turtle jeffrey = new Turtle();
		this.add(jeffrey);

		if (dotCount == 0) {
			jeffrey.setPosition(x, y); // presunutie korytnačky na cieľovú pozíciu
			firstX = jeffrey.getX(); // získanie súradnice x prvej bodky
			firstY = jeffrey.getY(); // získanie súradnice y prvej bodky
		} else { // príkazy po pridaní prvej bodky
			if (jeffrey.distanceTo(firstX, firstY) <= 12) {
				jeffrey.setPosition(beforeX, beforeY); // presunutie korytnačky na pozíciu predchádzajúcej bodky
				jeffrey.turnTowards(firstX, firstY); // natočenie korytnačky na prv bodku
				jeffrey.penUp();
				jeffrey.step(10); // posunutie o polomer bodky so zdvihnutým perom
				jeffrey.penDown();
				if (jeffrey.distanceTo(x, y) < 10) {
					jeffrey.penUp();
				}
				jeffrey.step(jeffrey.distanceTo(firstX, firstY)); // nakreslenie čiary, zmenšenej o polomer bodky
			} else {
				double direction = jeffrey.getDirection(); // premenná, v ktorej je uložený počiatočný smer bodky
				jeffrey.setPosition(beforeX, beforeY); // presunutie korytnačky na pozíciu predchádzajúcej bodky
				jeffrey.turnTowards(x, y); // natočenie korytnačky na novú bodku
				jeffrey.penUp();
				jeffrey.step(10); // posunutie o polomer bodky so zdvihnutým perom
				jeffrey.penDown();
				if (jeffrey.distanceTo(x, y) < 10) {
					jeffrey.penUp();
				}
				jeffrey.step(jeffrey.distanceTo(x, y)); // nakreslenie čiary, zmenšenej o polomer bodky
				jeffrey.setDirection(direction); // obnovenie natočenia bodky
			}
		}
		// spojenie čiarou s prvou bodkou
		if (jeffrey.distanceTo(firstX, firstY) <= 12 && dotCount != 0) {
			dotCount = -1; // vynulovanie počítadla
			beforeX = 0; // vynulovanie súradnice x
			beforeY = 0; // vynulovanie súradnice y
			this.remove(jeffrey); // odobratie korytnačky z kresliacej plochy
		}

		jeffrey.setFillColor(Color.ORANGE); // nastavenie farby výplne bodiek
		jeffrey.dot(10); // nakreslenie bodky
		this.dotCount++; // pripočítanie bodky

		// otočenie korytnačky a vypísanie o koľkú bodku sa jedná
		jeffrey.turn(90);
		String count = Integer.toString(dotCount);
		jeffrey.printCenter(count);

		beforeX = jeffrey.getX(); // uloženie súradnice x nakreslenej bodky
		beforeY = jeffrey.getY(); // uloženie súradnice y nakreslenej bodky

		this.remove(jeffrey); // odobratie korytnačky z kresliacej plochy
	}

	// vráti počet zatiaľ nakreslených bodiek
	public int getDotCount() {
		return this.dotCount;
	}

	// metóda vykonávajúca sa vždy po kliknutú do plochy
	@Override
	protected void onMousePressed(int x, int y, MouseEvent detail) {
		if (detail.getButton() == MouseEvent.BUTTON1) {
			this.dot(x, y);
		}
	}
}
