
public class Adjacent {

	private Vertex vertex;
	private Double distance;

	public Adjacent() {

	}

	public Adjacent(Vertex vertex, double distance) {
		this.vertex = vertex;
		this.distance = distance;
	}

	public Vertex getVertex() {
		return vertex;
	}

	public void setVertex(Vertex vertex) {
		this.vertex = vertex;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

}
