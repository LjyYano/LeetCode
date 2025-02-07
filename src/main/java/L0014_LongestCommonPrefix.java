/**
 * 最长公共前缀
 * https://leetcode.cn/problems/longest-common-prefix/
 */
public class L0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        // 处理边界情况
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // 使用第一个字符串作为基准
        String firstStr = strs[0];
        
        // 遍历第一个字符串的每个字符
        for (int i = 0; i < firstStr.length(); i++) {
            char c = firstStr.charAt(i);
            
            // 与其他字符串比较当前位置的字符
            for (int j = 1; j < strs.length; j++) {
                // 如果当前字符串已经到达末尾，或者字符不匹配
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // 返回当前位置之前的子串
                    return firstStr.substring(0, i);
                }
            }
        }
        
        // 如果循环正常结束，说明第一个字符串就是最长公共前缀
        return firstStr;
    }

    public static void main(String[] args) {
        L0014_LongestCommonPrefix solution = new L0014_LongestCommonPrefix();
        
        // 测试用例 1：有公共前缀
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Input: [\"flower\", \"flow\", \"flight\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs1) + "\"");
        System.out.println("Expected: \"fl\"");
        System.out.println();
        
        // 测试用例 2：无公共前缀
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Input: [\"dog\", \"racecar\", \"car\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs2) + "\"");
        System.out.println("Expected: \"\"");
        System.out.println();
        
        // 测试用例 3：空数组
        String[] strs3 = {};
        System.out.println("Input: []");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs3) + "\"");
        System.out.println("Expected: \"\"");
        System.out.println();
        
        // 测试用例 4：单个字符串
        String[] strs4 = {"hello"};
        System.out.println("Input: [\"hello\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs4) + "\"");
        System.out.println("Expected: \"hello\"");
        System.out.println();
        
        // 测试用例 5：包含空字符串
        String[] strs5 = {"", "b"};
        System.out.println("Input: [\"\", \"b\"]");
        System.out.println("Output: \"" + solution.longestCommonPrefix(strs5) + "\"");
        System.out.println("Expected: \"\"");
    }
} 