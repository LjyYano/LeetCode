import common.TreeNode;

public class L0106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    public TreeNode buildTree(int[] in, int[] post) {
        return robot(in, post, 0, in.length - 1, 0, post.length - 1);
    }

    private TreeNode robot(int[] in, int[] post, int inStart, int inEnd, int postStart,
            int postEnd) {
        if (postStart > postEnd) {
            return null;
        }
        TreeNode root = new TreeNode(post[postEnd]);
        int pos = 0;
        // 找到pos
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.val) {
                pos = i;
                break;
            }
        }
        root.left = robot(in, post, inStart, pos - 1, postStart, postStart + pos - inStart - 1);
        root.right = robot(in, post, pos + 1, inEnd, postEnd + pos - inEnd, postEnd - 1);
        return root;
    }

}
