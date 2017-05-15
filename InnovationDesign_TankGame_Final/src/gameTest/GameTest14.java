package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction06;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest14 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory robotTankBase = new DefaultTankFactory();
		Tank tank = null;
		TankAction playerTankAction = null;

		while (true) {
			tank = robotTankBase.orderTank(2, "player", new Point2D(-90, 0),
					12, 16, Math.PI / 2);
			playerTankAction = new PlayerTankAction06(pr, newMap);
			playerTankAction.tankReady(tank, 25, 0);

			cpDraw.show(1000);
		}
	}
}