
// https://leetcode-cn.com/problems/wildcard-matching/
class L0044_Wildcard_Matching {
    public boolean isMatch(String s, String p) {
		char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();
		boolean[][] dp = new boolean[string.length + 1][pattern.length + 1];
		dp[0][0] = true;
        
        for(int i = 1; i <= pattern.length; i++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }

		for (int i = 1; i <= string.length; i++) {
			for (int j = 1; j <= pattern.length; j++) {
				if (pattern[j - 1] == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				} else if (string[i - 1] == pattern[j - 1] || pattern[j - 1] == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				}
			}
		}

		return dp[string.length][pattern.length];
	}
}