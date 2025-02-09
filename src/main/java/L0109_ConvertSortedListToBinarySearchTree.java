import common.ListNode;

/**
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 * 
 * 给定一个单链表的头节点 head ，其中的元素 按升序排序 ，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * 
 * 示例 1：
 * ![img](https://assets.leetcode.com/uploads/2020/08/17/linked.jpg)
 * 输入：head = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：一个可能的答案是[0,-3,9,-10,null,5]，它表示所示的高度平衡的二叉搜索树。
 * 
 * 示例 2：
 * 输入：head = []
 * 输出：[]
 * 
 * 提示：
 * - head 中的节点数在[0, 2 * 10⁴]范围内
 * - -10⁵ <= Node.val <= 10⁵
 */
public class L0109_ConvertSortedListToBinarySearchTree {
    
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

    public TreeNode sortedListToBST(ListNode head) {
        // 如果链表为空，返回 null
        if (head == null) {
            return null;
        }
        // 如果链表只有一个节点，直接返回包含该值的树节点
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 使用快慢指针找到链表的中间节点
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        // 断开链表，分成左右两部分
        prev.next = null;
        
        // 创建根节点
        TreeNode root = new TreeNode(slow.val);
        
        // 递归构建左右子树
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }

    public static void main(String[] args) {
        L0109_ConvertSortedListToBinarySearchTree solution = new L0109_ConvertSortedListToBinarySearchTree();

        // 测试用例 1：普通有序链表
        ListNode head1 = new ListNode(-10);
        head1.next = new ListNode(-3);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(5);
        head1.next.next.next.next = new ListNode(9);
        System.out.println("测试用例 1：");
        System.out.println("输入：head = " + head1);
        System.out.println("输出：" + solution.sortedListToBST(head1));
        System.out.println();

        // 测试用例 2：空链表
        System.out.println("测试用例 2：");
        System.out.println("输入：head = null");
        System.out.println("输出：" + solution.sortedListToBST(null));
        System.out.println();

        // 测试用例 3：单个节点的链表
        ListNode head3 = new ListNode(0);
        System.out.println("测试用例 3：");
        System.out.println("输入：head = " + head3);
        System.out.println("输出：" + solution.sortedListToBST(head3));
    }
} 