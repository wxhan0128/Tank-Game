package defaultComponents;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankRadar;

public class FirstLevelTankRadar extends TankRadar {

	public FirstLevelTankRadar(Tank tank) {
		super(tank);
		// TODO Auto-generated constructor stub
		this.splitX = width / 8;
		this.splitY = height / 6;
		this.radarRotate = Math.PI / 25;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x() - splitX, cp.y());
		radarPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - 2.7 * splitX, cp.y() + 0.7
				* splitY);
		radarPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() - 2.6 * splitX, cp.y() + 0.7
				* splitY);
		radarPoint.add(thirdPoint);
		Point2D fourPoint = new Point2D(cp.x() - splitX, cp.y() + 0.1 * splitY);
		radarPoint.add(fourPoint);
		Point2D fifthPoint = new Point2D(cp.x() + splitX, cp.y() + 0.1 * splitY);
		radarPoint.add(fifthPoint);
		Point2D sixPoint = new Point2D(cp.x() + 2.6 * splitX, cp.y() + 0.7
				* splitY);
		radarPoint.add(sixPoint);
		Point2D sevenPoint = new Point2D(cp.x() + 2.7 * splitX, cp.y() + 0.7
				* splitY);
		radarPoint.add(sevenPoint);
		Point2D eightPoint = new Point2D(cp.x() + splitX, cp.y());
		radarPoint.add(eightPoint);

		for (int i = 0; i < radarPoint.size(); i++) {
			this.rectangular_ps.add(radarPoint.get(i));
			this.polar_ps.add(super.recTopolar(rectangular_ps.get(i)));
		}
	}
}