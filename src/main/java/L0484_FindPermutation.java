import java.util.Stack;

public class L0484_FindPermutation {
    // 方法一：使用栈
    public int[] findPermutation(String s) {
        int n = s.length() + 1;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            stack.push(i + 1);
            
            // 遇到'I'或到达末尾时，弹出栈中所有元素
            if (i == n - 1 || s.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result[idx++] = stack.pop();
                }
            }
        }
        
        return result;
    }
    
    // 方法二：贪心（不用栈）
    public int[] findPermutationGreedy(String s) {
        int n = s.length() + 1;
        int[] result = new int[n];
        
        // 先填充递增序列
        for (int i = 0; i < n; i++) {
            result[i] = i + 1;
        }
        
        // 反转所有'D'段
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'D') {
                int start = i;
                // 找到连续'D'的结束位置
                while (i < s.length() && s.charAt(i) == 'D') {
                    i++;
                }
                // 反转这一段
                reverse(result, start, i);
            } else {
                i++;
            }
        }
        
        return result;
    }
    
    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
} 