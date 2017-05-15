package tankMotion;

import geography.Map;
import resource.PublicResource;

public class PlayerTankAction06 extends TankAction {

	public PlayerTankAction06(PublicResource pr, Map mapInfo) {
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
			tank.setBlood(0);
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
	}

	@Override
	public void fire() {
		// TODO Auto-generated method stub
	}
}