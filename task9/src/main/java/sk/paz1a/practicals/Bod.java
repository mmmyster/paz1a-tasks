package sk.paz1a.practicals;

public class Bod {
	private double x;
	private double y;

	public Bod(double x, double y) {
		this.setX(x);
		this.y = y;
	}

	public Bod() {

	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getX() {
		return x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getY() {
		return y;
	}

	public boolean rovnakeSuradnice(Bod bod) {
		if (this.getX() == bod.getX() && this.getY() == bod.getY()) {
			return true;
		}
		return false;
	}

	public double vzdialenostK(double x, double y) {
		double a = this.x - x;
		double b = this.y - y;
		double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

		return c;
	}

	public double vzdialenostK(Bod bod) {
		return vzdialenostK(bod.getX(), bod.getY());
	}
}
