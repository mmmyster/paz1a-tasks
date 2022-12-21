package sk.paz1a.practicals;

import java.util.*;

public class ZoznamOdberov {
	/**
	 * List reprezentujuci zoznam odberov
	 */
	private List odbery;

	/**
	 * Konstruktor zoznamu odberov vytvori prazdny ArrayList
	 */
	public ZoznamOdberov() {
		odbery = new ArrayList();
	}

	/**
	 * Pridavanie odberu do list-u
	 *
	 * @param o
	 */
	public void pridaj(Odber o) {
		odbery.add(o);
	}

	/**
	 * Metoda vrati, kolko odberov sa vykonalo na odbernom mieste zdanom parametrom
	 *
	 * @param odberneMiesto cislo odberneho miesta
	 * @return pocet odberov, ktore sa vykonali na odbernom mieste odberneMiesto
	 */
	public int pocetOdberovNaMieste(int odberneMiesto) {
		List<Odber> list = new ArrayList<Odber>(odbery);
		int count = 0;
		// prechadzame zoznamom a pokial sa miesto odberu rovna inputu pripocitame jedna
		// k pocitadlu
		for (Odber odber : list) {
			if (odber.getOdberneMiesto() == odberneMiesto) {
				count++;
			}
		}
		return count;
	}

	/**
	 * Metoda vrati zoznam mien pozitivne testovanych. Mena sa nenachadzaju na
	 * zozname dupliticne
	 *
	 * @return zoznam mien pozitivne testovanych, bez duplicit
	 */
	public List pozitivneTestovani() {
		Set<Odber> setOfTests = new HashSet<Odber>(odbery);
		List<String> listOfPositives = new ArrayList<String>();
		// prechadzame mnozinou a pokial sa vysledok odberu rovna true,
		// pridame meno testovaneho do zoznamu
		for (Odber odber : setOfTests) {
			if (odber.getVysledok()) {
				listOfPositives.add(odber.getMenoZamestnanca());
			}
		}
		return listOfPositives;
	}

	/**
	 * Metoda vrati priemerny pocet testovanych za den testovania.
	 * Ak testujeme v pondelok 30.11. a piatok 4.12., tak sú to dva dni,
	 * pocas ktorych sa testovalo.
	 *
	 * @return priemerny pocet testovanych za den testovania
	 */
	public double priemernyPocetTestovZaDenTestovania() {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		List<String> days = new ArrayList<>();
		// prechadzame zoznamom odberov a ak zoznam dni uz den neobsahuje, prida ho
		for (Odber odber : listOfTests) {
			if (!days.contains(odber.getDatumOdberu())) {
				days.add(odber.getDatumOdberu());
			}
		}
		// vratime podiel dlzky zoznamu odberov a dlzky zoznamu dni
		return (double) listOfTests.size() / (double) days.size();
	}

	/**
	 * Metoda vrati zoznam mien vsetkych testovanych, ktori sa zucastnili odberu v
	 * rozmedzi datumov. Mena sa nenachadzaju na zozname dupliticne
	 *
	 * @param odDatum datum zaciatku, vratane tohto datumu
	 * @param doDatum datum konca, vratane tohto datumu
	 * @return mena testovanych v rozmedzi datumov
	 */
	public List testovaniOdDo(String odDatum, String doDatum) {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		List<String> testedInRange = new ArrayList<String>();
		String[] odDatumArray = odDatum.split("\\.");
		String[] doDatumArray = doDatum.split("\\.");
		String odDatumInt = "";
		String doDatumInt = "";
		String datumOdberuInt = "";
		// prechadzame polom a pred den a mesiac pokial maju iba jednu cifru pridame
		// nulu
		// datum rozdelime podla delimetru "." a odzadu pridame do premennej
		for (int i = odDatumArray.length - 1; i >= 0; i--) {
			if (odDatumArray[1].length() == 1 || odDatumArray[0].length() == 1) {
				odDatumInt += "0";
				odDatumInt += odDatumArray[i];
			} else {
				odDatumInt += odDatumArray[i];
			}
		}
		for (int i = doDatumArray.length - 1; i >= 0; i--) {
			if (doDatumArray[i].length() == 1) {
				doDatumInt += "0";
				doDatumInt += doDatumArray[i];
			} else {
				doDatumInt += doDatumArray[i];
			}
		}
		// prechadzame zoznamom odberov a rovnakym sposobom zapisujeme datum
		for (Odber odber : listOfTests) {
			String[] datumOdberuArray = odber.getDatumOdberu().split("\\.");
			for (int i = datumOdberuArray.length - 1; i >= 0; i--) {
				if (datumOdberuArray[i].length() == 1) {
					datumOdberuInt += "0";
					datumOdberuInt += datumOdberuArray[i];
				} else {
					datumOdberuInt += datumOdberuArray[i];
				}
			}
			// ak je datum v rozmedzi, do zoznamu pridame meno zamestnanca, ktory sa v ten
			// den testoval
			if (Integer.parseInt(odDatumInt) <= Integer.parseInt(datumOdberuInt) && Integer
					.parseInt(datumOdberuInt) <= Integer.parseInt(doDatumInt)) {
				testedInRange.add(odber.getMenoZamestnanca());
			}
			datumOdberuInt = "";
		}
		return testedInRange;
	}

