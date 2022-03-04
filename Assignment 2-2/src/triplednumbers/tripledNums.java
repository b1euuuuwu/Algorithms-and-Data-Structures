package triplednumbers;

import java.util.*;

public class tripledNums {
	private int[] array = new int[10];
	private int[] tripledArray = new int[10];
	Scanner sc = new Scanner(System.in);

	//constructor
	public tripledNums() {
		array = new int[10];
	}

	public void receiveInput() {
		for (int i = 0; i<10; i++) {
			System.out.println("Insert number: ");
			int input = sc.nextInt();
			array[i] = input;
		}
	}

	public void tripleNumbs() {
		for (int i = 0; i<10; i++) {
			int tripledNum = array[i] * 3;
			tripledArray[i] = tripledNum;
		}
	}

	public void printArray() {
		for (int i = 0; i<10; i++) {
			System.out.println((i+1) + ". " + tripledArray[i]);
		}
	}
}
