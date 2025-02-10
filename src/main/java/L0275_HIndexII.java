/**
 * https://leetcode.cn/problems/h-index-ii/
 * 
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数，citations 已经按照 升序排列 。计算并返回该研究者的 h 指数。
 * 
 * h 指数的定义：h 代表"高引用次数"（high citations），一名科研人员的 h 指数是指他（她）的 （n 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。
 * 
 * 请你设计并实现对数时间复杂度的算法解决此问题。
 * 
 * 示例 1：
 * 输入：citations = [0,1,3,5,6]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 
 * 示例 2：
 * 输入：citations = [1,2,100]
 * 输出：2
 * 
 * 提示：
 * n == citations.length
 * 1 <= n <= 10⁵
 * 0 <= citations[i] <= 1000
 * citations 按 升序排列
 */
public class L0275_HIndexII {
    
    // 使用二分查找
    // 因为数组已经排序，所以可以用二分查找优化
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        
        // 二分查找第一个满足条件的位置
        // citations[i] >= n-i 表示从位置 i 到末尾有 n-i 篇论文，引用次数都大于等于 citations[i]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= n - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return n - left;
    }

    public static void main(String[] args) {
        L0275_HIndexII solution = new L0275_HIndexII();
        
        // 测试用例 1
        System.out.println(solution.hIndex(new int[]{0, 1, 3, 5, 6}));  // 应该输出 3
        
        // 测试用例 2
        System.out.println(solution.hIndex(new int[]{1, 2, 100}));  // 应该输出 2
        
        // 测试用例 3：全部为 0
        System.out.println(solution.hIndex(new int[]{0, 0, 0}));  // 应该输出 0
        
        // 测试用例 4：全部为较大数
        System.out.println(solution.hIndex(new int[]{5, 5, 5, 5, 5}));  // 应该输出 5
    }
} 