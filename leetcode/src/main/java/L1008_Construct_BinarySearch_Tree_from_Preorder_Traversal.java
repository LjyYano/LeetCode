import common.TreeNode;

public class L1008_Construct_BinarySearch_Tree_from_Preorder_Traversal {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        return robot(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private TreeNode robot(int[] preorder, int min, int max) {
        if (index == preorder.length) {
            return null;
        }

        int val = preorder[index];
        if (val < min || val > max) {
            return null;
        }
        index++;
        TreeNode root = new TreeNode(val);
        root.left = robot(preorder, min, val);
        root.right = robot(preorder, val, max);
        return root;
    }
}
