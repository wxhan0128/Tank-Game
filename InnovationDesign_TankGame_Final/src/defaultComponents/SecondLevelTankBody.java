package defaultComponents;

import baseComponent.TankBody;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class SecondLevelTankBody extends TankBody {

	public SecondLevelTankBody(Point2D p, int width, int height) {
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
				/ 2);
		bodyPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() - width / 4, cp.y() + height
				/ 2);
		bodyPoint.add(thirdPoint);
		Point2D fourPoint = new Point2D(cp.x() - width / 4, cp.y() + height / 3);
		bodyPoint.add(fourPoint);
		Point2D fifthPoint = new Point2D(cp.x() + width / 4, cp.y() + height
				/ 3);
		bodyPoint.add(fifthPoint);
		Point2D sixPoint = new Point2D(cp.x() + width / 4, cp.y() + height / 2);
		bodyPoint.add(sixPoint);
		Point2D sevenPoint = new Point2D(cp.x() + width / 2, cp.y() + height
				/ 2);
		bodyPoint.add(sevenPoint);
		Point2D eightPoint = new Point2D(cp.x() + width / 2, cp.y() - height
				/ 2);
		bodyPoint.add(eightPoint);
		Point2D ninePoint = new Point2D(cp.x() + width / 4, cp.y() - height / 2);
		bodyPoint.add(ninePoint);
		Point2D tenPoint = new Point2D(cp.x() + width / 4, cp.y() - height / 3);
		bodyPoint.add(tenPoint);
		Point2D elevenPoint = new Point2D(cp.x() - width / 4, cp.y() - height
				/ 3);
		bodyPoint.add(elevenPoint);
		Point2D twelvePoint = new Point2D(cp.x() - width / 4, cp.y() - height
				/ 2);
		bodyPoint.add(twelvePoint);

		for (int i = 0; i < bodyPoint.size(); i++) {
			this.rectangular_ps.add(bodyPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}
	}
}