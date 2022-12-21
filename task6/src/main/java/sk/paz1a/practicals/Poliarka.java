package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

public class Poliarka extends Turtle {
	public double priemer(int[] pole) {
		double average = 0;
		for (int i = 0; i < pole.length; i++) {
			average += pole[i];
		}
		return average / pole.length;
	}

	public int pocetOpakovani(int[] pole, int cislo) {
		int sum = 0;
		for (int i = 0; i < pole.length; i++) {
			if (cislo == pole[i]) {
				sum++;
			}
		}
		return sum;
	}

	public int[] zdvojPole(int[] pole) {
		int[] doubleArray = new int[pole.length * 2];
		for (int i = 1; i < pole.length; i++) {
			doubleArray[i * 2] = pole[i];
			doubleArray[i * 2 + 1] = pole[i];
		}
		return doubleArray;
	}

	public boolean jeNeklesajuce(int[] pole) {
		boolean increase = false;
		for (int i = 1; i < pole.length; i++) {
			if (pole[i - 1] <= pole[i]) {
				increase = true;
			} else {
				increase = false;
				break;
			}
		}
		return increase;
	}
}
