package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction02;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest07 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hostBodyAngle = 0;

		Map newMap = new Map01(650, 650);
		newMap.createMap();
		// cpDraw.drawStyle1();
		// cpDraw.drawStyle2();

		PublicResource pr = new PublicResource();

		TankFactory hostTankBase = new DefaultTankFactory();

		Tank tank = hostTankBase.orderTank(3, "host", new Point2D(0, 0), 15,
				20, hostBodyAngle);
		HostTankAction02 hostTankAction = new HostTankAction02(pr, newMap);
		hostTankAction.tankReady(tank, 0, 10);
	}
}