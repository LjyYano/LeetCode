/*
 * https://leetcode.cn/problems/excel-sheet-column-title/
 * 
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。
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
 * 输入：columnNumber = 1
 * 输出："A"
 * 
 * 示例 2：
 * 输入：columnNumber = 28
 * 输出："AB"
 * 
 * 示例 3：
 * 输入：columnNumber = 701
 * 输出："ZY"
 * 
 * 示例 4：
 * 输入：columnNumber = 2147483647
 * 输出："FXSHRXW"
 * 
 * 提示：
 * - 1 <= columnNumber <= 2³¹ - 1
 */

public class L0168_ExcelSheetColumnTitle {
    
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();
        
        while (columnNumber > 0) {
            // 因为是从 1 开始的 26 进制，所以要先减 1
            columnNumber--;
            // 获取当前位的字母（A 的 ASCII 码是 65）
            char currentChar = (char) ('A' + columnNumber % 26);
            // 将字母添加到结果的开头
            result.insert(0, currentChar);
            // 处理下一位
            columnNumber /= 26;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0168_ExcelSheetColumnTitle solution = new L0168_ExcelSheetColumnTitle();
        
        // 测试用例 1
        int columnNumber1 = 1;
        System.out.println("测试用例 1：");
        System.out.println("输入：columnNumber = " + columnNumber1);
        System.out.println("输出：\"" + solution.convertToTitle(columnNumber1) + "\"");
        System.out.println("预期：\"A\"");
        System.out.println();
        
        // 测试用例 2
        int columnNumber2 = 28;
        System.out.println("测试用例 2：");
        System.out.println("输入：columnNumber = " + columnNumber2);
        System.out.println("输出：\"" + solution.convertToTitle(columnNumber2) + "\"");
        System.out.println("预期：\"AB\"");
        System.out.println();
        
        // 测试用例 3
        int columnNumber3 = 701;
        System.out.println("测试用例 3：");
        System.out.println("输入：columnNumber = " + columnNumber3);
        System.out.println("输出：\"" + solution.convertToTitle(columnNumber3) + "\"");
        System.out.println("预期：\"ZY\"");
        System.out.println();
        
        // 测试用例 4
        int columnNumber4 = 2147483647;
        System.out.println("测试用例 4：");
        System.out.println("输入：columnNumber = " + columnNumber4);
        System.out.println("输出：\"" + solution.convertToTitle(columnNumber4) + "\"");
        System.out.println("预期：\"FXSHRXW\"");
    }
} 