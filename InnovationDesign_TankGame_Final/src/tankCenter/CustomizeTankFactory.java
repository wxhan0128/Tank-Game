package tankCenter;

import tankModel.PlayerTank01;
import tankModel.PlayerTank02;
import tankModel.PlayerTank03;
import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class CustomizeTankFactory extends TankFactory {

	@Override
	public Tank createTank(int type, String flag, Point2D p, int width,
			int height, double bodyAngle) {
		// TODO Auto-generated method stub
		switch (type) {
		case 1:
			return new PlayerTank01(flag, p, width, height, bodyAngle);
		case 2:
			return new PlayerTank02(flag, p, width, height, bodyAngle);
		case 3:
			return new PlayerTank03(flag, p, width, height, bodyAngle);
		default:
			return new PlayerTank01(flag, p, width, height, bodyAngle);
		}
	}
}
