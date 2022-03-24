package binarysearchtree;

public class BinarySearchTree {
	Node root;

	BinarySearchTree() {
		root = null;
	}

	void insert(int key) {
		root = insertKey(root, key);
	}

	// Insert key in the tree
	Node insertKey(Node root, int key) {
		// Return a new node if the tree is empty
		if (root == null) {
			root = new Node(key);
			return root;
		}

		// Traverse to the right place and insert the node
		if (key < root.key)
			root.left = insertKey(root.left, key);
		else if (key > root.key)
			root.right = insertKey(root.right, key);

		return root;
	}

	void inorder() {
		inorder(root);
	}

	// Inorder Traversal
	void inorder(Node root) {
		if (root != null) {
			// Recur left subtree
			inorder(root.left);
			// Print the root
			System.out.print(root.key + " -> ");
			// Recur right subtree
			inorder(root.right);
		}
	}

	void deleteKey(int key) {
		root = deleteRecursive(root, key);
	}

	Node deleteRecursive(Node root, int key) {
		// Return if the tree is empty
		if (root == null)
			return root;

		// Find the node to be deleted
		if (key < root.key)
			root.left = deleteRecursive(root.left, key);
		else if (key > root.key)
			root.right = deleteRecursive(root.right, key);
		else {
			// If the node is with only one child or no child
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;

			// If the node has two children
			// Place the inorder successor in position of the node to be deleted
			root.key = minValue(root.right);

			// Delete the inorder successor
			root.right = deleteRecursive(root.right, root.key);
		}

		return root;
	}

	// Find the inorder successor
	int minValue(Node root) {
		int min = root.key;
		while (root.left != null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}
}
