import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * 
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 
 * 示例 2：
 * 输入：root = [1]
 * 输出：[[1]]
 * 
 * 示例 3：
 * 输入：root = []
 * 输出：[]
 * 
 * 提示：
 * - 树中节点数目在范围 [0, 2000] 内
 * - -1000 <= Node.val <= 1000
 */
public class L0102_BinaryTreeLevelOrderTraversal {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        
        TreeNode() {}
        
        TreeNode(int val) {
            this.val = val;
        }
        
        TreeNode(int val, TreeNode left, TreeNode right) {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // 当前层的节点数
            int levelSize = queue.size();
            // 存储当前层的节点值
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                currentLevel.add(node.val);

                // 将下一层的节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 将当前层的结果加入最终结果
            result.add(currentLevel);
        }

        return result;
    }

    public static void main(String[] args) {
        L0102_BinaryTreeLevelOrderTraversal solution = new L0102_BinaryTreeLevelOrderTraversal();

        // 测试用例 1：普通二叉树
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = " + root1);
        System.out.println("输出：" + solution.levelOrder(root1));
        System.out.println();

        // 测试用例 2：单个节点
        TreeNode root2 = new TreeNode(1);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = " + root2);
        System.out.println("输出：" + solution.levelOrder(root2));
        System.out.println();

        // 测试用例 3：空树
        System.out.println("测试用例 3：");
        System.out.println("输入：root = null");
        System.out.println("输出：" + solution.levelOrder(null));
    }
}