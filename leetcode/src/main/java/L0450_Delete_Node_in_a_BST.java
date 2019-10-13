import common.TreeNode;


public class L0450_Delete_Node_in_a_BST {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //如果右子树为null，则返回左子树
            if (root.right == null) {
                return root.left;
            } else {
                //如果右子树不为null，则返回右子树的最小节点
                //node为最小节点，parent为父节点
                TreeNode node = root.right;
                TreeNode parent = root;
                while (node != null && node.left != null) {
                    parent = node;
                    node = node.left;
                }
                //在右子树上删除node节点
                if (parent.left == node) {
                    parent.left = node.right;
                }
                if (parent.right == node) {
                    parent.right = node.right;
                }
                //将node节点放在key节点位置上
                node.left = root.left;
                node.right = root.right;
                return node;
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }

}
