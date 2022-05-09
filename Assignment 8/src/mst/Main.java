package mst;

public class Main {

    public static void main(String[] args) {
		MST g = new MST();
		int graph[][] = new int[][] {{0, 5, 0, 5, 4, 0, 0, 0, 0, 0},
									{5, 0, 3, 0, 7, 0, 6, 8, 0, 0},
									{0, 3, 0, 0, 0, 0, 0, 0, 5, 0},
									{5, 0, 0, 0, 0, 4, 0, 0, 0, 0},
									{4, 7, 0 ,0 ,0, 5, 0, 0, 0, 0},
									{0, 0, 0, 4, 5, 0, 3, 0, 0, 0},
									{0, 6, 0, 0, 0, 3, 0, 6, 0, 6},
									{0, 8 ,0, 0, 0, 0, 6, 0, 7, 0},
									{0, 0, 5, 0, 0, 0, 0, 7, 0, 4},
									{0, 0, 0, 0, 0, 0, 6, 0, 4, 0},};

		System.out.println("1. ");
		g.primMST(graph);
		System.out.println("2. Number of spanning trees: " + g.numberOfSpanningTree(graph));
    }
}
