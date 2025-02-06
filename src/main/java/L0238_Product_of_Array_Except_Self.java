
// https://leetcode-cn.com/problems/product-of-array-except-self/
class L0238_Product_of_Array_Except_Self {
    public int[] productExceptSelf(int[] nums) {
        final int[] left = new int[nums.length];
        left[0] = 1;
        
        for(int i = 1; i < nums.length; i++) {
            left[i] = nums[i - 1] * left[i - 1];
        }
        
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            left[i] *= right;
            right *= nums[i];
        }
        
        return left;
    }
}