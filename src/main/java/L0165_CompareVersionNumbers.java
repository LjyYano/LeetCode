/*
 * https://leetcode.cn/problems/compare-version-numbers/
 * 
 * 给你两个版本号 version1 和 version2 ，请你比较它们。
 * 
 * 版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。
 * 
 * 比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。
 * 
 * 返回规则如下：
 * - 如果 version1 > version2 返回 1，
 * - 如果 version1 < version2 返回 -1，
 * - 除此之外返回 0。
 * 
 * 示例 1：
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，"01" 和 "001" 都表示相同的整数 "1"
 * 
 * 示例 2：
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有指定下标为 2 的修订号，即视为 "0"
 * 
 * 示例 3：
 * 输入：version1 = "0.1", version2 = "1.1"
 * 输出：-1
 * 解释：version1 中下标为 0 的修订号是 "0"，version2 中下标为 0 的修订号是 "1" 。0 < 1，所以 version1 < version2
 * 
 * 提示：
 * - 1 <= version1.length, version2.length <= 500
 * - version1 和 version2 仅包含数字和 '.'
 * - version1 和 version2 都是 有效版本号
 * - version1 和 version2 的所有修订号都可以存储在 32 位整数 中
 */

public class L0165_CompareVersionNumbers {
    
    public int compareVersion(String version1, String version2) {
        // 将版本号按点号分割成数组
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        // 获取两个版本号的最大长度
        int maxLength = Math.max(v1.length, v2.length);
        
        // 逐个比较每个修订号
        for (int i = 0; i < maxLength; i++) {
            // 获取当前位置的修订号，如果超出长度则视为 0
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            
            // 比较当前修订号
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        
        // 所有修订号都相等
        return 0;
    }

    public static void main(String[] args) {
        L0165_CompareVersionNumbers solution = new L0165_CompareVersionNumbers();
        
        // 测试用例 1
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println("测试用例 1：");
        System.out.println("输入：version1 = \"" + version1 + "\", version2 = \"" + version2 + "\"");
        System.out.println("输出：" + solution.compareVersion(version1, version2));
        System.out.println("预期：0");
        System.out.println();
        
        // 测试用例 2
        version1 = "1.0";
        version2 = "1.0.0";
        System.out.println("测试用例 2：");
        System.out.println("输入：version1 = \"" + version1 + "\", version2 = \"" + version2 + "\"");
        System.out.println("输出：" + solution.compareVersion(version1, version2));
        System.out.println("预期：0");
        System.out.println();
        
        // 测试用例 3
        version1 = "0.1";
        version2 = "1.1";
        System.out.println("测试用例 3：");
        System.out.println("输入：version1 = \"" + version1 + "\", version2 = \"" + version2 + "\"");
        System.out.println("输出：" + solution.compareVersion(version1, version2));
        System.out.println("预期：-1");
    }
} 