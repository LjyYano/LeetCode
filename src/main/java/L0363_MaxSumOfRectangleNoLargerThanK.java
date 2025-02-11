import java.util.TreeSet;

/**
 * https://leetcode.cn/problems/max-sum-of-rectangle-no-larger-than-k/
 * 
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/03/18/sum-grid.jpg)
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * 
 * 提示：
 * - m == matrix.length
 * - n == matrix[i].length
 * - 1 <= m, n <= 100
 * - -100 <= matrix[i][j] <= 100
 * - -10⁵ <= k <= 10⁵
 */
public class L0363_MaxSumOfRectangleNoLargerThanK {
    
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        
        // 枚举左边界
        for (int left = 0; left < n; left++) {
            // 存储每一行的累加和
            int[] rowSum = new int[m];
            // 枚举右边界
            for (int right = left; right < n; right++) {
                // 计算每一行在左右边界内的和
                for (int i = 0; i < m; i++) {
                    rowSum[i] += matrix[i][right];
                }
                
                // 在 rowSum 中寻找不超过 k 的最大数值和
                maxSum = Math.max(maxSum, maxSumNoLargerThanK(rowSum, k));
            }
        }
        
        return maxSum;
    }
    
    // 在数组中寻找不超过 k 的最大子数组和
    private int maxSumNoLargerThanK(int[] arr, int k) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        
        for (int num : arr) {
            sum += num;
            // 寻找前缀和中是否存在一个数 x，使得 sum - x <= k
            Integer ceiling = set.ceiling(sum - k);
            if (ceiling != null) {
                maxSum = Math.max(maxSum, sum - ceiling);
            }
            set.add(sum);
        }
        
        return maxSum;
    }
    
    public static void main(String[] args) {
        L0363_MaxSumOfRectangleNoLargerThanK solution = new L0363_MaxSumOfRectangleNoLargerThanK();
        
        // 测试用例 1
        int[][] matrix1 = {{1,0,1},{0,-2,3}};
        int k1 = 2;
        System.out.println("测试用例 1 的结果: " + solution.maxSumSubmatrix(matrix1, k1));  // 预期输出: 2
        
        // 测试用例 2
        int[][] matrix2 = {{2,2,-1}};
        int k2 = 3;
        System.out.println("测试用例 2 的结果: " + solution.maxSumSubmatrix(matrix2, k2));  // 预期输出: 3
    }
} 