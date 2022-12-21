package sk.paz1a.practicals;

public class FrequencyTable {

	private String[][] table;

	/**
	 * Konstruktor: vytvori prazdnu frekvencnu tabulku
	 */
	public FrequencyTable() {
		table = new String[0][0];
	}

	/**
	 * Vyprazdni obsah tabulky (vratene vlozenych slov)
	 */
	public void clear() {
		table = new String[0][0];
	}

	/**
	 * Vrati pocet vyskytov slova. V pripade, ze sa slovo v tabulke nenachadza,
	 * vrati 0
	 *
	 * @param word
	 *             retazec, ktoreho pocet vyskytov chceme zistit
	 * @return pocet vyskytov zadaneho slova (retazca)
	 */
	public int getNumberOfOccurrences(String word) {
		// metoda vrati prvok 2d pola pri hladanom slove
		for (int i = 0; i < table.length; i++) {
			if (table[i][0].equals(word)) {
				return Integer.parseInt(table[i][1]);
			}
		}
		return 0;
	}

	/**
	 * Poznaci novy vyskyt slova vo frekvencnej tabulke (zvysi pocitadlo
	 * priradene danemu slovu o 1). Ak take slovo sa v tabulke nenachadza,
	 * nastavi pocet jeho vyskytov na 1
	 *
	 * @param word
	 *             slovo, ktoreho vyskyt chceme poznacit vo frekvencnej tabulke
	 */
	public void addOccurrence(String word) {
		boolean contains = false;
		if (getWordCount() == 0) {
			// vytvori 2d pole a prida slovo a pocet vyskytov do prveho riadka
			table = new String[1][2];
			table[0][0] = word;
			table[0][1] = "1";
		} else {
			// pokial sa slovo v tabulke nachadza, zvacsi pocet vyskytov
			for (int i = 0; i < table.length; i++) {
				if (table[i][0].equals(word)) {
					contains = true;
					table[i][1] = Integer.toString(Integer.parseInt(table[i][1]) + 1);
				}
			}
			// pokial sa slovo v tabulke nenachadza, vytvorime novu tabulku s rovnakym
			// povodnym obsahom
			// a novym riadkom so slovom a poctom vyskytov
			if (!contains) {
				String[][] newTable = new String[table.length + 1][2];
				System.arraycopy(table, 0, newTable, 0, table.length);
				newTable[table.length][0] = word;
				newTable[table.length][1] = "1";
				table = newTable;
			}
		}
	}

	/**
	 * Vrati pocet slov vo frekvencnej tabulke (vsetky maju nenulovy pocet vyskytov)
	 *
	 * @return pocet slov vo frekvencnej tabulke
	 */
	public int getWordCount() {
		return table.length;
	}

	/**
	 * Vrati slova vo frekvencnej tabulke v novovytvorenom poli retazcov
	 *
	 * @return referencia na novovytvorene pole retazcov so slovami v tabulke
	 */
	public String[] getWords() {
		// metoda prida do noveho pola prvy stlpec tabulky
		String[] words = new String[getWordCount()];
		for (int i = 0; i < table.length; i++) {
			words[i] = table[i][0];
		}
		return words;
	}

	/**
	 * Vrati obsah frekvencnej tabulky ako retazec vo formate
	 * [slovo1=pocetVyskytov1, slovo2=pocetVyskytov2]
	 */
	public String toString() {
		String stringTable;
		if (getWordCount() != 0) {
			stringTable = "[";
			for (int i = 0; i < table.length - 1; i++) {
				stringTable += table[i][0] + "=" + table[i][1] + ", ";
			}
			stringTable += table[table.length - 1][0] + "=" + table[table.length - 1][1] + "]";
		} else {
			// pokial je tabulka prazdna, vrati prazdne pole
			stringTable = "[]";
		}
		return stringTable;
	}
}
