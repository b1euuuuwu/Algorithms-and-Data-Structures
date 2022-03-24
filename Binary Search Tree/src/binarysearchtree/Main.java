package binarysearchtree;

import java.util.*;

public class Main {

    public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Scanner sc = new Scanner(System.in);

		// Hardcode data to make it simpler
		tree.insert(8);
		tree.insert(3);
		tree.insert(1);
		tree.insert(6);
		tree.insert(7);
		tree.insert(10);
		tree.insert(14);
		tree.insert(4);

		System.out.print("Inorder traversal: ");
		tree.inorder();

		System.out.print("\nWhich node would you like to delete? ");
		int deleteKey = sc.nextInt();
		tree.deleteKey(deleteKey);
		System.out.print("\nInorder traversal: ");
		tree.inorder();
	}
}

