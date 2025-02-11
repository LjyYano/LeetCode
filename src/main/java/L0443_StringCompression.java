import java.util.*;

/**
 * https://leetcode.cn/problems/string-compression/
 * 
 * 给你一个字符数组 chars ，请使用下述算法压缩：
 * 
 * 从一个空字符串 s 开始。对于 chars 中的每组连续重复字符：
 * - 如果这一组包含单个字符，则将这个字符直接追加到 s 中。
 * - 否则，需要向 s 追加字符，后跟这一组的长度。
 * 
 * 压缩后得到的字符串 s 需要无损地存储到字符数组 chars 中。请注意，group lengths 如果存在 10 或 10 以上的数字并排在一起，就需要分开写（两个或更多的数字）。
 * 
 * 请在修改完输入数组后，返回该数组的新长度。
 * 你必须设计并实现一个只使用常量额外空间的算法来解决此问题。
 * 
 * 示例 1：
 * 输入：chars = ["a","a","b","b","c","c","c"]
 * 输出：返回 6 ，输入数组的前 6 个字符应该是：["a","2","b","2","c","3"]
 * 解释："aa" 被 "a2" 替代。"bb" 被 "b2" 替代。"ccc" 被 "c3" 替代。
 * 
 * 示例 2：
 * 输入：chars = ["a"]
 * 输出：返回 1 ，输入数组的第 1 个字符应该是：["a"]
 * 解释：唯一的组是"a"，它保持未压缩，因为它是一个字符。
 * 
 * 示例 3：
 * 输入：chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * 输出：返回 4 ，输入数组的前 4 个字符应该是：["a","b","1","2"]
 * 解释：由于字符 "a" 不重复，所以不会被压缩。"bbbbbbbbbbbb" 被 "b12" 替代。
 */
public class L0443_StringCompression {
    
    public int compress(char[] chars) {
        if (chars == null || chars.length == 0) {
            return 0;
        }
        
        // write 指针表示写入位置
        int write = 0;
        // anchor 表示当前组的起始位置
        int anchor = 0;
        
        // 遍历字符数组
        for (int read = 0; read < chars.length; read++) {
            // 当到达字符数组末尾或者遇到不同的字符时
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                // 写入字符
                chars[write++] = chars[anchor];
                
                // 如果当前组的长度大于 1，需要写入数字
                if (read > anchor) {
                    // 计算当前组的长度
                    int count = read - anchor + 1;
                    // 将数字转为字符串
                    String countStr = String.valueOf(count);
                    // 逐个写入数字的每一位
                    for (char c : countStr.toCharArray()) {
                        chars[write++] = c;
                    }
                }
                // 更新下一组的起始位置
                anchor = read + 1;
            }
        }
        
        return write;
    }

    public static void main(String[] args) {
        L0443_StringCompression solution = new L0443_StringCompression();
        
        // 测试用例1
        char[] chars1 = {'a','a','b','b','c','c','c'};
        System.out.println("测试用例1：");
        System.out.println("输入：chars = " + Arrays.toString(chars1));
        int len1 = solution.compress(chars1);
        System.out.println("输出：" + len1);
        System.out.println("压缩后的前 " + len1 + " 个字符：" + Arrays.toString(Arrays.copyOf(chars1, len1)));
        
        // 测试用例2
        char[] chars2 = {'a'};
        System.out.println("\n测试用例2：");
        System.out.println("输入：chars = " + Arrays.toString(chars2));
        int len2 = solution.compress(chars2);
        System.out.println("输出：" + len2);
        System.out.println("压缩后的前 " + len2 + " 个字符：" + Arrays.toString(Arrays.copyOf(chars2, len2)));
        
        // 测试用例3
        char[] chars3 = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println("\n测试用例3：");
        System.out.println("输入：chars = " + Arrays.toString(chars3));
        int len3 = solution.compress(chars3);
        System.out.println("输出：" + len3);
        System.out.println("压缩后的前 " + len3 + " 个字符：" + Arrays.toString(Arrays.copyOf(chars3, len3)));
    }
} 