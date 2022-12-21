package sk.paz1a.practicals;

import sk.upjs.jpaz2.WinPane;

import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.awt.geom.Point2D;
import java.awt.Color;

import sk.upjs.jpaz2.*;

public class KorytnaciSvet extends WinPane {
	/**
	 * Referencia na pole korytnaciek
	 */
	private Turtle[] korytnacky = null;

	/**
	 * Inicializacna metoda (konstruktor)
	 */
	public KorytnaciSvet() {
		this.korytnacky = new Turtle[0];
	}

	/**
	 * Metoda na pridanie korytnacky na zadanych suradniciach
	 */
	public void pridajKorytnacku(int x, int y) {
		Turtle novaKorytnacka = new Turtle();
		this.add(novaKorytnacka);
		novaKorytnacka.setPosition(x, y);

		Turtle[] noveKorytnacky = new Turtle[this.korytnacky.length + 1];
		System.arraycopy(this.korytnacky, 0, noveKorytnacky, 0, this.korytnacky.length);
		noveKorytnacky[noveKorytnacky.length - 1] = novaKorytnacka;

		this.korytnacky = noveKorytnacky;
	}

	@Override
	protected void onMouseClicked(int x, int y, MouseEvent detail) {
		if (!(detail.isAltDown() || detail.isControlDown() || detail.isShiftDown())) {
			this.pridajKorytnacku(x, y);
		}
	}

	public void vystrelNaTazisko() {
		double x = 0;
		double y = 0;
		double startX = 0;
		double startY = 0;
		// šítanie súradníc korytnačiek
		for (int i = 0; i < korytnacky.length; i++) {
			x += korytnacky[i].getX();
			y += korytnacky[i].getY();
		}
		// výpočet súradníc ťažiska
		x /= korytnacky.length;
		y /= korytnacky.length;
		// presunutie korytnačiek na súradnice ťažiska a nakreslenie čiary do ich
		// pôvodného bodu
		for (int i = 0; i < korytnacky.length; i++) {
			startX = korytnacky[i].getX();
			startY = korytnacky[i].getY();
			korytnacky[i].setPosition(x, y);
			korytnacky[i].moveTo(startX, startY);
		}
	}

	public double explozia(double x, double y, double sila) {
		double longestDistance = 0;
		double aftermath;

		for (int i = 0; i < korytnacky.length; i++) {
			// výpočet vzdialenosti odhodenia
			aftermath = Math.pow(sila, 2) / Math.pow(korytnacky[i].distanceTo(x, y), 4);
			// otočenie sa od explózie a odhodenie
			korytnacky[i].turnTowards(x, y);
			korytnacky[i].turn(180);
			korytnacky[i].penUp();
			korytnacky[i].step(aftermath);
			// určenie najväčšej vzdialenosti
			if (longestDistance < aftermath) {
				longestDistance = aftermath;
			}
		}
		return longestDistance;
	}

	public double casDoPrichodu(double x, double y) {
		double bestTime = Double.MAX_VALUE;
		for (int i = 0; i < korytnacky.length; i++) {
			double timer = 0;
			double angle = korytnacky[i].directionTowards(x, y);
			double angleResidue = angle - (int) angle;
			double distance = korytnacky[i].distanceTo(x, y);
			double distanceResidue = distance - (int) distance;
			korytnacky[i].penUp();

			// zabezpečenie aby sa korytnačka posunula vždy o najmenší potrebný uhol
			if (angle > 180) {
				angle = 360 - angle;
				angleResidue = angle - (int) angle;
				for (int j = 0; j < angle; j++) {
					korytnacky[i].turn(-1);
				}
				korytnacky[i].turn(-angleResidue);
			} else {
				for (int j = 0; j < angle; j++) {
					korytnacky[i].turn(1);
				}
				korytnacky[i].turn(angleResidue);
			}
			// posun po jednom o celú vzdialenosť od cieľa
			for (int j = 0; j < distance; j++) {
				korytnacky[i].step(1);
			}
			// posun o zostávajúci desatinný zvyšok
			korytnacky[i].step(distanceResidue);
			// počet sekúnd ekvivalentných k počtu otočení a posunutí
			timer = distance + angle;
			// určenie najlepšieho času
			if (bestTime > timer) {
				bestTime = timer;
			}
		}
		return bestTime;
	}

