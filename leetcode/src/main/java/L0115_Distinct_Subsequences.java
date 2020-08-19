
// https://leetcode-cn.com/problems/distinct-subsequences/
class L0115_Distinct_Subsequences {
    public int numDistinct(String S, String T) {
        // array creation
        int[][] dp = new int[T.length()+1][S.length()+1];

        // filling the first row: with 1s
        for(int j=0; j<=S.length(); j++) {
            dp[0][j] = 1;
        }

        // the first column is 0 by default in every other rows but the first, which we need.

        /**
             S = [acdabefbc]
        mem[1] = [0111222222]
        mem[2] = [0000022244]
        **/
        for(int i=0; i<T.length(); i++) {
            for(int j=0; j<S.length(); j++) {
                if(T.charAt(i) == S.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j];
                } else {
                    dp[i+1][j+1] = dp[i+1][j];
                }
            }
        }

        return dp[T.length()][S.length()];
    }
}