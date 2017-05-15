package baseComponent;

import java.awt.Color;
import java.util.ArrayList;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankBloodbar extends TankPolygon {
	protected ArrayList<Point2D> barPoint = new ArrayList<Point2D>();
	protected double barLength = 15, hight = 1;

	protected double length = 0;

	private double split = 0;
	protected Point2D np = new Point2D(0, 0);

	private Color color = Color.GREEN;

	public TankBloodbar(Tank tank) {
		this.cp.setx(tank.getTankBody().cp.x());
		this.cp.sety(tank.getTankBody().cp.y());

		this.width = tank.getTankBody().width;
		this.height = tank.getTankBody().height;

		this.length = tank.newbarLength;
		this.split = tank.getTankBody().height / 6;

		np = new Point2D(tank.getTankBody().cp.x(), tank.getTankBody().cp.y()
				- 5.5 * split);
	}

	public abstract void create();

	public void move(Point2D p) {
		this.cp.setx(p.x());
		this.cp.sety(p.y());

		for (int i = 0; i < rectangular_ps.size(); i++) {
			rectangular_ps.set(i, polarTorec(polar_ps.get(i)));
		}
	}

	public double getBarLength() {
		return this.barLength;
	}

	public void filledPolygon() {
		synchronized (TankPolygon.lock) {
			if (length <= 0.75 * barLength) {
				color = Color.YELLOW;
			}
			if (length <= 0.25 * barLength) {
				color = Color.RED;
			}

			cpDraw.setPenColor(color);
			cpDraw.setPenRadius(pensize);
			cpDraw.FilledPolygon(this.rectangular_ps);
		}
	}

	public void fillErase() {
		synchronized (TankPolygon.lock) {
			cpDraw.setPenColor(Color.white);
			cpDraw.setPenRadius(erasesize);
			cpDraw.FilledPolygon(this.rectangular_ps);
			cpDraw.Polygon(rectangular_ps);
		}
	}
}