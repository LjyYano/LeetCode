/**
 * https://leetcode.cn/problems/reverse-string/
 * 
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 
 * 提示：
 * 1 <= s.length <= 10⁵
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class L0344_ReverseString {
    
    public void reverseString(char[] s) {
        // 使用双指针，从两端向中间移动
        int left = 0, right = s.length - 1;
        
        // 当左指针小于右指针时，交换两个字符
        while (left < right) {
            // 交换字符
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // 移动指针
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        L0344_ReverseString solution = new L0344_ReverseString();
        
        // 测试用例 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        System.out.print("测试用例 1 反转前：");
        printArray(s1);
        solution.reverseString(s1);
        System.out.print("测试用例 1 反转后：");
        printArray(s1);
        
        // 测试用例 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        System.out.print("测试用例 2 反转前：");
        printArray(s2);
        solution.reverseString(s2);
        System.out.print("测试用例 2 反转后：");
        printArray(s2);
    }
    
    // 辅助方法：打印字符数组
    private static void printArray(char[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print("'" + arr[i] + "'");
            if (i < arr.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }
} 