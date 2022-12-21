package sk.paz1a.practicals;

import sk.upjs.jpaz2.Turtle;

public class HomeTurtle extends Turtle {
	public String toEmailAddress(String name) {
		String email = ""; // prázdny string
		name = name.toLowerCase(); // zmeníme všetky písmená na malé

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) == ' ') {
				char space = name.charAt(i); // vloženie znaku medzery do premennej
				space = '.'; // nahradenie medzery bodkov
				email += space; // pridanie bodky do stringu
			} else {
				email += name.charAt(i); // pridanie ostatných znakov do stringu
			}
		}
		return email + "@upjs.sk"; // vrátenie stringu
	}

	public int countAcronyms(String r) {
		int sum = 0; // premenná na počítanie skratiek
		int i = 2; // premenná slúžiaca na reguláciu počtu cyklov
		int count = 0; // premenná na počítanie troch veľkých písmen nasledujúcich po sebe

		while (i < r.length()) {
			// overenie či sú prvý druhý a tretí znak nasledujúce po sebe veľké písmená
			boolean third = r.charAt(i) >= 'A' && r.charAt(i) <= 'Z';
			boolean second = r.charAt(i - 1) >= 'A' && r.charAt(i - 1) <= 'Z';
			boolean first = r.charAt(i - 2) >= 'A' && r.charAt(i - 2) <= 'Z';
			// ak áno, zväčšeníme hodnotu počítadla o jedna
			if (first && second && third) {
				count++;
				// ak sa v stringu nachádzajú aspoň tri veľké po sebe idúce písmená, k počtu
				// skratiek pripočítame jedna
				if (count == 1) {
					sum++;
				}
				// ak nasledujú znaky nepatriace k skratke, počítadlo sa vynuluje
			} else {
				count = 0;
			}
			i++; // po vykonaní cyklu zvýšime premennú o jedna
		}
		return sum; // vrátenie výsledného počtu skratiek
	}

	public String sanitize(String s) {
		String nonDuplicaString = ""; // prázdny string
		int i = 1; // premenná slúžiaca na reguláciu počtu cyklov

		// pokiaľ má string dĺžku 1, obsah stringu sa zapíše do nového, ktorý vraciame
		if (i == s.length()) {
			nonDuplicaString = s;
		}

		while (i < s.length()) {
			// ak znak nie je rovnaký ako po ňom nasledujúci, zapíše sa do stringu
			if (s.charAt(i - 1) != s.charAt(i)) {
				nonDuplicaString += s.charAt(i - 1);
			}
			// osobitne pripíšeme posledný znak
			if (i == s.length() - 1) {
				nonDuplicaString += s.charAt(i);
			}
			i++; // po vykonaní cyklu zvýšime premennú o jedna
		}
		return nonDuplicaString; // vrátenie výsledného stringu
	}

	public String charsToEntities(String s) {
		String entities = ""; // prázdny string

		for (int i = 0; i < s.length(); i++) {
			boolean lower = s.charAt(i) >= 'a' && s.charAt(i) <= 'z'; // overenie či znak patrí medzi malé písmená
			boolean upper = s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'; // overenie či znak patrí medzi veľké písmená
			boolean numbers = s.charAt(i) >= '0' && s.charAt(i) <= '9'; // overenie či znak patrí medzi čísla

			// ak znak nepatrí ani medzi malé veľké písmená a ani medzi čísla, do stringu
			// pridáme kód tohto znaku v UNICODE spolu so sprievodnými znakmi
			if (!(lower || upper || numbers)) {
				entities = entities + "&#" + (int) (s.charAt(i)) + ";";
				// ak nie, pridáme do stringu znak bez úprav
			} else {
				entities += s.charAt(i);
			}
		}
		return entities; // vrátenie výsledného stringu
	}

	public String entitiesToChars(String s) {
		String chars = ""; // prázdny string
		for (int i = 0; i < s.length(); i++) {
			// ak je daný znak &, posunieme sa o jedna aby sme sa dostali k číslam, ktoré
			// prevedieme na znak, až po ; a následne sa znova posunieme o jedna
			if (s.charAt(i) == '&') {
				i++;
				String num = "";
				while (s.charAt(i + 1) != ';') {
					i++;
					num += s.charAt(i);
				}
				int c = Integer.parseInt(num);
				chars = chars + (char) c;
				i++;
				// ostatné znaky pridáme do stringu
			} else {
				chars += s.charAt(i);
			}
		}
		return chars; // vrátenie výsledného stringu
	}
}
