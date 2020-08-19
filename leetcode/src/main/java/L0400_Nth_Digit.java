
// https://leetcode-cn.com/problems/nth-digit/
class L0400_Nth_Digit {
    public int findNthDigit(int n) {
        long start = 1, count = 9;
        int len = 1;
        while(n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        start += (n - 1) / len;
        String target = start + "";
        return target.toCharArray()[(n - 1) % len] - '0';
    }
}