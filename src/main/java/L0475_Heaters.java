import java.util.Arrays;

public class L0475_Heaters {
    // 解法一：二分查找
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

    // 解法二：双指针
    public int findRadiusTwoPointers(int[] houses, int[] heaters) {
        // 对房屋和供暖器位置进行排序
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int ans = 0;
        int i = 0; // 房屋指针
        int j = 0; // 供暖器指针
        
        while (i < houses.length) {
            // 当前房屋到当前供暖器的距离
            int currDist = Math.abs(houses[i] - heaters[j]);
            
            // 如果还有下一个供暖器，比较当前供暖器和下一个供暖器哪个更近
            if (j + 1 < heaters.length) {
                int nextDist = Math.abs(houses[i] - heaters[j + 1]);
                // 如果下一个供暖器更近，移动供暖器指针
                if (nextDist < currDist) {
                    j++;
                    continue;
                }
            }
            
            // 更新答案并移动到下一个房屋
            ans = Math.max(ans, currDist);
            i++;
        }
        
        return ans;
    }
} 