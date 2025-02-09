import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/
 * 
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * 
 * 示例 1:
 * 输入: strs = ["eat","tea","tan","ate","nat","bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 
 * 示例 2:
 * 输入: strs = [""]
 * 输出: [[""]]
 * 
 * 示例 3:
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * 
 * 提示：
 * 1 <= strs.length <= 10⁴
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 */
public class L0049_GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        // 特殊情况处理
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        
        // 使用 HashMap 存储排序后的字符串和对应的原始字符串列表
        Map<String, List<String>> map = new HashMap<>();
        
        // 遍历每个字符串
        for (String str : strs) {
            // 将字符串转换为字符数组并排序
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            
            // 将原始字符串添加到对应的列表中
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        
        // 返回所有分组
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        L0049_GroupAnagrams solution = new L0049_GroupAnagrams();
        
        // 测试用例 1
        String[] strs1 = {"eat","tea","tan","ate","nat","bat"};
        System.out.println("测试用例 1：");
        System.out.println(solution.groupAnagrams(strs1));
        
        // 测试用例 2
        String[] strs2 = {""};
        System.out.println("测试用例 2：");
        System.out.println(solution.groupAnagrams(strs2));
        
        // 测试用例 3
        String[] strs3 = {"a"};
        System.out.println("测试用例 3：");
        System.out.println(solution.groupAnagrams(strs3));
    }
} 