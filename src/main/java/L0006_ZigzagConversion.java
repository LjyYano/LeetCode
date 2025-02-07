/**
 * 题目链接：https://leetcode.cn/problems/zigzag-conversion/
 * 
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 */
public class L0006_ZigzagConversion {
    
    public String convert(String s, int numRows) {
        // 特殊情况处理
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }
        
        // 使用 StringBuilder 数组，每个元素对应一行
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        // 当前行号
        int currentRow = 0;
        // 是否向下移动
        boolean goingDown = false;
        
        // 遍历字符串中的每个字符
        for (char c : s.toCharArray()) {
            // 将字符添加到当前行
            rows[currentRow].append(c);
            
            // 在第一行或最后一行时改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // 根据方向移动当前行号
            currentRow += goingDown ? 1 : -1;
        }
        
        // 合并所有行
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0006_ZigzagConversion solution = new L0006_ZigzagConversion();
        
        // 测试用例 1
        String s1 = "PAYPALISHIRING";
        int numRows1 = 3;
        System.out.println("输入：s = " + s1 + ", numRows = " + numRows1);
        System.out.println("输出：" + solution.convert(s1, numRows1));  // 预期输出："PAHNAPLSIIGYIR"
        
        // 测试用例 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println("\n输入：s = " + s2 + ", numRows = " + numRows2);
        System.out.println("输出：" + solution.convert(s2, numRows2));  // 预期输出："PINALSIGYAHRPI"
        
        // 测试用例 3：单行
        String s3 = "AB";
        int numRows3 = 1;
        System.out.println("\n输入：s = " + s3 + ", numRows = " + numRows3);
        System.out.println("输出：" + solution.convert(s3, numRows3));  // 预期输出："AB"
    }
} 