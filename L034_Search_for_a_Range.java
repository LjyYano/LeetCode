package LeetCode;

public class L034_Search_for_a_Range {

	public int[] searchRange(int[] nums, int target) {

		int l = 0, r = nums.length;

		while (l < r) {

			int m = l + (r - l) / 2;

			if (nums[m] == target) {

				int s = m, e = m;

				while (s - 1 >= 0 && nums[s - 1] == target) {
					s--;
				}

				while (e + 1 < nums.length && nums[e + 1] == target) {
					e++;
				}

				return new int[] { s, e };

			} else if (nums[m] > target) {
				r = m;
			} else {
				l = m + 1;
			}
		}

		return new int[] { -1, -1 };
	}

}
