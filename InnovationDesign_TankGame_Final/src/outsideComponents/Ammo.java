package outsideComponents;

//
//import java.awt.Color;
//import java.util.ArrayList;
//
//import CreateTanks.Tank;
//import CreateTanks.FirstLevelTankBullets;
//import Resource.PublicResource;
//import Ynu.Sei.cpLibrary.BASIC.cpDraw;
//import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;
//
//public class Ammo implements Runnable {
//	private Point2D cp = new Point2D(0, 0);
//	protected ArrayList<Point2D> rectangular_ps = new ArrayList<Point2D>();
//	protected ArrayList<Point2D> polar_ps = new ArrayList<Point2D>();
//
//	// private Tank DE = new TankBullets(bulletEye, width, height, angle)
//	private long sleeptime = 5;
//	private double constrain = 11;
//	private boolean Ready = true;
//
//	protected Object lock = new Object();
//	protected Object lockforsynchronize = null;
//
//	protected Color color = cpDraw.BLACK;
//	protected PublicResource allresource = null;
//	protected int Side = 0;
//	protected int life = 1;
//	protected int damage = 1;
//	protected double speed = 0.7;
//	protected double angel = 0;
//
//	public boolean getReady() {
//		return this.Ready;
//	}
//
//	protected Point2D polarTorec(Point2D pp) {
//		double x = this.cp.x() + pp.x() * Math.cos(pp.y());
//		double y = this.cp.y() + pp.x() * Math.sin(pp.y());
//		Point2D p = new Point2D(x, y);
//		return p;
//	}
//
//	protected Point2D recTopolar(Point2D rp) {
//		double x = Math.sqrt(Math.pow(rp.x() - this.cp.x(), 2)
//				+ Math.pow(rp.y() - this.cp.y(), 2));
//		double y = Math.atan2(rp.y() - this.cp.y(), rp.x() - this.cp.x());
//		Point2D p = new Point2D(x, y);
//		return p;
//	}
//
//	public void translate(double x, double y) {
//		this.cp.setx(x);
//		this.cp.sety(y);
//		for (int i = 0; i < this.rectangular_ps.size(); i++) {
//			this.rectangular_ps.set(i, this.polarTorec(this.polar_ps.get(i)));
//		}
//	}
//
//	public void translateByUnit(double x, double y) {
//		this.cp.setx(this.cp.x() + x);
//		this.cp.sety(this.cp.y() + y);
//		for (int i = 0; i < this.rectangular_ps.size(); i++) {
//			this.rectangular_ps.set(i, this.polarTorec(this.polar_ps.get(i)));
//		}
//	}
//
//	public void rotate(double theta) {
//		for (int i = 0; i < this.polar_ps.size(); i++) {
//			this.polar_ps.set(i, new Point2D(this.polar_ps.get(i).x(),
//					this.polar_ps.get(i).y() + theta));
//		}
//		for (int i = 0; i < this.rectangular_ps.size(); i++) {
//			this.rectangular_ps.set(i, this.polarTorec(this.polar_ps.get(i)));
//		}
//	}
//
//	protected void draw() {
//		cpDraw.setPenColor(this.color);
//		cpDraw.Polygon(rectangular_ps);
//	}
//
//	protected void filledPolygon() {
//		cpDraw.setPenColor(this.color);
//		cpDraw.FilledPolygon(rectangular_ps);
//	}
//
//	protected void erase() {
//		// eraseA(1);
//		// eraseB();
//	}
//
//	private void eraseA(double x) {
//		this.DE.erase(x, this.cp, this.lock);
//	}
//
//	private void eraseB() {
//		this.DE.erasePolygonN(this.rectangular_ps, this.lock, 0.003);
//	}
//
//	public void setColor(Color color) {
//		this.color = color;
//	}
//
//	public Color getColor() {
//		return this.color;
//	}
//
//	public Point2D getcp() {
//		return this.cp;
//	}
//
//	public double getspeed() {
//		return this.speed;
//	}
//
//	public void setspeed(double speed) {
//		this.speed = speed;
//	}
//
//	public double getAngel() {
//		return this.angel;
//	}
//
//	public void setAngel(double angel) {
//		this.angel = angel;
//	}
//
//	public int getAmmoSide() {
//		return this.Side;
//	}
//
//	public void LifeDown(int damage) {
//		this.life -= damage;
//	}
//
//	public int getLife() {
//		return this.life;
//	}
//
//	public int getDamage() {
//		return this.damage;
//	}
//
//	public void setStartPoint(Point2D start) {
//		this.cp = start;
//	}
//
//	public ArrayList<Point2D> getPoint2DArrayList() {
//		return this.rectangular_ps;
//	}
//
//	// public PublicResource getAllresource() {
//	// return this.allresource;
//	// }
//
//	public boolean ALive() {
//		if (this.life <= 0)
//			return false;
//		else
//			return true;
//	}
//
//	private boolean IsAlive() {
//		if (!this.ALive()) {
//			this.erase();
//			this.Ready = true;
//			return false;
//		}
//		if (this.getcp().x() > constrain || this.getcp().x() < -constrain
//				|| this.getcp().y() > constrain
//				|| this.getcp().y() < -constrain) {
//			this.erase();
//			this.LifeDown(this.getDamage());
//			this.Ready = true;
//			return false;
//		}
//		return true;
//	}
//
//	private void CheckState() {
//		this.Ready = true;
//		synchronized (this.lockforsynchronize) {
//			try {
//				lockforsynchronize.wait();
//			} catch (InterruptedException e) {
//				// TODO 鑷姩鐢熸垚鐨�catch 鍧�
//				e.printStackTrace();
//			}
//		}
//		this.Ready = false;
//	}
//
//	private void function() {
//		this.CheckState();
//
//		this.erase();
//
//		this.Move();
//
//		this.DE.DrawFilled(this.color, this.rectangular_ps, this.lock);
//
//		this.Crash();
//	}
//
//	protected void Move() {
//		this.strategy.move.MoveA();
//	}
//
//	protected void Crash() {
//		this.strategy.crash.CrashA();
//	}
//
//	public void run() {
//		// TODO Auto-generated method stub
//		while (true) {
//			try {
//				Thread.sleep(sleeptime);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			this.function();
//			if (!this.IsAlive()) {
//				break;
//			}
//		}
//	}
//
// }