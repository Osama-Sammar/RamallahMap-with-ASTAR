
import java.util.LinkedList;
import javafx.scene.shape.Circle;

public class Vertex implements Comparable<Vertex> {

	private double x;
	private double y;
	private String name;
	LinkedList<Adjacent> adjacent;
	tableEnt table;
	Circle circle;

	public Vertex() {
		circle = new Circle();
		this.x = 0;
		this.y = 0;
		this.name = null;
		table = new tableEnt();
	}

	public Vertex(String name, double x, double y) {
		circle = new Circle();
		this.name = name;
		this.x = x;
		this.y = y;
		table = new tableEnt();

	}

	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Vertex [x=" + x + ", y=" + y + ", name=" + name + "]";
	}

	@Override
	public int compareTo(Vertex x) {

		if (x.table.getWeight() < table.getWeight())
			return 1;
		else if (x.table.getWeight() > table.getWeight())
			return -1;
		else
			return 0;
	}

}
