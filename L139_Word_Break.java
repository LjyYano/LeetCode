package LeetCode;

import java.util.Set;

public class L139_Word_Break {

	public static boolean wordBreak(String s, Set<String> wordDict) {

		boolean[] P = new boolean[s.length() + 1];
		P[0] = true;

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (P[j] && wordDict.contains(s.substring(j, i + 1))) {
					P[i + 1] = true;
				}
			}
		}

		return P[s.length()];
	}

}
