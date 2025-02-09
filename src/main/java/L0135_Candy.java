/**
 * https://leetcode.cn/problems/candy/
 * 
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 * - 每个孩子至少分配到 1 个糖果。
 * - 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * 
 * 示例 1：
 * 输入：ratings = [1,0,2]
 * 输出：5
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
 * 
 * 示例 2：
 * 输入：ratings = [1,2,2]
 * 输出：4
 * 解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
 *      第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
 * 
 * 提示：
 * - n == ratings.length
 * - 1 <= n <= 2 * 10⁴
 * - 0 <= ratings[i] <= 2 * 10⁴
 */
public class L0135_Candy {
    
    public int candy(int[] ratings) {
        int n = ratings.length;
        // 每个孩子至少分配 1 个糖果
        int[] candies = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        // 从左向右遍历，如果右边评分高于左边，右边的糖果数要多一个
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // 从右向左遍历，如果左边评分高于右边，左边的糖果数要多一个
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // 计算总糖果数
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }

    public static void main(String[] args) {
        L0135_Candy solution = new L0135_Candy();
        
        // 测试用例 1
        int[] ratings1 = {1, 0, 2};
        System.out.println("测试用例 1：");
        System.out.println("输入：ratings = [1,0,2]");
        System.out.println("输出：" + solution.candy(ratings1));
        System.out.println("预期：5");
        System.out.println();
        
        // 测试用例 2
        int[] ratings2 = {1, 2, 2};
        System.out.println("测试用例 2：");
        System.out.println("输入：ratings = [1,2,2]");
        System.out.println("输出：" + solution.candy(ratings2));
        System.out.println("预期：4");
    }
} 