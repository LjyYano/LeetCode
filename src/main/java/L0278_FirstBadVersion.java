/* 
 * https://leetcode.cn/problems/first-bad-version/
 * 
 * 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
 * 
 * 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
 * 
 * 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。
 * 
 * 示例 1：
 * 输入：n = 5, bad = 4
 * 输出：4
 * 解释：
 * 调用 isBadVersion(3) -> false 
 * 调用 isBadVersion(5) -> true 
 * 调用 isBadVersion(4) -> true
 * 所以，4 是第一个错误的版本。
 * 
 * 示例 2：
 * 输入：n = 1, bad = 1
 * 输出：1
 * 
 * 提示：
 * - 1 <= bad <= n <= 2³¹ - 1
 */

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class L0278_FirstBadVersion{

    public int firstBadVersion(int n) {
        // 使用二分查找
        int left = 1;
        int right = n;
        
        while (left < right) {
            // 避免整数溢出
            int mid = left + (right - left) / 2;
            
            if (isBadVersion(mid)) {
                // 如果当前版本是错误的，第一个错误版本在左边或就是当前版本
                right = mid;
            } else {
                // 如果当前版本是正确的，第一个错误版本在右边
                left = mid + 1;
            }
        }
        
        // 此时 left == right，就是第一个错误的版本
        return left;
    }

    // mock isBadVersion
    private boolean isBadVersion(int version) {
        return version >= 4;
    }

    public static void main(String[] args) {
        // 注意：由于 isBadVersion 是一个抽象方法，这里无法直接运行测试用例
        System.out.println("注意：这个类需要继承 VersionControl 类才能运行");
        System.out.println("在 LeetCode 平台上提交时会自动提供 VersionControl 类");
        System.out.println("本地无法运行测试用例");
    }
} 