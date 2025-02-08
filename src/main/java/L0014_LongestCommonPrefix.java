/**
 * 题目链接：https://leetcode.cn/problems/longest-common-prefix/
 * 
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 
 * 示例 1：
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class L0014_LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        // 如果数组为空，返回空字符串
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // 如果数组只有一个字符串，返回该字符串
        if (strs.length == 1) {
            return strs[0];
        }
        
        // 以第一个字符串为基准
        String first = strs[0];
        
        // 遍历第一个字符串的每个字符
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            // 与其他字符串比较当前位置的字符
            for (int j = 1; j < strs.length; j++) {
                // 如果其他字符串已经到达末尾，或者字符不匹配
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // 返回当前已匹配的子串
                    return first.substring(0, i);
                }
            }
        }
        
        // 如果循环结束还没有返回，说明第一个字符串就是最长公共前缀
        return first;
    }

    public static void main(String[] args) {
        L0014_LongestCommonPrefix solution = new L0014_LongestCommonPrefix();
        
        // 测试用例 1
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("测试用例 1 结果：" + solution.longestCommonPrefix(strs1));  // 预期输出：fl
        
        // 测试用例 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("测试用例 2 结果：" + solution.longestCommonPrefix(strs2));  // 预期输出：""
        
        // 测试用例 3：空数组
        String[] strs3 = {};
        System.out.println("测试用例 3 结果：" + solution.longestCommonPrefix(strs3));  // 预期输出：""
        
        // 测试用例 4：只有一个字符串
        String[] strs4 = {"alone"};
        System.out.println("测试用例 4 结果：" + solution.longestCommonPrefix(strs4));  // 预期输出：alone
    }
} 