package avltree;

public class AVLTree {
	public Node root;
	int leftHeight = 0, rightHeight = 0;

	public void addNode(Node node) {
		if (root == null) {
			root = node;
		}
		else {
			insertNode (root, node);
		}
	}

	public void insertNode(Node parent, Node node) {
		if (parent.getKey() > node.getKey()) {
			if (parent.left == null) {
				parent.left = node;
			}
			else {
				insertNode(parent.left, node);
			}
		}
		else {
			if (parent.right == null) {
				parent.right = node;
			}
			else {
				insertNode(parent.right, node);
			}
		}
	}

	public int getHeight(Node root) {
		if (root == null) {
			return 0;
		}
		else {
			if (root.left != null) {
				leftHeight = getHeight(root.left) + 1;
			}
			else if (root.right != null) {
				rightHeight = getHeight(root.right) + 1;
			}

			return leftHeight >= rightHeight ? leftHeight : rightHeight;
		}
	}

	public boolean checkAVL(Node root) {

		if (root == null) {
			return true;
		}

		leftHeight = getHeight(root.left);
		rightHeight = getHeight(root.right);

		if (Math.abs(leftHeight - rightHeight) <= 1 && checkAVL(root.left) && checkAVL(root.right)) {
			return true;
		}
		return false;
	}

	public String printAVLCheck() {
		if (checkAVL(this.root)) {
			return "This binary tree is an AVL tree";
		}
		return "This binary tree is not an AVL tree";
	}
}
