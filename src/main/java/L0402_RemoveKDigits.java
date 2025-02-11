import java.util.*;

/**
 * https://leetcode.cn/problems/remove-k-digits/description/
 * 
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 * 
 * 示例 1：
 * 输入：num = "1432219", k = 3
 * 输出："1219"
 * 解释：移除掉三个数字 4, 3, 和 2 后，剩下的数字是 "1219"，这是可能的最小的数字。
 * 
 * 示例 2：
 * 输入：num = "10200", k = 1
 * 输出："200"
 * 解释：移掉首位的 1 剩下的数字是 "0200"，去掉前导零后得到 "200"。
 * 
 * 示例 3：
 * 输入：num = "10", k = 2
 * 输出："0"
 * 
 * 提示：
 * 1 <= k <= num.length <= 10^5
 * num 仅由若干位数字（0-9）组成
 * 除了 0 本身之外，num 不含任何前导零
 */
public class L0402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        // 使用双端队列作为栈，方便从头遍历
        Deque<Character> deque = new LinkedList<>();
        
        // 遍历每一位数字
        for (char digit : num.toCharArray()) {
            // 当栈不为空且还可以删除数字且当前数字小于栈顶数字时，删除栈顶数字
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > digit) {
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        
        // 如果还有数字需要删除，从末尾删除
        for (int i = 0; i < k; i++) {
            deque.pollLast();
        }
        
        // 构建结果字符串，去除前导零
        StringBuilder result = new StringBuilder();
        boolean leadingZero = true;
        while (!deque.isEmpty()) {
            char digit = deque.pollFirst();
            if (leadingZero && digit == '0') {
                continue;
            }
            leadingZero = false;
            result.append(digit);
        }
        
        // 如果结果为空，返回 "0"
        return result.length() == 0 ? "0" : result.toString();
    }

    public static void main(String[] args) {
        L0402_RemoveKDigits solution = new L0402_RemoveKDigits();
        
        // 测试用例1
        String num1 = "1432219";
        int k1 = 3;
        System.out.println("测试用例1：num = " + num1 + ", k = " + k1);
        System.out.println("结果：" + solution.removeKdigits(num1, k1));
        
        // 测试用例2
        String num2 = "10200";
        int k2 = 1;
        System.out.println("\n测试用例2：num = " + num2 + ", k = " + k2);
        System.out.println("结果：" + solution.removeKdigits(num2, k2));
        
        // 测试用例3
        String num3 = "10";
        int k3 = 2;
        System.out.println("\n测试用例3：num = " + num3 + ", k = " + k3);
        System.out.println("结果：" + solution.removeKdigits(num3, k3));
    }
} 