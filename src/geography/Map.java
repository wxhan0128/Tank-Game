package geography;

public abstract class Map {
	protected int mapWidth = 650;
	protected int mapHeight = 650;

	private int maxWidth = 1360, maxHeight = 680;
	private int minWidth = 300, minHeight = 300;

	protected int border = 100;

	public Map() {

	}

	public Map(int width, int height) {
		if (width <= maxWidth && width >= minWidth) {
			this.mapWidth = width;
		}
		if (height <= maxHeight && width >= minHeight) {
			this.mapHeight = height;
		}
		if (width > maxWidth) {
			this.mapWidth = maxWidth;
		}
		if (height > maxHeight) {
			this.mapHeight = maxHeight;
		}
		if (width < minWidth) {
			this.mapWidth = minWidth;
		}
		if (height < minHeight) {
			this.mapHeight = minHeight;
		}
		if (height > maxHeight && width > mapWidth) {
			this.mapWidth = maxWidth;
			this.mapHeight = maxHeight;
		}
		if (height < minHeight && width < minWidth) {
			this.mapWidth = minWidth;
			this.mapHeight = minHeight;
		}
	}

	public abstract void createMap();

	public int getMapsizeWidth() {
		return this.mapWidth;
	}

	public int getMapsizeHeight() {
		return this.mapHeight;
	}

	public int getBorder() {
		return this.border;
	}
}
