public class L0012_IntegerToRoman {

    public String intToRoman(int num) {
        // 定义数值数组和对应的罗马数字符号
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        // 用于构建结果字符串
        StringBuilder result = new StringBuilder();
        
        // 遍历所有可能的数值
        for (int i = 0; i < values.length; i++) {
            // 当前数字大于等于数值时，添加对应的罗马数字
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        L0012_IntegerToRoman solution = new L0012_IntegerToRoman();

        // 测试用例 1
        int num1 = 3;
        System.out.println("测试用例 1：");
        System.out.println("输入：num = " + num1);
        System.out.println("输出：" + solution.intToRoman(num1));
        System.out.println("预期输出：III");
        System.out.println();

        // 测试用例 2
        int num2 = 4;
        System.out.println("测试用例 2：");
        System.out.println("输入：num = " + num2);
        System.out.println("输出：" + solution.intToRoman(num2));
        System.out.println("预期输出：IV");
        System.out.println();

        // 测试用例 3
        int num3 = 9;
        System.out.println("测试用例 3：");
        System.out.println("输入：num = " + num3);
        System.out.println("输出：" + solution.intToRoman(num3));
        System.out.println("预期输出：IX");
        System.out.println();

        // 测试用例 4
        int num4 = 58;
        System.out.println("测试用例 4：");
        System.out.println("输入：num = " + num4);
        System.out.println("输出：" + solution.intToRoman(num4));
        System.out.println("预期输出：LVIII");
        System.out.println();

        // 测试用例 5
        int num5 = 1994;
        System.out.println("测试用例 5：");
        System.out.println("输入：num = " + num5);
        System.out.println("输出：" + solution.intToRoman(num5));
        System.out.println("预期输出：MCMXCIV");
    }
} 