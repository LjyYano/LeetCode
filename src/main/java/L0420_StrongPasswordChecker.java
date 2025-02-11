import java.util.*;

/**
 * https://leetcode.cn/problems/strong-password-checker/description/
 * 
 * 如果一个密码满足下述所有条件，则认为这个密码是强密码：
 * - 由至少 6 个，至多 20 个字符组成。
 * - 至少包含一个小写字母，一个大写字母，和一个数字 。
 * - 同一字符 不能 连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 如果满足其他条件也可以视作是强密码)。
 * 
 * 给你一个字符串 password ，返回将 password 修改到满足强密码条件需要的最少修改步数。如果 password 已经是强密码，则返回 0 。
 * 在一步修改操作中，你可以：
 * - 插入一个字符到 password ，
 * - 从 password 中删除一个字符，或
 * - 用另一个字符来替换 password 中的某个字符。
 * 
 * 示例 1：
 * 输入：password = "a"
 * 输出：5
 * 解释：password 太短，需要至少插入 5 个字符。
 * 
 * 示例 2：
 * 输入：password = "aA1"
 * 输出：3
 * 解释：密码太短，需要插入 3 个字符。
 * 
 * 示例 3：
 * 输入：password = "1337C0d3"
 * 输出：0
 * 解释：password 已经是强密码。
 */
public class L0420_StrongPasswordChecker {

    public int strongPasswordChecker(String password) {
        int n = password.length();
        
        // 统计大写字母、小写字母和数字的数量
        int hasLower = 0, hasUpper = 0, hasDigit = 0;
        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) hasLower = 1;
            else if (Character.isUpperCase(c)) hasUpper = 1;
            else if (Character.isDigit(c)) hasDigit = 1;
        }
        int categories = hasLower + hasUpper + hasDigit;
        
        // 处理长度小于 6 的情况
        if (n < 6) {
            return Math.max(6 - n, 3 - categories);
        }
        
        // 处理长度大于 20 的情况
        if (n > 20) {
            // 统计连续字符的情况
            int replace = 0;
            int[] counts = new int[3];  // 存储模 3 余数的删除次数
            int curr = 1;  // 当前连续字符的数量
            char prev = '.';  // 前一个字符
            
            for (int i = 0; i < n; i++) {
                char c = password.charAt(i);
                if (c == prev) {
                    curr++;
                } else {
                    if (curr >= 3) {
                        replace += curr / 3;
                        counts[curr % 3]++;
                    }
                    curr = 1;
                    prev = c;
                }
            }
            if (curr >= 3) {
                replace += curr / 3;
                counts[curr % 3]++;
            }
            
            // 计算需要删除的字符数
            int deleteCount = n - 20;
            
            // 优先使用删除操作来减少替换操作
            for (int i = 0; i < 3; i++) {
                if (i < 2) {
                    int min = Math.min(deleteCount, counts[i] * (i + 1));
                    deleteCount -= min;
                    replace -= min / (i + 1);
                } else {
                    int min = Math.min(deleteCount, counts[2] * 3);
                    deleteCount -= min;
                    replace -= min / 3;
                }
            }
            
            return (n - 20) + Math.max(replace, 3 - categories);
        }
        
        // 处理长度在 6-20 之间的情况
        int replace = 0;
        int curr = 1;
        char prev = '.';
        
        // 统计需要替换的连续字符数量
        for (int i = 0; i < n; i++) {
            char c = password.charAt(i);
            if (c == prev) {
                curr++;
                if (curr == 3) {
                    replace++;
                    curr = 0;
                }
            } else {
                curr = 1;
            }
            prev = c;
        }
        
        return Math.max(replace, 3 - categories);
    }

    public static void main(String[] args) {
        L0420_StrongPasswordChecker solution = new L0420_StrongPasswordChecker();
        
        // 测试用例1
        String password1 = "a";
        System.out.println("测试用例1：");
        System.out.println("输入：password = " + password1);
        System.out.println("输出：" + solution.strongPasswordChecker(password1));
        
        // 测试用例2
        String password2 = "aA1";
        System.out.println("\n测试用例2：");
        System.out.println("输入：password = " + password2);
        System.out.println("输出：" + solution.strongPasswordChecker(password2));
        
        // 测试用例3
        String password3 = "1337C0d3";
        System.out.println("\n测试用例3：");
        System.out.println("输入：password = " + password3);
        System.out.println("输出：" + solution.strongPasswordChecker(password3));
        
        // 测试用例4
        String password4 = "aaa111";
        System.out.println("\n测试用例4：");
        System.out.println("输入：password = " + password4);
        System.out.println("输出：" + solution.strongPasswordChecker(password4));
    }
} 