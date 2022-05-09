package mst;

public class MST {
	// number of vertices in the graph
	private static final int V = 10;

	// method to find vertex with minimum key in a graph
	int minKey(int key[], Boolean setMST[]) {
		// initialize min value
		int min = Integer.MAX_VALUE, min_index = - 1;

		for (int v = 0; v < V; v++) {
			if (!setMST[v] && key[v]<min) {
				min = key[v];
				min_index = v;
			}
		}
		return min_index;
	}

	private void printMST(int parent[], int graph[][], int cost) {
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "\t" + graph[parent[i]][i]);
		System.out.println("Total Cost: " + cost);
	}

	int numberOfSpanningTree(int[][] graph) {
		// Function to create a Laplacian Matrix
		int[][] laplacianMatrix = new int[V][V];
		for (int i = 0; i < V; i++) {
			for (int j = i + 1; j < V; j++) {
				if (graph[i][j] != 0) {
					laplacianMatrix[i][j] = -1;
					laplacianMatrix[j][i] = -1;
					// counting degrees for every Vertex
					laplacianMatrix[i][i]++;
					laplacianMatrix[j][j]++;
				} else {
					laplacianMatrix[i][j] = 0;
					laplacianMatrix[j][i] = 0;
				}
			}
		}
		var Cofactor = new int[V - 1][V - 1];
		for (int i = 1; i < V; i++) {
			for (int j = 1; j < V; j++) {
				Cofactor[i - 1][j - 1] = laplacianMatrix[i][j];
			}
		}
		return getDeterminant(Cofactor);
	}
	int getDeterminant(int[][] matrix) {
		int[][] temp;
		int result = 0;
		int matrixLen = matrix.length;
		if (matrixLen == 1) {
			result = matrix[0][0];
			return result;
		}
		if (matrixLen == 2) {
			result = ((matrix[1][1] * matrix[0][0]) -
					(matrix[1][0] * matrix[0][1]));
			return result;
		}
		for (int i = 0; i < matrixLen; i++) {
			temp = new int[matrixLen - 1][matrixLen -
					1];
			for (int j = 1; j < matrixLen; j++) {
				for (int k = 0; k < matrixLen; k++) {
					if (k < i) {
						temp[j - 1][k] = matrix[j][k];
					} else if (k > i) {
						temp[j - 1][k - 1] = matrix[j][k];
					}
				}
			}
			result += matrix[0][i] * Math.pow(-1, i) *
					getDeterminant(temp);
		}
		return result;
	}

	// method implement prim's algorithm
	void primMST(int graph[][]) {
		//array to construct stored MST
		int[] parent = new int[V];

		//key value to pickup min Weight edge in a cut
		int[] key = new int[V];

		//represent et of vertices in MST
		Boolean[] setMST = new Boolean[V];

		//set all keys as INFINITE
		for (int i = 0; i < V; i++) {
			key[i] = Integer.MAX_VALUE;
			setMST[i] = false;
		}

		// ALWAYS include first vertex in MST
		key[0] = 0;
		parent [0] = -1;

		// the MST will have V vertices
		for (int count = 0; count < V-1; count++) {
			// pick the minimum key vertex from a set of vertices not yet included in the MST
			int u = minKey(key, setMST);

			// add the chosen vertex into the MST Set
			setMST[u] = true;

			for (int v = 0; v < V; v++)
				if (graph[u][v] != 0 && setMST[v]==false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		int cost = 0;
		for (int i = 1; i < V; i++)
			cost = cost + graph[parent[i]][i];
		printMST(parent, graph, cost);
	}
}
