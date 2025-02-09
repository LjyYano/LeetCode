/*
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
 * 
 * 给你一个下标从 1 开始的整数数组 numbers ，该数组已按 非递减顺序排列  ，请你从数组中找出满足相加之和等于目标数 target 的两个数。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 * 
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 * 
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 * 
 * 你所设计的解决方案必须只使用常量级的额外空间。
 * 
 * 示例 1：
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 
 * 示例 2：
 * 输入：numbers = [2,3,4], target = 6
 * 输出：[1,3]
 * 解释：2 与 4 之和等于目标数 6 。因此 index1 = 1, index2 = 3 。返回 [1, 3] 。
 * 
 * 示例 3：
 * 输入：numbers = [-1,0], target = -1
 * 输出：[1,2]
 * 解释：-1 与 0 之和等于目标数 -1 。因此 index1 = 1, index2 = 2 。返回 [1, 2] 。
 * 
 * 提示：
 * - 2 <= numbers.length <= 3 * 10⁴
 * - -1000 <= numbers[i] <= 1000
 * - numbers 按 非递减顺序 排列
 * - -1000 <= target <= 1000
 * - 仅存在一个有效答案
 */

public class L0167_TwoSumII {
    
    public int[] twoSum(int[] numbers, int target) {
        // 使用双指针，一个指向开头，一个指向结尾
        int left = 0;
        int right = numbers.length - 1;
        
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            
            if (sum == target) {
                // 因为题目要求返回的下标从 1 开始，所以要加 1
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                // 如果和小于目标值，说明需要更大的数，左指针右移
                left++;
            } else {
                // 如果和大于目标值，说明需要更小的数，右指针左移
                right--;
            }
        }
        
        // 题目保证有解，所以不会执行到这里
        return new int[]{};
    }

    public static void main(String[] args) {
        L0167_TwoSumII solution = new L0167_TwoSumII();
        
        // 测试用例 1
        int[] numbers1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("测试用例 1：");
        System.out.print("输入：numbers = [");
        printArray(numbers1);
        System.out.println("], target = " + target1);
        int[] result1 = solution.twoSum(numbers1, target1);
        System.out.print("输出：[");
        printArray(result1);
        System.out.println("]");
        System.out.println("预期：[1,2]");
        System.out.println();
        
        // 测试用例 2
        int[] numbers2 = {2, 3, 4};
        int target2 = 6;
        System.out.println("测试用例 2：");
        System.out.print("输入：numbers = [");
        printArray(numbers2);
        System.out.println("], target = " + target2);
        int[] result2 = solution.twoSum(numbers2, target2);
        System.out.print("输出：[");
        printArray(result2);
        System.out.println("]");
        System.out.println("预期：[1,3]");
        System.out.println();
        
        // 测试用例 3
        int[] numbers3 = {-1, 0};
        int target3 = -1;
        System.out.println("测试用例 3：");
        System.out.print("输入：numbers = [");
        printArray(numbers3);
        System.out.println("], target = " + target3);
        int[] result3 = solution.twoSum(numbers3, target3);
        System.out.print("输出：[");
        printArray(result3);
        System.out.println("]");
        System.out.println("预期：[1,2]");
    }
    
    // 打印数组的辅助方法
    private static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
    }
} 