package tankModel;

import java.awt.Color;

import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;
import baseComponent.TankBody;
import baseComponent.TankBullet;
import baseComponent.TankCannonTower;
import baseComponent.TankRadar;

public abstract class Tank {
	private String armyFlag = "host";

	protected TankBody tankBody;
	protected TankCannonTower tanktTower;
	protected TankRadar tankRadar;
	protected TankBullet tankBullet;
	protected TankBloodbar tankBloodbar;

	protected double bodyAngle = 0;

	protected double initialBlood = 10;
	protected double blood = initialBlood;
	public double newbarLength = 0;

	private boolean alive = true;

	public boolean moveable = true;
	public boolean fireable = false;

	public Tank(String army, Point2D p, int width, int height, double bodyAngle) {
		this.armyFlag = army;
		this.bodyAngle = bodyAngle;
	}

	public void tankfinish() {
		this.blood = initialBlood;
		newbarLength = tankBloodbar.getBarLength();

		tankBody.create();
		tanktTower.create();
		tankRadar.create();
		tankBloodbar.create();

		tankBody.rotate(-this.bodyAngle);
		tanktTower.rotate(-this.bodyAngle);
	}

	public void paint(Color c) {
		this.tankBody.setArmyColor(c);
		this.tanktTower.setArmyColor(c);
		this.tankRadar.setArmyColor(c);
	}

	public abstract void setTankBullet(double angle);

	public abstract void setMutiTankBullet(int n, double angle);

	public abstract TankBloodbar refreshBloodbar();

	public String getArmy() {
		return this.armyFlag;
	}

	public TankBody getTankBody() {
		return tankBody;
	}

	public TankCannonTower getTankTower() {
		return tanktTower;
	}

	public TankRadar getTankRadar() {
		return tankRadar;
	}

	public TankBloodbar getTankBloodbar() {
		return tankBloodbar;
	}

	public TankBullet getTankBullet() {
		return tankBullet;
	}

	public double getTankRotate() {
		return this.bodyAngle;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public boolean getAlive() {
		return this.alive;
	}

	public void setBlood(double blood) {
		this.blood = blood;
	}

	public double getBlood() {
		return this.blood;
	}

	public void damage(double damage) {
		this.blood = blood - damage;

		this.newbarLength = newbarLength - tankBloodbar.getBarLength()
				/ this.initialBlood * damage;
	}
}