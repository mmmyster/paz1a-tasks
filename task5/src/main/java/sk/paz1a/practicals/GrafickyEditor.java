package sk.paz1a.practicals;

import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;

import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

public class GrafickyEditor extends WinPane {
	private Turtle pen;
	private boolean pressed;

	public GrafickyEditor() {
		this.pen = new Turtle();
		this.add(this.pen);
	}

	@Override
	protected void onMouseClicked(int x, int y, MouseEvent detail) {
		super.onMouseClicked(x, y, detail);
	}

	@Override
	protected void onMouseMoved(int x, int y, MouseEvent detail) {
		Point2D startPosition = pen.getPosition();
		pen.turnTowards(x, y);
		pen.moveTo(x, y);
		pen.setPosition(startPosition);
	}

	@Override
	protected void onMousePressed(int x, int y, MouseEvent detail) {
		if (detail.getButton() == MouseEvent.BUTTON1) {
			pressed = true;
		} else {
			pressed = false;
		}
	}

	@Override
	protected void onMouseDragged(int x, int y, MouseEvent detail) {
		if (pressed) {
			pen.moveTo(x, y);
		}
	}

	@Override
	protected void onMouseReleased(int x, int y, MouseEvent detail) {
		if (pressed = true) {
			pressed = false;
		}
	}

}
