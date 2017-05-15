package tankMotion;

public class Behaviour {
	protected double a = 0;
	private double v = 0, vx = 0, vy = 0;
	private double t = 0.03;
	private double x = 0, y = 0;

	public Behaviour(double v, double angle) {
		this.vx = v * Math.sin(angle);
		this.vy = v * Math.cos(angle);
	}

	public void setAccelerate(double a) {
		this.a = a;
	}

	public void accelerate(double angle) {
		this.vx = (this.v + a * t) * Math.sin(angle);
		this.vy = (this.v + a * t) * Math.cos(angle);
	}

	public void brake(double angle) {
		this.vx = (this.v - a * t) * Math.sin(angle);
		this.vy = (this.v - a * t) * Math.cos(angle);
	}

	public double distanceX(double vx) {
		this.x = vx * t + 1 / 2 * a * Math.pow(t, 2);
		return this.x;
	}

	public double distanceY(double vy) {
		this.y = vy * t + 1 / 2 * a * Math.pow(t, 2);
		return this.y;
	}

	public void setSpeed(double vx, double vy, double angle) {
		this.vx = vx;
		this.vy = vy;
		this.v = this.vy / Math.cos(angle);
	}

	public void setDirection(double angle) {
		this.vx = this.v * Math.sin(angle);
		this.vy = this.v * Math.cos(angle);
	}

	public double getSpeed() {
		return v;
	}

	public double getSpeedx() {
		return vx;
	}

	public double getSpeedy() {
		return vy;
	}
}
