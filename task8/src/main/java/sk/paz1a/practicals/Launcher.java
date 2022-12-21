package sk.paz1a.practicals;

import java.io.File;
import java.util.Arrays;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		File file = new File(
				"/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task8/fileWithNumbers.txt");

		TextTurtle jeffrey = new TextTurtle();
		jeffrey.average(file);

		FileTurtle albert = new FileTurtle();
		// System.out.println(Arrays.toString(albert.vycitanka(4, 5,

		// "/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task8/file.txt")));
		// }
		albert.renameVariables(
				"/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task8/file.txt",
				"/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task8/fileOutput.txt");
	}
}