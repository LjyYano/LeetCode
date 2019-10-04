import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import common.TreeNode;

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

				// �½�һ����㣬���������һ������ֵfirst
				// �����ж��Ƿ��ǵ�һ����ջ
				PostTreeNode post = new PostTreeNode();
				post.node = p;
				post.first = true;
				stack.push(post);
				p = p.left;
			}

			if (!stack.empty()) {

				t = stack.pop();

				// �������һ�γ�ջ���ٴ���ջ����first��Ϊfalse
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
