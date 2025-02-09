import java.util.*;

/**
 * https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * 
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/19/tree1.jpg)
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
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
 * - -100 <= Node.val <= 100
 */
public class L0103_BinaryTreeZigzagLevelOrderTraversal {
    
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 使用队列进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        // 标记是否需要反转当前层的遍历结果
        boolean isReverse = false;

        while (!queue.isEmpty()) {
            // 当前层的节点数
            int levelSize = queue.size();
            // 使用双端队列存储当前层的节点值
            LinkedList<Integer> currentLevel = new LinkedList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                
                // 根据方向决定是从头部还是尾部添加节点值
                if (isReverse) {
                    currentLevel.addFirst(node.val);
                } else {
                    currentLevel.addLast(node.val);
                }

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
            // 切换方向
            isReverse = !isReverse;
        }

        return result;
    }

    public static void main(String[] args) {
        L0103_BinaryTreeZigzagLevelOrderTraversal solution = new L0103_BinaryTreeZigzagLevelOrderTraversal();

        // 测试用例 1：普通二叉树
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("测试用例 1：");
        System.out.println("输入：root = " + root1);
        System.out.println("输出：" + solution.zigzagLevelOrder(root1));
        System.out.println();

        // 测试用例 2：单个节点
        TreeNode root2 = new TreeNode(1);
        System.out.println("测试用例 2：");
        System.out.println("输入：root = " + root2);
        System.out.println("输出：" + solution.zigzagLevelOrder(root2));
        System.out.println();

        // 测试用例 3：空树
        System.out.println("测试用例 3：");
        System.out.println("输入：root = null");
        System.out.println("输出：" + solution.zigzagLevelOrder(null));
    }
} 