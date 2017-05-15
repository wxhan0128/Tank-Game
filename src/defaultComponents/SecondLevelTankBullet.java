package defaultComponents;

import tankModel.Tank;
import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
import baseComponent.TankBullet;

public class SecondLevelTankBullet extends TankBullet {

	public SecondLevelTankBullet(Tank tank, double angle) {
		super(tank, angle);
		// TODO Auto-generated constructor stub
		this.damage = 2;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub
		double r = 1.6;

		this.bulletPoint.add(new Point2D(r, 2 * Math.PI / 72 * 11));
		this.bulletPoint.add(new Point2D(r + 2, 2 * Math.PI / 72 * 18));
		this.bulletPoint.add(new Point2D(r, 2 * Math.PI / 72 * 25));
		this.bulletPoint.add(new Point2D(r, 2 * Math.PI / 72 * 47));
		this.bulletPoint.add(new Point2D(r, 2 * Math.PI / 72 * 61));

		for (int i = 0; i < bulletPoint.size(); i++) {
			this.rectangular_ps.add(this.polarTorec(this.bulletPoint.get(i)));
			this.polar_ps.add(bulletPoint.get(i));
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

	public void rotate() {
		for (int i = 0; i < this.bulletPoint.size(); i++) {
			this.polar_ps.set(i, new Point2D(this.bulletPoint.get(i).x(),
					this.bulletPoint.get(i).y() + this.theta));
		}

		for (int i = 0; i < this.rectangular_ps.size(); i++) {
			this.rectangular_ps.set(i, polarTorec(this.polar_ps.get(i)));
		}
	}
}