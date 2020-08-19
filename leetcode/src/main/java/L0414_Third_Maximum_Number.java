
// https://leetcode-cn.com/problems/third-maximum-number/
class L0414_Third_Maximum_Number {
    public int thirdMax(int[] nums) {
        long max0 = Long.MIN_VALUE;
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
		
		for(int v : nums) {
			if(max0 < v) {
				max2 = max1;
				max1 = max0;
				max0 = (long)v;
			} else if(max1 < v && v < max0) {
				max2 = max1;
				max1 = (long)v;
			} else if(max2 < v && v < max1){
				max2 = (long)v;
			}
            
		}
		
		return (int) (max2 == Long.MIN_VALUE ? max0 : max2);
    }
}