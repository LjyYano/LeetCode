import java.util.*;

/**
 * https://leetcode.cn/problems/construct-quad-tree/description/
 * 
 * 给你一个 n * n 矩阵 grid ，矩阵由若干 0 和 1 组成。请你用四叉树表示该矩阵 grid 。
 * 你需要返回能表示矩阵的 四叉树 的根结点。
 * 
 * 注意，当 isLeaf 为 False 时，你可以把 True 或者 False 赋值给节点，两种值都会被判题机制 接受 。
 * 
 * 四叉树数据结构中，每个内部节点只有四个子节点。此外，每个节点都有两个属性：
 * - val：储存叶子结点所代表的区域的值。1 对应 True，0 对应 False；
 * - isLeaf：当这个节点是一个叶子结点时为 True，如果它有 4 个子节点则为 False 。
 * 
 * 示例 1：
 * 输入：grid = [[0,1],[1,0]]
 * 输出：[[0,1],[1,0],[1,1],[1,1],[1,0]]
 * 解释：此示例的解释如下：
 * 请注意，在下面四叉树的图示中，0 表示 false，1 表示 True 。
 * 
 * 示例 2：
 * 输入：grid = [[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,1],
 *              [1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0],[1,1,1,1,0,0,0,0]]
 * 输出：[[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
 */
public class L0427_ConstructQuadTree {
    
    // 定义四叉树节点
    static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }
        
        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length);
    }
    
    /**
     * 递归构建四叉树
     * 
     * @param grid 输入矩阵
     * @param row 当前区域的起始行
     * @param col 当前区域的起始列
     * @param size 当前区域的大小
     * @return 构建好的四叉树节点
     */
    private Node construct(int[][] grid, int row, int col, int size) {
        // 检查当前区域是否都是相同的值
        boolean isLeaf = true;
        int val = grid[row][col];
        
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) break;
        }
        
        // 如果是叶子节点，直接返回
        if (isLeaf) {
            return new Node(val == 1, true);
        }
        
        // 不是叶子节点，递归构建四个子节点
        int newSize = size / 2;
        Node node = new Node(true, false);
        node.topLeft = construct(grid, row, col, newSize);
        node.topRight = construct(grid, row, col + newSize, newSize);
        node.bottomLeft = construct(grid, row + newSize, col, newSize);
        node.bottomRight = construct(grid, row + newSize, col + newSize, newSize);
        
        return node;
    }

    public static void main(String[] args) {
        L0427_ConstructQuadTree solution = new L0427_ConstructQuadTree();
        
        // 测试用例1
        int[][] grid1 = {{0,1}, {1,0}};
        System.out.println("测试用例1：");
        System.out.println("输入：grid = " + Arrays.deepToString(grid1));
        solution.construct(grid1);
        System.out.println("输出：四叉树已构建");
        
        // 测试用例2
        int[][] grid2 = {
            {1,1,1,1,0,0,0,0},
            {1,1,1,1,0,0,0,0},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,1,1,1,1},
            {1,1,1,1,0,0,0,0},
            {1,1,1,1,0,0,0,0},
            {1,1,1,1,0,0,0,0},
            {1,1,1,1,0,0,0,0}
        };
        System.out.println("\n测试用例2：");
        System.out.println("输入：grid = " + Arrays.deepToString(grid2));
        solution.construct(grid2);
        System.out.println("输出：四叉树已构建");
    }
} 