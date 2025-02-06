
// https://leetcode-cn.com/problems/find-peak-element/
class L0162_Find_Peak_Element {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        for(int i = 0; i < nums.length; i++) {
            boolean left = i == 0 ? true : nums[i] > nums[i - 1];
            boolean right = i == nums.length - 1 ? true : nums[i] > nums[i + 1];
            
            if(left && right) return i;
        }
        
        return 0;
    }
}