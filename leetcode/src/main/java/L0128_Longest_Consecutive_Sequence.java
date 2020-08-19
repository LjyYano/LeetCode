import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/longest-consecutive-sequence/
class L0128_Longest_Consecutive_Sequence {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                int left = map.containsKey(nums[i] - 1) ? map.get(nums[i] - 1) : 0;
                int right = map.containsKey(nums[i] + 1) ? map.get(nums[i] + 1) : 0;
            
                int times = left + right + 1;
                
                map.put(nums[i], times);
                ans = Math.max(ans, times);
                
                map.put(nums[i] - left, times);
                map.put(nums[i] + right, times);
            }
        }
        
        return ans;
    }
}