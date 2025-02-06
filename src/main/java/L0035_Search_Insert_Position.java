
// https://leetcode-cn.com/problems/search-insert-position/
class L0035_Search_Insert_Position {
    public int searchInsert(int[] nums, int target) {
        if(nums == null) return 0;
        
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
        
        if(ans != -1) return ans;
        // start 和 end 已经包含了插入的信息
        return start > end ? start : end;
    }
}