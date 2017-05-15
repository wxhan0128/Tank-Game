package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction01;
import tankMotion.PlayerTankAction01;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest12 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hostBodyAngle = 0;
		int i = 0;

		Map newMap = new Map01(650, 650);
		newMap.createMap();
		cpDraw.drawStyle1();
		cpDraw.drawStyle2();

		PublicResource pr = new PublicResource();

		TankFactory hostTankBase = new DefaultTankFactory();
		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = hostTankBase.orderTank(2, "host", new Point2D(0, 0), 15,
				20, hostBodyAngle);
		HostTankAction01 hostTankAction = new HostTankAction01(pr, newMap);
		hostTankAction.tankReady(tank, 0, 10);

		while (true) {
			if (i >= 5) {
				if (pr.getTankResource().size() <= 5) {
					tank = robotTankBase.orderTank(
							2,
							"player",
							new Point2D(cpRandom.uniform(-90, 90), cpRandom
									.uniform(-90, 90)), 12, 16, cpRandom
									.uniform(-Math.PI / 2, Math.PI / 2));
					TankAction playerTankAction = new PlayerTankAction01(pr,
							newMap);
					playerTankAction.tankReady(tank, 20, 10);
				}
				i = 0;
			} else {
				i++;
			}

			cpDraw.show(1000);
			System.out.println(i);
		}
	}
}