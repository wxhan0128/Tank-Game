package gameTest;

import geography.Map;
import geography.Map01;

import java.awt.Color;

import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction08;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.BASIC.cpRandom;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest16 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();

		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = robotTankBase.orderTank(
				2,
				"player1",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		tank.paint(Color.BLUE);
		TankAction playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(
				2,
				"player1",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		tank.paint(Color.BLUE);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(
				2,
				"player2",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		tank.paint(Color.RED);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);

		tank = robotTankBase.orderTank(
				2,
				"player2",
				new Point2D(cpRandom.uniform(-90, 90), cpRandom
						.uniform(-90, 90)), 12, 16, cpRandom.uniform(-Math.PI,
						Math.PI));
		tank.paint(Color.RED);
		playerTankAction = new PlayerTankAction08(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}