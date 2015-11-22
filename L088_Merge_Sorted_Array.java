package LeetCode;

public class L088_Merge_Sorted_Array {

	public int help(int[] nums, int k) {

		if (k < 0) {
			return Integer.MIN_VALUE;
		}

		return nums[k];
	}

	public void merge(int[] nums1, int m, int[] nums2, int n) {

		if (nums1 == null || nums2 == null) {
			return;
		}

		int t = m + n - 1;

		while (t >= 0) {

			int n1 = help(nums1, m - 1);
			int n2 = help(nums2, n - 1);

			if (n1 > n2) {
				nums1[t] = n1;
				m--;
			} else {
				nums1[t] = n2;
				n--;
			}

			t--;
		}
	}

}
