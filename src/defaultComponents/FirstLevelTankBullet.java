package defaultComponents;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBullet;

public class FirstLevelTankBullet extends TankBullet {

	public FirstLevelTankBullet(Tank tank, double angle) {
		super(tank, angle);
		// TODO Auto-generated constructor stub
		this.damage = 1;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		Point2D firstPoint = new Point2D(cp.x() - width / 8, cp.y());
		bulletPoint.add(firstPoint);
		Point2D secondPoint = new Point2D(cp.x() - width / 8, cp.y() + height
				/ 8);
		bulletPoint.add(secondPoint);
		Point2D thirdPoint = new Point2D(cp.x() + width / 8, cp.y() + height
				/ 8);
		bulletPoint.add(thirdPoint);
		Point2D fourPoint = new Point2D(cp.x() + width / 8, cp.y());
		bulletPoint.add(fourPoint);

		for (int i = 0; i < bulletPoint.size(); i++) {
			this.rectangular_ps.add(bulletPoint.get(i));
			this.polar_ps.add(recTopolar(rectangular_ps.get(i)));
		}

		rotate(-theta);
		move(new Point2D(np.x(), np.y()));
	}

	public void move(Point2D p) {
		this.cp.setx(p.x());
		this.cp.sety(p.y());

		for (int i = 0; i < rectangular_ps.size(); i++) {
			rectangular_ps.set(i, polarTorec(polar_ps.get(i)));
		}
	}

	public void rotate(double theta) {
		for (int i = 0; i < this.bulletPoint.size(); i++) {
			this.polar_ps.set(i,
					new Point2D(recTopolar(this.bulletPoint.get(i)).x(),
							recTopolar(this.bulletPoint.get(i)).y() + theta));
		}

		for (int i = 0; i < this.rectangular_ps.size(); i++) {
			this.rectangular_ps.set(i, polarTorec(this.polar_ps.get(i)));
		}
	}
}