package LeetCode;

public class L283_Move_Zeroes {

	public void moveZeroes(int[] nums) {

		int t = 0;

		// 把非0元素移到前面
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[t++] = nums[i];
			}
		}

		// 把后面元素值0
		for (int i = t; i < nums.length; i++) {
			nums[i] = 0;
		}
	}

}
