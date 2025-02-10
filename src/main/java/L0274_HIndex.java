/**
 * https://leetcode.cn/problems/h-index/
 * 
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * 
 * 根据维基百科上 h 指数的定义：h 代表"高引用次数" ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次。
 * 如果 h 有多种可能的值，h 指数 是其中最大的那个。
 * 
 * 示例 1：
 * 输入：citations = [3,0,6,1,5]
 * 输出：3
 * 解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
 *      由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。
 * 
 * 示例 2：
 * 输入：citations = [1,3,1]
 * 输出：1
 * 
 * 提示：
 * n == citations.length
 * 1 <= n <= 5000
 * 0 <= citations[i] <= 1000
 */
public class L0274_HIndex {
    
    // 使用计数排序的思想
    // 因为 h 指数不可能超过论文总数，所以可以用计数排序优化
    public int hIndex(int[] citations) {
        int n = citations.length;
        // 计数数组，count[i] 表示引用次数为 i 的论文数量
        int[] count = new int[n + 1];
        
        // 统计每种引用次数的论文数
        // 如果引用次数大于 n，就按 n 来算
        for (int citation : citations) {
            count[Math.min(citation, n)]++;
        }
        
        // 从后往前遍历，累计论文数，找到第一个满足条件的位置
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        
        return 0;
    }

    public static void main(String[] args) {
        L0274_HIndex solution = new L0274_HIndex();
        
        // 测试用例 1
        System.out.println(solution.hIndex(new int[]{3, 0, 6, 1, 5}));  // 应该输出 3
        
        // 测试用例 2
        System.out.println(solution.hIndex(new int[]{1, 3, 1}));  // 应该输出 1
        
        // 测试用例 3：全部为 0
        System.out.println(solution.hIndex(new int[]{0, 0, 0}));  // 应该输出 0
        
        // 测试用例 4：全部为较大数
        System.out.println(solution.hIndex(new int[]{5, 5, 5, 5, 5}));  // 应该输出 5
    }
} 