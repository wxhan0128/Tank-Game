package baseComponent;

import java.util.ArrayList;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankCannonTower extends TankPolygon {
	protected ArrayList<Point2D> towerPoint = new ArrayList<Point2D>();
	protected double splitX = 0, splitY = 0;

	protected double towerRotate = 0;

	public TankCannonTower(Tank tank) {
		this.cp.setx(tank.getTankBody().cp.x());
		this.cp.sety(tank.getTankBody().cp.y());

		this.width = tank.getTankBody().width;
		this.height = tank.getTankBody().height;
	}

	public abstract void create();

	public double getTowerRotate() {
		return this.towerRotate;
	}
}
