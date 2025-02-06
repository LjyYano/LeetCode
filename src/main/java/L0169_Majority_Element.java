
// https://leetcode-cn.com/problems/majority-element/
class L0169_Majority_Element {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0, ans = 0;
        
        for(int v : nums) {
            if(count == 0) {
                ans = v;
                count = 1;
            } else if(v != ans) {
                count--;
            } else {
                count++;
            }
        }
        
        return ans;
    }
}