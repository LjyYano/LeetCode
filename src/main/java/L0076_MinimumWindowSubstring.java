/**
 * https://leetcode.cn/problems/minimum-window-substring/
 * 
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * 
 * 注意：
 * - 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * - 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 
 * 示例 2：
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 
 * 示例 3:
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，因此没有符合条件的子字符串，返回空字符串。
 * 
 * 提示：
 * - m == s.length
 * - n == t.length
 * - 1 <= m, n <= 10⁵
 * - s 和 t 由英文字母组成
 * 
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
class L0076_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        // 如果 s 或 t 为空，直接返回空字符串
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }

        // 记录 t 中每个字符出现的次数
        int[] need = new int[128];
        // 记录窗口中每个字符出现的次数
        int[] window = new int[128];

        // 统计 t 中字符出现次数
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        // 记录最小覆盖子串的起始位置和长度
        int start = 0, minLen = Integer.MAX_VALUE;
        // 左右指针，用于滑动窗口
        int left = 0, right = 0;
        // 记录已经找到的 t 中字符的个数
        int count = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            // 扩大窗口
            window[c]++;
            // 如果找到了一个需要的字符
            if (need[c] > 0 && window[c] <= need[c]) {
                count++;
            }

            // 当找到了所有需要的字符后，尝试缩小窗口
            while (count == t.length()) {
                // 更新最小覆盖子串
                if (right - left + 1 < minLen) {
                    start = left;
                    minLen = right - left + 1;
                }

                char d = s.charAt(left);
                // 缩小窗口
                window[d]--;
                // 如果移除了一个需要的字符
                if (need[d] > 0 && window[d] < need[d]) {
                    count--;
                }
                left++;
            }
            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        L0076_MinimumWindowSubstring solution = new L0076_MinimumWindowSubstring();

        // 测试用例 1
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        System.out.println("测试用例 1:");
        System.out.println("输入: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("输出: \"" + solution.minWindow(s1, t1) + "\"");
        System.out.println();

        // 测试用例 2
        String s2 = "a", t2 = "a";
        System.out.println("测试用例 2:");
        System.out.println("输入: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("输出: \"" + solution.minWindow(s2, t2) + "\"");
        System.out.println();

        // 测试用例 3
        String s3 = "a", t3 = "aa";
        System.out.println("测试用例 3:");
        System.out.println("输入: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("输出: \"" + solution.minWindow(s3, t3) + "\"");
    }
} 