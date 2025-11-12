public class L0485_MaxConsecutiveOnes {
    // 方法一：标准写法
    public int findMaxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num == 1) {
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                count = 0;
            }
        }
        
        return maxCount;
    }
    
    // 方法二：另一种写法
    public int findMaxConsecutiveOnesV2(int[] nums) {
        int maxCount = 0;
        int count = 0;
        
        for (int num : nums) {
            if (num == 1) {
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
            }
        }
        
        // 处理数组以1结尾的情况
        return Math.max(maxCount, count);
    }
} 