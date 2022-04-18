package adjacencylist;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {
	private boolean adjMatrix[][];
	private int vertices;

	// Initialize the matrix
	public Graph(int vertices) {
		this.vertices = vertices;
		adjMatrix = new boolean[vertices][vertices];
	}

	// Add edges
	public void addEdge(int i, int j) {
		adjMatrix[i][j] = true;
		adjMatrix[j][i] = true;
	}

	// Print the matrix
	public String toString() {
		StringBuilder s = new StringBuilder();

		for (int i = 0; i < vertices; i++) {
			s.append(i + ": ");
			for (boolean j : adjMatrix[i]) {
				// Appends 1 or 0 to the matrix depending on the if there is a path/edge from i to j
				s.append((j ? 1 : 0) + " ");
			}
			s.append("\n");
		}
		return s.toString();
	}

	public void bfs(int start) {
		boolean visited[] = new boolean[vertices];
		Queue<Integer> queue = new LinkedList<>();
		visited[start] = true;
		queue.add(start);

		while(queue.size() != 0) {
			// Starting on the first element in the Queue
			int current = queue.remove();
			System.out.print(current + " ");
			// Insert all Adjacent Nodes into Queue
			for (int i = 0; i < vertices; i++) {
				if(!visited[i] && adjMatrix[current] [i] == true) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public void dfs(int start) {
		boolean visited [] = new boolean[vertices];
		Stack<Integer> stack = new Stack<>();
		visited[start] = true;
		stack.push(start);

		while(stack.size() != 0) {
			// Start from the top of the Stack
			int current = stack.pop();
			System.out.print(current + " ");
			// Insert all Adjacent Nodes into Stack
			for (int i = 0; i < vertices; i++) {
				if(!visited[i] && adjMatrix [current] [i] == true) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}
	}
}
