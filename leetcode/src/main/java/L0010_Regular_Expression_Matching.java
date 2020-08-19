import java.util.Arrays;

// https://leetcode-cn.com/problems/regular-expression-matching/
class L0010_Regular_Expression_Matching {
    public boolean isMatch(String s, String p) {
        char[] string = s.toCharArray();
		char[] pattern = p.toCharArray();
		boolean[][] dp = new boolean[string.length + 1][pattern.length + 1];
		dp[0][0] = true;
        
        for(int i = 2; i <= pattern.length; i++) {
            if(pattern[i - 1] == '*') dp[0][i] = dp[0][i - 2];
        }

		for (int i = 1; i <= string.length; i++) {
			for (int j = 1; j <= pattern.length; j++) {
                if (pattern[j - 1] == string[i - 1] || pattern[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if(pattern[j - 1] == '*') {
                    if(!dp[i][j - 1] && j >= 2) {
                        dp[i][j] = dp[i][j - 2] || ((string[i - 1] == pattern[j - 2] || pattern[j - 2] == '.') && dp[i - 1][j]);
                    } else if(dp[i][j - 1]) {
                        dp[i][j] = dp[i - 1][j] && (string[i - 1] == pattern[j - 2] || pattern[j - 2] == '.');
                    }
                }
			}
            //System.out.println(Arrays.deepToString(dp));
		}

		return dp[string.length][pattern.length];
    }
}