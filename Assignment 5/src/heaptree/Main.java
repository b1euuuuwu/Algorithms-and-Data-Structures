package heaptree;

import java.util.Arrays;

public class Main {

	public static void heapify(int[] array, int length, int i) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest = i;
		if (left < length && array[left] > array[largest]) {
			largest = left;
		}
		if (right < length && array[right] > array[largest]) {
			largest = right;
		}
		if (largest != i) {
			int tmp = array[i];
			array[i] = array[largest];
			array[largest] = tmp;
			heapify(array, length, largest);
		}
	}

	public static void heapSort(int[] array) {
		if (array.length == 0) {
			return;
		}

		int length = array.length;

		// Moving from the first element that isn't a leaf towards the root
		for (int i = length / 2 - 1; i >= 0; i--) {
			heapify(array, length, i);
		}

		for (int i = length - 1; i >= 0; i--) {
			int tmp = array[0];
			array[0] = array[i];
			array[i] = tmp;
			heapify(array, i, 0);
		}
	}

    public static void main(String[] args) {
		int[] data = new int[]{78, 3, 9, 10, 23, 77, 34, 86, 90, 100, 20, 66, 94, 63, 97};
		Heap tree = new Heap(15);

		for (int i = 0 ; i < data.length; i++) {
			tree.insert(data[i]);
		}

		tree.displayHeap();

		heapSort(data);
		System.out.println("\nHeap Sort: " + Arrays.toString(data));
    }
}
