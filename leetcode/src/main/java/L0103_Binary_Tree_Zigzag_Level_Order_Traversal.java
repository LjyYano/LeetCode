import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import common.TreeNode;

public class L0103_Binary_Tree_Zigzag_Level_Order_Traversal {

    // solution 1：递归
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        robot(root, ans, 0);
        // 与层序遍历相比，变化的部分
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }

    private void robot(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        if (ans.size() == level) {
            ans.add(new ArrayList());
        }
        ans.get(level).add(root.val);
        robot(root.left, ans, level + 1);
        robot(root.right, ans, level + 1);
    }

    // solution 2：迭代
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> current = new ArrayList<>();

            // 当前层的元素个数
            int length = queue.size();
            for (int i = 0; i < length; ++i) {
                TreeNode node = queue.remove();

                // 放入结果
                current.add(node.val);

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
        // 与层序遍历相比，变化的部分
        for (int i = 1; i < ans.size(); i += 2) {
            Collections.reverse(ans.get(i));
        }
        return ans;
    }
}
