/**
 * https://leetcode.cn/problems/sort-characters-by-frequency/
 * 
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * 
 * 返回 已排序的字符串 。如果有多个答案，返回其中任何一个。
 * 
 * 示例 1:
 * 输入: s = "tree"
 * 输出: "eert"
 * 解释: 'e'出现两次，'r'和't'都只出现一次。
 * 因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 
 * 示例 2:
 * 输入: s = "cccaaa"
 * 输出: "cccaaa"
 * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效答案。
 * 注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 
 * 示例 3:
 * 输入: s = "Aabb"
 * 输出: "bbAa"
 * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
 * 注意'A'和'a'被认为是两种不同的字符。
 * 
 * 提示:
 * 1 <= s.length <= 5 * 10⁵
 * s 由大小写英文字母和数字组成
 */
public class L0451_SortCharactersByFrequency {
    
    public String frequencySort(String s) {
        // 使用数组统计每个字符的频率
        int[] freq = new int[128];
        for (char c : s.toCharArray()) {
            freq[c]++;
        }
        
        // 创建一个优先队列，按照频率降序排序
        java.util.PriorityQueue<Character> pq = new java.util.PriorityQueue<>((a, b) -> {
            if (freq[b] != freq[a]) {
                return freq[b] - freq[a];
            }
            return a - b;
        });
        
        // 将所有出现过的字符加入优先队列
        for (int i = 0; i < 128; i++) {
            if (freq[i] > 0) {
                pq.offer((char) i);
            }
        }
        
        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            char c = pq.poll();
            // 重复频率次数添加字符
            for (int i = 0; i < freq[c]; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0451_SortCharactersByFrequency solution = new L0451_SortCharactersByFrequency();
        
        // 测试用例 1
        String s1 = "tree";
        System.out.println("测试用例 1 输入：" + s1);
        System.out.println("测试用例 1 输出：" + solution.frequencySort(s1));
        
        // 测试用例 2
        String s2 = "cccaaa";
        System.out.println("\n测试用例 2 输入：" + s2);
        System.out.println("测试用例 2 输出：" + solution.frequencySort(s2));
        
        // 测试用例 3
        String s3 = "Aabb";
        System.out.println("\n测试用例 3 输入：" + s3);
        System.out.println("测试用例 3 输出：" + solution.frequencySort(s3));
    }
} 