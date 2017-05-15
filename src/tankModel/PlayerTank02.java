package tankModel;

import playerComponents.PlayerTankBody02;
import playerComponents.PlayerTankCannonTower02;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBloodbar;
import defaultComponents.FirstLevelTankBullet;
import defaultComponents.FirstLevelTankRadar;
import defaultComponents.FirstStyleBloodbar;

public class PlayerTank02 extends Tank {

	public PlayerTank02(String army, Point2D p, int width, int height,
			double bodyAngle) {
		super(army, p, width, height, bodyAngle);
		// TODO Auto-generated constructor stub
		this.initialBlood = 12;

		tankBody = new PlayerTankBody02(p, width, height);
		tanktTower = new PlayerTankCannonTower02(this);
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