	/**
	 * Metoda vrati mapu, kde je kazdemu menu priradene kolko testov absolvoval
	 *
	 * @return mapa osob a ich poctu absolvovanych testov
	 */
	public Map pocetTestovOsoby() {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		Map<String, Integer> testsPerPerson = new HashMap<>();
		// prechadzame zoznamom odberov, do mapy pridame meno zamestnanca
		// a pocet testov, ktory sa zvysuje vzdy, ked sa meno objavi znova
		for (Odber odber : listOfTests) {
			// pri prvom zapise musime ako value nastavit jednotku aby sa k nej dalo dalej
			// pripocitavat
			if (testsPerPerson.get(odber.getMenoZamestnanca()) == null) {
				testsPerPerson.put(odber.getMenoZamestnanca(), 1);
			} else {
				testsPerPerson.put(odber.getMenoZamestnanca(), testsPerPerson.get(odber.getMenoZamestnanca()) + 1);
			}
		}
		return testsPerPerson;
	}

	/**
	 * Metoda vrati zoznam mien pozitivne testovanych, ktori mali aspon 2 pozitivne
	 * testy. Mena sa nenachadzaju na zozname dupliticne.
	 *
	 * @return zoznam mien tych, ktori boli pozitivne testovani aspon dvakrat, bez
	 *         duplicity mien
	 */
	public List opakovanePozitivny() {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		List<String> repeatedlyPositive = new ArrayList<>();
		Map<String, Integer> testsPerPerson = new HashMap<>(pocetTestovOsoby());
		// prechadzame zoznamom odberov a ak bol vysledok negativny, z map (obsahuje
		// rovnake udaje ako ta z metody pocetTestovOsoby())
		// odratame test
		for (Odber odber : listOfTests) {
			if (!odber.getVysledok()) {
				testsPerPerson.put(odber.getMenoZamestnanca(), testsPerPerson.get(odber.getMenoZamestnanca()) - 1);
			}
		}
		// prechadzame entry hodnotami v map a pokial je value vascia rovna 2,
		// cize pozitivne testy mal clovek aspon dva (lebo negativne sme odratali)
		// do zoznamu pridame meno tejto osoby
		Set<Map.Entry<String, Integer>> entrySet = testsPerPerson.entrySet();
		for (Map.Entry<String, Integer> entry : entrySet) {
			if (entry.getValue() >= 2) {
				repeatedlyPositive.add(entry.getKey());
			}
		}
		return repeatedlyPositive;
	}

	/**
	 * Metoda vrati, ci zamestnanec prekonal nakazu. To znamena, ze mal pozitivny
	 * test v nejaky den a negativny neskor.
	 *
	 * @param menoZamestnanca
	 * @return
	 */
	public boolean prekonalNakazu(String menoZamestnanca) {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		String positive = "";
		String negative = "";
		int maxPositive = 0;
		int maxNegative = 0;
		// prechadzame zoznamom odberov (uz zase)
		for (Odber odber : listOfTests) {
			// hladame data konkretneho zamestnanca
			if (menoZamestnanca.equals(odber.getMenoZamestnanca())) {
				String positiveInt = "";
				String negativeInt = "";
				// ak bol vysledok pozitivny, datum odberu dame do tvaru ako v metode
				// testovaniOdDo
				if (odber.getVysledok()) {
					positive = odber.getDatumOdberu();
					String[] positiveSplitted = positive.split("\\.");
					for (int i = positiveSplitted.length - 1; i >= 0; i--) {
						if (positiveSplitted[1].length() == 1 || positiveSplitted[0].length() == 1) {
							positiveInt += "0";
							positiveInt += positiveSplitted[i];
						} else {
							positiveInt += positiveSplitted[i];
						}
					}
					// aby sme ziskali najaktualnejsi datum, porovnavame ich a nechavame najvacsi
					if (Integer.parseInt(positiveInt) > maxPositive) {
						maxPositive = Integer.parseInt(positiveInt);
					}
				} else {
					// rovnako ako pri pozitivnom vysledku ibaze tentokrat s negativnym
					negative = odber.getDatumOdberu();
					String[] negativeSplitted = negative.split("\\.");
					for (int i = negativeSplitted.length - 1; i >= 0; i--) {
						if (negativeSplitted[1].length() == 1 || negativeSplitted[0].length() == 1) {
							negativeInt += "0";
							negativeInt += negativeSplitted[i];
						} else {
							negativeInt += negativeSplitted[i];
						}
					}
					// najvacsi datum
					if (Integer.parseInt(negativeInt) > maxNegative) {
						maxNegative = Integer.parseInt(negativeInt);
					}
				}
			}
		}
		// pokial je datum pozitivneho testu nizsi, cize bol skor, metoda vrati true
		if (maxPositive < maxNegative) {
			return true;
		}
		return false;
	}

