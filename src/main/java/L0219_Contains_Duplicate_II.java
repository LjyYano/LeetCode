import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/contains-duplicate-ii/
class L0219_Contains_Duplicate_II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        
        return false;
    }
}