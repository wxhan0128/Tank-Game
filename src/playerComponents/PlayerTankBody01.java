package playerComponents;

import baseComponent.TankBody;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class PlayerTankBody01 extends TankBody {

	public PlayerTankBody01(Point2D p, int width, int height) {
		super(p, width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x(), cp.y() + height / 2);
		bodyPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - 0.6 * width
				* Math.cos(Math.PI / 6), cp.y() - height / 2
				* Math.sin(Math.PI / 6));
		bodyPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() + 0.6 * width
				* Math.cos(Math.PI / 6), cp.y() - height / 2
				* Math.sin(Math.PI / 6));
		bodyPoint.add(thirdPoint);

		for (int i = 0; i < bodyPoint.size(); i++) {
			this.rectangular_ps.add(bodyPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}
	}
}
