package tankMotion;

import geography.Map;
import resource.PublicResource;
import tankModel.Tank;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;

public class PlayerTankAction09 extends TankAction {
	private double boundRotate = Math.PI / 20;
	private double findAngle = 0;

	private Tank t = null;

	private Thread autoFire;
	private TankBulletAction tankBulletThread;

	public PlayerTankAction09(PublicResource pr, Map mapInfo) {
		super(pr, mapInfo);
		// TODO Auto-generated constructor stub
	}

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

		if (isBounded(x + tankDisX, y + tankDisY)) {
			tankBehaviour.setSpeed(0, 0, boundRotate);
			tankBody.rotate(-boundRotate);
			bodyRotate += boundRotate;
			tankBehaviour.setDirection(bodyRotate);
		}

		if (isCrashed())
			tankBehaviour.setSpeed(-v0x, -v0y, bodyRotate);
	}

	public void tower_action() {
		tankTower.translate(x, y);

		try {
			findAngle = Math.PI
					/ 2
					- Math.atan2((t.getTankBody().cp.y() - tankBody.cp.y()),
							(t.getTankBody().cp.x() - tankBody.cp.x()));
			tankTower.rotate(towerRotate - findAngle);
			tankBody.rotate(bodyRotate - findAngle);
			towerRotate -= (towerRotate - findAngle);
			bodyRotate -= (bodyRotate - findAngle);
			tankBehaviour.setDirection(bodyRotate);

			this.tank.fireable = true;
		} catch (Exception el) {
			System.out.println("");
		}

		if (v >= 0 && v <= 30)
			tankBehaviour.accelerate(bodyRotate);
		else if (v < 0 && v >= -30)
			tankBehaviour.brake(bodyRotate);
	}

	@Override
	public void radar_action() {
		// TODO Auto-generated method stub
		t = tankRadar.nearestTank(tank, pr, tankBody.cp);
		tankRadar.rotate(tankRadar.getRadarRotate());
		tankRadar.translate(x, y);
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