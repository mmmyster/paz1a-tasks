package sk.paz1a.practicals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.annotation.processing.FilerException;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// List<Integer> list = new ArrayList<Integer>();
		// double average = 0;

		// while (sc.hasNext()) {
		// String read = sc.next();
		// int num = 0;
		// try {
		// num = Integer.parseInt(read);
		// if (num < 0) {
		// break;
		// } else {
		// list.add(num);
		// average += num;
		// }
		// } catch (Exception e) {
		// System.err.println("not number i guess");
		// }
		// }
		// average /= list.size();
		// Collections.sort(list);
		// for (Integer integer : list) {
		// if (integer >= average) {
		// list.remove(integer);
		// }
		// }
		// System.out.println(list);

		File file = new File(
				"/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task11/file.txt");

		SpolocnePrednasky obj = new SpolocnePrednasky();
		System.err.println(obj.prednasky(file));

		Odber o = new Odber("Korry", "1.11.2020", 3, false);
		Odber oz = new Odber("Korry", "1.11.2020", 3, true);
		Odber oy = new Odber("Korry", "1.11.2020", 3, false);
		Odber ox = new Odber("Korry", "2.11.2020", 3, false);
		Odber oa = new Odber("Korry", "1.11.2020", 3, false);
		ZoznamOdberov list = new ZoznamOdberov();
		List<String> ogList = new ArrayList<>();
		ogList.add("Johnny");
		ogList.add("JohnnyB");
		ogList.add("Korry");
		list.pridaj(o);
		list.pridaj(oz);
		list.pridaj(oy);
		list.pridaj(ox);
		list.pridaj(oa);
		System.out.println(list.prekonalNakazu("Korry"));
	}
}