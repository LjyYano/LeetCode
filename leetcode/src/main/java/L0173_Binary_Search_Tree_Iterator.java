import java.util.Stack;

import common.TreeNode;

public class L0173_Binary_Search_Tree_Iterator {
    class BSTIterator {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;

        public BSTIterator(TreeNode root) {
            current = root;
            // 一直放入左儿子（左）
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            // 一直放入左儿子（左）
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            int ans = 0;
            // 访问当前元素（根），把右儿子入栈（右）
            if (!stack.isEmpty()) {
                current = stack.pop();
                ans = current.val;
                current = current.right;
            }
            return ans;
        }
    }

    /**
     * Your BSTIterator object will be instantiated and called as such:
     * BSTIterator obj = new BSTIterator(root);
     * int param_1 = obj.next();
     * boolean param_2 = obj.hasNext();
     */

}