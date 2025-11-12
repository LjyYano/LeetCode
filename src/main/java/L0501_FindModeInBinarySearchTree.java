/**
 * https://leetcode.cn/problems/find-mode-in-binary-search-tree/
 * 
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 
 * 假定 BST 满足如下定义：
 * - 结点左子树中所含节点的值 小于等于 当前节点的值
 * - 结点右子树中所含节点的值 大于等于 当前节点的值
 * - 左子树和右子树都是二叉搜索树
 * 
 * 示例 1：
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 
 * 示例 2：
 * 输入：root = [0]
 * 输出：[0]
 * 
 * 提示：
 * - 树中节点的数目在范围 [1, 10^4] 内
 * - -10^5 <= Node.val <= 10^5
 * 
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
import common.TreeNode;
import java.util.*;

public class L0501_FindModeInBinarySearchTree {
    
    private int maxCount = 0;
    private int currentCount = 0;
    private Integer prev = null;
    private List<Integer> modes = new ArrayList<>();
    
    /**
     * 中序遍历 BST
     * 利用 BST 的性质，中序遍历是有序的，相同的值会连续出现
     */
    public int[] findMode(TreeNode root) {
        inorder(root);
        
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        inorder(node.left);
        
        // 处理当前节点
        if (prev == null || node.val != prev) {
            currentCount = 1;
        } else {
            currentCount++;
        }
        
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }
        
        prev = node.val;
        
        inorder(node.right);
    }

    public static void main(String[] args) {
        L0501_FindModeInBinarySearchTree solution = new L0501_FindModeInBinarySearchTree();
        
        // 测试用例 1: [1,null,2,2]
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.right.left = new TreeNode(2);
        int[] result1 = solution.findMode(root1);
        System.out.println(Arrays.toString(result1)); // 预期输出：[2]
        
        // 测试用例 2: [0]
        TreeNode root2 = new TreeNode(0);
        int[] result2 = solution.findMode(root2);
        System.out.println(Arrays.toString(result2)); // 预期输出：[0]
    }
}
