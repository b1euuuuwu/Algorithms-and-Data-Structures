package palindrome;

public class WordChecker {
	String stringBefore;
	String reversedString;

	public WordChecker(String input) {
		stringBefore = input;
	}

	public String reverseString() {
		StringBuilder stringAfter = new StringBuilder();

		stringAfter.append(stringBefore);
		return String.valueOf(stringAfter.reverse());
	}

	public void palindromeCheck() {
		reversedString = reverseString();

		if (reversedString.equals(stringBefore)) {
			System.out.println("it is palindrome");
		} else {
			System.out.println("not palindrome");
		}
	}
}
