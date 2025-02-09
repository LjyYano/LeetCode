import java.util.List;
import java.util.Arrays;

/**
 * https://leetcode.cn/problems/triangle/
 * 
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 * 也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * 
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 *    2
 *   3 4
 *  6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 
 * 提示：
 * - 1 <= triangle.length <= 200
 * - triangle[0].length == 1
 * - triangle[i].length == triangle[i - 1].length + 1
 * - -10⁴ <= triangle[i][j] <= 10⁴
 * 
 * 进阶：你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class L0120_Triangle {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        
        // 获取三角形的行数
        int n = triangle.size();
        
        // dp[j] 表示从当前位置到底部的最小路径和
        int[] dp = new int[n];
        
        // 初始化最后一行
        List<Integer> lastRow = triangle.get(n - 1);
        for (int j = 0; j < n; j++) {
            dp[j] = lastRow.get(j);
        }
        
        // 从倒数第二行开始向上计算
        for (int i = n - 2; i >= 0; i--) {
            List<Integer> currentRow = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                // 当前位置的最小路径和等于当前值加上下一行相邻位置的最小值
                dp[j] = currentRow.get(j) + Math.min(dp[j], dp[j + 1]);
            }
        }
        
        return dp[0];
    }

    public static void main(String[] args) {
        L0120_Triangle solution = new L0120_Triangle();
        
        // 测试用例 1
        List<List<Integer>> triangle1 = Arrays.asList(
            Arrays.asList(2),
            Arrays.asList(3, 4),
            Arrays.asList(6, 5, 7),
            Arrays.asList(4, 1, 8, 3)
        );
        System.out.println("测试用例 1：");
        System.out.println("输入：triangle = " + triangle1);
        System.out.println("输出：" + solution.minimumTotal(triangle1));
        System.out.println("预期：11");
        System.out.println();
        
        // 测试用例 2
        List<List<Integer>> triangle2 = Arrays.asList(
            Arrays.asList(-10)
        );
        System.out.println("测试用例 2：");
        System.out.println("输入：triangle = " + triangle2);
        System.out.println("输出：" + solution.minimumTotal(triangle2));
        System.out.println("预期：-10");
        System.out.println();
        
        // 测试用例 3：包含负数的复杂情况
        List<List<Integer>> triangle3 = Arrays.asList(
            Arrays.asList(1),
            Arrays.asList(-5, 2),
            Arrays.asList(3, -2, 6),
            Arrays.asList(-1, 3, -1, 4)
        );
        System.out.println("测试用例 3：");
        System.out.println("输入：triangle = " + triangle3);
        System.out.println("输出：" + solution.minimumTotal(triangle3));
        System.out.println("预期：-4");
    }
} 