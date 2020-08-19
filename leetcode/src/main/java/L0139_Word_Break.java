import java.util.Arrays;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/word-break/
class L0139_Word_Break {
    public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return false;
		}
		Set<String> set = new HashSet<>(wordDict);
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (dp[j] && set.contains(s.substring(j, i + 1))) {
					dp[i + 1] = true;
					break;
				}
			}
			// System.out.println(Arrays.toString(dp));
		}
		return dp[s.length()];
	}
}