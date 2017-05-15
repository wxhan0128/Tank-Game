package baseComponent;

import java.util.ArrayList;

import resource.PublicResource;
import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankRadar extends TankPolygon {
	protected ArrayList<Point2D> radarPoint = new ArrayList<Point2D>();
	protected double splitX = 0, splitY = 0;
	protected double radarRotate = 0;

	private ArrayList<Tank> temp_tank_list = new ArrayList<Tank>();

	public TankRadar(Tank tank) {
		// TODO Auto-generated method stub
		this.cp.setx(tank.getTankBody().cp.x());
		this.cp.sety(tank.getTankBody().cp.y());

		this.width = tank.getTankBody().width;
		this.height = tank.getTankBody().height;
	}

	public abstract void create();

	public boolean detect(Tank tank, PublicResource pr, Point2D position,
			double detectlength) {
		double templength = 0;
		boolean findEnemy = false;

		for (int i = 0; i < pr.getTankResource().size(); i++) {
			if (tank != pr.getTankResource().get(i)
					&& !tank.getArmy().equals(
							pr.getTankResource().get(i).getArmy())) {
				templength = Math.sqrt(Math.pow(position.x()
						- pr.getTankResource().get(i).getTankBody().cp.x(), 2)
						+ Math.pow(
								position.y()
										- pr.getTankResource().get(i)
												.getTankBody().cp.y(), 2));
				if (templength <= detectlength) {
					findEnemy = true;
				}
			}
		}
		return findEnemy;
	}

	public Tank nearestTank(Tank tank, PublicResource pr, Point2D position) {
		this.temp_tank_list.clear();
		Tank ntank = null;
		double distance = 1000;
		int index = 0;

		for (int i = 0; i < pr.getTankResource().size(); i++) {
			if (tank != pr.getTankResource().get(i))
				if (!tank.getArmy().equals(
						pr.getTankResource().get(i).getArmy())) {
					ntank = pr.getTankResource().get(i);
					temp_tank_list.add(ntank);
					double dis = Math.sqrt(Math.pow(ntank.getTankBody().cp.x()
							- position.x(), 2)
							+ Math.pow(
									ntank.getTankBody().cp.y() - position.y(),
									2));
					if (dis < distance) {
						distance = dis;
						index = temp_tank_list.size() - 1;
					}
				}
		}

		if (temp_tank_list.size() > 0) {
			ntank = null;
			ntank = temp_tank_list.get(index);
		}
		return ntank;
	}

	public double getRadarRotate() {
		return this.radarRotate;
	}
}