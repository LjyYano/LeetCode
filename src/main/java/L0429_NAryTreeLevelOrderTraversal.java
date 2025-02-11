import java.util.*;

/**
 * https://leetcode.cn/problems/n-ary-tree-level-order-traversal/description/
 * 
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 * 
 * 示例 1：
 * 输入：root = [1,null,3,2,4,null,5,6]
 * 输出：[[1],[3,2,4],[5,6]]
 * 
 * 示例 2：
 * 输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * 输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 */
public class L0429_NAryTreeLevelOrderTraversal {
    
    // 定义 N 叉树节点
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        // 使用队列进行层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();
            
            // 处理当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                currentLevel.add(node.val);
                
                // 将当前节点的所有子节点加入队列
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            
            result.add(currentLevel);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0429_NAryTreeLevelOrderTraversal solution = new L0429_NAryTreeLevelOrderTraversal();
        
        // 构建测试用例1
        Node root1 = new Node(1);
        Node node3 = new Node(3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        
        root1.children = Arrays.asList(node3, node2, node4);
        node3.children = Arrays.asList(node5, node6);
        
        System.out.println("测试用例1：");
        System.out.println("输入：root = [1,null,3,2,4,null,5,6]");
        System.out.println("输出：" + solution.levelOrder(root1));
        
        // 构建测试用例2
        Node root2 = new Node(1);
        Node node2_2 = new Node(2);
        Node node3_2 = new Node(3);
        Node node4_2 = new Node(4);
        Node node5_2 = new Node(5);
        Node node6_2 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        Node node10 = new Node(10);
        Node node11 = new Node(11);
        Node node12 = new Node(12);
        Node node13 = new Node(13);
        Node node14 = new Node(14);
        
        root2.children = Arrays.asList(node2_2, node3_2, node4_2, node5_2);
        node3_2.children = Arrays.asList(node6_2, node7);
        node4_2.children = Arrays.asList(node8);
        node5_2.children = Arrays.asList(node9, node10);
        node7.children = Arrays.asList(node11);
        node8.children = Arrays.asList(node12);
        node9.children = Arrays.asList(node13);
        node11.children = Arrays.asList(node14);
        
        System.out.println("\n测试用例2：");
        System.out.println("输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]");
        System.out.println("输出：" + solution.levelOrder(root2));
    }
} 