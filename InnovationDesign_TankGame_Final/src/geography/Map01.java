package geography;

import Ynu.Sei.cpLibrary.BASIC.cpDraw;

public class Map01 extends Map {

	public Map01() {

	}

	public Map01(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createMap() {
		// TODO Auto-generated method stub
		cpDraw.setCanvasSize(mapWidth, mapHeight);
		double derta = (double) mapHeight / (double) mapWidth;
		cpDraw.setX(-border, border, 1);
		cpDraw.setY(-border * derta, border * derta, 1);
	}
}
