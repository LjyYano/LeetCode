/*
 * https://leetcode.cn/problems/permutation-sequence/
 * 
 * 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 * 
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * 
 * 示例 1：
 * 输入：n = 3, k = 3
 * 输出："213"
 * 
 * 示例 2：
 * 输入：n = 4, k = 9
 * 输出："2314"
 * 
 * 示例 3：
 * 输入：n = 3, k = 1
 * 输出："123"
 * 
 * 提示：
 * 1 <= n <= 9
 * 1 <= k <= n!
 */

import java.util.ArrayList;
import java.util.List;

public class L0060_PermutationSequence {

    // 计算阶乘
    private int factorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    public String getPermutation(int n, int k) {
        // 创建数字列表
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // k 从 1 开始，转换为从 0 开始
        k--;

        StringBuilder result = new StringBuilder();
        // 从最高位开始确定每一位
        for (int i = n - 1; i >= 0; i--) {
            // 计算当前位之后的所有排列数
            int factorial = factorial(i);
            // 计算当前位的数字在剩余数字中的索引
            int index = k / factorial;
            // 更新 k 为剩余的排列数
            k %= factorial;
            // 将找到的数字添加到结果中
            result.append(numbers.remove(index));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L0060_PermutationSequence solution = new L0060_PermutationSequence();

        // 测试用例 1
        System.out.println("n = 3, k = 3");
        System.out.println("输出：" + solution.getPermutation(3, 3));
        System.out.println("预期：213");
        System.out.println();

        // 测试用例 2
        System.out.println("n = 4, k = 9");
        System.out.println("输出：" + solution.getPermutation(4, 9));
        System.out.println("预期：2314");
        System.out.println();

        // 测试用例 3
        System.out.println("n = 3, k = 1");
        System.out.println("输出：" + solution.getPermutation(3, 1));
        System.out.println("预期：123");
    }
} 