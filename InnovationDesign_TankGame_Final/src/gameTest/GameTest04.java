package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.HostTankAction01;
import tankMotion.PlayerTankAction02;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest04 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory hostTankBase = new DefaultTankFactory();
		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = hostTankBase.orderTank(2, "host", new Point2D(0, 0), 15,
				20, 0);
		HostTankAction01 hostTankAction = new HostTankAction01(pr, newMap);
		hostTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(
				2,
				"player",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		TankAction playerTankAction = new PlayerTankAction02(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}