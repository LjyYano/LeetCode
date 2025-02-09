/*
 * https://leetcode.cn/problems/valid-number/
 * 
 * 有效数字（按顺序）可以分成以下几个部分：
 * 1. 一个 小数 或者 整数
 * 2.（可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 
 * 小数（按顺序）可以分成以下几个部分：
 * 1.（可选）一个符号字符（'+' 或 '-'）
 * 2. 下述格式之一：
 *    1. 至少一位数字，后面跟着一个点 '.'
 *    2. 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 *    3. 一个点 '.' ，后面跟着至少一位数字
 * 
 * 整数（按顺序）可以分成以下几个部分：
 * 1.（可选）一个符号字符（'+' 或 '-'）
 * 2. 至少一位数字
 * 
 * 部分有效数字列举如下：["2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"]
 * 部分无效数字列举如下：["abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"]
 * 
 * 给你一个字符串 s ，如果 s 是一个 有效数字 ，请返回 true 。
 * 
 * 示例 1：
 * 输入：s = "0"
 * 输出：true
 * 
 * 示例 2：
 * 输入：s = "e"
 * 输出：false
 * 
 * 示例 3：
 * 输入：s = "."
 * 输出：false
 * 
 * 提示：
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，或者点 '.' 。
 */

public class L0065_ValidNumber {

    public boolean isNumber(String s) {
        // 状态机的状态定义
        int STATE_INITIAL = 0;           // 初始状态
        int STATE_SIGN1 = 1;             // 符号状态（整数/小数部分）
        int STATE_INTEGER1 = 2;          // 整数部分
        int STATE_POINT1 = 3;            // 小数点（前有整数）
        int STATE_POINT2 = 4;            // 小数点（前无整数）
        int STATE_FRACTION = 5;          // 小数部分
        int STATE_EXP = 6;               // 指数标记
        int STATE_SIGN2 = 7;             // 符号状态（指数部分）
        int STATE_INTEGER2 = 8;          // 指数部分

        int state = STATE_INITIAL;       // 当前状态
        
        for (char c : s.toCharArray()) {
            switch (state) {
                case 0: // 初始状态
                    if (c == '+' || c == '-') {
                        state = STATE_SIGN1;
                    } else if (Character.isDigit(c)) {
                        state = STATE_INTEGER1;
                    } else if (c == '.') {
                        state = STATE_POINT2;
                    } else {
                        return false;
                    }
                    break;
                    
                case 1: // 符号状态（整数/小数部分）
                    if (Character.isDigit(c)) {
                        state = STATE_INTEGER1;
                    } else if (c == '.') {
                        state = STATE_POINT2;
                    } else {
                        return false;
                    }
                    break;
                    
                case 2: // 整数部分
                    if (Character.isDigit(c)) {
                        state = STATE_INTEGER1;
                    } else if (c == '.') {
                        state = STATE_POINT1;
                    } else if (c == 'e' || c == 'E') {
                        state = STATE_EXP;
                    } else {
                        return false;
                    }
                    break;
                    
                case 3: // 小数点（前有整数）
                    if (Character.isDigit(c)) {
                        state = STATE_FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = STATE_EXP;
                    } else {
                        return false;
                    }
                    break;
                    
                case 4: // 小数点（前无整数）
                    if (Character.isDigit(c)) {
                        state = STATE_FRACTION;
                    } else {
                        return false;
                    }
                    break;
                    
                case 5: // 小数部分
                    if (Character.isDigit(c)) {
                        state = STATE_FRACTION;
                    } else if (c == 'e' || c == 'E') {
                        state = STATE_EXP;
                    } else {
                        return false;
                    }
                    break;
                    
                case 6: // 指数标记
                    if (c == '+' || c == '-') {
                        state = STATE_SIGN2;
                    } else if (Character.isDigit(c)) {
                        state = STATE_INTEGER2;
                    } else {
                        return false;
                    }
                    break;
                    
                case 7: // 符号状态（指数部分）
                    if (Character.isDigit(c)) {
                        state = STATE_INTEGER2;
                    } else {
                        return false;
                    }
                    break;
                    
                case 8: // 指数部分
                    if (Character.isDigit(c)) {
                        state = STATE_INTEGER2;
                    } else {
                        return false;
                    }
                    break;
            }
        }
        
        // 判断最终状态是否合法
        return state == STATE_INTEGER1 || state == STATE_POINT1 || 
               state == STATE_FRACTION || state == STATE_INTEGER2;
    }

    public static void main(String[] args) {
        L0065_ValidNumber solution = new L0065_ValidNumber();

        // 测试用例 1：有效数字
        String[] validNumbers = {
            "2", "0089", "-0.1", "+3.14", "4.", "-.9", "2e10", 
            "-90E3", "3e+7", "+6e-1", "53.5e93", "-123.456e789"
        };
        System.out.println("测试有效数字：");
        for (String num : validNumbers) {
            System.out.println(num + " -> " + solution.isNumber(num));
        }
        System.out.println();

        // 测试用例 2：无效数字
        String[] invalidNumbers = {
            "abc", "1a", "1e", "e3", "99e2.5", "--6", "-+3", "95a54e53"
        };
        System.out.println("测试无效数字：");
        for (String num : invalidNumbers) {
            System.out.println(num + " -> " + solution.isNumber(num));
        }
    }
} 