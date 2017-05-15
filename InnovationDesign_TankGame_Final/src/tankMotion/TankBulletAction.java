package tankMotion;

import resource.PublicResource;
import tankModel.Tank;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;
import baseComponent.TankBullet;

public class TankBulletAction implements Runnable {
	private PublicResource pr = null;

	private Tank tank;
	private TankBullet tankBullet;
	private Behaviour bulletBehaviour;

	private double v0 = 0, v0x = 0, v0y = 0, a = 0;
	private double x = 0, y = 0;
	private double shootAngle = 0;

	private double range = 0;
	private int sleepTime = 30;

	public TankBulletAction(PublicResource pr, Tank tank, double angle,
			double v, double range) {
		this.pr = pr;

		this.tank = tank;
		this.shootAngle = angle;
		this.v0 = v;
		this.range = range;

		this.tank.setTankBullet(angle);
		tankBullet = this.tank.getTankBullet();

		bulletBehaviour = new Behaviour(v0, this.shootAngle);
	}

	@SuppressWarnings("deprecation")
	private boolean isMissed() {
		for (int i = 0; i < pr.getTankResource().size(); i++) {
			try {
				if (tank != pr.getTankResource().get(i)
						&& tankBullet.intersection(pr.getTankResource().get(i)
								.getTankBody())) {
					tankBullet.setValue(false);
					tankBullet.erase();

					if (!tank.getArmy().equals(
							pr.getTankResource().get(i).getArmy())) {
						pr.getTankResource().get(i)
								.damage(tankBullet.getDamage());

						System.out.println("Rest blood is "
								+ pr.getTankResource().get(i).getBlood());
					}

					Thread.currentThread().stop();
				}
			} catch (Exception el) {
				System.out.println("不是闭合曲线!");
			}
		}
		return tankBullet.getValue();
	}

	private boolean isInside() {
		if (Math.abs(tankBullet.cp.x()) >= range
				|| Math.abs(tankBullet.cp.y()) >= range) {
			tankBullet.setValue(false);
			tankBullet.erase();
		}
		return tankBullet.getValue();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isMissed()) {
			bulletBehaviour.setAccelerate(a);

			v0 = bulletBehaviour.getSpeed();
			v0x = bulletBehaviour.getSpeedx();
			v0y = bulletBehaviour.getSpeedy();

			bulletBehaviour.setSpeed(v0x, v0y, shootAngle);

			x = bulletBehaviour.distanceX(v0x);
			y = bulletBehaviour.distanceY(v0y);

			tankBullet.erase();
			tankBullet.translate(x, y);
			tankBullet.draw();

			if (!isInside())
				break;

			cpDraw.show(sleepTime);
		}
	}
}