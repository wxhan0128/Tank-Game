package tankModel;

import playerComponents.PlayerTankBody01;
import playerComponents.PlayerTankCannonTower01;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;
import defaultComponents.FirstLevelTankBullet;
import defaultComponents.FirstLevelTankRadar;
import defaultComponents.FirstStyleBloodbar;

public class PlayerTank01 extends Tank {

	public PlayerTank01(String army, Point2D p, int width, int height,
			double bodyAngle) {
		super(army, p, width, height, bodyAngle);
		// TODO Auto-generated constructor stub
		this.initialBlood = 10;

		tankBody = new PlayerTankBody01(p, width, height);
		tanktTower = new PlayerTankCannonTower01(this);
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
