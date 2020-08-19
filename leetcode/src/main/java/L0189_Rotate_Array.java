
// https://leetcode-cn.com/problems/rotate-array/
public class L0189_Rotate_Array {	static void reverse(int[] nums, int st, int ed) {

		while (st < ed) {
			int t = nums[st];
			nums[st] = nums[ed];
			nums[ed] = t;
			st++;
			ed--;
		}
	}

	public static void rotate(int[] nums, int k) {

		int length = nums.length;

		k = k % length;

		if (length == 1 || k == 0)
			return;

		reverse(nums, 0, length - k - 1);
		reverse(nums, length - k, length - 1);
		reverse(nums, 0, length - 1);
	}}