import java.util.ArrayList;
import java.util.List;

import common.TreeNode;

public class L0095_Unique_Binary_Search_Trees_II {

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {
        List<TreeNode> roots = new ArrayList<>();
        if (start > end) {
            // null也要放入，否则下面的双重循环进不去
            roots.add(null);
            return roots;
        }
        if (start == end) {
            roots.add(new TreeNode(start));
            return roots;
        }
        for (int i = start; i <= end; i++) {
            // 递归求出[start,i-1]的所有左子树
            List<TreeNode> leftList = build(start, i - 1);
            // 递归求出[i+1,end]的所有右子树
            List<TreeNode> rightList = build(i + 1, end);

            // 对上面求出的所有左子树、所有右子树做笛卡尔积，分别赋值给root的左右节点
            for (TreeNode left : leftList) {
                for (TreeNode right : rightList) {
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
