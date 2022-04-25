package dijkstrasalgo;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	// A list of lists to represent an adjacency list
	List<List<Edge>> adjList = null;

	// Constructor
	Graph(List<Edge> edges, int n) {
		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adjList.add(new ArrayList<>());
		}

		// add edges to the directed graph
		for (Edge edge: edges) {
			adjList.get(edge.source).add(edge);
		}
	}
}
