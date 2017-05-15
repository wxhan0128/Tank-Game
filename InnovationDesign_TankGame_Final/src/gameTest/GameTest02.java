package gameTest;

import geography.Map;
import geography.Map01;

import java.awt.Color;

import resource.PublicResource;
import tankCenter.DefaultTankFactory;
import tankCenter.TankFactory;
import tankModel.Tank;
import tankMotion.PlayerTankAction01;
import tankMotion.TankAction;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public class GameTest02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map newMap = new Map01(650, 650);
		newMap.createMap();

		PublicResource pr = new PublicResource();
		TankFactory robotTankBase = new DefaultTankFactory();

		Tank tank = robotTankBase.orderTank(2, "player", new Point2D(90, -90),
				12, 16, 0);
		tank.paint(Color.MAGENTA);
		TankAction playerTankAction = new PlayerTankAction01(pr, newMap);
		playerTankAction.tankReady(tank, 0, 10);
	}
}