/**
 * https://leetcode.cn/problems/assign-cookies/
 * 
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释: 
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 
 * 示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释: 
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数组为[1,2,3]。
 * 你可以给第一个孩子分配第一块饼干，给第二个孩子分配第二块饼干。
 * 每个孩子都得到了满足他们胃口的饼干，所以你应该输出2。
 * 
 * 提示：
 * 1 <= g.length <= 3 * 10⁴
 * 0 <= s.length <= 3 * 10⁴
 * 1 <= g[i], s[j] <= 2³¹ - 1
 */
public class L0455_AssignCookies {
    
    public int findContentChildren(int[] g, int[] s) {
        // 对胃口值和饼干尺寸进行排序
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        
        int child = 0;  // 当前满足的孩子数量
        int cookie = 0;  // 当前使用的饼干索引
        
        // 遍历所有孩子和饼干
        while (child < g.length && cookie < s.length) {
            // 如果当前饼干能满足当前孩子的胃口
            if (s[cookie] >= g[child]) {
                child++;  // 满足一个孩子
            }
            cookie++;  // 无论是否满足，都尝试下一块饼干
        }
        
        return child;
    }

    public static void main(String[] args) {
        L0455_AssignCookies solution = new L0455_AssignCookies();
        
        // 测试用例 1
        int[] g1 = {1, 2, 3};
        int[] s1 = {1, 1};
        System.out.println("测试用例 1 结果：" + solution.findContentChildren(g1, s1)); // 预期输出：1
        
        // 测试用例 2
        int[] g2 = {1, 2};
        int[] s2 = {1, 2, 3};
        System.out.println("测试用例 2 结果：" + solution.findContentChildren(g2, s2)); // 预期输出：2
        
        // 测试用例 3：空饼干数组
        int[] g3 = {1, 2, 3};
        int[] s3 = {};
        System.out.println("测试用例 3 结果：" + solution.findContentChildren(g3, s3)); // 预期输出：0
    }
} 