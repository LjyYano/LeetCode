public class L0479_LargestPalindromeProduct {
    public int largestPalindrome(int n) {
        // 特殊情况
        if (n == 1) {
            return 9;
        }
        
        // n 位数的最大值和最小值
        long max = (long) Math.pow(10, n) - 1;
        long min = (long) Math.pow(10, n - 1);
        
        // 从最大可能的回文数开始枚举
        // 枚举回文数的左半部分
        for (long left = max; left >= min; left--) {
            // 构造回文数
            long palindrome = createPalindrome(left);
            
            // 检查是否能分解为两个 n 位数的乘积
            for (long i = max; i * i >= palindrome; i--) {
                if (palindrome % i == 0) {
                    long j = palindrome / i;
                    if (j <= max && j >= min) {
                        return (int) (palindrome % 1337);
                    }
                }
            }
        }
        
        return -1;
    }
    
    // 根据左半部分构造回文数
    private long createPalindrome(long left) {
        String s = String.valueOf(left);
        String reversed = new StringBuilder(s).reverse().toString();
        return Long.parseLong(s + reversed);
    }
} 