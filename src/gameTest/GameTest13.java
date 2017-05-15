package gameTest;

import geography.Map;
import geography.Map01;
import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction05;
import tankMotion.PlayerTankAction06;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest13 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = -90;
		double y = -90;

		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory robotTankBase = new DefaultTankFactory();
		Tank tank = null;
		TankAction playerTankAction = null;

		for (int i = 0; i < 3; i++) {
			tank = robotTankBase.orderTank(2, "player1", new Point2D(0, y), 12,
					16, 0);
			playerTankAction = new PlayerTankAction05(pr, newMap);
			playerTankAction.tankReady(tank, 0, 10);
			y = y + 20;
		}

		for (int i = 0; i < 3; i++) {
			tank = robotTankBase.orderTank(2, "player2", new Point2D(x, 0), 12,
					16, Math.PI / 2);
			playerTankAction = new PlayerTankAction06(pr, newMap);
			playerTankAction.tankReady(tank, 0, 10);
			x = x + 20;
		}
	}
}