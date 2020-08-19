
// https://leetcode-cn.com/problems/remove-element/
class L0027_Remove_Element {
    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != val) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}