import common.Node;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import common.TreeNode;

// https://leetcode-cn.com/problems/find-mode-in-binary-search-tree/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0501_Find_Mode_in_Binary_Search_Tree {
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> ans = new ArrayList<>();
        int currentTime = 0, maxTime = Integer.MIN_VALUE, beforeVal = 0;
        Stack<TreeNode> stack = new Stack<>();
        // 将根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            // 取出栈顶元素
            TreeNode tmp = stack.pop();
            if (tmp != null) {
                // 第一个
                if (maxTime == Integer.MIN_VALUE) {
                    currentTime++;
                    maxTime = currentTime;
                } else if (tmp.val == beforeVal) {
                    currentTime++;
                } else {
                    currentTime = 1;
                }

                if (maxTime < currentTime) {
                    maxTime = currentTime;
                    // 置成新的
                    ans.clear();
                    ans.add(tmp.val);
                } else if (maxTime == currentTime) {
                    ans.add(tmp.val);
                }

                beforeVal = tmp.val;

                // 将其孩子节点压入栈中（先右节点、再左节点）
                if (tmp.right != null) {
                    stack.add(tmp.right);
                }
                if (tmp.left != null) {
                    stack.add(tmp.left);
                }
            }
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}