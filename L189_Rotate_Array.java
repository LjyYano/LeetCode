package LeetCode;

public class L189_Rotate_Array {

	void reverse(int[] nums, int st, int ed) {

		while (st < ed) {
			int t = nums[st];
			nums[st] = nums[ed];
			nums[ed] = t;
			st++;
			ed--;
		}
	}

	public void rotate(int[] nums, int k) {

		int length = nums.length;

		k = k % length;

		if (length == 1 || k == 0)
			return;

		reverse(nums, 0, length - k - 1);
		reverse(nums, length - k, length - 1);
		reverse(nums, 0, length - 1);
	}

}
