package sk.upjs.paz;

import java.util.ArrayList;
import java.util.List;

public class Utils {
	public static double average(List<Double> zoznam) {
		if (zoznam == null || zoznam.size() == 0) {
			throw new EmptyListException();
		}
		double sum = 0;
		for (Double number : zoznam) {
			sum += number;
		}
		return sum / zoznam.size();
	}

	public static List<Double> parseNumbers(String[] array) throws ParseFailedException {
		List<Double> list = new ArrayList<>();
		List<String> notConvertable = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			try {
				list.add(Double.parseDouble(array[i]));
			} catch (NumberFormatException e) {
				notConvertable.add(array[i]);
			}
		}
		if (notConvertable.size() > 0) {
			throw new ParseFailedException();
		}
		return list;
	}
}
