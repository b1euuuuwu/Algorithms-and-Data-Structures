package avltree;

public class Node {
	public int key;
	public Node left;
	public Node right;

	Node (int value) {
		this.key = value;
	}

	public int getKey() {
		return key;
	}
}
