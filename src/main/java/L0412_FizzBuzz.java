import java.util.*;

/**
 * https://leetcode.cn/problems/fizz-buzz/description/
 * 
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
 * answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
 * answer[i] == "Fizz" 如果 i 是 3 的倍数。
 * answer[i] == "Buzz" 如果 i 是 5 的倍数。
 * answer[i] == i （以字符串形式）如果上述条件全不满足。
 * 
 * 示例 1：
 * 输入：n = 3
 * 输出：["1","2","Fizz"]
 * 
 * 示例 2：
 * 输入：n = 5
 * 输出：["1","2","Fizz","4","Buzz"]
 * 
 * 示例 3：
 * 输入：n = 15
 * 输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 */
public class L0412_FizzBuzz {

    public List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();
        
        // 遍历 1 到 n 的每个数字
        for (int i = 1; i <= n; i++) {
            // 判断是否同时能被 3 和 5 整除
            if (i % 3 == 0 && i % 5 == 0) {
                answer.add("FizzBuzz");
            }
            // 判断是否能被 3 整除
            else if (i % 3 == 0) {
                answer.add("Fizz");
            }
            // 判断是否能被 5 整除
            else if (i % 5 == 0) {
                answer.add("Buzz");
            }
            // 其他情况，直接将数字转换为字符串
            else {
                answer.add(String.valueOf(i));
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {
        L0412_FizzBuzz solution = new L0412_FizzBuzz();
        
        // 测试用例1
        int n1 = 3;
        System.out.println("测试用例1：");
        System.out.println("输入：n = " + n1);
        System.out.println("输出：" + solution.fizzBuzz(n1));
        
        // 测试用例2
        int n2 = 5;
        System.out.println("\n测试用例2：");
        System.out.println("输入：n = " + n2);
        System.out.println("输出：" + solution.fizzBuzz(n2));
        
        // 测试用例3
        int n3 = 15;
        System.out.println("\n测试用例3：");
        System.out.println("输入：n = " + n3);
        System.out.println("输出：" + solution.fizzBuzz(n3));
    }
} 