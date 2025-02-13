/**
 * https://leetcode.cn/problems/convert-a-number-to-hexadecimal/description/
 * 
 * 给定一个整数 num，将其转化为十六进制数。如果结果为负数，以二进制补码形式表示。
 * 注意：
 * 十六进制中所有字母(a-f)都必须是小写。
 * 十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
 * 给定的数确保在32位有符号整数范围内。
 * 不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
 * 
 * 示例 1：
 * 输入：num = 26
 * 输出："1a"
 * 
 * 示例 2：
 * 输入：num = -1
 * 输出："ffffffff"
 * 
 * 示例 3：
 * 输入：num = 0
 * 输出："0"
 */
public class L0405_ConvertANumberToHexadecimal {

    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        
        // 使用字符数组存储 16 进制字符
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder result = new StringBuilder();
        
        // 由于 int 是 32 位，所以最多需要 8 位十六进制数
        // 使用无符号右移，每次处理 4 位
        while (num != 0) {
            // 取最低 4 位
            int digit = num & 0xf;
            // 将对应的十六进制字符添加到结果中
            result.insert(0, hexChars[digit]);
            // 无符号右移 4 位
            num >>>= 4;
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0405_ConvertANumberToHexadecimal solution = new L0405_ConvertANumberToHexadecimal();
        
        // 测试用例1：26
        int num1 = 26;
        System.out.println("测试用例1：num = " + num1);
        System.out.println("结果：" + solution.toHex(num1));
        
        // 测试用例2：-1
        int num2 = -1;
        System.out.println("\n测试用例2：num = " + num2);
        System.out.println("结果：" + solution.toHex(num2));
        
        // 测试用例3：0
        int num3 = 0;
        System.out.println("\n测试用例3：num = " + num3);
        System.out.println("结果：" + solution.toHex(num3));
    }
} 