	public int[] histogram(double x, double y, double d) {
		int[] areas = null;
		if (d > 0) {
			// určenie najvzdialenejšej korytnačky
			double farAway = korytnacky[0].distanceTo(x, y);
			for (int i = 0; i < korytnacky.length; i++) {
				if (farAway < korytnacky[i].distanceTo(x, y)) {
					farAway = korytnacky[i].distanceTo(x, y);
				}
			}
			// pole s dĺžkou závisejúcou od vzdialenosti najvzdialenejšej korytnačky a šírky
			// zóny
			areas = new int[((int) (farAway / d)) + 1];
			// pripočítanie jednej korytnačky na daný index poľa
			for (int i = 0; i < korytnacky.length; i++) {
				for (int j = 0; j < areas.length; j++) {
					if (korytnacky[i].distanceTo(x, y) >= d * j && korytnacky[i].distanceTo(x, y) < j * d + d) {
						areas[j] += 1;
					}
					// počet korytnačiek v poslednej zóne
					if (korytnacky[i].distanceTo(x, y) > d * korytnacky.length) {
						areas[korytnacky.length] += 1;
					}
				}
			}
		}
		return areas;
	}

	public void testHistogram(double x, double y, double d) {
		int[] p = this.histogram(x, y, d);
		System.out.print("histogram(" + x + ", " + y + ", " + d + "): ");
		System.out.println(Arrays.toString(p));
	}

	// nedokončené
	public void doStvorca(double dlzkaStrany) {
		int index = 0;

		for (int j = 0; j < (korytnacky.length / 4); j++) {
			korytnacky[index].setPosition(
					(150 + dlzkaStrany / (korytnacky.length / 4) * korytnacky.length) - dlzkaStrany / (korytnacky.length / 4) * j,
					(150 - dlzkaStrany / 2));
			index++;
		}

		for (int j = 0; j < (korytnacky.length / 4); j++) {
			korytnacky[index].setPosition((150 + dlzkaStrany / 2), (150) - dlzkaStrany / (korytnacky.length / 4) * j);
			index++;
		}

		for (int j = 0; j < (korytnacky.length / 4); j++) {
			korytnacky[index].setPosition((150) - dlzkaStrany / (korytnacky.length / 4) * j, (dlzkaStrany / 2 + 150));
			index++;
		}

		for (int j = 0; j < (korytnacky.length / 4); j++) {
			korytnacky[index].setPosition((150 - dlzkaStrany / 2), (150) - dlzkaStrany / (korytnacky.length / 4) * j);
			index++;
		}
	}

	// nedokončené
	public void prestrelka(int idxPrvehoStrelca, Color farbaStriel) {
		double farAway = 0;
		Point2D pos = korytnacky[0].getPosition();
		Point2D ogPos = korytnacky[0].getPosition();
		int index = 1;
		int i = 0;
		int[] dead = new int[korytnacky.length];

		while (i < korytnacky.length) {
			i = idxPrvehoStrelca;
			// získanie najbližšej korytnačky
			farAway = korytnacky[i].distanceTo(korytnacky[1].getPosition());
			for (int j = i + 1; j < korytnacky.length; j++) {
				if (korytnacky[i].distanceTo(korytnacky[j].getPosition()) < farAway) {
					farAway = korytnacky[i].distanceTo(korytnacky[j].getPosition());
					pos = korytnacky[j].getPosition();
					index = j;
				}
			}
			// overenie či už nebola zastrelená
			for (int j = 0; j < dead.length; j++) {
				if (index == dead[j]) {
					i++;
				}
			}
			// streľba
			ogPos = korytnacky[i].getPosition();
			korytnacky[i].turnTowards(pos);
			korytnacky[i].setPosition(pos);
			korytnacky[i].setPenColor(farbaStriel);
			korytnacky[i].moveTo(ogPos);
			// pridanie korytnačky do poľa zastrelených
			dead[i] += index;
			i = index;

		}
	}
}
