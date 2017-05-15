package tankModel;

import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;
import defaultComponents.FirstLevelTankRadar;
import defaultComponents.FirstStyleBloodbar;
import defaultComponents.SecondLevelTankBody;
import defaultComponents.ThirdLevelTankBullet;
import defaultComponents.ThirdLevelTankCannonTower;

public class ThirdLevelTank extends Tank {

	public ThirdLevelTank(String army, Point2D p, int width, int height,
			double bodyAngle) {
		super(army, p, width, height, bodyAngle);
		// TODO Auto-generated constructor stub
		this.initialBlood = 15;

		tankBody = new SecondLevelTankBody(p, width, height);
		tanktTower = new ThirdLevelTankCannonTower(this);
		tankRadar = new FirstLevelTankRadar(this);
		tankBloodbar = new FirstStyleBloodbar(this);

		tankfinish();
	}

	@Override
	public void setTankBullet(double angle) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMutiTankBullet(int n, double angle) {
		// TODO Auto-generated method stub
		tankBullet = new ThirdLevelTankBullet(this, angle);
		tankBullet.setBulletNumber(n);

		tankBullet.create();
	}

	@Override
	public TankBloodbar refreshBloodbar() {
		// TODO Auto-generated method stub
		tankBloodbar = new FirstStyleBloodbar(this);

		tankBloodbar.create();
		return tankBloodbar;
	}
}
