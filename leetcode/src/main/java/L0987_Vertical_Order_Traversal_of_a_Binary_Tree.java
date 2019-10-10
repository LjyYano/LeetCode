import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import common.TreeNode;

public class L0987_Vertical_Order_Traversal_of_a_Binary_Tree {

    public class PositionNode {
        int val;
        int x;
        int y;

        PositionNode(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        public int getVal() {
            return val;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        // 构建节点的位置信息
        List<PositionNode> posNodes = new ArrayList<>();
        robot(root, posNodes, 0, 0);

        // 将 posNodes 展开成 key 是 x 坐标、value 是对应 PositionNode 的 map
        // 注意这里使用 TreeMap，因为要对 x 坐标排序
        Map<Integer, List<PositionNode>> positionMap = posNodes.stream().collect(
                Collectors.groupingBy(PositionNode::getX, TreeMap::new, Collectors.toList()));

        // 构建结果
        List<List<Integer>> ans = new ArrayList<>();
        positionMap.forEach((k, v) -> {
            // 题目要求：相同位置节点，按照自然顺序排序（即先按照 Y 降序排列；若 Y 相同，则按照 val 升序排列）
            v.sort(Comparator.comparing(PositionNode::getY).reversed()
                    .thenComparing(PositionNode::getVal));
            ans.add(v.stream().map(PositionNode::getVal).collect(Collectors.toList()));
        });
        return ans;
    }

    private void robot(TreeNode root, List<PositionNode> posNodes, int x, int y) {
        if (root == null) {
            return;
        }

        posNodes.add(new PositionNode(root.val, x, y));

        // 根节点的(x,y)=(0,0)，若某个节点坐标为(x,y)，则左节点坐标为(x-1,y-1)，右节点坐标为(x+1,y-1)
        robot(root.left, posNodes, x - 1, y - 1);
        robot(root.right, posNodes, x + 1, y - 1);
    }
}
