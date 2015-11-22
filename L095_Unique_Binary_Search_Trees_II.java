package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L095_Unique_Binary_Search_Trees_II {

	public List<TreeNode> generateTrees(int n) {

		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}

		return generateTrees(array);
	}

	List<TreeNode> generateTrees(int[] array) {

		if (array.length == 0) {
			return new ArrayList<TreeNode>(
					Collections.<TreeNode> singletonList(null));
		}

		ArrayList<TreeNode> result = new ArrayList<TreeNode>();

		for (int i = 0; i < array.length; i++) {
			for (TreeNode left : generateTrees(Arrays.copyOfRange(array, 0, i))) {
				for (TreeNode right : generateTrees(Arrays.copyOfRange(array,
						i + 1, array.length))) {
					TreeNode root = new TreeNode(array[i]);

					root.left = left;
					root.right = right;

					result.add(root);
				}
			}
		}

		return result;
	}

}
