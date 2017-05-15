package baseComponent;

import java.util.ArrayList;

import Ynu.Sei.cpLibrary.cellgrid2D.Point2D;

public abstract class TankBody extends TankPolygon {
	protected ArrayList<Point2D> bodyPoint = new ArrayList<Point2D>();

	public TankBody(Point2D p, int width, int height) {
		// TODO Auto-generated method stub
		this.cp.setx(p.x());
		this.cp.sety(p.y());
		
		this.width = width;
		this.height = height;
	}

	public abstract void create();
}
