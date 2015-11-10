package LeetCode;

public class L031_Next_Permutation {

	public void nextPermutation(int[] nums) {

		if (nums == null || nums.length < 2) {
			return;
		}

		int p = 0;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1]) {
				p = i;
				break;
			}
		}

		int q = 0;
		for (int i = nums.length - 1; i > p; i--) {
			if (nums[i] > nums[p]) {
				q = i;
				break;
			}
		}

		if (p == 0 && q == 0) {
			reverse(nums, 0, nums.length - 1);
			return;
		}

		int temp = nums[p];
		nums[p] = nums[q];
		nums[q] = temp;

		if (p < nums.length - 1) {
			reverse(nums, p + 1, nums.length - 1);
		}

	}

	private void reverse(int[] nums, int left, int right) {

		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

}
