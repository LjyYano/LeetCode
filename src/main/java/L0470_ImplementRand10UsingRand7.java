import java.util.Random;

/**
 * 470. 用 Rand7() 实现 Rand10()
 * 
 * https://leetcode.cn/problems/implement-rand10-using-rand7/
 * 
 * 给定方法 rand7() 可生成 [1,7] 范围内的均匀随机整数，试写一个方法 rand10() 生成 [1,10] 范围内的均匀随机整数。
 * 
 * 你只能调用 rand7() 且不能调用其他方法。请不要使用系统的 Math.random() 方法。
 * 
 * 每个测试用例将有一个内部参数 n，即你实现的函数 rand10() 在测试时将被调用的次数。请注意，这不是传递给 rand10() 的参数。
 * 
 * 示例 1:
 * 输入: 1
 * 输出: [2]
 * 
 * 示例 2:
 * 输入: 2
 * 输出: [2,8]
 * 
 * 示例 3:
 * 输入: 3
 * 输出: [3,8,10]
 * 
 * 提示:
 * 1 <= n <= 10^5
 * 
 * 进阶:
 * rand7() 调用次数的 期望值 是多少？
 * 你能否尽量少调用 rand7()?
 */
public class L0470_ImplementRand10UsingRand7 {

    public int rand10() {
        while (true) {
            // 首先使用 rand7() 生成 [1,49] 范围内的随机数
            // (rand7() - 1) * 7 生成 [0,42] 范围内的随机数
            // rand7() 生成 [1,7] 范围内的随机数
            int num = (rand7() - 1) * 7 + rand7();
            // 如果生成的数大于 40，则重新生成
            // 因为 41-49 这些数不能均匀地映射到 1-10
            if (num <= 40) {
                // 将 [1,40] 映射到 [1,10]
                return 1 + (num - 1) % 10;
            }
        }
    }

    // 这个方法是题目给定的，这里只是为了编译通过
    private int rand7() {
        return new Random().nextInt(7) + 1;
    }

    public static void main(String[] args) {
        L0470_ImplementRand10UsingRand7 solution = new L0470_ImplementRand10UsingRand7();
        // 测试用例 1
        System.out.println("测试用例 1 结果：" + solution.rand10());
        // 测试用例 2
        System.out.println("测试用例 2 结果：" + solution.rand10());
        // 测试用例 3
        System.out.println("测试用例 3 结果：" + solution.rand10());
    }
} 