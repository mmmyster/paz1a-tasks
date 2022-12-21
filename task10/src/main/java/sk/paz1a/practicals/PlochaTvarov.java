// package sk.paz1a.practicals;

// import java.awt.Color;

// import java.awt.event.MouseEvent;

// import sk.upjs.jpaz2.WinPane;

// public class PlochaTvarov extends WinPane {

// private ZoznamTvarov tvary;

// private double dragX;
// private double dragY;
// private boolean tahanie = false;

// public PlochaTvarov() {
// this.tvary = new ZoznamTvarov();
// }

// @Override
// protected void onMouseClicked(int x, int y, MouseEvent detail) {
// if (detail.getButton() == MouseEvent.BUTTON1) {
// if (detail.isAltDown()) {
// this.tvary.pridajTvar(new Kruh(50, 150, 30, Color.PINK));
// } else {
// this.tvary.pridajTvar(new Obdlznik(100, 50, 40, 20, Color.CYAN));
// }
// }

// if (detail.getButton() == MouseEvent.BUTTON3) {
// Tvar naOdstranenie = this.tvary.bodTvaru(x, y);
// if (naOdstranenie != null) {
// this.tvary.odstranTvar(naOdstranenie);
// }
// }

// this.clear();
// this.tvary.nakresliVsetky(this);
// }

// @Override
// protected void onMousePressed(int x, int y, MouseEvent detail) {
// if (detail.getButton() == MouseEvent.BUTTON1) {
// this.tahanie = true;
// this.dragX = x;
// this.dragY = y;
// }
// }

// @Override
// protected void onMouseDragged(int x, int y, MouseEvent detail) {
// if (this.tahanie) {
// tvary.posun(x - this.dragX, y - this.dragY);
// this.dragX = x;
// this.dragY = y;
// this.clear();
// this.tvary.nakresliVsetky(this);
// }
// }

// @Override
// protected void onMouseReleased(int x, int y, MouseEvent detail) {
// if (detail.getButton() == MouseEvent.BUTTON1) {
// this.tahanie = false;
// }
// }
// }