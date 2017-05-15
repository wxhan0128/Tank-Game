package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.CustomizeTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction02;
import tankMotion.PlayerTankAction04;
import tankMotion.PlayerTankAction07;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory tankBase = new CustomizeTankFactory();

		Tank tank = tankBase.orderTank(2, "player1", new Point2D(0, 0), 12, 16,
				0);
		TankAction playerTankAction = new PlayerTankAction04(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = tankBase
				.orderTank(1, "player2", new Point2D(-90, 90), 12, 16, 0);
		playerTankAction = new PlayerTankAction07(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = tankBase.orderTank(
				1,
				"player2",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		playerTankAction = new PlayerTankAction02(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}