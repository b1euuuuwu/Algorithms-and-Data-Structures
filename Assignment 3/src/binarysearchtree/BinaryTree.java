package binarysearchtree;

public class BinaryTree {
	Node root;

	BinaryTree() {
		root = null;
	}

	public void addNode (Node node) {
		if (root == null) {
			root = node;
		}
		else {
			insertNode (root, node);
		}
	}

	public void insertNode (Node parent, Node node) {
		if(parent.key > node.key) {
			if(parent.left == null) {
				parent.left = node;
			}
			else {
				insertNode(parent.left, node);
			}
		}
		else {
			if(parent.right == null) {
				parent.right = node;
			}
			else {
				insertNode(parent.right, node);
			}
		}
	}

	//method to print inorder traversal using recursive
	public void printInorder(Node node) {
		if (node == null)
			return;

		//recur left child
		printInorder(node.left);

		//print the node value
		System.out.print(node.key + " ");

		//recur right child
		printInorder(node.right);
	}

	public void printPreorder(Node node) {
		if (node == null)
			return;

		//print the first node value (root)
		System.out.print(node.key + " ");

		//recur left subtree
		printPreorder(node.left);

		//recur right subtree
		printPreorder(node.right);
	}

	//method to print postorder traversal using recursive
	public void printPostorder(Node node) {
		if (node == null)
			return;

		//recur left subtree
		printPostorder(node.left);

		//recur right subtree
		printPostorder(node.right);

		//print the node value
		System.out.print(node.key + " ");
	}

	//method to calculate sum of all node values using recursion
	public int sumOfNodes(Node root) {
		if (root == null)
			return 0;
		return (root.key + sumOfNodes(root.left) + sumOfNodes(root.right));
	}

	//method to calculate tree height
	public int heightOfTree(Node root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(heightOfTree(root.left),heightOfTree(root.right));
	}

	//method to show level order
	public void showLevelOrder() {
		int h = heightOfTree(root);
		for (int i = 1; i <= h; i++) {
			printCurrentLevel(root, i);
		}

	}

	private void printCurrentLevel(Node root, int level) {
		if (root == null)
			return;
		if (level ==1)
			System.out.print(root.key + " ");
		else if(level > 1) {
			printCurrentLevel(root.left, level - 1);
			printCurrentLevel(root.right, level - 1);
		}
	}

	//method to show sibling value
	public Node showSiblingValue(Node node, int value) {
		//case if node doesn't exist
		if (node == null)
			return null;

		Node parentNode = null; //acts as temporary node to save data

		//while loop to find sibling node
		while (node != null) {
			if (value < node.key) { //traverse left subtree if value < key
				parentNode = node;
				node = node.left;
			}
			else if (value > node.key) { //traverse right subtree if value > key
				parentNode = node;
				node = node.right;
			}
			else break;
		}

		if (value == parentNode.left.key) {
			return parentNode.right;
		}
		else if (value == parentNode.right.key) {
			return parentNode.left;
		}
		return null;
	}

	//wrappers
	public void printInorder() {
		printInorder(root);
	}

	public void printPreorder() {
		printPreorder(root);
	}

	public void printPostorder() {
		printPostorder(root);
	}

}
