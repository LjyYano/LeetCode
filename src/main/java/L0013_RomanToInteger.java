/**
 * 罗马数字转整数
 * https://leetcode.cn/problems/roman-to-integer/
 * 
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。
 * 
 * 给定一个罗马数字，将其转换成整数。
 */
public class L0013_RomanToInteger {
    
    public int romanToInt(String s) {
        // 记录结果
        int result = 0;
        // 记录前一个字符对应的数值
        int prevValue = 0;
        
        // 从右向左遍历字符串
        for (int i = s.length() - 1; i >= 0; i--) {
            // 获取当前字符对应的数值
            int currentValue = getValue(s.charAt(i));
            
            // 如果当前数值小于前一个数值，说明是特殊情况（如 IV、IX 等）
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            
            // 更新前一个数值
            prevValue = currentValue;
        }
        
        return result;
    }
    
    /**
     * 获取罗马数字字符对应的数值
     */
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        L0013_RomanToInteger solution = new L0013_RomanToInteger();
        
        // 测试用例 1：基本情况
        String s1 = "III";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.romanToInt(s1));
        System.out.println("Expected: 3");
        System.out.println();
        
        // 测试用例 2：减法情况 1
        String s2 = "IV";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.romanToInt(s2));
        System.out.println("Expected: 4");
        System.out.println();
        
        // 测试用例 3：减法情况 2
        String s3 = "IX";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.romanToInt(s3));
        System.out.println("Expected: 9");
        System.out.println();
        
        // 测试用例 4：混合情况
        String s4 = "LVIII";
        System.out.println("Input: " + s4);
        System.out.println("Output: " + solution.romanToInt(s4));
        System.out.println("Expected: 58");
        System.out.println();
        
        // 测试用例 5：复杂情况
        String s5 = "MCMXCIV";
        System.out.println("Input: " + s5);
        System.out.println("Output: " + solution.romanToInt(s5));
        System.out.println("Expected: 1994");
    }
} 