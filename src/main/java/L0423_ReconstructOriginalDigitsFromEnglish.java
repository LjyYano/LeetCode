/**
 * https://leetcode.cn/problems/reconstruct-original-digits-from-english/description/
 * 
 * 给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。
 * 
 * 示例 1：
 * 输入：s = "owoztneoer"
 * 输出："012"
 * 
 * 示例 2：
 * 输入：s = "fviefuro"
 * 输出："45"
 */
public class L0423_ReconstructOriginalDigitsFromEnglish {

    public String originalDigits(String s) {
        // 统计每个字母出现的次数
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        
        // 统计每个数字出现的次数
        int[] nums = new int[10];
        
        // 根据独特字母推断数字
        // zero: z
        nums[0] = count['z' - 'a'];
        // two: w
        nums[2] = count['w' - 'a'];
        // four: u
        nums[4] = count['u' - 'a'];
        // six: x
        nums[6] = count['x' - 'a'];
        // eight: g
        nums[8] = count['g' - 'a'];
        
        // three: h - eight
        nums[3] = count['h' - 'a'] - nums[8];
        // five: f - four
        nums[5] = count['f' - 'a'] - nums[4];
        // seven: s - six
        nums[7] = count['s' - 'a'] - nums[6];
        // one: o - zero - two - four
        nums[1] = count['o' - 'a'] - nums[0] - nums[2] - nums[4];
        // nine: i - five - six - eight
        nums[9] = count['i' - 'a'] - nums[5] - nums[6] - nums[8];
        
        // 构建结果字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < nums[i]; j++) {
                result.append(i);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0423_ReconstructOriginalDigitsFromEnglish solution = new L0423_ReconstructOriginalDigitsFromEnglish();
        
        // 测试用例1
        String s1 = "owoztneoer";
        System.out.println("测试用例1：");
        System.out.println("输入：s = \"" + s1 + "\"");
        System.out.println("输出：\"" + solution.originalDigits(s1) + "\"");
        
        // 测试用例2
        String s2 = "fviefuro";
        System.out.println("\n测试用例2：");
        System.out.println("输入：s = \"" + s2 + "\"");
        System.out.println("输出：\"" + solution.originalDigits(s2) + "\"");
        
        // 测试用例3
        String s3 = "zeroonetwothreefourfivesixseveneightnine";
        System.out.println("\n测试用例3：");
        System.out.println("输入：s = \"" + s3 + "\"");
        System.out.println("输出：\"" + solution.originalDigits(s3) + "\"");
    }
} 