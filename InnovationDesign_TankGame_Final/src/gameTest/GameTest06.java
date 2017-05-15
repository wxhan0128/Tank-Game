package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction01;
import tankMotion.PlayerTankAction01;
import tankMotion.PlayerTankAction02;
import tankMotion.PlayerTankAction03;
import tankMotion.RobotTankAction01;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest06 {

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
		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = hostTankBase.orderTank(2, "host", new Point2D(0, 0), 15,
				20, hostBodyAngle);
		HostTankAction01 hostTankAction = new HostTankAction01(pr, newMap);
		hostTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(2, "player", new Point2D(90, 90), 12,
				16, cpRandom.uniform(-Math.PI / 2, Math.PI / 2));
		TankAction playerTankAction = new RobotTankAction01(pr, newMap);
		playerTankAction.tankReady(tank, 20, 0);

		tank = robotTankBase.orderTank(2, "player", new Point2D(-90, 90), 12,
				16, 0);
		playerTankAction = new PlayerTankAction01(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(2, "player", new Point2D(-90, -90), 12,
				16, cpRandom.uniform(-Math.PI, Math.PI));
		playerTankAction = new PlayerTankAction02(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(2, "player", new Point2D(90, -90), 12,
				16, 0);
		playerTankAction = new PlayerTankAction03(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}