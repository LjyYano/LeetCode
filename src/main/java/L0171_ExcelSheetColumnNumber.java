/**
 * https://leetcode.cn/problems/excel-sheet-column-number/
 * 
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * 
 * 例如：
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28 
 * ...
 * 
 * 示例 1：
 * 输入: columnTitle = "A"
 * 输出: 1
 * 
 * 示例 2：
 * 输入: columnTitle = "AB"
 * 输出: 28
 * 
 * 示例 3：
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * 
 * 提示：
 * - 1 <= columnTitle.length <= 7
 * - columnTitle 仅由大写英文组成
 * - columnTitle 在范围 ["A", "FXSHRXW"] 内
 */
public class L0171_ExcelSheetColumnNumber {
    
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        // 从左到右遍历字符串的每个字符
        for (char c : columnTitle.toCharArray()) {
            // 将已有结果乘以 26
            result *= 26;
            // 加上当前字符对应的数值（A=1, B=2, ..., Z=26）
            result += c - 'A' + 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0171_ExcelSheetColumnNumber solution = new L0171_ExcelSheetColumnNumber();
        
        // 测试用例 1
        String columnTitle1 = "A";
        System.out.println("测试用例 1：");
        System.out.println("输入：columnTitle = \"" + columnTitle1 + "\"");
        System.out.println("输出：" + solution.titleToNumber(columnTitle1));
        System.out.println("预期：1");
        System.out.println();
        
        // 测试用例 2
        String columnTitle2 = "AB";
        System.out.println("测试用例 2：");
        System.out.println("输入：columnTitle = \"" + columnTitle2 + "\"");
        System.out.println("输出：" + solution.titleToNumber(columnTitle2));
        System.out.println("预期：28");
        System.out.println();
        
        // 测试用例 3
        String columnTitle3 = "ZY";
        System.out.println("测试用例 3：");
        System.out.println("输入：columnTitle = \"" + columnTitle3 + "\"");
        System.out.println("输出：" + solution.titleToNumber(columnTitle3));
        System.out.println("预期：701");
    }
} 