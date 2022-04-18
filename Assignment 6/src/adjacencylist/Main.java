package adjacencylist;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
		Graph graph = new Graph(6);

		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);

		System.out.println(graph.toString());

		System.out.println("BFS: ");
		graph.bfs(0);

		System.out.println("\nDFS: ");
		graph.dfs(0);
    }
}
