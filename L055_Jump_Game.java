package LeetCode;

public class L055_Jump_Game {

	public boolean canJump(int[] nums) {

		if (nums == null || nums.length == 0) {
			return false;
		}

		int maxStep = 0;

		for (int i = 0; i < nums.length; i++) {

			if (maxStep >= nums.length - 1) {
				return true;
			}

			if (nums[i] == 0 && maxStep == i) {
				return false;
			}

			maxStep = Math.max(maxStep, nums[i] + i);
		}

		return true;
	}

}
