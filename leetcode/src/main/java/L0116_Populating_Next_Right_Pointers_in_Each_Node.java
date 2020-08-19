import common.Node;

// https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class L0116_Populating_Next_Right_Pointers_in_Each_Node {
    
    public void connect(TreeLinkNode root) {
       if(root == null) return;
        
        if(root.left != null) {
            root.left.next = root.right;
            if(root.next != null) {
                root.right.next = root.next.left;
            }
        }
        
        connect(root.left);
        connect(root.right);
    }
}