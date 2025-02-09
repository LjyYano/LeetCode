/**
 * https://leetcode.cn/problems/reverse-bits/
 * 
 * 颠倒给定的 32 位无符号整数的二进制位。
 * 
 * 提示：
 * - 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * - 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在 示例 2 中，输入表示有符号整数 -3，输出表示有符号整数 -1073741825。
 */
public class L0190_ReverseBits {
    
    /**
     * 使用位运算实现二进制位的反转：
     * 1. 从右到左遍历原数的每一位
     * 2. 将每一位放到结果中对应的位置
     */
    public int reverseBits(int n) {
        int result = 0;
        
        // 遍历 32 位
        for (int i = 0; i < 32; i++) {
            // 将结果左移一位，为新的位腾出空间
            result <<= 1;
            // 取出原数最后一位，加到结果中
            result |= (n & 1);
            // 将原数右移一位
            n >>>= 1;
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0190_ReverseBits solution = new L0190_ReverseBits();
        
        // 测试用例 1
        int n1 = 0b00000010100101000001111010011100;
        System.out.println("输入：" + n1);
        System.out.println("输出：" + solution.reverseBits(n1));  // 预期输出：964176192
        
        // 测试用例 2
        int n2 = 0b11111111111111111111111111111101;
        System.out.println("\n输入：" + n2);
        System.out.println("输出：" + solution.reverseBits(n2));  // 预期输出：3221225471
    }
} 