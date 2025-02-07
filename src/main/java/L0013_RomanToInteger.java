import java.util.HashMap;
import java.util.Map;

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
 * 数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。
 * 同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * - I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * - X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * - C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 */
public class L0013_RomanToInteger {
    
    public int romanToInt(String s) {
        // 创建罗马数字到整数的映射
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
        
        int result = 0;
        int prevValue = 0;
        
        // 从右向左遍历字符串
        for (int i = s.length() - 1; i >= 0; i--) {
            int currValue = romanMap.get(s.charAt(i));
            // 如果当前值小于前一个值，说明需要减去当前值
            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }
            prevValue = currValue;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0013_RomanToInteger solution = new L0013_RomanToInteger();
        
        // 测试用例
        String[] testCases = {"III", "IV", "IX", "LVIII", "MCMXCIV"};
        int[] expected = {3, 4, 9, 58, 1994};
        
        // 运行测试用例并打印结果
        for (int i = 0; i < testCases.length; i++) {
            int result = solution.romanToInt(testCases[i]);
            System.out.printf("输入：%s\n", testCases[i]);
            System.out.printf("输出：%d\n", result);
            System.out.printf("预期：%d\n", expected[i]);
            System.out.printf("结果：%s\n\n", result == expected[i] ? "✓" : "✗");
        }
    }
} 