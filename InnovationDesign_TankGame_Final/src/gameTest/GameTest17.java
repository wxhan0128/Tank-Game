package gameTest;

import geography.Map;
import geography.Map01;

import java.awt.Color;

import resource.PublicResource;
import tankCenter.CustomizeTankFactory;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction08;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest17 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory robotTankBase = new DefaultTankFactory();
		TankFactory playerTankBase = new CustomizeTankFactory();

		Tank tank = robotTankBase.orderTank(1, "player1", new Point2D(-10, 90),
				12, 16, Math.PI);
		tank.paint(Color.BLUE);
		TankAction playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(1, "player1", new Point2D(10, 90), 12,
				16, Math.PI);
		tank.paint(Color.BLUE);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(2, "player2", new Point2D(-10, -90), 12,
				16, 0);
		tank.paint(Color.BLACK);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(2, "player2", new Point2D(10, -90), 12,
				16, 0);
		tank.paint(Color.BLACK);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = playerTankBase.orderTank(1, "player3", new Point2D(-90, 10), 12,
				16, Math.PI / 2);
		tank.paint(Color.RED);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = playerTankBase.orderTank(1, "player3", new Point2D(-90, -10),
				12, 16, Math.PI / 2);
		tank.paint(Color.RED);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = playerTankBase.orderTank(2, "player4", new Point2D(90, 10), 12,
				16, -Math.PI / 2);
		tank.paint(Color.CYAN);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = playerTankBase.orderTank(2, "player4", new Point2D(90, -10), 12,
				16, -Math.PI / 2);
		tank.paint(Color.CYAN);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}