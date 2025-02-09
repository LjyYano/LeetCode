import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle-ii/
 * 
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 示例 1：
 * 输入：rowIndex = 3
 * 输出：[1,3,3,1]
 * 
 * 示例 2：
 * 输入：rowIndex = 0
 * 输出：[1]
 * 
 * 示例 3：
 * 输入：rowIndex = 1
 * 输出：[1,1]
 * 
 * 提示：
 * - 0 <= rowIndex <= 33
 * 
 * 进阶：你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 */
public class L0119_PascalsTriangleII {
    
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        // 第一个数字总是 1
        row.add(1);
        
        // 如果是第 0 行，直接返回
        if (rowIndex == 0) {
            return row;
        }
        
        // 从第 1 行开始计算
        for (int i = 1; i <= rowIndex; i++) {
            // 从后向前计算，避免使用额外空间
            for (int j = row.size() - 1; j >= 1; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
            // 添加每行最后的 1
            row.add(1);
        }
        
        return row;
    }

    public static void main(String[] args) {
        L0119_PascalsTriangleII solution = new L0119_PascalsTriangleII();
        
        // 测试用例 1：第 3 行
        int rowIndex1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：rowIndex = " + rowIndex1);
        System.out.println("输出：" + solution.getRow(rowIndex1));
        System.out.println();
        
        // 测试用例 2：第 0 行
        int rowIndex2 = 0;
        System.out.println("测试用例 2：");
        System.out.println("输入：rowIndex = " + rowIndex2);
        System.out.println("输出：" + solution.getRow(rowIndex2));
        System.out.println();
        
        // 测试用例 3：第 1 行
        int rowIndex3 = 1;
        System.out.println("测试用例 3：");
        System.out.println("输入：rowIndex = " + rowIndex3);
        System.out.println("输出：" + solution.getRow(rowIndex3));
    }
} 