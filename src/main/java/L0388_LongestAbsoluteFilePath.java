/**
 * https://leetcode.cn/problems/longest-absolute-file-path/
 * 
 * 假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：
 * 
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * 
 * 在上面的例子中，我们有两个文件：
 * "dir/subdir1/file1.ext" ，和 "dir/subdir2/subsubdir2/file2.ext" 。
 * 
 * 若文件系统中的路径为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"，
 * 请找出最长的绝对路径的长度。
 */
public class L0388_LongestAbsoluteFilePath {
    
    public int lengthLongestPath(String input) {
        // 使用数组来模拟栈，存储每一层目录的长度
        int[] stack = new int[input.length() + 1];
        int maxLen = 0;
        
        // 按换行符分割输入字符串
        for (String line : input.split("\n")) {
            // 计算当前层级（通过计算制表符的数量）
            int level = line.lastIndexOf('\t') + 1;
            // 计算当前文件/目录名的实际长度（去掉制表符）
            int curLen = line.length() - level;
            
            // 如果不是第 0 层，则需要加上父目录的长度和一个斜杠的长度
            if (level > 0) {
                curLen += stack[level - 1] + 1;
            }
            
            // 更新当前层级的长度
            stack[level] = curLen;
            
            // 如果是文件（包含 .），则更新最大长度
            if (line.contains(".")) {
                maxLen = Math.max(maxLen, curLen);
            }
        }
        
        return maxLen;
    }

    public static void main(String[] args) {
        L0388_LongestAbsoluteFilePath solution = new L0388_LongestAbsoluteFilePath();
        
        // 测试用例 1
        String input1 = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println("Test case 1:");
        System.out.println("Input: " + input1);
        System.out.println("Output: " + solution.lengthLongestPath(input1));
        // 预期输出：32
        
        // 测试用例 2
        String input2 = "a";
        System.out.println("\nTest case 2:");
        System.out.println("Input: " + input2);
        System.out.println("Output: " + solution.lengthLongestPath(input2));
        // 预期输出：0
        
        // 测试用例 3
        String input3 = "file1.txt\nfile2.txt\nlongfile.txt";
        System.out.println("\nTest case 3:");
        System.out.println("Input: " + input3);
        System.out.println("Output: " + solution.lengthLongestPath(input3));
        // 预期输出：12
    }
} 