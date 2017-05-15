package defaultComponents;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;

public class FirstStyleBloodbar extends TankBloodbar {

	public FirstStyleBloodbar(Tank tank) {
		super(tank);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x() - length / 2, cp.y() - hight
				/ 2);
		barPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - length / 2, cp.y() + hight
				/ 2);
		barPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() + length / 2, cp.y() + hight
				/ 2);
		barPoint.add(thirdPoint);
		Point2D fourPoint = new Point2D(cp.x() + length / 2, cp.y() - hight / 2);
		barPoint.add(fourPoint);

		for (int i = 0; i < barPoint.size(); i++) {
			this.rectangular_ps.add(barPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}

		move(new Point2D(np.x(), np.y()));
	}
}