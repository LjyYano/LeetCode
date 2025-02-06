
// https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/
class L0080_Remove_Duplicates_from_Sorted_Array_II {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2) return nums.length;
        int count = 1;
        for(int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[count] || (nums[i] == nums[count] && nums[i] != nums[count - 1])) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}