package outsideComponents;
//package OtherComponents;
//
//import Resource.PublicResource;
//import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
//
//public class AmmoTankA extends Ammo {
//
//	public AmmoTankA(Point2D p, Object lock, Object lockforsynchronize,
//			int side, PublicResource allresource) {
//		this.life = 5;
//		this.damage = 5;
//		this.lock = lock;
//		this.Side = side;
//		this.lockforsynchronize = lockforsynchronize;
//		this.allresource = allresource;
//		this.translate(p.x(), p.y());
//		double r = 0.15;
//		this.polar_ps.add(new Point2D(r, 2 * Math.PI / 72 * 11));
//		this.polar_ps.add(new Point2D(r + 0.2, 2 * Math.PI / 72 * 18));
//		this.polar_ps.add(new Point2D(r, 2 * Math.PI / 72 * 25));
//		this.polar_ps.add(new Point2D(r, 2 * Math.PI / 72 * 47));
//		this.polar_ps.add(new Point2D(r, 2 * Math.PI / 72 * 61));
//		for (int i = 0; i < polar_ps.size(); i++) {
//			this.rectangular_ps.add(this.polarTorec(this.polar_ps.get(i)));
//		}
//	}
//
//	public static void main(String[] args) {
//		AmmoTankA T = new AmmoTankA(new Point2D(0, 10), new Object(),
//				new Object(), 1, null);
//		T.filledPolygon();
//	}
//
// }
