
// https://leetcode-cn.com/problems/sliding-window-maximum/
class L0239_Sliding_Window_Maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[nums.length + 1 - k];
        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                p.remove(nums[i - k]);
            }
            p.offer(nums[i]);
            if (i + 1 >= k) {
                res[i + 1 - k] = p.peek();
            }
        }
        return res;
    }
}