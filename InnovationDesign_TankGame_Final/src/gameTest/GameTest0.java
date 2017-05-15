package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction01;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest0 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hostBodyAngle = 0;

		Map newMap = new Map01();
		newMap.createMap();
		// cpDraw.drawStyle1();
		// cpDraw.drawStyle2();

		PublicResource pr = new PublicResource();

		TankFactory hostTankBase = new DefaultTankFactory();
		Tank hostTank = hostTankBase.orderTank(2, "player", new Point2D(0, 0),
				15, 20, hostBodyAngle);
		TankAction hostTankAction = new HostTankAction01(pr, newMap);
		hostTankAction.tankReady(hostTank, 0, 10);
	}
}