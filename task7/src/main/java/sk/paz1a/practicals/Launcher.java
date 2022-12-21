package sk.paz1a.practicals;

import java.io.File;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// put your code here
		SmartTurtle jeffrey = new SmartTurtle();
		TurtleCommander albert = new TurtleCommander();
		File folder = new File("/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/ZLI");
		// File file = new File(
		// "/Users/jakub/Library/CloudStorage/OneDrive-Personal/School/UPJŠ/1-rocnik/ZS/PAZ1a/task7/file.txt");
		// albert.generateUnicodeFile(file, 65, 68);

		ObjectInspector oi = new ObjectInspector();

		ClickPane pain = new ClickPane();
		oi.inspect(pain);

	}
}