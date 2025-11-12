public class L0477_TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        // 遍历 32 位
        for (int i = 0; i < 32; i++) {
            int count1 = 0;
            // 统计第 i 位上有多少个 1
            for (int num : nums) {
                count1 += (num >> i) & 1;
            }
            // 第 i 位的贡献：count1 个 1 和 (n - count1) 个 0
            ans += count1 * (n - count1);
        }
        
        return ans;
    }
} 