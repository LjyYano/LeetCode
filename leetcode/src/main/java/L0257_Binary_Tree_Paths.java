import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class L0257_Binary_Tree_Paths {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        robot(root, ans, "");
        return ans;
    }

    private void robot(TreeNode root, List<String> ans, String path) {
        if (root == null) {
			return;
		}
        if (root.left == null && root.right == null) {
            ans.add(path + root.val);
            return;
        }
        robot(root.left, ans, path + root.val + "->");
        robot(root.right, ans, path + root.val + "->");
    }
}
