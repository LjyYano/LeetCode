package LeetCode;

public class L238_Product_of_Array_Except_Self {

	public int[] productExceptSelf(int[] nums) {

		int[] rt = new int[nums.length];
		rt[nums.length - 1] = 1;

		for (int i = nums.length - 2; i >= 0; i--) {
			rt[i] = rt[i + 1] * nums[i+1];
		}

		int left = 1;
		for (int i = 0; i < nums.length; i++) {
			rt[i] *= left;
			left *= nums[i];
		}

		return rt;
	}
}
