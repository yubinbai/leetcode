package leetcode.minWindow.allElements;

/**
 * Given a set T of characters and a string S, find the minimum window in S
 * which will contain all the characters in T in complexity O(n).
 * 
 * eg, S = “ADOBECODEBANC” T = “ABC”
 * 
 * Minimum window is “BANC”.
 * 
 */
public class MinWindow {

	public static String getWindow(String source, String target) {

		char S[] = source.toCharArray();
		char T[] = target.toCharArray();
		int needToFind[] = new int[256]; // goal in target
		for (int i = 0; i < target.length(); i++)
			needToFind[T[i]]++;

		int hasFound[] = new int[256];
		int minWindowLen = Integer.MAX_VALUE;
		int minWindowBegin = 0, minWindowEnd = 0;
		int countFound = 0; // found characters

		for (int begin = 0, end = 0; end < source.length(); end++) {
			// skip characters not in T
			if (needToFind[S[end]] == 0)
				continue;
			hasFound[S[end]]++;
			if (hasFound[S[end]] <= needToFind[S[end]])
				countFound++;

			// if window constraint is satisfied
			if (countFound == target.length()) {
				// advance begin index as far right as possible,
				// stop when advancing breaks window constraint.
				while (needToFind[S[begin]] == 0
						|| hasFound[S[begin]] > needToFind[S[begin]]) {
					if (hasFound[S[begin]] > needToFind[S[begin]])
						hasFound[S[begin]]--;
					begin++;
				}

				// update minWindow if a minimum length is met
				int windowLen = end - begin + 1;
				if (windowLen < minWindowLen) {
					minWindowBegin = begin;
					minWindowEnd = end;
					minWindowLen = windowLen;
				} // end if
			} // end if
		} // end for

		return (countFound == target.length()) ? source.substring(
				minWindowBegin, minWindowEnd + 1) : "";
	}

}
