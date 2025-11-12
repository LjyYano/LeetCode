/**
 * https://leetcode.cn/problems/relative-ranks/
 * 
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。
 * 所有得分都 互不相同 。
 * 
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。
 * 运动员的名次决定了他们的获奖情况：
 * - 名次第 1 的运动员获金牌 "Gold Medal" 。
 * - 名次第 2 的运动员获银牌 "Silver Medal" 。
 * - 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * - 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * 
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * 
 * 示例 1：
 * 输入：score = [5,4,3,2,1]
 * 输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
 * 解释：名次为 [1st, 2nd, 3rd, 4th, 5th] 。
 * 
 * 示例 2：
 * 输入：score = [10,3,8,9,4]
 * 输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
 * 解释：名次为 [1st, 5th, 3rd, 2nd, 4th] 。
 * 
 * 提示：
 * - n == score.length
 * - 1 <= n <= 10^4
 * - 0 <= score[i] <= 10^6
 * - score 中的所有值 互不相同
 */
import java.util.*;

public class L0506_RelativeRanks {
    
    /**
     * 排序 + 哈希表
     */
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        
        // 创建索引数组并按分数降序排序
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> score[b] - score[a]);
        
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[indices[i]] = "Gold Medal";
            } else if (i == 1) {
                result[indices[i]] = "Silver Medal";
            } else if (i == 2) {
                result[indices[i]] = "Bronze Medal";
            } else {
                result[indices[i]] = String.valueOf(i + 1);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0506_RelativeRanks solution = new L0506_RelativeRanks();
        
        // 测试用例 1
        int[] score1 = {5, 4, 3, 2, 1};
        System.out.println(Arrays.toString(solution.findRelativeRanks(score1)));
        // 预期输出：["Gold Medal","Silver Medal","Bronze Medal","4","5"]
        
        // 测试用例 2
        int[] score2 = {10, 3, 8, 9, 4};
        System.out.println(Arrays.toString(solution.findRelativeRanks(score2)));
        // 预期输出：["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    }
}
