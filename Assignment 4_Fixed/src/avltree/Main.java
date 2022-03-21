package avltree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);

	AVLTree tree = new AVLTree();
	int n;

		System.out.print("Insert amount of elements to add: ");
		int size = sc.nextInt();

		System.out.println("Insert Nodes: ");
		for (int i = 0; i<size; i++) {
			n = sc.nextInt();
			tree.addNode((new Node(n)));
		}

		tree.checkAVL(tree.root);
		System.out.println(tree.printAVLCheck());
    }
}
