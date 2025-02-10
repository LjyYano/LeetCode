/**
 * https://leetcode.cn/problems/isomorphic-strings/
 * 
 * 给定两个字符串 s 和 t，判断它们是否是同构的。
 * 
 * 如果 s 中的字符可以按某种映射关系替换得到 t，那么这两个字符串是同构的。
 * 
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，
 * 相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * 
 * 示例 1:
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 
 * 示例 2:
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 
 * 示例 3:
 * 输入：s = "paper", t = "title"
 * 输出：true
 * 
 * 提示：
 * - 1 <= s.length <= 5 * 10^4
 * - t.length == s.length
 * - s 和 t 由任意有效的 ASCII 字符组成
 */
public class L0205_IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        // 如果长度不相等，直接返回 false
        if (s.length() != t.length()) {
            return false;
        }
        
        // 创建两个数组来存储字符的映射关系
        int[] sToT = new int[256];
        int[] tToS = new int[256];
        
        // 初始化映射数组，用一个不可能的值填充
        for (int i = 0; i < 256; i++) {
            sToT[i] = -1;
            tToS[i] = -1;
        }
        
        // 遍历字符串，建立双向映射关系
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);
            
            // 如果当前字符还没有映射关系
            if (sToT[sChar] == -1 && tToS[tChar] == -1) {
                sToT[sChar] = tChar;
                tToS[tChar] = sChar;
            }
            // 如果映射关系不一致，返回 false
            else if (sToT[sChar] != tChar || tToS[tChar] != sChar) {
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        L0205_IsomorphicStrings solution = new L0205_IsomorphicStrings();
        
        // 测试用例 1
        String s1 = "egg", t1 = "add";
        System.out.println("Test case 1:");
        System.out.println("Input: s = \"" + s1 + "\", t = \"" + t1 + "\"");
        System.out.println("Output: " + solution.isIsomorphic(s1, t1));
        System.out.println();
        
        // 测试用例 2
        String s2 = "foo", t2 = "bar";
        System.out.println("Test case 2:");
        System.out.println("Input: s = \"" + s2 + "\", t = \"" + t2 + "\"");
        System.out.println("Output: " + solution.isIsomorphic(s2, t2));
        System.out.println();
        
        // 测试用例 3
        String s3 = "paper", t3 = "title";
        System.out.println("Test case 3:");
        System.out.println("Input: s = \"" + s3 + "\", t = \"" + t3 + "\"");
        System.out.println("Output: " + solution.isIsomorphic(s3, t3));
    }
} 