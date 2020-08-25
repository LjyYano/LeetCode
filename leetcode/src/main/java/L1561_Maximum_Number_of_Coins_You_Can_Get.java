import java.util.Arrays;

// https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
class L1561_Maximum_Number_of_Coins_You_Can_Get {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int start = 0, end = piles.length - 1, ans = 0;
        while (start < end) {
            ans += piles[end - 1];
            start++;
            end -= 2;
        }
        return ans;
    }
}
