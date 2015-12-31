package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L095_Unique_Binary_Search_Trees_II {

	public List<TreeNode> generateTrees(int n) {

		int[] array = new int[n];

		// 建立1~n的数组
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

		ArrayList<TreeNode> rt = new ArrayList<TreeNode>();

		// 数组的每一个元素（array[i]），分别作为根结点
		for (int i = 0; i < array.length; i++) {
			// array[i]作为根结点，array[i]之前的元素为左结点，array[i]之后的元素为右结点
			for (TreeNode left : generateTrees(Arrays.copyOfRange(array, 0, i))) {
				for (TreeNode right : generateTrees(Arrays.copyOfRange(array,
						i + 1, array.length))) {
					TreeNode root = new TreeNode(array[i]);

					root.left = left;
					root.right = right;

					rt.add(root);
				}
			}
		}

		return rt;
	}

}
