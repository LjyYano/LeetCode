import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/lexicographical-numbers/
 * 
 * 给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
 * 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
 */
public class L0386_LexicographicalNumbers {
    
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        int current = 1;
        
        for (int i = 0; i < n; i++) {
            result.add(current);
            
            // 如果 current * 10 <= n，说明可以在末尾添加 0
            if (current * 10 <= n) {
                current *= 10;
            } else {
                // 如果已经到达 n，或者无法继续添加 0，需要找到下一个数
                while (current % 10 == 9 || current + 1 > n) {
                    current /= 10;
                }
                // 如果 current 为 0，说明已经遍历完所有数字
                if (current == 0) {
                    break;
                }
                current++;
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0386_LexicographicalNumbers solution = new L0386_LexicographicalNumbers();
        
        // 测试用例 1
        int n1 = 13;
        System.out.println("Test case 1: n = " + n1);
        System.out.println("Output: " + solution.lexicalOrder(n1));
        // 预期输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
        
        // 测试用例 2
        int n2 = 2;
        System.out.println("\nTest case 2: n = " + n2);
        System.out.println("Output: " + solution.lexicalOrder(n2));
        // 预期输出：[1,2]
        
        // 测试用例 3
        int n3 = 100;
        System.out.println("\nTest case 3: n = " + n3);
        System.out.println("Output: " + solution.lexicalOrder(n3));
    }
} 