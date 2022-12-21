package sk.paz1a.practicals;

import java.awt.Color;

import sk.upjs.jpaz2.*;

public class Launcher {

	public static void main(String[] args) {
		// put your code here
		GrafickyEditor go = new GrafickyEditor();
		Korytnackovo kor = new Korytnackovo();
		ObjectInspector oi = new ObjectInspector();
		oi.inspect(oi);

		KorytnaciSvet world = new KorytnaciSvet();
		world.vystrelNaTazisko();
		oi.inspect(world);

	}
}