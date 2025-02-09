import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/unique-binary-search-trees-ii/
 * 
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。可以按 任意顺序 返回答案。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/01/18/uniquebstn3.jpg)
 * 输入：n = 3
 * 输出：[[1,null,2,null,3],[1,null,3,2],[2,1,3],[3,1,null,null,2],[3,2,null,1]]
 * 
 * 示例 2：
 * 输入：n = 1
 * 输出：[[1]]
 * 
 * 提示：
 * - 1 <= n <= 8
 */
public class L0095_UniqueBinarySearchTreesII {
    
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
            return String.valueOf(val);
        }
    }
    
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return generateTreesHelper(1, n);
    }
    
    private List<TreeNode> generateTreesHelper(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        
        // 如果 start > end，说明是空子树，返回包含 null 的列表
        if (start > end) {
            result.add(null);
            return result;
        }
        
        // 遍历每个可能的根节点
        for (int i = start; i <= end; i++) {
            // 递归生成左子树的所有可能情况
            List<TreeNode> leftSubtrees = generateTreesHelper(start, i - 1);
            // 递归生成右子树的所有可能情况
            List<TreeNode> rightSubtrees = generateTreesHelper(i + 1, end);
            
            // 组合左右子树生成所有可能的二叉搜索树
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0095_UniqueBinarySearchTreesII solution = new L0095_UniqueBinarySearchTreesII();

        // 测试用例 1
        int n1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：n = " + n1);
        List<TreeNode> result1 = solution.generateTrees(n1);
        System.out.println("输出：" + result1);
        System.out.println("输出的二叉搜索树数量：" + result1.size());
        System.out.println();

        // 测试用例 2
        int n2 = 1;
        System.out.println("测试用例 2：");
        System.out.println("输入：n = " + n2);
        List<TreeNode> result2 = solution.generateTrees(n2);
        System.out.println("输出：" + result2);
        System.out.println("输出的二叉搜索树数量：" + result2.size());
    }
} 