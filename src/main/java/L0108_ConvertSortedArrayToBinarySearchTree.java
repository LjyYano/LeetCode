import java.util.*;

/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * 
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2021/02/18/btree1.jpg)
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * ![img](https://assets.leetcode.com/uploads/2021/02/18/btree2.jpg)
 * 
 * 示例 2：
 * ![img](https://assets.leetcode.com/uploads/2021/02/18/btree.jpg)
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * 
 * 提示：
 * - 1 <= nums.length <= 10⁴
 * - -10⁴ <= nums[i] <= 10⁴
 * - nums 按 严格递增 顺序排列
 */
public class L0108_ConvertSortedArrayToBinarySearchTree {
    
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

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    /**
     * 递归构建二叉搜索树
     * 
     * @param nums 有序数组
     * @param left 左边界（包含）
     * @param right 右边界（包含）
     * @return 构建好的二叉搜索树的根节点
     */
    private TreeNode buildBST(int[] nums, int left, int right) {
        // 递归终止条件：左边界大于右边界
        if (left > right) {
            return null;
        }

        // 选择中间位置作为根节点
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        // 递归构建左右子树
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);

        return root;
    }

    public static void main(String[] args) {
        L0108_ConvertSortedArrayToBinarySearchTree solution = new L0108_ConvertSortedArrayToBinarySearchTree();

        // 测试用例 1：普通有序数组
        int[] nums1 = {-10, -3, 0, 5, 9};
        System.out.println("测试用例 1：");
        System.out.println("输入：nums = " + Arrays.toString(nums1));
        System.out.println("输出：" + solution.sortedArrayToBST(nums1));
        System.out.println();

        // 测试用例 2：两个元素的数组
        int[] nums2 = {1, 3};
        System.out.println("测试用例 2：");
        System.out.println("输入：nums = " + Arrays.toString(nums2));
        System.out.println("输出：" + solution.sortedArrayToBST(nums2));
        System.out.println();

        // 测试用例 3：单个元素的数组
        int[] nums3 = {0};
        System.out.println("测试用例 3：");
        System.out.println("输入：nums = " + Arrays.toString(nums3));
        System.out.println("输出：" + solution.sortedArrayToBST(nums3));
    }
} 