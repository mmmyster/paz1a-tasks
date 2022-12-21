package sk.paz1a.practicals;

public class ZoznamBodov {

	private Bod[] list;

	public ZoznamBodov() {
		list = new Bod[0];
	}

	public int dlzka() {
		return list.length;
	}

	public void pridajBod(Bod bod) {
		Bod[] newList = new Bod[list.length + 1];
		System.arraycopy(list, 0, newList, 0, list.length);
		newList[newList.length - 1] = bod;
		list = newList;
	}

	public Bod dajBod(int index) {
		return list[index];
	}

	public void vymaz() {
		list = new Bod[0];
	}

	public double dlzkaSpojnic() {
		double lineLength = 0;
		for (int i = 1; i < list.length; i++) {
			lineLength += list[i - 1].vzdialenostK(list[i]);
		}
		lineLength += list[list.length - 1].vzdialenostK(list[0]);
		return lineLength;
	}

	public String toString() {
		return "[" + list.toString() + "]";
	}

	public void odoberBod(int index) {
		Bod[] newList = new Bod[list.length - 1];
		System.arraycopy(list, 0, newList, 0, index);
		System.arraycopy(list, index + 1, newList, index, list.length - 1 - index);
		list = newList;
	}
}
