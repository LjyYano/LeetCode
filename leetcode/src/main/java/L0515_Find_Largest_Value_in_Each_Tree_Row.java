import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class L0515_Find_Largest_Value_in_Each_Tree_Row {

    // solution 1：递归
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans, 0);
        return ans;
    }

    private void robot(TreeNode root, List<Integer> ans, int level) {
        if (root == null) {
            return;
        }

        if (ans.size() <= level) {
            ans.add(Integer.MIN_VALUE);
        }

        ans.set(level, Math.max(ans.get(level), root.val));
        robot(root.left, ans, level + 1);
        robot(root.right, ans, level + 1);
    }

    // solution 2：迭代
    public List<Integer> largestValues2(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int current = Integer.MIN_VALUE;

            // 当前层的元素个数
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                TreeNode node = queue.remove();

                // 放入结果（变化的地方）
                current = Math.max(current, node.val);

                // 依次将 node 的左右子节点加入队列
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ans.add(current);
        }
        return ans;
    }
}
