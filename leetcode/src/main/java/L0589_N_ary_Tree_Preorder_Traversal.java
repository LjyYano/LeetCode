import java.util.ArrayList;
import java.util.List;

import common.Node;

public class L0589_N_ary_Tree_Preorder_Traversal {

    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        robot(root, ans);
        return ans;
    }

    private void robot(Node root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        ans.add(root.val);
        if (root.children == null) {
            return;
        }

        for (Node child : root.children) {
            robot(child, ans);
        }
    }
}
