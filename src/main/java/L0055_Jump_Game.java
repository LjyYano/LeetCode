
// https://leetcode-cn.com/problems/jump-game/
class L0055_Jump_Game {
    // 55. Jump Game
    public boolean canJump(int[] nums) {
        int curr = 0, currJump = nums[0], max = Integer.MIN_VALUE;
        if (currJump >= nums.length - 1) return true;

        while (true) {
            for (int i = curr; i <= currJump ; i++) {
                max = Math.max(max, nums[i] + i);
            }
            if (max >= nums.length - 1) {
                return true;
            } else if (max == currJump) {
                return false;
            } else {
                curr = currJump;
                currJump = max;
            }
        }
    }
}