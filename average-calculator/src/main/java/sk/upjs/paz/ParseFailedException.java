package sk.upjs.paz;

import java.util.List;

public class ParseFailedException extends Exception {
	public ParseFailedException() {
		System.err.println("Vstupny zoznam obsahuje neciselne prvky");
	}

	public ParseFailedException(List<String> notConvertable) {
		System.err.println("Vstupny zoznam obsahuje neciselne prvky");
		System.err.println(notConvertable);
	}
}
