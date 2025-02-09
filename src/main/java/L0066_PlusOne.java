/*
 * https://leetcode.cn/problems/plus-one/
 * 
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 
 * 示例 1：
 * 输入：digits = [1,2,3]
 * 输出：[1,2,4]
 * 解释：输入数组表示数字 123，加 1 得到 124。
 * 
 * 示例 2：
 * 输入：digits = [4,3,2,1]
 * 输出：[4,3,2,2]
 * 解释：输入数组表示数字 4321，加 1 得到 4322。
 * 
 * 示例 3：
 * 输入：digits = [9]
 * 输出：[1,0]
 * 解释：输入数组表示数字 9，加 1 得到 10。
 * 
 * 提示：
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 */

public class L0066_PlusOne {

    public int[] plusOne(int[] digits) {
        // 从最后一位开始处理
        for (int i = digits.length - 1; i >= 0; i--) {
            // 如果当前位小于 9，直接加 1 并返回
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // 当前位是 9，加 1 后需要进位，将当前位置为 0
            digits[i] = 0;
        }
        
        // 如果程序执行到这里，说明所有位都是 9
        // 需要创建一个新数组，长度比原数组多 1，首位为 1，其余为 0
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }

    public static void main(String[] args) {
        L0066_PlusOne solution = new L0066_PlusOne();

        // 测试用例 1
        int[] digits1 = {1, 2, 3};
        System.out.println("测试用例 1：");
        System.out.print("输入：");
        printArray(digits1);
        int[] result1 = solution.plusOne(digits1);
        System.out.print("输出：");
        printArray(result1);
        System.out.println();

        // 测试用例 2
        int[] digits2 = {4, 3, 2, 1};
        System.out.println("测试用例 2：");
        System.out.print("输入：");
        printArray(digits2);
        int[] result2 = solution.plusOne(digits2);
        System.out.print("输出：");
        printArray(result2);
        System.out.println();

        // 测试用例 3
        int[] digits3 = {9};
        System.out.println("测试用例 3：");
        System.out.print("输入：");
        printArray(digits3);
        int[] result3 = solution.plusOne(digits3);
        System.out.print("输出：");
        printArray(result3);
    }

    // 打印数组的辅助方法
    private static void printArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
} 