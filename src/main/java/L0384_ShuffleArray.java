import java.util.Random;

/**
 * https://leetcode.cn/problems/shuffle-an-array/
 * 
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。打乱后，数组的所有排列应该是等可能的。
 * 
 * 实现 Solution 类：
 * - Solution(int[] nums) 使用整数数组 nums 初始化对象
 * - int[] reset() 重设数组到它的初始状态并返回
 * - int[] shuffle() 返回数组随机打乱后的结果
 */
public class L0384_ShuffleArray {
    private int[] original;
    private int[] array;
    private Random rand;
    
    public L0384_ShuffleArray(int[] nums) {
        original = nums.clone();
        array = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        array = original.clone();
        return array;
    }
    
    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            // 生成一个 [0, i] 范围内的随机索引
            int j = rand.nextInt(i + 1);
            // 交换当前位置和随机位置的元素
            swap(array, i, j);
        }
        return array;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        // 测试用例
        int[] nums = {1, 2, 3};
        L0384_ShuffleArray solution = new L0384_ShuffleArray(nums);
        
        // 打印初始数组
        System.out.println("Original array:");
        printArray(nums);
        
        // 测试 shuffle
        System.out.println("\nShuffled array:");
        printArray(solution.shuffle());
        
        // 测试 reset
        System.out.println("\nReset array:");
        printArray(solution.reset());
        
        // 再次测试 shuffle
        System.out.println("\nShuffled array again:");
        printArray(solution.shuffle());
    }
    
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
} 