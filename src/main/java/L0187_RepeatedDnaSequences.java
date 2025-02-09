import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/repeated-dna-sequences/
 * 
 * DNA序列 由一系列核苷酸组成，缩写为 'A', 'C', 'G' 和 'T'。
 * 
 * 例如，"ACGAATTCCG" 是一个 DNA序列 。
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * 
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。
 * 你可以按 任意顺序 返回答案。
 * 
 * 示例 1：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * 
 * 示例 2：
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * 
 * 提示：
 * - 0 <= s.length <= 10⁵
 * - s[i] 为 'A'、'C'、'G' 或 'T'
 */
public class L0187_RepeatedDnaSequences {
    
    /**
     * 使用滑动窗口和哈希集合查找重复的 DNA 序列
     */
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();
        
        // 遍历所有长度为 10 的子串
        for (int i = 0; i <= s.length() - 10; i++) {
            String sequence = s.substring(i, i + 10);
            // 如果已经见过这个序列，将其添加到重复集合中
            if (!seen.add(sequence)) {
                repeated.add(sequence);
            }
        }
        
        return new ArrayList<>(repeated);
    }

    public static void main(String[] args) {
        L0187_RepeatedDnaSequences solution = new L0187_RepeatedDnaSequences();
        
        // 测试用例 1
        String s1 = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        System.out.println("测试用例 1：");
        System.out.println("输入：" + s1);
        System.out.println("输出：" + solution.findRepeatedDnaSequences(s1));
        
        // 测试用例 2
        String s2 = "AAAAAAAAAAAAA";
        System.out.println("\n测试用例 2：");
        System.out.println("输入：" + s2);
        System.out.println("输出：" + solution.findRepeatedDnaSequences(s2));
    }
} 