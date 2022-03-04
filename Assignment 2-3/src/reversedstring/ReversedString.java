package reversedstring;

import java.util.*;
import java.lang.*;


public class ReversedString {
	String stringBefore;
	Scanner sc = new Scanner(System.in);

	public ReversedString() {
		stringBefore = "";
	}

	//method to reverse string with StringBuilder
	public void reverseString() {
		System.out.print("Enter your word: ");
		stringBefore = sc.next();
		StringBuilder stringAfter = new StringBuilder();

		stringAfter.append(stringBefore);
		stringAfter.reverse();

		System.out.println(stringAfter);
	}
}
