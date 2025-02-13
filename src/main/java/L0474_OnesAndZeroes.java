/**
 * https://leetcode.cn/problems/ones-and-zeroes/
 * 
 * @author Yano
 * @since 2024/03/19
 */
public class L0474_OnesAndZeroes {

    public int findMaxForm(String[] strs, int m, int n) {
        // dp[i][j] represents the maximum size of subset with i zeros and j ones
        int[][] dp = new int[m + 1][n + 1];
        
        for (String str : strs) {
            int zeros = 0, ones = 0;
            // Count zeros and ones in current string
            for (char c : str.toCharArray()) {
                if (c == '0') zeros++;
                else ones++;
            }
            
            // Update dp array from bottom-right to top-left
            // to avoid using same string multiple times
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        L0474_OnesAndZeroes solution = new L0474_OnesAndZeroes();
        
        // Test case 1
        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        System.out.println(solution.findMaxForm(strs1, 5, 3)); // Expected output: 4
        
        // Test case 2
        String[] strs2 = {"10", "0", "1"};
        System.out.println(solution.findMaxForm(strs2, 1, 1)); // Expected output: 2
    }
} 