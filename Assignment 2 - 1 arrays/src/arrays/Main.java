package arrays;

import java.util.*;

public class Main {

    public static void main(String[] args) {
		int newArray[] = new int[10];
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			System.out.println("Enter number: ");
			int input = sc.nextInt();
			newArray[i] = input;
		}

		for (int i = 0; i < 10; i++) {
			System.out.println((i+1) + ". " + newArray[i]);
		}
    }
}
