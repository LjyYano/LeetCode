import common.Node;
import java.util.Stack;
import common.TreeNode;

// https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0230_Kth_Smallest_Element_in_a_BST {
    public int kthSmallest(TreeNode root, int k) {

        if (root == null) {
            return 0;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            if (!stack.isEmpty()) {
                root = stack.pop();
                if (--k == 0) {
                    return root.val;
                }
                root = root.right;
            }
        }

        return 0;
    }
}