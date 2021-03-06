package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.CustomizeTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction04;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest09 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory robotTankBase = new CustomizeTankFactory();

		Tank tank = robotTankBase.orderTank(
				2,
				"player",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, 0);
		TankAction playerTankAction = new PlayerTankAction04(pr, newMap);
		playerTankAction.tankReady(tank, 0, 5);
	}
}