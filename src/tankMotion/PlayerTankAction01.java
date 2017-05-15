package tankMotion;

import geography.Map;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import resource.PublicResource;

public class PlayerTankAction01 extends TankAction {
	private double boundRotate = Math.PI / 2;

	private Thread autoFire;
	private TankBulletAction tankBulletThread;

	public PlayerTankAction01(PublicResource pr, Map mapInfo) {
		super(pr, mapInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void body_action() {
		// TODO Auto-generated method stub
		tankBehaviour.setAccelerate(a);

		v = tankBehaviour.getSpeed();
		v0x = tankBehaviour.getSpeedx();
		v0y = tankBehaviour.getSpeedy();

		tankBehaviour.setSpeed(v0x, v0y, bodyRotate);

		x = tankBehaviour.distanceX(v0x);
		y = tankBehaviour.distanceY(v0y);

		tankBody.translate(x, y);

		tankDisX = tankBody.cp.x();
		tankDisY = tankBody.cp.y();

		if ((isBounded(x + tankDisX, y + tankDisY))) {
			tankBehaviour.setSpeed(0, 0, boundRotate);
			tankBody.rotate(-boundRotate);
			bodyRotate += boundRotate;
			tankBehaviour.setDirection(bodyRotate);
		}

		if (isCrashed())
			tankBehaviour.setSpeed(-v0x, -v0y, bodyRotate);

		if (v >= 0 && v <= 30)
			tankBehaviour.accelerate(bodyRotate);
		else if (v < 0 && v >= -30)
			tankBehaviour.brake(bodyRotate);
	}

	@Override
	public void tower_action() {
		// TODO Auto-generated method stub
		tankTower.translate(x, y);
	}

	@Override
	public void radar_action() {
		// TODO Auto-generated method stub
		tankRadar.rotate(tankRadar.getRadarRotate());
		tankRadar.translate(x, y);

		if (tankRadar.detect(tank, pr, tankBody.cp, 100))
			this.tank.fireable = true;
		else
			this.tank.fireable = false;
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
		autoFire = new Thread(new Runnable() {
			int bulletSleep = 600;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while (isAlive()) {
					if (tank.fireable) {
						if (pr.getRobotBulletResource().size() < 100) {
							try {
								tankBulletThread = new TankBulletAction(pr,
										tank, towerRotate, 100, border);
								Thread rt = new Thread(tankBulletThread);
								rt.start();
								pr.setRobotBulletsResource(tank.getTankBullet());
							} catch (Exception el) {
								System.out.println("不是闭合曲线!");
							}
						}
					}

					cpDraw.show(bulletSleep);
				}
			}
		});
		autoFire.start();
	}
}