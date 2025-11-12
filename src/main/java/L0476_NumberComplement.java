public class L0476_NumberComplement {
    // 解法一：构造掩码
    public int findComplement(int num) {
        // 找到最高位
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        
        // 异或得到补数
        return num ^ mask;
    }
    
    // 解法二：使用 highestOneBit
    public int findComplementV2(int num) {
        // 找到最高位的位置
        int highestBit = Integer.highestOneBit(num);
        // 构造掩码：(highestBit << 1) - 1
        int mask = (highestBit << 1) - 1;
        // 异或得到补数
        return num ^ mask;
    }
    
    // 解法三：简洁写法
    public int findComplementV3(int num) {
        int mask = 1;
        int temp = num;
        // 找到比 num 大的最小的 2^n - 1
        while (temp > 0) {
            temp >>= 1;
            mask <<= 1;
        }
        return (mask - 1) ^ num;
    }
} 