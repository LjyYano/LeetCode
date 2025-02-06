import common.Node;
import java.util.List;
import java.util.ArrayList;
import common.TreeNode;

// https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class L0095_Unique_Binary_Search_Trees_II {
    public List<TreeNode> generateTrees(int n) {
        if(n <= 0) return new ArrayList<>();
        return build(1, n);
    }
    private List<TreeNode> build(int start, int end) {
        List<TreeNode> roots = new ArrayList<>();       
        if(start > end) {           
            // null也要放入，否则下面的双重循环进不去
            roots.add(null);
            return roots;
        }
        if(start == end) {
            roots.add(new TreeNode(start));
            return roots;
        }
        for(int i = start; i <= end; i++) {
            List<TreeNode> leftList = build(start, i - 1);
            List<TreeNode> rightList = build(i + 1, end);
            for(TreeNode left : leftList) {             
                for(TreeNode right : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    roots.add(root);
                }
            }
        }
        return roots;
    }
}