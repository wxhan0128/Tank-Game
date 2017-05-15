package tankCenter;

import tankModel.FirstLevelTank;
import tankModel.SecondLevelTank;
import tankModel.Tank;
import tankModel.ThirdLevelTank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class DefaultTankFactory extends TankFactory {

	@Override
	public Tank createTank(int type, String flag, Point2D p, int width,
			int height, double bodyAngle) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			return new FirstLevelTank(flag, p, width, height, bodyAngle);
		case 2:
			return new SecondLevelTank(flag, p, width, height, bodyAngle);
		case 3:
			return new ThirdLevelTank(flag, p, width, height, bodyAngle);
		default:
			return new FirstLevelTank(flag, p, width, height, bodyAngle);
		}
	}
}
