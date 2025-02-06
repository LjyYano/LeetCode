
// https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
class L0033_Search_in_Rotated_Sorted_Array {
    public int search(int[] nums, int target) {
        if(nums == null) return -1;
        
        int start = 0, end = nums.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            } 
            
            // 左序列连续递增
            if(nums[start] <= nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            
            // 右序列连续递增
            if(nums[mid] <= nums[end]) {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}