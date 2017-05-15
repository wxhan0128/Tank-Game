package resource;

import java.util.ArrayList;

import tankModel.Tank;
import baseComponent.TankBullet;

public class PublicResource {
	private ArrayList<Tank> totalTank = new ArrayList<Tank>();
	private ArrayList<TankBullet> totalHostBullet = new ArrayList<TankBullet>();
	private ArrayList<TankBullet> totalRobotBullet = new ArrayList<TankBullet>();

	public void setTankResource(Tank tank) {
		totalTank.add(tank);
	}

	public void setHostBulletsResource(TankBullet bullet) {
		totalHostBullet.add(bullet);
	}

	public void setRobotBulletsResource(TankBullet bullet) {
		totalRobotBullet.add(bullet);
	}

	public ArrayList<Tank> getTankResource() {
		return totalTank;
	}

	public ArrayList<TankBullet> getHostBulletResource() {
		return totalHostBullet;
	}

	public ArrayList<TankBullet> getRobotBulletResource() {
		return totalRobotBullet;
	}
}