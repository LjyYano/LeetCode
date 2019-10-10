import common.TreeNode;

public class L0222_Count_Complete_Tree_Nodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = 0;
        int right = 0;

        TreeNode p = root;
        while (p != null) {
            p = p.left;
            left++;
        }

        p = root;
        while (p != null) {
            p = p.right;
            right++;
        }

        if (left == right) {
            return (1 << left) - 1;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

}
