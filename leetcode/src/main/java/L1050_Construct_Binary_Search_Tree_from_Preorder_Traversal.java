import common.Node;
import common.TreeNode;

// https://leetcode-cn.com/problems/construct-binary-search-tree-from-preorder-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L1050_Construct_Binary_Search_Tree_from_Preorder_Traversal {
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