package sk.paz1a.practicals;

import java.io.*;
import java.util.*;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// Bod k = new Bod(6, 4);
		// Bod l = new Bod(3, 5);
		// Bod m = new Bod(2, 1);

		// ZoznamBodov list = new ZoznamBodov();
		// list.pridajBod(k);
		// list.pridajBod(l);
		// list.pridajBod(m);
		// System.out.println(list.dlzkaSpojnic());

		// System.out.println(list.dajBod(0));

		int[] numbers = new int[] { 2, 1, 3, 8 };
		// Vypise: [4, 6, 2, 1, 3, 8]
		System.out.println(Arrays.toString(numbers));

		NumberList z1 = new NumberList(numbers);
		z1.set(1, 8);
		// Vypise: [4, 8, 2, 1, 3, 8]
		System.out.println(z1.toString());

		// Vypise: [4, 6, 2, 1, 3, 8], t.j. pole sa nezmenilo
		System.out.println(Arrays.toString(numbers));

		NumberList z2 = new NumberList(z1);
		// Vypise: [4, 8, 2, 1, 3, 8]
		System.out.println(z1.toString());
		// Vypise: [4, 8, 2, 1, 3, 8]
		System.out.println(z2.toString());

		z2.set(1, 10);

		// Vypise: [4, 8, 2, 1, 3, 8]
		System.out.println(z1.toString());
		// Vypise: [4, 10, 2, 1, 3, 8]
		System.out.println(z2.toString());
	}

}