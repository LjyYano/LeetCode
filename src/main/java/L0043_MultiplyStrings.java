/**
 * 题目链接：https://leetcode.cn/problems/multiply-strings/
 * 
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * 
 * 示例 1:
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 
 * 示例 2:
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class L0043_MultiplyStrings {

    public String multiply(String num1, String num2) {
        // 处理特殊情况
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        
        // 结果数组，存储每一位的计算结果
        int[] result = new int[num1.length() + num2.length()];
        
        // 从右往左遍历 num1 的每一位
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            
            // 从右往左遍历 num2 的每一位
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                
                // 计算当前位置的乘积，并加上之前的进位
                int sum = result[i + j + 1] + n1 * n2;
                
                // 更新当前位置和进位
                result[i + j + 1] = sum % 10;
                result[i + j] += sum / 10;
            }
        }
        
        // 构建结果字符串
        StringBuilder sb = new StringBuilder();
        // 跳过前导零
        int i = 0;
        while (i < result.length && result[i] == 0) {
            i++;
        }
        // 将数组转换为字符串
        while (i < result.length) {
            sb.append(result[i++]);
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        L0043_MultiplyStrings solution = new L0043_MultiplyStrings();
        
        // 测试用例 1
        String num1 = "2";
        String num2 = "3";
        System.out.println("测试用例 1：");
        System.out.println("输入：num1 = \"2\", num2 = \"3\"");
        System.out.println("输出：" + solution.multiply(num1, num2));
        // 预期输出："6"
        
        // 测试用例 2
        String num3 = "123";
        String num4 = "456";
        System.out.println("\n测试用例 2：");
        System.out.println("输入：num1 = \"123\", num2 = \"456\"");
        System.out.println("输出：" + solution.multiply(num3, num4));
        // 预期输出："56088"
    }
} 