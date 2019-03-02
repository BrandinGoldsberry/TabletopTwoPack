package hnefataflModels;

public class CoordinateKey {
	private int x;
	private int y;
	
	public CoordinateKey(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) { 
        	return true;
        }
        if (!(o instanceof CoordinateKey)) {
        	return false;
        }
        CoordinateKey key = (CoordinateKey) o;
        return x == key.x && y == key.y;
    }
	
	public boolean equals(int x, int y) {
        return getX() == x && getY() == y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
