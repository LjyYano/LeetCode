
// https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class L0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null) return new int[] {-1, -1};
        
        // 先找到一个位置
        int start = 0, end = nums.length - 1, ans = -1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                ans = mid;
                break;
            }
            
            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if(ans == -1) return new int[] {-1, -1};
        // 找起始点
        int s = ans, e = ans;
        while(s >= 0 && nums[s] == target) {
            s--;
        }
        while(e < nums.length && nums[e] == target) {
            e++;
        }
        return new int[] {s + 1, e - 1};
    }
}