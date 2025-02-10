import java.util.*;

/**
 * https://leetcode.cn/problems/palindrome-permutation-ii/
 * 
 * 给定一个字符串 s ，返回其通过重新排列组合后所有可能的回文字符串，并去除重复的组合。
 * 如不能形成任何回文排列时，则返回一个空列表。
 * 
 * 示例 1：
 * 输入: "aabb"
 * 输出: ["abba", "baab"]
 * 
 * 示例 2：
 * 输入: "abc"
 * 输出: []
 */
public class L0267_PalindromePermutationII {
    
    public List<String> generatePalindromes(String s) {
        // 统计每个字符出现的次数
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        
        // 检查是否可以形成回文串
        // 最多只能有一个字符出现奇数次
        char oddChar = 0;
        int oddCount = 0;
        List<Character> halfChars = new ArrayList<>();
        
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            
            if (count % 2 == 1) {
                oddChar = c;
                oddCount++;
                if (oddCount > 1) {
                    return new ArrayList<>(); // 不能形成回文串
                }
            }
            // 将一半的字符加入列表
            for (int i = 0; i < count / 2; i++) {
                halfChars.add(c);
            }
        }
        
        // 生成所有可能的排列
        Set<String> result = new HashSet<>();
        boolean[] used = new boolean[halfChars.size()];
        backtrack(halfChars, used, new StringBuilder(), oddChar, result);
        
        return new ArrayList<>(result);
    }
    
    private void backtrack(List<Character> halfChars, boolean[] used, 
            StringBuilder current, char oddChar, Set<String> result) {
        if (current.length() == halfChars.size()) {
            // 构建回文串
            String half = current.toString();
            String reversedHalf = new StringBuilder(half).reverse().toString();
            if (oddChar != 0) {
                result.add(half + oddChar + reversedHalf);
            } else {
                result.add(half + reversedHalf);
            }
            return;
        }
        
        for (int i = 0; i < halfChars.size(); i++) {
            if (used[i] || (i > 0 && halfChars.get(i) == halfChars.get(i-1) && !used[i-1])) {
                continue;
            }
            used[i] = true;
            current.append(halfChars.get(i));
            backtrack(halfChars, used, current, oddChar, result);
            current.setLength(current.length() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        L0267_PalindromePermutationII solution = new L0267_PalindromePermutationII();
        
        // 测试用例 1
        System.out.println(solution.generatePalindromes("aabb"));  // 应该输出 ["abba", "baab"]
        
        // 测试用例 2
        System.out.println(solution.generatePalindromes("abc"));   // 应该输出 []
        
        // 测试用例 3：包含重复字符
        System.out.println(solution.generatePalindromes("aaaa"));  // 应该输出 ["aaaa"]
        
        // 测试用例 4：奇数长度
        System.out.println(solution.generatePalindromes("aabbc")); // 应该输出 ["abcba", "bacab"]
    }
} 