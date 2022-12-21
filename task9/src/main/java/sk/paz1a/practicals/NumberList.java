package sk.paz1a.practicals;

import java.util.Arrays;

/**
 *  * Trieda realizujuca dynamicke pole (zoznam) cisel.
 *  
 */
public class NumberList {
	private int[] numberList;

	/**
	 * Konstruktor zoznamu cisel - vytvori prazdny zoznam
	 */
	public NumberList() {
		numberList = new int[0];
	}

	/**
	 * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA pola
	 *
	 * @param numbers pole, podla ktoreho sa ma inicializovat zoznam cisel
	 */
	public NumberList(int[] numbers) {
		numberList = new int[numbers.length];
		System.arraycopy(numbers, 0, numberList, 0, numbers.length);
	}

	/**
	 * Konstruktor zoznamu cisel, pricom zoznam sa inicializuje hodnotami PODLA
	 * ineho zoznamu
	 *
	 * @param numberList zoznam, podla ktoreho sa ma inicializovat zoznam cisel
	 */
	public NumberList(NumberList numberList) {
		this.numberList = new int[numberList.size()];
		for (int i = 0; i < numberList.size(); i++) {
			this.numberList[i] = numberList.get(i);
		}
	}

	/**
	 * Vrati cislo aktualne ulozene na zadanom indexe v zozname
	 *
	 * @param index index prvku zoznamu, ktoreho hodnotu chceme vratit
	 * @return cislo na zadanom indexe v zozname
	 */
	public int get(int index) {
		return numberList[index];
	}

	/**
	 * Nastavi hodnotu prvku zoznamu na zadanom (uz existujucom) indexe
	 *
	 * @param index index prvku
	 * @param value nova hodnota pre prvom na zadanom indexe
	 */
	public void set(int index, int value) {
		numberList[index] = value;
	}

	/**
	 * Prida na koniec zoznamu novy prvok so zadanou hodnotou
	 *
	 * @param value hodnota prvku pridaneho na koniec zoznamu
	 */
	public void add(int value) {
		// metoda vytvori nove pole o jedno vacsie ako povodne,
		// skopiruje povodne prvky a prida novy
		// stare pole nahradime novovytvorenym
		int[] extendedList = new int[numberList.length + 1];
		System.arraycopy(numberList, 0, extendedList, 0, numberList.length);
		extendedList[numberList.length] = value;
		numberList = extendedList;
	}

	/**
	 * Vrati aktualny pocet prvkov v zozname cisel
	 *
	 * @return pocet prvkov v zozname cisel
	 */
	public int size() {
		return numberList.length;
	}

	/**
	 * Vyprazdni zoznam
	 */
	public void clear() {
		numberList = new int[0];
	}

	/**
	 * Odstrani zo zoznamu prvok na zadanom indexe a vrati hodnotu odstraneneho
	 * prvku
	 *
	 * @param index index odstranovaneho prvku v zozname
	 * @return hodnota odstranovaneho prvku v zozname
	 */
	public int remove(int index) {
		// metoda vytvori nove, o jedna kratsie pole,
		// skopriruje cast povodneho pola po dany prvok a cast pola od daneho prvku
		// prvok si ulozime do premennej, ktoru vraciame a pole cisel nahradime
		int deleted = numberList[index];
		int[] shortenList = new int[numberList.length - 1];
		System.arraycopy(numberList, 0, shortenList, 0, index);
		System.arraycopy(numberList, index + 1, shortenList, index, numberList.length - 1 - index);
		numberList = shortenList;
		return deleted;
	}

	/**
	 * Vrati obsah zoznamu vo forme formatovaneho retazca [prvok1, prvok2, prvok3,
	 * prvok4]
	 */
	@Override
	public String toString() {
		return Arrays.toString(numberList);
	}
}
