package LeetCode;

import java.util.Arrays;

public class L108_Convert_Sorted_Array_to_Binary_Search_Tree {

	int[] nums;

	public TreeNode sortedArrayToBST(int[] nums) {

		this.nums = nums;

		return buildBST(0, nums.length);
	}

	TreeNode buildBST(int start, int end) {

		if (start >= end) {
			return null;
		}

		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(nums[mid]);

		root.left = buildBST(start, mid);
		root.right = buildBST(mid + 1, end);

		return root;
	}

	public TreeNode sortedArrayToBST2(int[] nums) {

		if (nums.length == 0) {
			return null;
		}

		if (nums.length == 1) {
			return new TreeNode(nums[0]);
		}

		int mid = nums.length / 2;

		TreeNode root = new TreeNode(nums[mid]);

		root.left = sortedArrayToBST2(Arrays.copyOfRange(nums, 0, mid));
		root.right = sortedArrayToBST2(Arrays.copyOfRange(nums, mid + 1,
				nums.length));

		return root;
	}

}
