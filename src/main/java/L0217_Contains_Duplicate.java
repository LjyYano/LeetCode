import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/contains-duplicate/
class L0217_Contains_Duplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<>();
        
        for(int v : nums) {
            if(set.contains(v)) return true;
            set.add(v);
        }
        
        return false;
    }
}