package baseComponent;

import java.awt.Color;
import java.util.ArrayList;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.Geometry.geom.Coordinate;
import Ynu.Sei.cpLibrary.Geometry.geom.GeometryFactory;
import Ynu.Sei.cpLibrary.Geometry.geom.Polygon;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class TankPolygon {
	protected int width = 0, height = 0;
	public Point2D cp = new Point2D(0, 0);

	protected ArrayList<Point2D> rectangular_ps = new ArrayList<Point2D>();
	protected ArrayList<Point2D> polar_ps = new ArrayList<Point2D>();

	protected double pensize = 0.002, erasesize = 0.005;
	private Color color = Color.BLACK;
	public static Object lock = new Object();

	/**
	 * Returns a correctly polar point of a {@code Point2D} value transformed by
	 * a rectangular point
	 * 
	 * @param pp
	 *            a polar point
	 * @return p a rectangular point
	 */
	protected Point2D polarTorec(Point2D pp) {
		double x = this.cp.x() + pp.x() * Math.cos(pp.y());
		double y = this.cp.y() + pp.x() * Math.sin(pp.y());
		Point2D p = new Point2D(x, y);
		return p;
	}

	/**
	 * Returns a correctly rectangular point of a {@code Point2D} value
	 * transformed by a polar point
	 * 
	 * @param rp
	 *            a rectangular point
	 * @return p a polar point
	 */
	protected Point2D recTopolar(Point2D rp) {
		double radius = Math.sqrt(Math.pow(rp.x() - this.cp.x(), 2)
				+ Math.pow(rp.y() - this.cp.y(), 2));
		double theta = Math.atan2(rp.y() - this.cp.y(), rp.x() - this.cp.x());
		Point2D p = new Point2D(radius, theta);
		return p;
	}

	/**
	 * translate all rectangular points to a new position,refresh the
	 * rectangular point and the polar point
	 * 
	 * @param x
	 * @param y
	 */
	public void translate(double x, double y) {
		cp.setx(cp.x() + x);
		cp.sety(cp.y() + y);

		for (int i = 0; i < rectangular_ps.size(); i++) {
			this.rectangular_ps.get(i).setx(this.rectangular_ps.get(i).x() + x);
			this.rectangular_ps.get(i).sety(this.rectangular_ps.get(i).y() + y);
			this.polar_ps.set(i, recTopolar(rectangular_ps.get(i)));
		}
	}

	/**
	 * tank's all components rotate an angle,change the polar_ps and
	 * rectangular_ps
	 * 
	 * @param theta
	 * 
	 * */
	public void rotate(double theta) {
		for (int i = 0; i < this.polar_ps.size(); i++) {
			this.polar_ps.set(i, new Point2D(this.polar_ps.get(i).x(),
					this.polar_ps.get(i).y() + theta));
		}

		for (int i = 0; i < this.rectangular_ps.size(); i++) {
			this.rectangular_ps.set(i, polarTorec(this.polar_ps.get(i)));
		}
	}

	public Polygon rgpToPoly() {
		GeometryFactory factory = new GeometryFactory();
		Coordinate[] cs = new Coordinate[this.rectangular_ps.size() + 1];
		for (int i = 0; i < cs.length - 1; i++) {
			cs[i] = new Coordinate(this.rectangular_ps.get(i).x(),
					this.rectangular_ps.get(i).y());
		}
		cs[cs.length - 1] = new Coordinate(this.rectangular_ps.get(0).x(),
				this.rectangular_ps.get(0).y());
		return new Polygon(factory.createLinearRing(cs), null, factory);
	}

	public boolean intersection(TankPolygon rpg) {
		return this.rgpToPoly().intersects(rpg.rgpToPoly());
	}

	public void draw() {
		synchronized (lock) {
			cpDraw.setPenColor(this.color);
			cpDraw.setPenRadius(pensize);
			cpDraw.Polygon(this.rectangular_ps);
		}
	}

	public void filledPolygon() {
		synchronized (lock) {
			cpDraw.setPenColor(Color.BLACK);
			cpDraw.setPenRadius(pensize);
			cpDraw.FilledPolygon(this.rectangular_ps);
		}
	}

	public void erase() {
		synchronized (lock) {
			cpDraw.setPenColor(Color.WHITE);
			cpDraw.setPenRadius(erasesize);
			cpDraw.Polygon(this.rectangular_ps);
		}
	}

	public void fillErase() {
		synchronized (lock) {
			cpDraw.setPenColor(Color.white);
			cpDraw.setPenRadius(erasesize);
			cpDraw.FilledPolygon(this.rectangular_ps);
			cpDraw.Polygon(rectangular_ps);
		}
	}

	public void setArmyColor(Color c) {
		this.color = c;
	}
}