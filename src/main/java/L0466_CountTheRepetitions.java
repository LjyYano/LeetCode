/**
 * https://leetcode.cn/problems/count-the-repetitions/
 * 
 * 定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。
 * 
 * 例如，str == ["abc", 3] =="abcabcabc" 。
 * 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 中获取。
 * 
 * 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 中获取，仅需要删除加粗且用斜体标识的字符。
 * 现在给你两个字符串 s1 和 s2 以及两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。
 * 
 * 请你找出一个最大整数 m ，以满足 str = [s1, m] 可以从 str2 中获取。
 * 
 * 示例 1：
 * 输入：s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
 * 输出：2
 * 
 * 示例 2：
 * 输入：s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
 * 输出：1
 * 
 * 提示：
 * 1 <= s1.length, s2.length <= 100
 * 1 <= n1, n2 <= 10⁶
 * s1 和 s2 由小写英文字母组成
 */
public class L0466_CountTheRepetitions {
    
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        // 如果 s2 中的任一字符在 s1 中不存在，直接返回 0
        for (char c : s2.toCharArray()) {
            if (s1.indexOf(c) == -1) {
                return 0;
            }
        }
        
        // 记录每个 s1 串匹配 s2 的情况
        int[] repeatCount = new int[n1 + 1];  // 匹配完第 i 个 s1 后，s2 出现的次数
        int[] nextIndex = new int[n1 + 1];    // 匹配完第 i 个 s1 后，s2 下一个待匹配字符的位置
        
        int j = 0;  // s2 中待匹配字符的位置
        int cnt = 0;  // s2 出现的次数
        
        // 遍历 s1 的每一个副本
        for (int k = 1; k <= n1; k++) {
            // 遍历当前 s1 的每一个字符
            for (int i = 0; i < s1.length(); i++) {
                // 如果当前字符匹配 s2 中待匹配的字符
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;  // 移动 s2 的匹配位置
                    // 如果 s2 已经匹配完一次
                    if (j == s2.length()) {
                        j = 0;  // 重置 s2 的匹配位置
                        cnt++;  // 增加 s2 的匹配次数
                    }
                }
            }
            repeatCount[k] = cnt;
            nextIndex[k] = j;
            
            // 检查是否出现循环
            for (int start = 0; start < k; start++) {
                if (nextIndex[start] == j) {
                    // 找到循环，计算结果
                    int cycleLen = k - start;  // 循环长度
                    int cycleNum = (n1 - start) / cycleLen;  // 完整的循环次数
                    int cycleCount = (repeatCount[k] - repeatCount[start]) * cycleNum;  // 循环部分的 s2 出现次数
                    int remainNum = (n1 - start) % cycleLen;  // 剩余的 s1 个数
                    int remainCount = repeatCount[start + remainNum] - repeatCount[start];  // 剩余部分的 s2 出现次数
                    
                    return (cycleCount + remainCount) / n2;
                }
            }
        }
        
        // 如果没有找到循环，直接计算结果
        return repeatCount[n1] / n2;
    }

    public static void main(String[] args) {
        L0466_CountTheRepetitions solution = new L0466_CountTheRepetitions();
        
        // 测试用例 1
        System.out.println("测试用例 1 结果：" + solution.getMaxRepetitions("acb", 4, "ab", 2));  // 预期输出：2
        
        // 测试用例 2
        System.out.println("测试用例 2 结果：" + solution.getMaxRepetitions("acb", 1, "acb", 1));  // 预期输出：1
    }
} 