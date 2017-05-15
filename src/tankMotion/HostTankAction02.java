package tankMotion;

import geography.Map;

import java.util.ArrayList;

import resource.PublicResource;
import Ynu.Sei.cpLibrary.BASIC.cpDraw;

public class HostTankAction02 extends TankAction {
	private double crashRotate = 0;
	private int cooling = 0;
	private ArrayList<MutiTankBulletAction> tankBulletThread_list = new ArrayList<MutiTankBulletAction>();

	public HostTankAction02(PublicResource pr, Map mapInfo) {
		super(pr, mapInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void body_action() {
		// TODO Auto-generated method stub
		tankBehaviour.setAccelerate(0);

		v0x = tankBehaviour.getSpeedx();
		v0y = tankBehaviour.getSpeedy();

		tankBehaviour.setSpeed(v0x, v0y, bodyRotate);

		x = tankBehaviour.distanceX(v0x);
		y = tankBehaviour.distanceY(v0y);

		tankBody.translate(x, y);

		tankDisX = tankBody.cp.x();
		tankDisY = tankBody.cp.y();

		if (cpDraw.hasNextKeyTyped() && cpDraw.isKeyPressed('w')) {
			tankBehaviour.setAccelerate(a);
			tankBehaviour.accelerate(bodyRotate);
		}
		if (cpDraw.isKeyPressed('s')) {
			tankBehaviour.setAccelerate(a);
			tankBehaviour.brake(bodyRotate);
		}
		if (cpDraw.isKeyPressed('a')) {
			tankBody.erase();
			tankBody.rotate(Math.PI / 20);
			bodyRotate -= Math.PI / 20;
			tankBehaviour.setDirection(bodyRotate);
		}
		if (cpDraw.isKeyPressed('d')) {
			tankBody.erase();
			tankBody.rotate(-Math.PI / 20);
			bodyRotate += Math.PI / 20;
			tankBehaviour.setDirection(bodyRotate);
		}
		if (cpDraw.isKeyPressed('q')) {
			tankTower.erase();
			tankTower.rotate(Math.PI / 25);
			towerRotate -= Math.PI / 25;
		}
		if (cpDraw.isKeyPressed('e')) {
			tankTower.erase();
			tankTower.rotate(-Math.PI / 25);
			towerRotate += Math.PI / 25;
		}
		if (cpDraw.isKeyPressed(' ') && pr.getHostBulletResource().size() < 200) {
			if (cooling >= 30) {
				this.tank.fireable = true;
				fire();
				cooling = 0;
			}
		}

		if ((isBounded(x + tankDisX, y + tankDisY)))
			tankBehaviour.setSpeed(-v0x, -v0y, crashRotate);

		if (isCrashed())
			tankBehaviour.setSpeed(-v0x, -v0y, bodyRotate);

		if (cooling <= 200) {
			cooling += 1;
		}
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
	}

	public void fire() {
		// TODO Auto-generated method stub
		tankBulletThread_list.clear();

		if (this.tank.fireable) {
			tankBulletThread_list.add(new MutiTankBulletAction(1, pr, tank,
					towerRotate, 100, border));
			tankBulletThread_list.add(new MutiTankBulletAction(2, pr, tank,
					towerRotate, 100, border));

			for (int i = 0; i < tankBulletThread_list.size(); i++) {
				Thread ht = new Thread(tankBulletThread_list.get(i));
				ht.start();
				pr.setHostBulletsResource(tank.getTankBullet());
			}
			this.tank.fireable = false;
		}
	}
}