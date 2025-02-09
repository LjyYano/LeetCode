/**
 * https://leetcode.cn/problems/number-of-1-bits/
 * 
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）。
 * 
 * 提示：
 * - 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * - 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的示例 3 中，输入表示有符号整数 -3。
 */
public class L0191_NumberOf1Bits {
    
    /**
     * 方法一：循环检查每一位
     * 使用位运算，每次检查最后一位是否为 1
     */
    public int hammingWeight(int n) {
        int count = 0;
        
        // 循环 32 次，每次检查一位
        for (int i = 0; i < 32; i++) {
            // 如果最后一位是 1，计数加 1
            if ((n & 1) == 1) {
                count++;
            }
            // 无符号右移一位
            n >>>= 1;
        }
        
        return count;
    }
    
    /**
     * 方法二：使用 n & (n-1) 消除最后一个 1
     * 每次操作会消除二进制中最后一个 1，直到所有 1 被消除
     */
    public int hammingWeight2(int n) {
        int count = 0;
        
        // 当 n 不为 0 时继续循环
        while (n != 0) {
            // 每次操作消除最后一个 1
            n &= (n - 1);
            count++;
        }
        
        return count;
    }

    public static void main(String[] args) {
        L0191_NumberOf1Bits solution = new L0191_NumberOf1Bits();
        
        // 测试用例 1
        int n1 = 0b00000000000000000000000000001011;
        System.out.println("输入：" + n1);
        System.out.println("输出（方法一）：" + solution.hammingWeight(n1));  // 预期输出：3
        System.out.println("输出（方法二）：" + solution.hammingWeight2(n1));  // 预期输出：3
        
        // 测试用例 2
        int n2 = 0b00000000000000000000000010000000;
        System.out.println("\n输入：" + n2);
        System.out.println("输出（方法一）：" + solution.hammingWeight(n2));  // 预期输出：1
        System.out.println("输出（方法二）：" + solution.hammingWeight2(n2));  // 预期输出：1
        
        // 测试用例 3
        int n3 = 0b11111111111111111111111111111101;
        System.out.println("\n输入：" + n3);
        System.out.println("输出（方法一）：" + solution.hammingWeight(n3));  // 预期输出：31
        System.out.println("输出（方法二）：" + solution.hammingWeight2(n3));  // 预期输出：31
    }
} 