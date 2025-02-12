/**
 * https://leetcode.cn/problems/circular-array-loop/
 * 
 * 存在一个不含 0 的 环形 数组 nums ，每个 nums[i] 都表示位置 i 的向前跳转或向后跳转步数（可以是负数）。
 * 
 * 环形数组意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个位置是 nums[(i + nums[i]) % n] 。环形数组也意味着前进超过数组的末端会回到开头，也就是说 i % n = i 。
 * 
 * 返回 true ，如果 nums 中存在循环（或周期），假设从 nums[i] 开始进行移动操作，如果存在循环，应该返回 true 。否则，返回 false 。
 * 
 * 循环必须满足以下条件：
 * - 循环中的所有数字方向相同（要么全是正数，要么全是负数）
 * - 循环至少包含两个元素
 * - 循环中的所有数字互不相同
 * 
 * 示例 1：
 * 输入：nums = [2,-1,1,2,2]
 * 输出：true
 * 解释：存在循环，按下标 0 -> 2 -> 3 -> 0 。循环长度为 3 。
 * 
 * 示例 2：
 * 输入：nums = [-1,2]
 * 输出：false
 * 解释：按下标 1 -> 1 -> 1 ... 的运动无法构成循环，因为循环的长度为 1 。根据定义，循环的长度必须大于 1 。
 * 
 * 示例 3：
 * 输入：nums = [-2,1,-1,-2,-2]
 * 输出：false
 * 解释：按下标 1 -> 2 -> 1 -> ... 运动无法构成循环，因为 nums[1] 是正数，而 nums[2] 是负数。
 * 所有循环中的数字必须方向相同。
 * 
 * 提示：
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 * nums[i] != 0
 */
public class L0457_CircularArrayLoop {
    
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        
        // 遍历每个位置作为起点
        for (int i = 0; i < n; i++) {
            // 如果当前位置已经被访问过且不是循环起点，跳过
            if (nums[i] == 0) {
                continue;
            }
            
            // 使用快慢指针检测循环
            int slow = i;
            int fast = getNextPosition(nums, getNextPosition(nums, i));
            
            // 判断是否是同方向
            while (nums[slow] * nums[fast] > 0 && 
                   nums[slow] * nums[getNextPosition(nums, fast)] > 0) {
                if (slow == fast) {
                    // 检查循环长度是否大于 1
                    if (slow != getNextPosition(nums, slow)) {
                        return true;
                    }
                    break;
                }
                slow = getNextPosition(nums, slow);
                fast = getNextPosition(nums, getNextPosition(nums, fast));
            }
            
            // 标记已访问的位置
            int current = i;
            int value = nums[current];
            while (nums[current] * value > 0) {
                int next = getNextPosition(nums, current);
                nums[current] = 0;
                current = next;
            }
        }
        
        return false;
    }
    
    // 获取下一个位置
    private int getNextPosition(int[] nums, int current) {
        int n = nums.length;
        int next = ((current + nums[current]) % n + n) % n;
        return next;
    }

    public static void main(String[] args) {
        L0457_CircularArrayLoop solution = new L0457_CircularArrayLoop();
        
        // 测试用例 1
        int[] nums1 = {2, -1, 1, 2, 2};
        System.out.println("测试用例 1 结果：" + solution.circularArrayLoop(nums1)); // 预期输出：true
        
        // 测试用例 2
        int[] nums2 = {-1, 2};
        System.out.println("测试用例 2 结果：" + solution.circularArrayLoop(nums2)); // 预期输出：false
        
        // 测试用例 3
        int[] nums3 = {-2, 1, -1, -2, -2};
        System.out.println("测试用例 3 结果：" + solution.circularArrayLoop(nums3)); // 预期输出：false
    }
} 