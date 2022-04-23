package dijkstrasalgo;

import java.util.*;

public class Main {
	private static void getRoute(int[] prev, int i, List<Integer> route)
	{
		if (i >= 0)
		{
			getRoute(prev, prev[i], route);
			route.add(i);
		}
	}

	// Run Dijkstra’s algorithm on a given graph
	public static void findShortestPaths(Graph graph, int source, int n)
	{
		// create a min-heap and push source node having distance 0
		PriorityQueue<Node> minHeap;
		minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
		minHeap.add(new Node(source, 0));

		// set initial distance from the source to `v` as infinity
		List<Integer> dist;
		dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

		// distance from the source to itself is zero
		dist.set(source, 0);

		// boolean array to track vertices for which minimum
		// cost is already found
		boolean[] done = new boolean[n];
		done[source] = true;

		// stores predecessor of a vertex (to a print path)
		int[] prev = new int[n];
		prev[source] = -1;

		// run till min-heap is empty
		while (!minHeap.isEmpty())
		{
			// Remove and return the best vertex
			Node node = minHeap.poll();

			// get the vertex number
			int u = node.vertex;

			// do for each neighbor `v` of `u`
			for (Edge edge: graph.adjList.get(u))
			{
				int v = edge.dest;
				int weight = edge.weight;

				// Relaxation step
				if (!done[v] && (dist.get(u) + weight) < dist.get(v))
				{
					dist.set(v, dist.get(u) + weight);
					prev[v] = u;
					minHeap.add(new Node(v, dist.get(v)));
				}
			}

			// mark vertex `u` as done so it will not get picked up again
			done[u] = true;
		}

		List<Integer> route = new ArrayList<>();

		for (int i = 0; i < n; i++)
		{
			if (i != source && dist.get(i) != Integer.MAX_VALUE)
			{
				getRoute(prev, i, route);
				System.out.printf("Path (%d —> %d): Minimum cost = %d, Route = %s\n",
						source, i, dist.get(i), route);
				route.clear();
			}
		}
	}

	public static void main(String[] args)
	{
		// initialize edges as per the above diagram
		// (u, v, w) represent edge from vertex `u` to vertex `v` having weight `w`
		// {a, b, c, d, e, f, g, h, i} == {0, 1, 2, 3, 4, 5, 6, 7, 8}
		List<Edge> edges = Arrays.asList(
				new Edge(0, 1, 10),
				new Edge(0, 2, 5),
				new Edge(0, 3, 1),
				new Edge(1, 2, 4),
				new Edge(1, 6, 3),
				new Edge(1, 4, 10),
				new Edge(2, 4, 10),
				new Edge(2, 5, 17),
				new Edge(2, 3, 5),
				new Edge(3, 5, 16),
				new Edge(3, 7, 21),
				new Edge(4, 5, 2),
				new Edge(4, 6, 2),
				new Edge(4, 7, 18),
				new Edge(5, 7, 15),
				new Edge(5, 8, 6),
				new Edge(6, 7, 25),
				new Edge(7, 8, 10)
				);

		// total number of nodes in the graph (labelled from 0 to 4)
		int n = 9;

		// construct graph
		Graph graph = new Graph(edges, n);

		// run the Dijkstra’s algorithm from every node
		for (int source = 0; source < n; source++) {
			findShortestPaths(graph, source, n);
		}
	}
}

