package binarysearchtree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		int[] treeData;
		treeData = new int[]{56, 23, 21, 15, 9, 87, 45, 77, 59, 90, 83, 75, 20, 5, 92, 98, 100};
		BinaryTree tree = new BinaryTree();
		Scanner sc = new Scanner(System.in);

		//sort treeData first
		Arrays.sort(treeData);

		//hardcode binary tree
		tree.root = new Node(treeData[(treeData.length/2)]);
		tree.root.left = new Node(treeData[4]);
		tree.root.left.left = new Node(treeData[1]);
		tree.root.left.right = new Node(treeData[6]);
		tree.root.left.left.left = new Node(treeData[0]);
		tree.root.left.left.right = new Node(treeData[2]);
		tree.root.left.right.left = new Node(treeData[5]);
		tree.root.left.right.left.left = new Node(treeData[3]);
		tree.root.left.right.right = new Node(treeData[7]);
		tree.root.right = new Node(treeData[12]);
		tree.root.right.left = new Node(treeData[10]);
		tree.root.right.left.left = new Node(treeData[9]);
		tree.root.right.left.right = new Node(treeData[11]);
		tree.root.right.right = new Node(treeData[14]);
		tree.root.right.right.left = new Node(treeData[13]);
		tree.root.right.right.right = new Node(treeData[15]);
		tree.root.right.right.right.right = new Node(treeData[16]);

		//inorder traversal
		System.out.print("In Order: ");
		tree.printInorder();

		//postorder traversal
		System.out.print("\nPost Order: ");
		tree.printPostorder();

		//preorder traversal
		System.out.print("\nPre Order: ");
		tree.printPreorder();

		//sum of node values
		int sum = tree.sumOfNodes(tree.root);
		System.out.print("\nThe sum of all node values is: " + sum);

		//height of tree
		int treeHeight = tree.heightOfTree(tree.root);
		System.out.print("\nThe height of this tree is: " + treeHeight);

		//level order
		System.out.print("\nThe level order of traversal in this binary tree is: ");
		tree.showLevelOrder();

		//find sibling value
		try {
			System.out.print("\nEnter the node: ");
			int searchSibling = sc.nextInt();
			Node siblingNode = tree.showSiblingValue(tree.root, searchSibling);
			if (siblingNode != null) {
				System.out.println("Sibling is: " + siblingNode.key);
			}
		} catch (Exception e){
			System.out.println("Error: Sibling doesn't exist"); //prints error message if sibling doesn't exist
		}
		//for (int i = 0; i<treeData.length; i++) System.out.print(treeData[i] + " ");



    }


}
