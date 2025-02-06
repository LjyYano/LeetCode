import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/word-break-ii/
class L0140_Word_Break_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
		List<String> ans = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return ans;
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
		}
        if(dp[s.length()]) {
            robot(s, 0, set, ans, "", dp);
        }
		return ans;
	}

	private void robot(String s, int start, Set<String> set, List<String> ans, String out, boolean[] dp) {
		if (start == s.length()) {
			ans.add(out.substring(0, out.length() - 1));
			return;
		}

		for (int i = start; i < s.length(); i++) {
			String word = s.substring(start, i + 1);
			if (dp[i + 1] && set.contains(word)) {
				robot(s, i + 1, set, ans, out + word + " ", dp);
			}
		}
	}
}