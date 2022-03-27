package heaptree;

public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;

	public Heap(int max) {
		maxSize = max;
		currentSize = 0;
		heapArray = new Node[maxSize+1];
	}

	public boolean isEmpty() {
		return currentSize == 0;
	}

	public boolean isFull() {
		return currentSize == maxSize;
	}

	public boolean hasLeft(int index) {
		return 2*index <= currentSize;
	}

	public boolean hasRight(int index) {
		return 2*index + 1 <= currentSize;
	}

	public boolean insert(int key) {
		if (isFull()) {
			return false;
		}

		Node newNode = new Node(key);
		currentSize++;
		heapArray[currentSize] = newNode;
		trickleUp(currentSize);
		return true;
	}

	private void trickleUp(int index) {
		int parent = index/2;
		Node bottom = heapArray[index];

		while(index > 1 && heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = index/2;
		}

		heapArray[index] = bottom;
	}

	public Node remove() {
		Node root = heapArray[1];
		heapArray[1] = heapArray[currentSize];
		currentSize--;
		trickleDown(1);
		return root;
	}

	private void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];

		while (hasLeft(index)) {
			int left = 2*index;
			int right = left + 1;

			if (hasRight(index) && heapArray[right].getKey() > heapArray[left].getKey()) {
				largerChild = right;
			} else {
				largerChild = left;
			}

			if (top.getKey() >= heapArray[largerChild].getKey()) {
				break;
			}

			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}

	public void displayHeap() {
		System.out.print("Heap Array: ");

		for (int i = 1; i <= currentSize; i++) {
			System.out.print(heapArray[i].getKey() + " ");
		}
	}
}
