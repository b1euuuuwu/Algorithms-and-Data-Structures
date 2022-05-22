package StringMatching;

public class Main {
	public static void execTime(String text, String pattern) {
		long start1 = System.nanoTime();
		StringMatcher.naive(text, pattern);
		long end1 = System.nanoTime();
		long exec1 = end1 - start1;
		System.out.println("Execution time: " + exec1 + " nanoseconds\n");

		long start2 = System.nanoTime();
		StringMatcher.kmp(text, pattern);
		long end2 = System.nanoTime();
		long exec2 = end2 - start2;
		System.out.println("Execution time: " + exec2 + " nanoseconds");
	}

	public static void numberThree() {
		StringBuilder s = new StringBuilder("erwineko");
		StringBuilder t = new StringBuilder("ekoerwin");
		int cycleShifts = 0;
		int tries = 0;
		boolean anagramFound = false;

		System.out.println("\n3. \n" + t.toString()); //space
		while (anagramFound == false) {
			char lastLetter = t.charAt(0);
			t.deleteCharAt(0);
			String new_t = String.valueOf(t.append(lastLetter));
			System.out.println(new_t.toString());
			cycleShifts += 1;
			tries +=1;
			if (String.valueOf(new_t).equals(String.valueOf(s)))
				anagramFound = true;
			else if (tries > (String.valueOf(t)).length())
				System.out.println("No match can be found");
		}
		if (anagramFound)
			System.out.println("\ns can be shifted into t\nIt took " + cycleShifts + " cycle shifts to find t");
	}

	public static void main(String[] args) {
		// Ans num. 1
		String text1 = "", pattern1 = "";

		System.out.println("1. ");

		while (text1.length() <= 100000)
			text1 += 'a';
		while (pattern1.length() <= 10000)
			pattern1 += 'a';
		pattern1 += 'b';

		execTime(text1, pattern1);

		// Ans num. 2
		String text2 = "", pattern2 = "";

		System.out.println("\n2. ");

		while (text2.length() <= 100000)
			text2 += 'a';
		while (pattern2.length() <= 10000)
			pattern2 += 'a';

		execTime(text2, pattern2);

		//Ans num. 3
		numberThree();
	}
}
