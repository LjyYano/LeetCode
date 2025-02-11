import java.util.*;

/**
 * https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/
 * 
 * 给定两个以 非递减顺序 排列的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 
 * 请找到和最小的 k 个数对 (u1,v1), (u2,v2) ... (uk,vk) 。
 * 
 * 示例 1:
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [[1,2],[1,4],[1,6]]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 
 * 示例 2:
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [[1,1],[1,1]]
 * 解释: 返回序列中的前 2 对数：
 *      [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * 
 * 示例 3:
 * 输入: nums1 = [1,2], nums2 = [3], k = 3
 * 输出: [[1,3],[2,3]]
 * 解释: 也可能序列中所有的数对都被返回: [[1,3],[2,3]]
 * 
 * 提示:
 * - 1 <= nums1.length, nums2.length <= 10⁵
 * - -10⁹ <= nums1[i], nums2[i] <= 10⁹
 * - nums1 和 nums2 均为升序排列
 * - 1 <= k <= 10⁴
 */
public class L0373_FindKPairsWithSmallestSums {
    
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k <= 0) {
            return result;
        }
        
        // 使用优先队列（小顶堆）存储三元组 (sum, i, j)
        // sum 是 nums1[i] + nums2[j] 的和
        // i 和 j 分别是 nums1 和 nums2 的索引
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        
        // 将所有 nums1 中的数和 nums2[0] 的组合加入队列
        for (int i = 0; i < nums1.length && i < k; i++) {
            pq.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }
        
        // 循环 k 次或直到队列为空
        while (k > 0 && !pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[1];
            int j = curr[2];
            
            // 将当前组合加入结果集
            result.add(Arrays.asList(nums1[i], nums2[j]));
            
            // 如果还有下一个数，将新组合加入队列
            if (j + 1 < nums2.length) {
                pq.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
            
            k--;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0373_FindKPairsWithSmallestSums solution = new L0373_FindKPairsWithSmallestSums();
        
        // 测试用例 1
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;
        System.out.println("测试用例 1：");
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("k = " + k);
        System.out.println("输出：" + solution.kSmallestPairs(nums1, nums2, k));
        System.out.println();
        
        // 测试用例 2
        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        k = 2;
        System.out.println("测试用例 2：");
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("k = " + k);
        System.out.println("输出：" + solution.kSmallestPairs(nums1, nums2, k));
        System.out.println();
        
        // 测试用例 3
        nums1 = new int[]{1, 2};
        nums2 = new int[]{3};
        k = 3;
        System.out.println("测试用例 3：");
        System.out.println("nums1 = " + Arrays.toString(nums1));
        System.out.println("nums2 = " + Arrays.toString(nums2));
        System.out.println("k = " + k);
        System.out.println("输出：" + solution.kSmallestPairs(nums1, nums2, k));
    }
} 