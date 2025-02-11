import common.TreeNode;

/**
 * https://leetcode.cn/problems/delete-node-in-a-bst/
 * 
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * 
 * 一般来说，删除节点可分为两个步骤：
 * 1. 首先找到需要删除的节点；
 * 2. 如果找到了，删除它。
 * 
 * 示例 1:
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * 
 * 示例 2:
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 
 * 示例 3:
 * 输入: root = [], key = 0
 * 输出: []
 * 
 * 提示:
 * - 节点数的范围 [0, 10⁴]
 * - -10⁵ <= Node.val <= 10⁵
 * - 节点值唯一
 * - root 是合法的二叉搜索树
 * - -10⁵ <= key <= 10⁵
 */
public class L0450_DeleteNodeInBst {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        
        // 如果 key 小于当前节点值，继续在左子树中删除
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        }
        // 如果 key 大于当前节点值，继续在右子树中删除
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        }
        // 找到要删除的节点
        else {
            // 情况 1：叶子节点，直接删除
            if (root.left == null && root.right == null) {
                return null;
            }
            // 情况 2：只有一个子节点，返回该子节点
            else if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }
            // 情况 3：有两个子节点，找到右子树中的最小节点
            else {
                TreeNode minNode = findMin(root.right);
                // 用最小节点的值替换当前节点的值
                root.val = minNode.val;
                // 删除最小节点
                root.right = deleteNode(root.right, minNode.val);
            }
        }
        return root;
    }
    
    // 查找以 root 为根的子树中的最小节点
    private TreeNode findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {
        L0450_DeleteNodeInBst solution = new L0450_DeleteNodeInBst();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(6);
        root1.left.left = new TreeNode(2);
        root1.left.right = new TreeNode(4);
        root1.right.right = new TreeNode(7);
        
        System.out.println("删除节点 3 前的中序遍历：");
        printInorder(root1);
        
        TreeNode result1 = solution.deleteNode(root1, 3);
        
        System.out.println("\n删除节点 3 后的中序遍历：");
        printInorder(result1);
        
        // 测试用例 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(6);
        root2.left.left = new TreeNode(2);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);
        
        System.out.println("\n\n删除不存在的节点 0 前的中序遍历：");
        printInorder(root2);
        
        TreeNode result2 = solution.deleteNode(root2, 0);
        
        System.out.println("\n删除不存在的节点 0 后的中序遍历：");
        printInorder(result2);
    }
    
    // 辅助方法：中序遍历打印二叉树
    private static void printInorder(TreeNode root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }
} 