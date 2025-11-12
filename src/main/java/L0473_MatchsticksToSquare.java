/**
 * https://leetcode.cn/problems/matchsticks-to-square/
 * 
 * 你将得到一个整数数组 matchsticks ，其中 matchsticks[i] 是第 i 个火柴棒的长度。
 * 你要用 所有的火柴棍 拼成一个正方形。你 不能折断 任何一根火柴棒，但你可以把它们连在一起，
 * 而且每根火柴棒必须 使用一次 。
 * 
 * 如果你能使这个正方形，则返回 true ，否则返回 false 。
 * 
 * 示例 1：
 * 输入: matchsticks = [1,1,2,2,2]
 * 输出: true
 * 解释: 能拼成一个边长为 2 的正方形，每边两根火柴。
 * 
 * 示例 2：
 * 输入: matchsticks = [3,3,3,3,4]
 * 输出: false
 * 解释: 不能用所有火柴拼成一个正方形。
 * 
 * 提示：
 * - 1 <= matchsticks.length <= 15
 * - 1 <= matchsticks[i] <= 10^8
 */
import java.util.Arrays;

public class L0473_MatchsticksToSquare {
    
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }
        
        // 计算总长度
        int sum = 0;
        for (int len : matchsticks) {
            sum += len;
        }
        
        // 如果不能被4整除，无法构成正方形
        if (sum % 4 != 0) {
            return false;
        }
        
        int sideLength = sum / 4;
        
        // 从大到小排序，优化剪枝效果
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        
        // 如果最长的火柴超过边长，无法构成正方形
        if (matchsticks[0] > sideLength) {
            return false;
        }
        
        // 使用回溯法尝试将火柴分配到4条边
        int[] sides = new int[4];
        return backtrack(matchsticks, sides, 0, sideLength);
    }
    
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        if (index == matchsticks.length) {
            // 所有火柴都已分配，检查是否每条边都等于目标长度
            return sides[0] == target && sides[1] == target && 
                   sides[2] == target && sides[3] == target;
        }
        
        int len = matchsticks[index];
        
        // 尝试将当前火柴放到每一条边
        for (int i = 0; i < 4; i++) {
            // 剪枝：如果加上当前火柴后超过目标长度，跳过
            if (sides[i] + len > target) {
                continue;
            }
            
            // 剪枝：如果当前边和前一条边长度相同，跳过（避免重复计算）
            if (i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }
            
            sides[i] += len;
            if (backtrack(matchsticks, sides, index + 1, target)) {
                return true;
            }
            sides[i] -= len;
        }
        
        return false;
    }
    
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        L0473_MatchsticksToSquare solution = new L0473_MatchsticksToSquare();
        
        // 测试用例 1
        int[] matchsticks1 = {1,1,2,2,2};
        System.out.println(solution.makesquare(matchsticks1)); // 预期输出：true
        
        // 测试用例 2
        int[] matchsticks2 = {3,3,3,3,4};
        System.out.println(solution.makesquare(matchsticks2)); // 预期输出：false
    }
}
