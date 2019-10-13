import common.TreeNode;

public class L0108_Convert_Sorted_Array_to_Binary_Search_Tree {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return robot(nums, 0, nums.length - 1);
    }

    private TreeNode robot(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        // 划分为 [start, mid) 和 (mid,end] 区间
        int mid = start + (end - start) / 2;

        // 创建节点，并分别递归两个区间
        TreeNode root = new TreeNode(nums[mid]);
        root.left = robot(nums, start, mid - 1);
        root.right = robot(nums, mid + 1, end);
        return root;
    }
}
