package sk.paz1a.practicals;

import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// put your code here
		Poliarka wendy = new Poliarka();
		int[] pole = { 0, -1, 1, 1, 997, 8564, 564, 564, 32, 879 };
		System.out.println(Arrays.toString(pole));

		PrepinaciaHra hra = new PrepinaciaHra();
		hra.tah(0, 1);

	}
}