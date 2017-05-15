package playerComponents;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankCannonTower;

public class PlayerTankCannonTower01 extends TankCannonTower {

	public PlayerTankCannonTower01(Tank tank) {
		super(tank);
		// TODO Auto-generated constructor stub
		this.splitX = width / 4;
		this.splitY = height / 5;

		this.towerRotate = Math.PI / 25;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x() - splitX, cp.y() - splitY);
		towerPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - splitX, cp.y() + splitY);
		towerPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() - 0.3 * splitX, cp.y() + splitY);
		towerPoint.add(thirdPoint);
		Point2D fourthPoint = new Point2D(cp.x() - 0.3 * splitX, cp.y() + 4
				* splitY);
		towerPoint.add(fourthPoint);
		Point2D fifthPoint = new Point2D(cp.x() + 0.3 * splitX, cp.y() + 4
				* splitY);
		towerPoint.add(fifthPoint);
		Point2D sixPoint = new Point2D(cp.x() + 0.3 * splitX, cp.y() + splitY);
		towerPoint.add(sixPoint);
		Point2D sevenPoint = new Point2D(cp.x() + splitX, cp.y() + splitY);
		towerPoint.add(sevenPoint);
		Point2D eightPoint = new Point2D(cp.x() + splitX, cp.y() - splitY);
		towerPoint.add(eightPoint);

		for (int i = 0; i < towerPoint.size(); i++) {
			this.rectangular_ps.add(towerPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}
	}

}
