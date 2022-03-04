package arrays;

import java.util.*;

public class List {
	int numInput;
	int numAmount;
	LinkedList<Integer> linkedList = new LinkedList<>();
	Scanner sc = new Scanner(System.in);

	//constructor
	public List() {
		this.numInput = 0;
	}

	public int getNumInput() {
		return numInput;
	}

	public LinkedList<Integer> getLinkedList() {
		return linkedList;
	}

	public void setNumInput(int d) {
		numInput = d;
	}

	public void insertElement() {
		int i = 1;
		System.out.println("How many numbers would you like to input? ");
		numAmount = sc.nextInt();

		while (i <= numAmount) {
			System.out.println("Enter number: ");
			setNumInput(sc.nextInt());
			linkedList.add(getNumInput());
			i++;
		}
	}

	public void printElements() {
		for (int a = 0; a < linkedList.size(); a++) {
			System.out.println((a+1) + ". " + linkedList.get(a));
		}
	}
}
