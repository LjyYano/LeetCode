package common;

/**
 * 二叉树节点的定义
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(this, sb);
        return sb.toString();
    }

    private void toString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("null");
            return;
        }
        sb.append(node.val);
        if (node.left != null || node.right != null) {
            sb.append(",");
            toString(node.left, sb);
            sb.append(",");
            toString(node.right, sb);
        }
    }
}
