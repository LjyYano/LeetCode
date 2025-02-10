/*
 * https://leetcode.cn/problems/range-sum-query-mutable/
 * 
 * 给你一个数组 nums，请你完成两类查询。
 * 
 * 1. 其中一类查询要求 更新 数组 nums 下标对应的值
 * 2. 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（包含）的nums元素的 和，其中 left <= right
 * 
 * 实现 NumArray 类：
 * 
 * NumArray(int[] nums) 用整数数组 nums 初始化对象
 * void update(int index, int val) 将 nums[index] 的值 更新 为 val
 * int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（包含）的nums元素的 和（即，nums[left] + nums[left + 1], ..., nums[right]）
 * 
 * 示例 1：
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 * 
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 * 
 * 提示：
 * 1 <= nums.length <= 3 * 10⁴
 * -100 <= nums[i] <= 100
 * 0 <= index < nums.length
 * -100 <= val <= 100
 * 0 <= left <= right < nums.length
 * 调用 update 和 sumRange 方法次数不大于 3 * 10⁴
 */

public class L0307_RangeSumQueryMutable {
    // 线段树节点类
    private static class SegmentTreeNode {
        private int start, end;
        private SegmentTreeNode left, right;
        private int sum;

        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }

    private SegmentTreeNode root = null;

    // 构建线段树
    private SegmentTreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        
        if (start == end) {
            node.sum = nums[start];
            return node;
        }
        
        int mid = start + (end - start) / 2;
        node.left = buildTree(nums, start, mid);
        node.right = buildTree(nums, mid + 1, end);
        node.sum = node.left.sum + node.right.sum;
        
        return node;
    }

    // 更新线段树中的值
    private void updateTree(SegmentTreeNode node, int index, int val) {
        if (node.start == node.end) {
            node.sum = val;
            return;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (index <= mid) {
            updateTree(node.left, index, val);
        } else {
            updateTree(node.right, index, val);
        }
        
        node.sum = node.left.sum + node.right.sum;
    }

    // 查询区间和
    private int queryTree(SegmentTreeNode node, int left, int right) {
        if (node.start == left && node.end == right) {
            return node.sum;
        }
        
        int mid = node.start + (node.end - node.start) / 2;
        if (right <= mid) {
            return queryTree(node.left, left, right);
        } else if (left > mid) {
            return queryTree(node.right, left, right);
        } else {
            return queryTree(node.left, left, mid) + queryTree(node.right, mid + 1, right);
        }
    }

    public L0307_RangeSumQueryMutable(int[] nums) {
        if (nums.length > 0) {
            root = buildTree(nums, 0, nums.length - 1);
        }
    }
    
    public void update(int index, int val) {
        if (root != null) {
            updateTree(root, index, val);
        }
    }
    
    public int sumRange(int left, int right) {
        if (root == null) {
            return 0;
        }
        return queryTree(root, left, right);
    }

    public static void main(String[] args) {
        // 测试用例 1
        int[] nums1 = {1, 3, 5};
        L0307_RangeSumQueryMutable numArray = new L0307_RangeSumQueryMutable(nums1);
        System.out.println(numArray.sumRange(0, 2)); // 应输出 9
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2)); // 应输出 8

        // 测试用例 2
        int[] nums2 = {1, 2, 3, 4, 5};
        L0307_RangeSumQueryMutable numArray2 = new L0307_RangeSumQueryMutable(nums2);
        System.out.println(numArray2.sumRange(0, 4)); // 应输出 15
        numArray2.update(2, 10);
        System.out.println(numArray2.sumRange(1, 3)); // 应输出 16
    }
} 