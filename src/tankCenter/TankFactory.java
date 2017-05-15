package tankCenter;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankFactory {

	public Tank orderTank(int type, String flag, Point2D p, int width,
			int height, double bodyAngle) {
		Tank tank;

		tank = createTank(type, flag, p, width, height, bodyAngle);

		return tank;
	}

	protected abstract Tank createTank(int type, String flag, Point2D p,
			int width, int height, double bodyAngle);
}
