
// https://leetcode-cn.com/problems/maximum-product-subarray/
class L0152_Maximum_Product_Subarray {
    public int maxProduct(int[] nums) {
        int maxLocal = nums[0];
        int minLocal = nums[0];
        int global = nums[0];
        
        for(int i = 1; i < nums.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * temp, nums[i] * minLocal), nums[i]);
            minLocal = Math.min(Math.min(nums[i] * temp, nums[i] * minLocal), nums[i]);
            
            global = Math.max(global, maxLocal);
        }
        
        return global;
    }
}