package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {
	public void flagOfSouthKorea(int stepCount, double height) {
		// ... inicializacne prikazy
		double startX = this.getX();
		double startY = this.getY();

		for (int i = 0; i < stepCount; i++) {
			// ... prikazy na nastavenie farby podla aktualnej pozicie
			boolean blueSmall = this.distanceTo(startX + (height / 8), startY) < height / 8;
			boolean redSmall = this.distanceTo(startX - (height / 8), startY) < height / 8;
			boolean blueHalf = (this.getY() > startY + height / 150) && (this.distanceTo(startX, startY) < height / 4);
			boolean redHlaf = (this.getY() < startY - height / 150) && (this.distanceTo(startX, startY) < height / 4);

			if (blueSmall) {
				this.setPenColor(Color.BLUE);
			} else if (redSmall) {
				this.setPenColor(Color.RED);
			} else if (blueHalf) {
				this.setPenColor(Color.BLUE);
			} else if (redHlaf) {
				this.setPenColor(Color.RED);
			} else {
				this.setPenColor(Color.WHITE);
			}

			this.turn(Math.random() * 360);
			this.step(5);

			// ... prikazy, resp. podmienka, ktore zabezpecia, ze korytnacka
			// nevyjde mimo definovanej obdlznikovej oblasti
			boolean right = this.getX() > startX + (height / 2) * 1.5;
			boolean left = this.getX() < startX - (height / 2) * 1.5;
			boolean up = this.getY() < startY - height / 2;
			boolean down = this.getY() > startY + height / 2;

			boolean outOfArea = right || left || up || down;

			if (outOfArea) {
				this.step(-5);
			}
		}

		// ... prikazy, ktore obnovia vychodiskovy stav
		this.setPosition(startX, startY);
		this.setDirection(0);
	}

	public void sipka(double sirka, double dlzka) {
		this.penUp();
		this.turn(-90);
		this.step(sirka / 2);
		this.turn(90);
		this.openPolygon();
		this.step(dlzka);
		this.turn(30);
		this.step(sirka);
		this.turn(120);
		this.step(sirka);
		this.turn(30);
		this.step(dlzka);
		this.turn(150);
		this.step(sirka);
		this.turn(-120);
		this.step(sirka);
		this.closePolygon();
		this.turn(-120);
		this.step(sirka / 2);
		this.turn(-90);
	}

	public void sipkovnica(int pocetSipok, double sirka, double dlzkaPrvej, double medzera) {
		// vloženie počiatočných súradníc do premenných
		double startX = getX();
		double startY = getY();

		// vloženie 70% z dĺžky prvej šípky do premennej length
		double length = dlzkaPrvej * 0.7;

		// vykreslenie prvej šípky a medzery
		this.setFillColor(Color.ORANGE);
		this.sipka(sirka, dlzkaPrvej);
		this.step(medzera + dlzkaPrvej);

		// cyklus na vykreslenie zadaného počtu šípok mínus prvá, ktorá je už vykreslená
		for (int i = 0; i < pocetSipok - 1; i++) {
			// striedanie farieb šípok
			if (i % 2 == 0) {
				this.setFillColor(Color.BLACK);
			} else {
				this.setFillColor(Color.ORANGE);
			}

			// vykresľovanie šípok a výpočet dĺžky pre ďalšie, vložením veľkosti do novej
			// premennej a následným nahradením
			this.sipka(sirka, length);
			this.step(medzera + length);
			double newLength = length * 0.7;
			length = newLength;
		}
		// obnovenie východískovej pozície
		this.setPosition(startX, startY);
	}
}
