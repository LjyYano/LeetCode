import java.util.Arrays;

public class L0475_Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        // 对房屋和供暖器位置进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int ans = 0;
        // 遍历每个房屋
        for (int house : houses) {
            // 二分查找找到最近的供暖器
            int left = 0, right = heaters.length - 1;
            int closestDist = Integer.MAX_VALUE;
            
            while (left <= right) {
                int mid = left + (right - left) / 2;
                // 计算当前供暖器到房屋的距离
                int dist = Math.abs(heaters[mid] - house);
                closestDist = Math.min(closestDist, dist);
                
                // 如果供暖器在房屋左边,尝试右边的供暖器
                if (heaters[mid] < house) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            // 更新所需的最小半径
            ans = Math.max(ans, closestDist);
        }
        
        return ans;
    }
} 