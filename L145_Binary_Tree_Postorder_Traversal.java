package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L145_Binary_Tree_Postorder_Traversal {

	public class PostTreeNode {
		TreeNode node;
		boolean first;
	}

	public List<Integer> postorderTraversal(TreeNode root) {

		List<Integer> rt = new ArrayList<Integer>();

		if (root == null) {
			return rt;
		}

		Stack<PostTreeNode> stack = new Stack<PostTreeNode>();
		TreeNode p = root;
		PostTreeNode t;

		while (p != null || !stack.empty()) {

			while (p != null) {

				// 新建一个结点，这个结点包含一个布尔值first
				// 用来判断是否是第一次入栈
				PostTreeNode post = new PostTreeNode();
				post.node = p;
				post.first = true;
				stack.push(post);
				p = p.left;
			}

			if (!stack.empty()) {

				t = stack.pop();

				// 如果结点第一次出栈，再次入栈，将first置为false
				if (t.first == true) {
					t.first = false;
					stack.push(t);
					p = t.node.right;
				} else {
					rt.add(t.node.val);
					p = null;
				}
			}
		}

		return rt;
	}

}
