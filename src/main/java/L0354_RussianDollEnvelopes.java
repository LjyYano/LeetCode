import java.util.Arrays;

/**
 * https://leetcode.cn/problems/russian-doll-envelopes/
 * 
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 
 * 请计算 最多能有多少个 信封能组成一组"俄罗斯套娃"信封（即可以把一个信封放到另一个信封里面）。
 * 
 * 注意：不允许旋转信封。
 * 
 * 示例 1：
 * 输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
 * 输出：3
 * 解释：最优的俄罗斯套娃信封组合是 [2,3] => [5,4] => [6,7]。
 * 
 * 示例 2：
 * 输入：envelopes = [[1,1],[1,1],[1,1]]
 * 输出：1
 * 
 * 提示：
 * - 1 <= envelopes.length <= 10⁵
 * - envelopes[i].length == 2
 * - 1 <= wi, hi <= 10⁵
 */
public class L0354_RussianDollEnvelopes {
    
    public int maxEnvelopes(int[][] envelopes) {
        // 按宽度升序排序，如果宽度相同，则按高度降序排序
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return b[1] - a[1];
            }
        });
        
        // 对高度数组寻找最长递增子序列
        int[] heights = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            heights[i] = envelopes[i][1];
        }
        
        return longestIncreasingSubsequence(heights);
    }
    
    // 使用二分查找优化的最长递增子序列算法
    private int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        
        for (int num : nums) {
            // 使用二分查找找到 num 应该插入的位置
            int left = 0, right = len;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            
            // 更新 dp 数组
            dp[left] = num;
            if (left == len) {
                len++;
            }
        }
        
        return len;
    }

    public static void main(String[] args) {
        L0354_RussianDollEnvelopes solution = new L0354_RussianDollEnvelopes();
        
        // 测试用例 1
        int[][] envelopes1 = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println("测试用例 1：");
        System.out.println("输入：" + Arrays.deepToString(envelopes1));
        System.out.println("输出：" + solution.maxEnvelopes(envelopes1));
        System.out.println("预期：3");
        System.out.println();
        
        // 测试用例 2
        int[][] envelopes2 = {{1,1},{1,1},{1,1}};
        System.out.println("测试用例 2：");
        System.out.println("输入：" + Arrays.deepToString(envelopes2));
        System.out.println("输出：" + solution.maxEnvelopes(envelopes2));
        System.out.println("预期：1");
        System.out.println();
        
        // 测试用例 3：宽度相同的情况
        int[][] envelopes3 = {{1,2},{1,3},{1,4},{2,5}};
        System.out.println("测试用例 3：");
        System.out.println("输入：" + Arrays.deepToString(envelopes3));
        System.out.println("输出：" + solution.maxEnvelopes(envelopes3));
        System.out.println("预期：2");
    }
} 