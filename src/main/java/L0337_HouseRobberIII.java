import common.TreeNode;

/**
 * https://leetcode.cn/problems/house-robber-iii/
 * 
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * 
 * 除了 root 之外，每栋房子有且只有一个"父"房子与之相连。一番侦察之后，聪明的小偷意识到"这个地方的所有房屋的排列类似于一棵二叉树"。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * 
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * 
 * 示例 1:
 * ![img](https://assets.leetcode.com/uploads/2021/03/10/rob1-tree.jpg)
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7 
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 
 * 示例 2:
 * ![img](https://assets.leetcode.com/uploads/2021/03/10/rob2-tree.jpg)
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * 
 * 提示：
 * 树的节点数在 [1, 10⁴] 范围内
 * 0 <= Node.val <= 10⁴
 */
public class L0337_HouseRobberIII {
    
    /**
     * 使用后序遍历解决打家劫舍 III
     * 对于每个节点，返回一个长度为 2 的数组
     * dp[0] 表示不选择当前节点时能获得的最大金额
     * dp[1] 表示选择当前节点时能获得的最大金额
     */
    public int rob(TreeNode root) {
        int[] result = robHelper(root);
        return Math.max(result[0], result[1]);
    }
    
    /**
     * 后序遍历辅助函数
     * @return int[2] 数组，分别表示不选择和选择当前节点时能获得的最大金额
     */
    private int[] robHelper(TreeNode node) {
        // 基本情况：空节点
        if (node == null) {
            return new int[]{0, 0};
        }
        
        // 后序遍历
        int[] left = robHelper(node.left);
        int[] right = robHelper(node.right);
        
        // 当前节点的结果数组
        int[] result = new int[2];
        
        // 不选择当前节点
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        
        // 选择当前节点
        result[1] = node.val + left[0] + right[0];
        
        return result;
    }

    public static void main(String[] args) {
        L0337_HouseRobberIII solution = new L0337_HouseRobberIII();
        
        // 测试用例 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        
        System.out.println("测试用例 1：");
        System.out.println("输入：[3,2,3,null,3,null,1]");
        System.out.println("输出：" + solution.rob(root1));
        System.out.println("预期输出：7");
        System.out.println();
        
        // 测试用例 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        
        System.out.println("测试用例 2：");
        System.out.println("输入：[3,4,5,1,3,null,1]");
        System.out.println("输出：" + solution.rob(root2));
        System.out.println("预期输出：9");
    }
} 