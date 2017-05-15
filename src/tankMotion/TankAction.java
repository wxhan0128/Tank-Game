package tankMotion;

import geography.Map;
import resource.PublicResource;
import tankModel.Tank;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import baseComponent.TankBloodbar;
import baseComponent.TankBody;
import baseComponent.TankCannonTower;
import baseComponent.TankRadar;

public abstract class TankAction {
	protected PublicResource pr = null;

	protected Tank tank;
	protected TankBody tankBody;
	protected TankCannonTower tankTower;
	protected TankRadar tankRadar;
	protected TankBloodbar tankBloodbar;

	protected double bodyRotate = 0, towerRotate = 0;

	protected double v = 0, v0x = 0, v0y = 0;
	protected double a = 0;
	protected double x = 0, y = 0;
	protected Behaviour tankBehaviour;
	protected double tankDisX = 0, tankDisY = 0;

	protected double border = 0;
	protected final int sleepTime = 30;

	public TankAction(PublicResource pr, Map mapInfo) {
		this.pr = pr;
		this.border = mapInfo.getBorder();
	}

	public final void tankReady(Tank tank, double speed, double accelerate) {
		initTankInfor(tank);
		initMotionInfor(speed, accelerate);
		play();
		fire();
	}

	public void initTankInfor(Tank tank) {
		this.tank = tank;

		this.bodyRotate = tank.getTankRotate();
		this.towerRotate = tank.getTankRotate();

		this.tankBody = tank.getTankBody();
		this.tankTower = tank.getTankTower();
		this.tankRadar = tank.getTankRadar();
		this.tankBloodbar = tank.getTankBloodbar();

		pr.setTankResource(tank);
	}

	public void initMotionInfor(double v, double a) {
		this.v = v;
		this.a = a;
		tankBehaviour = new Behaviour(this.v, this.bodyRotate);

		this.v0x = tankBehaviour.getSpeedx();
		this.v0y = tankBehaviour.getSpeedy();
	}

	public boolean isAlive() {
		if (tank.getBlood() <= 0) {
			tank.setAlive(false);

			tankBody.erase();
			tankTower.erase();
			tankRadar.erase();
			tankBloodbar.erase();

			pr.getTankResource().remove(tank);
		}
		return tank.getAlive();
	}

	public boolean isBounded(double x, double y) {
		boolean bounded = false;

		if ((Math.abs(x) >= border) || (Math.abs(y) >= border)) {
			bounded = true;
		}
		return bounded;
	}

	public boolean isCrashed() {
		boolean crashed = false;

		for (int i = 0; i < pr.getTankResource().size(); i++) {
			if (tank != pr.getTankResource().get(i))
				try {
					if (tankBody.intersection(pr.getTankResource().get(i)
							.getTankBody())) {
						crashed = true;
					}
				} catch (Exception el) {
					System.out.println("不是闭合曲线!");
				}
		}
		return crashed;
	}

	public abstract void body_action();

	public abstract void tower_action();

	public abstract void radar_action();

	public abstract void fire();

	public void play() {
		Thread antoPlay = new Thread(new Runnable() {
			@Override
			public void run() {
				while (isAlive()) {
					tankTower.erase();
					tankBody.erase();
					tankRadar.erase();
					tankBloodbar.fillErase();

					body_action();
					tower_action();
					radar_action();

					tankBloodbar = tank.refreshBloodbar();

					tankBody.draw();
					tankTower.draw();
					tankRadar.draw();
					tankBloodbar.filledPolygon();

					cpDraw.show(sleepTime);
				}
			}
		});
		antoPlay.start();
	}
}