	/**
	 * Metoda vrati zoznam tych mien z vyberu zamestnancov, ktori este neabsolvovali
	 * ziaden odber.
	 *
	 * @param vyberZamestnancov
	 * @return novy zoznam vytvoreny zo zoznamu vyberZamestancov, bez zamestancov,
	 *         ktori uz absolvovali odber
	 */
	public List bezOdberu(List vyberZamestnancov) {
		List<String> notTested = new ArrayList<String>(vyberZamestnancov);
		Set<String> keySet = pocetTestovOsoby().keySet();
		Set<String> toRemove = new HashSet<>();
		// prechadzame zoznamom a pokial sa v nasej mape s testami zamestnanec nachadza
		// pridame ich do zoznamu na dodstranenie
		for (String string : notTested) {
			if (keySet.contains(string)) {
				toRemove.add(string);
			}
		}
		// vsetky prvky vyskytujuce sa aj v zozname na odstranenie
		// z finalneho zoznamu odstranime
		notTested.removeAll(toRemove);
		return notTested;
	}

	/**
	 * Metoda vrati zoznam mien zamestnancov, ktori mali pocas toho isteho dna
	 * pozitivny aj negativny test. Mena sa nenachadzaju na zozname dupliticne.
	 *
	 * @return zoznam mien tych, ktori pocas jedneho dna mali pozitivny aj negativny
	 *         test
	 */
	public List podozrivoTestovani() {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		List<String> suspicious = new ArrayList<>();
		List<Odber> positive = new ArrayList<>();
		List<Odber> negative = new ArrayList<>();
		// roztriedime odbery podla vysledku do dvoch zoznamov
		for (Odber odber : listOfTests) {
			if (odber.getVysledok()) {
				positive.add(odber);
			} else {
				negative.add(odber);
			}
		}
		// pokial sa meno a datum prisluchajuce odberu s pozitivnym vysledkom rovna tomu
		// s negativnym, pridame danu osobu na zoznam podozrivych, mozno uplatok
		for (Odber odberNeg : negative) {
			for (Odber odberPos : positive) {
				if (odberNeg.getMenoZamestnanca().equals(odberPos.getMenoZamestnanca())
						&& odberNeg.getDatumOdberu().equals(odberPos.getDatumOdberu())) {
					suspicious.add(odberNeg.getMenoZamestnanca());
				}
			}
		}
		return suspicious;
	}

	/**
	 * Metoda vrati cislo odberneho miesta, kde sa vykonalo najviac odberov. Ak je
	 * takychto pracovisk viac, tak vrati ktorekolvek z nich.
	 *
	 * @return cislo pracoviska, ktore vykonalo najviac odberov
	 */
	public int najvytazenejsiePracovisko() {
		List<Odber> listOfTests = new ArrayList<Odber>(odbery);
		Map<Integer, Integer> hardWorking = new HashMap<>();
		// do mapy pridame cislo pracoviska a pocet odberov vypocitanych v metode
		// pocetOdberovNaMieste
		for (Odber odber : listOfTests) {
			hardWorking.put(odber.getOdberneMiesto(), pocetOdberovNaMieste(odber.getOdberneMiesto()));
		}
		int max = Integer.MIN_VALUE;
		int hardestWorking = 0;
		// prechadzame entry hodnotami v mape a porovnavame
		// kluc, cize cislo pracoviska s najvyssim klucom potom vraciame
		for (Map.Entry<Integer, Integer> entry : hardWorking.entrySet()) {
			if (entry.getValue() > max) {
				max = entry.getValue();
				hardestWorking = entry.getKey();
			}
		}
		return hardestWorking;
	}
}
