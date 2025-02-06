
// https://leetcode-cn.com/problems/jump-game-ii/
class L0045_Jump_Game_II {
    public int jump(int[] nums) {
        if (nums.length <= 1) return 0;
        int reach = nums[0], lastReach = 0, step = 0;

        for (int i = 1; i <= reach && i < nums.length; i++) {
            if (i > lastReach) {
                step++;
                lastReach = reach;
            }
            reach = Math.max(reach, nums[i] + i);
        }

        return (reach < nums.length - 1) ? 0 : step;
    }
}