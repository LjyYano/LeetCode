package LeetCode;

import java.util.Deque;
import java.util.LinkedList;

public class L297_Serialize_and_Deserialize_Binary_Tree {

	public String serialize(TreeNode root) {

		if (root == null) {
			return "";
		}

		StringBuffer sb = new StringBuffer();

		Deque<TreeNode> deque = new LinkedList<TreeNode>();
		deque.add(root);

		while (!deque.isEmpty()) {
			TreeNode p = deque.pop();

			if (p == null) {
				sb.append(",#");
			} else {
				sb.append("," + p.val);
				deque.add(p.left);
				deque.add(p.right);
			}
		}

		// 第一个元素前也有一个逗号，截取
		return sb.toString().substring(1);
	}

	public TreeNode deserialize(String data) {

		if (data == null || data.length() == 0) {
			return null;
		}

		String[] s = data.split(",");

		TreeNode[] node = new TreeNode[s.length];

		// 新建TreeNode，并初始化
		for (int i = 0; i < node.length; i++) {
			if (!"#".equals(s[i])) {
				node[i] = new TreeNode(Integer.valueOf(s[i]));
			}
		}

		int parent = 0;

		// 将结点连接起来
		for (int i = 0; parent * 2 + 2 < s.length; i++) {
			if (node[i] != null) {
				node[i].left = node[parent * 2 + 1];
				node[i].right = node[parent * 2 + 2];
				parent++;
			}
		}

		return node[0];
	}
}
