# 33. 搜索旋转排序数组

## 题目描述

给你一个整数数组 nums ，它原本是按升序排序的，但在传入函数前在某个下标 k 处进行了旋转。现在需要在这个旋转后的数组中查找目标值 target。如果找到目标值则返回其下标，否则返回 -1。要求算法的时间复杂度为 O(log n)。

示例：
```
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4
```

## 解题思路

1. 本题的关键是利用二分查找来实现 O(log n) 的时间复杂度。虽然数组被旋转了，但我们仍然可以利用数组部分有序的特性。

2. 对于任意一个中间位置 mid，数组在这个位置分成的两部分中，至少有一部分是有序的：
   - 如果 nums[left] <= nums[mid]，说明左半部分是有序的
   - 否则右半部分是有序的

3. 算法步骤：
   1) 首先判断 mid 位置的值是否为目标值
   2) 判断哪一部分是有序的：
      - 如果左半部分有序（nums[left] <= nums[mid]）：
        - 如果目标值在左半部分的范围内，则在左半部分查找
        - 否则在右半部分查找
      - 如果右半部分有序：
        - 如果目标值在右半部分的范围内，则在右半部分查找
        - 否则在左半部分查找

4. 时间复杂度分析：
   - 时间复杂度：O(log n)，二分查找的标准时间复杂度
   - 空间复杂度：O(1)，只使用了常数级别的额外空间

## 代码实现

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // 判断左半部分是否有序
            if (nums[left] <= nums[mid]) {
                // 目标值在左半部分
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // 右半部分有序
            else {
                // 目标值在右半部分
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
```

## 易错点

1. 在判断左半部分是否有序时，条件应该是 nums[left] <= nums[mid]，而不是 nums[left] < nums[mid]。这是因为当数组中只有两个元素时，left 和 mid 可能指向同一个位置。

2. 在判断目标值是否在某个区间时，需要注意边界条件的等号：
   - 对于左半部分：target >= nums[left] && target < nums[mid]
   - 对于右半部分：target > nums[mid] && target <= nums[right]

3. 二分查找的循环条件是 left <= right，而不是 left < right，这样可以处理数组长度为 1 的情况。

## 相关题目

- [81. 搜索旋转排序数组 II](https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/) - 允许重复值的变体
- [153. 寻找旋转排序数组中的最小值](https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/) - 类似的旋转数组问题 