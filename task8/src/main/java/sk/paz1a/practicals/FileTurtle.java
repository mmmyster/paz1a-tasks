package sk.paz1a.practicals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import sk.upjs.jpaz2.Turtle;

public class FileTurtle extends Turtle {
	public boolean isWinner(String name, String resultsFilename) {
		// objakt triedy file s cestou nacitanou zo vstupu
		File file = new File(resultsFilename);
		// objekt triedy scanner na citanie riadkov
		Scanner reader = null;
		// objekt triedy scanner na citanie riadkov po slovach
		Scanner lineReader = null;
		int allVotes = 0;
		int votes = 0;
		int num = 0;
		boolean winner = false;
		boolean trueWinner = false;
		String nextString = "";
		// vsetky moznosti tvarov mena
		String upperName = name.toUpperCase();
		String lowerName = name.toLowerCase();
		String capitalize = lowerName.substring(0, 1).toUpperCase() + lowerName.substring(1);
		try {
			reader = new Scanner(file);
			while (reader.hasNextLine()) {
				// priradenie riadka do premennej
				String nextLine = reader.nextLine();
				// citanie daneho riadka
				lineReader = new Scanner(nextLine);
				while (lineReader.hasNext() || lineReader.hasNextInt()) {
					// pokial sa da nasledujuci token konvertovat na int ulozi sa do premennej a
					// pripocita k celkovemu poctu hlasov
					if (lineReader.hasNextInt()) {
						num = lineReader.nextInt();
						allVotes += num;
						// pokial token nemozno konvertovat na int je ulozeny do premennej ako string
					} else {
						nextString = lineReader.next();
					}
					// ak sa obsah premennej rovna jednemu z moznych tvarov mien hodnota trueWinner
					// sa nastavi na true
					if (nextString.equals(lowerName) || nextString.equals(upperName) || nextString.equals(capitalize)) {
						trueWinner = true;
					}
				}
				// ak sa v riadku nachadzalo meno dameho kandidata pripocita sa mu pocet hlasov
				// v riadku
				if (trueWinner) {
					votes += num;
					trueWinner = false;
				}
			}
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} finally {
			// ak mal dany kandidat nadpolovicnu vacsinu vyhral
			if (allVotes / 2 < votes) {
				winner = true;
			}
			// uzatvorenie scannerov
			if (lineReader != null) {
				lineReader.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
		return winner;
	}

	public String[] vycitanka(int n, int k, String priebeh) {
		File file = new File(priebeh);
		Scanner sc = null;
		int eliminatedIndex;
		int index = 0;
		// zoznam s poradim vypadnutia
		String[] eliminationOrder = new String[n];
		// zoznam s povodnym poradim
		String[] originalOrder = new String[n];
		try {
			sc = new Scanner(file);
			// nacitanie mien zo suboru do zoznamu
			while (sc.hasNext()) {
				eliminationOrder[index] = sc.next();
				index++;
			}

			index = 0;

			while (n > 0) {
				// vypocet indexu mena, ktore dane kolo vypadlo
				eliminatedIndex = (k - 1) % n;
				// pokial sa na indexe v zozname s povodnym usporiadanim uz niekto nachadza,
				// vyberie najblizsi volny index
				if (originalOrder[eliminatedIndex] != null) {
					for (int i = eliminatedIndex; i < originalOrder.length - eliminatedIndex + 1; i++) {
						if (originalOrder[i] == null) {
							originalOrder[i] = eliminationOrder[index];
							break;
						}
					}
					// postupne prechadzame zoznam s poradim vypadnutia a vkladame na vypocitane
					// indexy zoznamu s povodnym poradim
				} else {
					originalOrder[eliminatedIndex] = eliminationOrder[index];
				}
				// zmensujeme pocet mien po kazdom vlozeni
				n--;
				// zvacsujeme index
				index++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
		return originalOrder;
	}

	public void renameVariables(String inputFilename, String outputFilename) {
		File fromFile = new File(inputFilename);
		File toFile = new File(outputFilename);
		Scanner reader = null;
		Scanner lineReader = null;
		PrintWriter pw = null;
		String nextString = "";
		int index = 0;

		try {
			reader = new Scanner(fromFile);
			pw = new PrintWriter(toFile);

			while (reader.hasNextLine()) {
				String[] method = new String[0];
				method[index] = reader.nextLine();
				index++;
				String[] newMethod = new String[index];
				method = newMethod;
				System.out.println(Arrays.toString(method));
			}

			// priradenie riadka do premennej
			// String nextLine = reader.nextLine();
			// // citanie daneho riadka
			// lineReader = new Scanner(nextLine);
			// while (lineReader.hasNext()) {
			// nextString = lineReader.next();
			// if (nextString.equals("(")) {
			// while (!(lineReader.next()).equals(")")) {
			// System.out.println(lineReader.next());
			// }
			// }
			// for (int i = 0; i < nextString.length(); i++) {
			// if (nextString.charAt(i) == '(') {
			// method[index] = lineReader.next();
			// index++;
			// nextString = lineReader.next();
			// while (!(nextString.charAt(i) == ')')) {
			// method[index] = lineReader.next();
			// index++;
			// nextString = lineReader.next();
			// }
			// } else if (nextString.charAt(i) == ')') {
			// method[index] = nextString;
			// }
			// }

		} catch (FileNotFoundException e) {
			System.err.println("file not found");
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (pw != null) {
				pw.close();
			}
		}
	}
}
