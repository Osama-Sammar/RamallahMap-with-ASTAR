
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Graph {

	int numOfVertex;
	int numOfEdges;
	Vertex[] vertex;
	PriorityQueue<Vertex> queue = new PriorityQueue<>();

	public void initilizeTable(int start) {

		for (int i = 0; i < numOfVertex; i++) {

			vertex[i].table = new tableEnt(null, false, Integer.MAX_VALUE);
		}
		vertex[start].table = new tableEnt(null, false, 0);
		queue.add(vertex[start]);
	}

	public void CalculateDistance() {

		while (!queue.isEmpty()) {
			Vertex x = queue.poll();

			x.table.setVisited(true);

			for (int j = 0; j < x.adjacent.size(); j++) { // for each adjacent
				int index = findIndex(x.adjacent.get(j).getVertex());

				if (!vertex[index].table.isVisited()) {
					if (x.adjacent.get(j).getDistance() + x.table.getWeight() < vertex[index].table.getWeight()) {
						vertex[index].table.setWeight(x.adjacent.get(j).getDistance() + x.table.getWeight());
						vertex[index].table.setPath(x);
						queue.add(vertex[index]);

					}
				}
			}
		}

	}

	public void readFromFile(String path1, String path2) {

		File file1 = new File(path1);
		File file2 = new File(path2);
		Scanner scan1;
		Scanner scan2;
		try {
			scan1 = new Scanner(file1);
			scan2 = new Scanner(file2);

			String line1 = scan1.nextLine();
			String str1[] = line1.split(",");

			String line2 = scan2.nextLine();
			String str2[] = line2.split(",");

			numOfVertex = Integer.parseInt(str1[0]);
			numOfEdges = Integer.parseInt(str2[0]);

			vertex = new Vertex[numOfVertex];

			int Tracker = 0;

			while (scan1.hasNextLine()) {

				line1 = scan1.nextLine();
				str1 = line1.split(",");
				vertex[Tracker] = new Vertex(str1[0], Double.parseDouble(str1[1]), Double.parseDouble(str1[2]));
				Tracker++;
			}

			for (int i = 0; i < numOfVertex; i++)
				vertex[i].adjacent = new LinkedList<Adjacent>();

			Tracker = 0;

			while (scan2.hasNextLine()) {

				line2 = scan2.nextLine();
				str2 = line2.split(",");

				Vertex temp1 = findVertex(str2[0]);
				Vertex temp2 = findVertex(str2[1]);
				int index1 = findIndex(temp1);
				int index2 = findIndex(temp2);

				vertex[index1].adjacent.add(new Adjacent(findVertex(str2[1]), Double.parseDouble(str2[2])));
				vertex[index2].adjacent.add(new Adjacent(findVertex(str2[0]), Double.parseDouble(str2[2])));
				Tracker++;
			}

			scan1.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void printPath(Vertex v) {

		if (v.table.getPath() != null) {
			printPath(v.table.getPath());
			System.out.print("-->");
		}

		System.out.println(v.getName());

	}

	public Vertex findVertex(String name) {

		for (int i = 0; i < numOfVertex; i++) {

			if (vertex[i].getName().compareTo(name) == 0) {
				return vertex[i];
			}

		}
		return null;

	}

	public int index(String name) {

		for (int i = 0; i < numOfVertex; i++) {

			if (vertex[i].getName().compareTo(name) == 0) {
				return i;
			}

		}
		return -1;

	}

	private int findIndex(Vertex v) {
		int index = -1;
		for (int i = 0; i < numOfVertex; i++) {

			if (v.getName().compareTo(vertex[i].getName()) == 0) {
				index = i;
				break;
			}

		}
		return index;
	}

}
