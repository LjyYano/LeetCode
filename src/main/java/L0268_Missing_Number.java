
// https://leetcode-cn.com/problems/missing-number/
class L0268_Missing_Number {
    public int missingNumber(int[] nums) {
        if(nums == null) return 0;
        int sum = (1 + nums.length) * nums.length / 2;
        
        for(int v : nums) {
            sum -= v;
        }
        
        return sum;
    }
}