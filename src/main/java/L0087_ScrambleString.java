/**
 * https://leetcode.cn/problems/scramble-string/
 * 
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 1. 如果字符串的长度为 1 ，算法停止
 * 2. 如果字符串的长度 > 1 ，执行下述步骤：
 *    - 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 *    - 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 *    - 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * 
 * 示例 1：
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情况是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/at" // 继续递归执行此算法，都将忽略。因为将字符串分割成单个字符时，算法停止
 * 最终得到的字符串为 "rgeat" ，这是 s2 的一种排列，因此返回 true
 * 
 * 示例 2：
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 
 * 示例 3：
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 * 
 * 提示：
 * - s1.length == s2.length
 * - 1 <= s1.length <= 30
 * - s1 和 s2 由小写英文字母组成
 */
public class L0087_ScrambleString {
    
    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        // dp[i][j][len] 表示从 s1 的 i 位置和 s2 的 j 位置开始，长度为 len 的子串是否互为扰乱字符串
        boolean[][][] dp = new boolean[n][n][n + 1];
        
        // 初始化长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        // 枚举长度 len，从 2 到 n
        for (int len = 2; len <= n; len++) {
            // 枚举 s1 的起始位置 i
            for (int i = 0; i <= n - len; i++) {
                // 枚举 s2 的起始位置 j
                for (int j = 0; j <= n - len; j++) {
                    // 枚举分割点，将字符串分为两部分
                    for (int k = 1; k < len; k++) {
                        // 不交换的情况：
                        // s1 的 [i, i+k) 和 s2 的 [j, j+k) 互为扰乱字符串
                        // 且 s1 的 [i+k, i+len) 和 s2 的 [j+k, j+len) 互为扰乱字符串
                        boolean noSwap = dp[i][j][k] && dp[i + k][j + k][len - k];
                        
                        // 交换的情况：
                        // s1 的 [i, i+k) 和 s2 的 [j+len-k, j+len) 互为扰乱字符串
                        // 且 s1 的 [i+k, i+len) 和 s2 的 [j, j+len-k) 互为扰乱字符串
                        boolean swap = dp[i][j + len - k][k] && dp[i + k][j][len - k];
                        
                        // 只要有一种情况成立，就说明长度为 len 的子串互为扰乱字符串
                        if (noSwap || swap) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        
        return dp[0][0][n];
    }

    public static void main(String[] args) {
        L0087_ScrambleString solution = new L0087_ScrambleString();

        // 测试用例 1
        String s1 = "great";
        String s2 = "rgeat";
        System.out.println("测试用例 1：");
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("结果：" + solution.isScramble(s1, s2)); // 应输出 true
        System.out.println();

        // 测试用例 2
        s1 = "abcde";
        s2 = "caebd";
        System.out.println("测试用例 2：");
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("结果：" + solution.isScramble(s1, s2)); // 应输出 false
        System.out.println();

        // 测试用例 3
        s1 = "a";
        s2 = "a";
        System.out.println("测试用例 3：");
        System.out.println("s1 = " + s1 + ", s2 = " + s2);
        System.out.println("结果：" + solution.isScramble(s1, s2)); // 应输出 true
    }
} 