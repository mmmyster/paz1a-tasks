package sk.paz1a.practicals;

import java.awt.Color;
import java.awt.event.MouseEvent;

import sk.upjs.jpaz2.*;

public class PrepinaciaHra extends WinPane {
	/**
	 * Policka hracej dosky
	 */
	private boolean[][] doska = new boolean[6][6];

	/**
	 * Indikuje, ci hra bezi (hra konci, ked sa dosiahlo vyherne rozlozenie)
	 */
	private boolean hraBezi = true;

	public PrepinaciaHra() {
		this.kresliMriezku();
		this.zamiesaj(30);
		this.kresliDosku();
	}

	/**
	 * Nakresli mriezku
	 */
	public void kresliMriezku() {
		Turtle k = new Turtle();
		this.add(k);

		for (int i = 1; i < 6; i++) {
			k.setPosition(i * 50, 0);
			k.moveTo(i * 50, this.getHeight());
		}

		for (int i = 1; i < 6; i++) {
			k.setPosition(0, i * 50);
			k.moveTo(this.getWidth(), i * 50);
		}

		this.remove(k);
	}

	/**
	 * Nakresli farebne kamene na zaklade obsahu policok
	 * v this.doska
	 */
	public void kresliDosku() {
		Turtle kreslic = new Turtle();
		this.add(kreslic);
		for (int r = 0; r < 6; r++) {
			for (int s = 0; s < 6; s++) {
				// pristupim do pola
				if (this.doska[r][s]) {
					// cervena
					kreslic.setFillColor(Color.RED);
				} else {
					// modra
					kreslic.setFillColor(Color.BLUE);
				}
				// pristupim k policku
				kreslic.setPosition(s * 50 + 25, r * 50 + 25);
				kreslic.dot(20);
			}
		}
		this.remove(kreslic);
	}

	/**
	 * Overi, ci riadok r a stlpec s su platne suradnice
	 */
	public boolean dobraSuradnica(int r, int s) {
		return (r >= 0) && (r < 6) && (s >= 0) && (s < 6);
	}

	/**
	 * Zrealizuje tah, kedy bolo zatlaceny prepinac na policku
	 * v riadku r a stlpci s
	 */
	public void tah(int r, int s) {
		int[][] smery = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int smer = 0; smer < smery.length; smer++) {
			int rSused = r + smery[smer][0];
			int sSused = s + smery[smer][1];
			if (dobraSuradnica(rSused, sSused)) {
				this.doska[rSused][sSused] = !this.doska[rSused][sSused];
			}
		}
		this.kresliDosku();
	}

	/**
	 * Vytvori startovacie rozlozenie kamenov tak, ze spravi
	 * zadany pocet nahodnych prepnuti (tahov)
	 */
	public void zamiesaj(int pocetMiesani) {
		for (int i = 0; i < pocetMiesani; i++) {
			int nahodnyRiadok = (int) Math.random() * 6;
			int nahodnyStlpec = (int) Math.random() * 6;
			this.tah(nahodnyRiadok, nahodnyStlpec);
		}
	}

	/**
	 * Vrati, ci v aktualnom stave policok je kresliaca plocha
	 * jednofarebna
	 */
	public boolean jeVyherna() {
		for (int r = 0; r < 6; r++) {
			for (int s = 0; s < 6; s++) {
				if (this.doska[r][s] != this.doska[0][0]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected void onMouseClicked(int x, int y, MouseEvent detail) {
		if (!this.hraBezi) {
			return;
		}
		int r = y / 50;
		int s = x / 50;
		this.tah(r, s);
		if (this.jeVyherna()) {
			hraBezi = false;
			System.out.println("Gratulujem vyhral si!");
		}
	}
}
