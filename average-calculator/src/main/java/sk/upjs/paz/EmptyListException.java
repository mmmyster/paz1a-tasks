package sk.upjs.paz;

public class EmptyListException extends RuntimeException {
	public EmptyListException() {
		System.err.println("Vstupny zoznam je null alebo prazdny");
	}
}
