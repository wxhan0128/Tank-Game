package gameTest;

import geography.Map;
import geography.Map01;

import java.awt.Color;

import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction02;
import tankMotion.RobotTankAction02;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest18 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double hostBodyAngle = 0;

		Map newMap = new Map01();
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory hostTankBase = new DefaultTankFactory();
		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = hostTankBase.orderTank(3, "host", new Point2D(0, 0), 15,
				20, hostBodyAngle);
		tank.paint(Color.BLUE);
		TankAction hostTankAction = new HostTankAction02(pr, newMap);
		hostTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(3, "robot1", new Point2D(90, 90), 12,
				16, cpRandom.uniform(-Math.PI / 2, Math.PI / 2));
		TankAction robotTankAction = new RobotTankAction02(pr, newMap);
		robotTankAction.tankReady(tank, 20, 0);

		tank = robotTankBase.orderTank(3, "robot1", new Point2D(-90, 90), 12,
				16, cpRandom.uniform(-Math.PI / 2, Math.PI / 2));
		robotTankAction = new RobotTankAction02(pr, newMap);
		robotTankAction.tankReady(tank, 20, 0);

		tank = robotTankBase.orderTank(3, "robot2", new Point2D(-90, -90), 12,
				16, cpRandom.uniform(-Math.PI / 2, Math.PI / 2));
		robotTankAction = new RobotTankAction02(pr, newMap);
		robotTankAction.tankReady(tank, 20, 0);

		tank = robotTankBase.orderTank(3, "robot2", new Point2D(90, -90), 12,
				16, cpRandom.uniform(-Math.PI / 2, Math.PI / 2));
		robotTankAction = new RobotTankAction02(pr, newMap);
		robotTankAction.tankReady(tank, 20, 0);
	}
}