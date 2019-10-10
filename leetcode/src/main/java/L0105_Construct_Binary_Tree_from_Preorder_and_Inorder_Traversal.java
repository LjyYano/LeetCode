import common.TreeNode;

public class L0105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] pre, int[] in) {
        return robot(pre, in, 0, 0, in.length - 1);
    }

    private TreeNode robot(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart >= pre.length || inStart > inEnd) {
			return null;
		}
        // 找到pos
        TreeNode root = new TreeNode(pre[preStart]);
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                index = i;
                break;
            }
        }
        root.left = robot(pre, in, preStart + 1, inStart, index - 1);
        root.right = robot(pre, in, preStart + 1 + index - inStart, index + 1, inEnd);
        return root;
    }
}
