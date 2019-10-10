import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

import common.TreeNode;

public class L0297_Serialize_and_Deserialize_Binary_Tree {

    public String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);

        while (!deque.isEmpty()) {
            TreeNode p = deque.pop();

            if (p == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(p.val);
                deque.add(p.left);
                deque.add(p.right);
            }
        }

        return sb.toString().substring(1);
    }

    public TreeNode deserialize(String data) {

        if (data == null || Objects.equals(data, "")) {
            return null;
        }

        String[] s = data.split(",");

        TreeNode[] root = new TreeNode[s.length];

        for (int i = 0; i < root.length; i++) {
            if (!Objects.equals(s[i], "#")) {
                root[i] = new TreeNode(Integer.valueOf(s[i]));
            }
        }

        int parent = 0;

        for (int i = 0; parent * 2 + 2 < s.length; i++) {
            if (root[i] != null) {
                root[i].left = root[parent * 2 + 1];
                root[i].right = root[parent * 2 + 2];
                parent++;
            }
        }

        return root[0];
    }
}
