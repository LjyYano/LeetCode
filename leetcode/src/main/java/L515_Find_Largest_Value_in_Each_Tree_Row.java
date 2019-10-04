import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class L515_Find_Largest_Value_in_Each_Tree_Row {

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

}
