public class L0483_SmallestGoodBase {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        
        // m 的最大值
        int maxM = (int) (Math.log(num) / Math.log(2)) + 1;
        
        // 从大的 m 开始枚举（希望得到小的 k）
        for (int m = maxM; m >= 2; m--) {
            // 二分查找 k
            long left = 2;
            long right = (long) Math.pow(num, 1.0 / (m - 1)) + 1;
            
            while (left <= right) {
                long mid = left + (right - left) / 2;
                long sum = calculateSum(mid, m);
                
                if (sum == num) {
                    return String.valueOf(mid);
                } else if (sum < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        // 如果没有找到，返回 n-1
        return String.valueOf(num - 1);
    }
    
    // 计算 k^(m-1) + k^(m-2) + ... + k + 1
    private long calculateSum(long k, int m) {
        long sum = 0;
        long term = 1;
        
        for (int i = 0; i < m; i++) {
            // 防止溢出
            if (sum > Long.MAX_VALUE - term) {
                return Long.MAX_VALUE;
            }
            sum += term;
            
            // 防止溢出
            if (i < m - 1) {
                if (term > Long.MAX_VALUE / k) {
                    return Long.MAX_VALUE;
                }
                term *= k;
            }
        }
        
        return sum;
    }
} 