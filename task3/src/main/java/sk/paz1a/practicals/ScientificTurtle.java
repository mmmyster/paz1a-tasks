package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

public class ScientificTurtle extends Turtle {

	public double min(double cislo1, double cislo2) {
		if (cislo1 > cislo2) {
			return cislo1;
		} else {
			return cislo2;
		}
	}

	public long power(int n, int k) {
		long num = n;
		for (int i = 0; i < k - 1; i++) {
			num *= n;
		}
		if (k == 0) {
			num = 1;
		}
		return num;
	}

	public long factorial(int n) {
		int i = n;
		long num = 1;

		while (i > 0) {
			num *= i;
			i--;
		}
		return num;
	}

	public int countDivisors(int n) {
		int i = 1;
		int num = 0;
		while (i <= n) {
			if (n % i == 0) {
				num++;
			}
			i++;
		}
		return num;
	}

	public int countDigits(int n) {
		int num = 0;
		while (n > 0) {
			n /= 10;
			num++;
		}
		return num;
	}

	public boolean isPrime(int n) {
		int i = 1;
		int num = 0;
		boolean prime = false;
		while (i <= n) {
			if (n % i == 0) {
				num++;
			}
			i++;
		}
		if (num == 2) {
			prime = true;
		}
		return prime;
	}

	public boolean containsDigit(byte c, int n) {
		boolean contains = false;
		for (int i = 0; i <= n; i++) {
			if (n % 10 == c) {
				contains = true;
			} else {
				n /= 10;
			}
		}
		return contains;
	}

	public boolean hasNonincreasingDigits(int n) {
		boolean increase = true;
		int i = 0;
		while (i < n) {
			int num = n % 10;
			int newNum = n % 10;
			if (newNum < num) {
				increase = false;
				break;
			} else {
				increase = true;
			}
			n /= 10;
			i++;
			System.out.println(num);
			System.out.println(newNum);
		}
		return increase;
	}

	// public int gcd(int a, int b) {

	// }

	// public int lcm(int a, int b) {

	// }
	// }
}
