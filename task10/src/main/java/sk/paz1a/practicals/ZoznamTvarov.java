package sk.paz1a.practicals;

import sk.upjs.jpaz2.Pane;

public class ZoznamTvarov {
	private Tvar[] tvary;

	public ZoznamTvarov() {
		super();

		tvary = new Tvar[0];
	}

	public void pridajTvar(Tvar t) {
		Tvar[] tvaryExtended = new Tvar[tvary.length + 1];
		System.arraycopy(tvary, 0, tvaryExtended, 0, tvary.length);
		tvaryExtended[tvary.length] = t;
		tvary = tvaryExtended;
	}

	public void nakresliVsetky(Pane plocha) {
		for (int i = 0; i < tvary.length; i++) {
			tvary[i].vykresliSa(plocha);
		}
	}

	public void posun(double dx, double dy) {
		for (int i = 0; i < tvary.length; i++) {
			tvary[i].posun(dx, dy);
			tvary[i].posun(dx, dy);
		}
	}

	public Tvar bodTvaru(double x, double y) {
		for (int i = 0; i < tvary.length; i++) {
			if (tvary[i].jeVnutornyBod(x, y)) {
				return tvary[i];
			}
		}
		return null;
	}

	public void odstranTvar(Tvar t) {
		int index = 0;
		for (int i = 0; i < tvary.length; i++) {
			if (t == tvary[i]) {
				index = i;
			}
		}
		Tvar[] tvarySchrinked = new Tvar[tvary.length - 1];
		System.arraycopy(tvary, 0, tvarySchrinked, index, tvary.length);
		System.arraycopy(tvary, index + 1, tvarySchrinked, index, tvarySchrinked.length - index);
		tvary = tvarySchrinked;
	}
}
