package tankMotion;

import geography.Map;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import resource.PublicResource;

public class RobotTankAction01 extends TankAction {
	private double boundRotate = Math.PI / 20;

	private Thread autoFire;
	private TankBulletAction tankBulletThread;

	public RobotTankAction01(PublicResource pr, Map mapInfo) {
		super(pr, mapInfo);
		// TODO Auto-generated constructor stub
	}

	public void body_action() {
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
			tankBody.rotate(-boundRotate);
			bodyRotate += boundRotate;
			tankBehaviour.setDirection(bodyRotate);
		}

		if (isCrashed())
			tankBehaviour.setSpeed(-v0x, -v0y, bodyRotate);
	}

	@Override
	public void tower_action() {
		// TODO Auto-generated method stub
		tankTower.translate(x, y);
		towerRotate += tankTower.getTowerRotate();
		tankTower.rotate(-tankTower.getTowerRotate());
	}

	@Override
	public void radar_action() {
		// TODO Auto-generated method stub
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
					if (pr.getRobotBulletResource().size() < 100) {
						try {
							pr.setRobotBulletsResource(tank.getTankBullet());
							tankBulletThread = new TankBulletAction(pr, tank,
									towerRotate, 100, border);
							Thread rt = new Thread(tankBulletThread);
							rt.start();
						} catch (Exception el) {
							System.out.println("���Ǳպ�����!");
						}
					}

					cpDraw.show(bulletSleep);
				}
			}
		});
		autoFire.start();
	}
}