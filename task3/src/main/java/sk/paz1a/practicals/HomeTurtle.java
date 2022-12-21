package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

import java.awt.Color;

public class HomeTurtle extends Turtle {
	public void squardot(double size) {
		// uloženie počiatočných súradníc do premenných
		double startX = this.getX();
		double startY = this.getY();

		// vytvorenie nových objektov triedy Color
		Color lightGray = new Color(192, 192, 192);
		Color darkGray = new Color(128, 128, 128);

		while (size > 1) { // nekreslíme pod jeden pixel
			// vykreslenie kruhu
			this.setFillColor(lightGray);
			this.dot(size / 2);

			// postavenie na pozíciu, z ktorej ideme kresliť štvorec
			this.setFillColor(darkGray);
			this.penUp();
			this.turn(45);
			this.step(-size / 2);
			this.turn(-45);

			// výpočet strany štvorca pomocou pytagorovej vety
			size = Math.sqrt(Math.pow((size / 2), 2) * 2);
			this.openPolygon();

			// vykreslenie štvorca
			for (int i = 0; i < 4; i++) {
				this.step(size);
				this.turn(90);
			}
			this.closePolygon();

			// návrat na počiatočnú pozíciu
			this.setPosition(startX, startY);
		}
	}

	public int divergence(double c) {
		double n = 1;
		double sum = 0;

		// cyklus bude prebiehať kým c bude väčšie ako súčet A(n), čiže sa zastaví keď
		// bude A(n) väčšie alebo rovné c
		while (sum < c) {
			// zapezpečený číselný rád zväčšujúci sa o jedna
			n++;

			// ak je číslo párne 1 / n
			// ak nepárne (n - 1) / n
			if (n % 2 == 0) {
				sum += 1 / n;
			} else {
				sum += (n - 1) / n;
			}
		}
		// pretypovanie n na int, ako je zadané pri definovaní metódy
		return (int) n;
	}

	public boolean isUniDigitNumber(int n) {
		boolean same = true;
		n = Math.abs(n); // absolútna hodnota n
		int n1 = n; // číslo n vložíme do premennej n1, aby sme ho mohli požiť aj pri výpočte počtu
								// cifier
		int sum = 0; // počet cifier
		int num = 0; // cifra na pozícii k
		int newNum = n % 10; // cifra na pozícii k + 1

		// počet cifier
		while (n1 > 0) {
			n1 /= 10;
			sum++;
		}

		// cyklus sa opakuje toľkokrát, koľko má číslo cifier
		for (int i = 0; i < sum; i++) {
			// vloženie cifry do premennej num a jej odpočítanie od n
			num = n % 10;
			n /= 10;

			// vloženie nasledujúcej cifry do premennej newNum
			newNum = n % 10;

			// ak sa cifra rovná po nej nasledujúcej, cyklus pokračuje a hodnota premennej
			// same je true, ak nie, hodnota same je false a cyklus skončí
			if (num == newNum || (num == 0 || newNum == 0)) {
				same = true;
			} else {
				same = false;
				break;
			}
		}
		return same;
	}

	public int countHammingDistance(int number1, int number2) {
		int count = 0;
		int num1 = 0;
		int num2 = 0;

		while (number1 > 0 || number2 > 0) {
			// vloženie cifier prvého a druhého čísla do premenných a následné
			// odstránenie cifier z čísel
			num1 = number1 % 10;
			num2 = number2 % 10;
			number1 /= 10;
			number2 /= 10;

			// ak sa cifra na danej pozícii prvého čísla nerovná cifre na tej istej
			// pozícii druhého, k premennej count sa pripočíta jedontka
			if (num1 != num2) {
				count++;
			}
		}
		return count;
	}
}
