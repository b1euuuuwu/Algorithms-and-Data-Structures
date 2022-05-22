package StringMatching;

public class StringMatcher {
	public static void naive(String text, String pattern) {
		long start = System.nanoTime();
		int textLen = text.length();
		int patternLen = pattern.length();
		int patternsFound = 0;

		boolean found = false;

		for (int i = 0; i+patternLen <= textLen; i++) {
			boolean curr_found = true;
			for (int j = 0; j<patternLen; j++) {
				if (text.charAt(i+j) != pattern.charAt(j)) {
					curr_found = false;
					break;
				}
			}
			if (curr_found) {
				found = true;
				patternsFound +=1;;
			}
		}
		if (!found)
			System.out.println("Pattern not found using naive");
		System.out.println("There are " + patternsFound + " patterns (naive)");
	}

	private static int[] computeLPSArray(String str) {
		int len = str.length();

		int lps[] = new int[len];
		lps[0] = 0;

		for (int i=1; i<len; i++) {
			int j = lps[i-1];

			while((j>0) && (str.charAt(i) != str.charAt(j)))
				j = lps[j-1];
			if (str.charAt(i) == str.charAt(j))
				j++;
			lps[i] = j;
		}
		return lps;
	}

	public static void kmp(String text, String pattern) {
		String combined = pattern + "#" + text;
		int combinedLen = combined.length();
		int patternLen = pattern.length();
		int patternsFound = 0;

		int lps[] = computeLPSArray(combined);

		boolean found = false;
		for (int i = patternLen+1; i<combinedLen; i++)
			if(lps[i] == patternLen) {
				found = true;
				patternsFound +=1;
			}
		if (!found)
			System.out.println("Pattern not found using KMP");
		System.out.println("There are " + patternsFound + " patterns (KMP)");
	}
}
