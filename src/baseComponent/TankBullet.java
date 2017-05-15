package baseComponent;

import java.util.ArrayList;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankBullet extends TankPolygon {
	protected ArrayList<Point2D> bulletPoint = new ArrayList<Point2D>();
	protected double theta = 0;

	protected Point2D np = new Point2D(0, 0);
	private double split = 0;

	private boolean value = true;

	protected double damage = 0;
	protected int no = 0;

	public TankBullet(Tank tank, double angle) {
		this.cp.setx(tank.getTankBody().cp.x());
		this.cp.sety(tank.getTankBody().cp.y());

		this.width = tank.getTankBody().width;
		this.height = tank.getTankBody().height;

		this.theta = angle;
		this.split = height / 6;

		this.np = new Point2D(tank.getTankBody().cp.x() + 5.5 * split
				* Math.sin(theta), tank.getTankBody().cp.y() + 5.5 * split
				* Math.cos(theta));
	}

	public void setBulletNumber(int n) {
		this.no = n;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	public boolean getValue() {
		return this.value;
	}

	public abstract void create();

	public double getDamage() {
		return this.damage;
	}
}
