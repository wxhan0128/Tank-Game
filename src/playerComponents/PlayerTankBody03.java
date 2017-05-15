package playerComponents;

import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBody;

public class PlayerTankBody03 extends TankBody {

	public PlayerTankBody03(Point2D p, int width, int height) {
		super(p, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x() - width / 2, cp.y() - height
				/ 2);
		bodyPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - width / 2, cp.y() + height
				/ 6);
		bodyPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() - width / 4, cp.y() + height
				/ 2.5);
		bodyPoint.add(thirdPoint);
		Point2D fourthPoint = new Point2D(cp.x(), cp.y() + height / 2);
		bodyPoint.add(fourthPoint);
		Point2D fifthPoint = new Point2D(cp.x() + width / 4, cp.y() + height
				/ 2.5);
		bodyPoint.add(fifthPoint);
		Point2D sixPoint = new Point2D(cp.x() + width / 2, cp.y() + height / 6);
		bodyPoint.add(sixPoint);
		Point2D sevenPoint = new Point2D(cp.x() + width / 2, cp.y() - height
				/ 2);
		bodyPoint.add(sevenPoint);

		for (int i = 0; i < bodyPoint.size(); i++) {
			this.rectangular_ps.add(bodyPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}
	}
}
