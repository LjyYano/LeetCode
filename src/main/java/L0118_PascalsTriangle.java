import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/
 * 
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 
 * 示例 1：
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 
 * 示例 2：
 * 输入: numRows = 1
 * 输出: [[1]]
 * 
 * 提示：
 * - 1 <= numRows <= 30
 */
public class L0118_PascalsTriangle {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        // 处理第一行
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);
        
        // 生成其余行
        for (int i = 1; i < numRows; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = result.get(i - 1);
            
            // 每行的第一个数字总是 1
            currentRow.add(1);
            
            // 计算中间的数字
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            
            // 每行的最后一个数字总是 1
            currentRow.add(1);
            
            result.add(currentRow);
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0118_PascalsTriangle solution = new L0118_PascalsTriangle();
        
        // 测试用例 1：5 行
        System.out.println("Test Case 1:");
        List<List<Integer>> result1 = solution.generate(5);
        System.out.println(result1);
        
        // 测试用例 2：1 行
        System.out.println("\nTest Case 2:");
        List<List<Integer>> result2 = solution.generate(1);
        System.out.println(result2);
        
        // 测试用例 3：3 行
        System.out.println("\nTest Case 3:");
        List<List<Integer>> result3 = solution.generate(3);
        System.out.println(result3);
    }
} 