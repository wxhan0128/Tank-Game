package tankModel;

import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;
import defaultComponents.FirstLevelTankBody;
import defaultComponents.FirstLevelTankBullet;
import defaultComponents.FirstLevelTankCannonTower;
import defaultComponents.FirstLevelTankRadar;
import defaultComponents.FirstStyleBloodbar;

public class FirstLevelTank extends Tank {

	public FirstLevelTank(String army, Point2D p, int width, int height,
			double bodyAngle) {
		super(army, p, width, height, bodyAngle);
		// TODO Auto-generated constructor stub
		this.initialBlood = 10;

		tankBody = new FirstLevelTankBody(p, width, height);
		tanktTower = new FirstLevelTankCannonTower(this);
		tankRadar = new FirstLevelTankRadar(this);
		tankBloodbar = new FirstStyleBloodbar(this);

		tankfinish();
	}

	@Override
	public void setTankBullet(double angle) {
		// TODO Auto-generated method stub
		tankBullet = new FirstLevelTankBullet(this, angle);

		tankBullet.create();
	}

	@Override
	public void setMutiTankBullet(int n, double angle) {
		// TODO Auto-generated method stub

	}

	@Override
	public TankBloodbar refreshBloodbar() {
		// TODO Auto-generated method stub
		tankBloodbar = new FirstStyleBloodbar(this);

		tankBloodbar.create();
		return tankBloodbar;
	}
}