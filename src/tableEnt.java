
public class tableEnt {

	private boolean isVisited;
	private double weight;
	private Vertex path;

	public tableEnt() {
		this.isVisited = false;
		this.weight = 0;
		this.path = null;
	}

	public tableEnt(Vertex path, boolean isVisited, double weight) {
		this.isVisited = isVisited;
		this.path = path;
		this.weight = weight;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Vertex getPath() {
		return path;
	}

	public void setPath(Vertex path) {
		this.path = path;
	}

}