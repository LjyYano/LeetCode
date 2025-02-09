/**
 * https://leetcode.cn/problems/largest-number/
 * 
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 * 
 * 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 
 * 示例 1：
 * 输入：nums = [10,2]
 * 输出："210"
 * 
 * 示例 2：
 * 输入：nums = [3,30,34,5,9]
 * 输出："9534330"
 * 
 * 提示：
 * - 1 <= nums.length <= 100
 * - 0 <= nums[i] <= 10⁹
 */
public class L0179_LargestNumber {
    
    public String largestNumber(int[] nums) {
        // 将整数数组转换为字符串数组
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        
        // 自定义排序规则：比较 s1+s2 和 s2+s1 的大小
        // 例如：对于 3 和 30，比较 "330" 和 "303"
        java.util.Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        // 处理特殊情况：如果排序后第一个数字是 0，说明所有数字都是 0
        if (strs[0].equals("0")) {
            return "0";
        }
        
        // 拼接所有数字
        StringBuilder result = new StringBuilder();
        for (String str : strs) {
            result.append(str);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0179_LargestNumber solution = new L0179_LargestNumber();
        
        // 测试用例 1
        int[] nums1 = {10, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = [10,2]");
        System.out.println("输出：" + solution.largestNumber(nums1));
        System.out.println("预期：\"210\"");
        System.out.println();
        
        // 测试用例 2
        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = [3,30,34,5,9]");
        System.out.println("输出：" + solution.largestNumber(nums2));
        System.out.println("预期：\"9534330\"");
        System.out.println();
        
        // 测试用例 3：全 0 的情况
        int[] nums3 = {0, 0};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = [0,0]");
        System.out.println("输出：" + solution.largestNumber(nums3));
        System.out.println("预期：\"0\"");
    }
} 