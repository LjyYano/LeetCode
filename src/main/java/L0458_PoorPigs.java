/**
 * https://leetcode.cn/problems/poor-pigs/
 * 
 * 有 buckets 桶液体，其中正好有一桶含有毒药，其余装的都是水。它们从外观看起来都一样。为了弄清楚哪只水桶含有毒药，你可以喂一些猪喝，通过观察猪是否会死进行判断。
 * 
 * 每只猪都有固定的饮水时间，且知道在喝完毒药后多久会死亡。
 * 
 * 给你桶的数目 buckets ，喂猪的最小分钟数 minutesToDie 以及猪会在 minutesToTest 分钟内死亡。返回在规定时间内判断哪个桶有毒需要的 最小 猪数。
 * 
 * 示例 1：
 * 输入：buckets = 1000, minutesToDie = 15, minutesToTest = 60
 * 输出：5
 * 
 * 示例 2：
 * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 15
 * 输出：2
 * 
 * 示例 3：
 * 输入：buckets = 4, minutesToDie = 15, minutesToTest = 30
 * 输出：2
 * 
 * 提示：
 * - 1 <= buckets <= 1000
 * - 1 <= minutesToDie <= minutesToTest <= 100
 */
public class L0458_PoorPigs {
    
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // 计算每只猪可以测试的轮数
        int rounds = minutesToTest / minutesToDie;
        // 每只猪在每轮测试中都有两种状态：活或死
        // 所以每只猪在整个测试过程中有 rounds + 1 种状态
        // 假设需要 x 只猪，则这些猪的状态组合数必须大于等于桶的数量
        // 即 (rounds + 1)^x >= buckets
        // 取对数后：x >= log(buckets) / log(rounds + 1)
        // 向上取整得到最小的 x
        return (int) Math.ceil(Math.log(buckets) / Math.log(rounds + 1));
    }

    public static void main(String[] args) {
        L0458_PoorPigs solution = new L0458_PoorPigs();
        
        // 测试用例 1
        int result1 = solution.poorPigs(1000, 15, 60);
        System.out.println("测试用例 1 结果：" + result1); // 预期输出：5
        
        // 测试用例 2
        int result2 = solution.poorPigs(4, 15, 15);
        System.out.println("测试用例 2 结果：" + result2); // 预期输出：2
        
        // 测试用例 3
        int result3 = solution.poorPigs(4, 15, 30);
        System.out.println("测试用例 3 结果：" + result3); // 预期输出：2
    }
} 