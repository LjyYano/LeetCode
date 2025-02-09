/**
 * https://leetcode.cn/problems/simplify-path/
 * 
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * 
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。
 * 任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * 
 * 请注意，返回的 规范路径 必须遵循下述格式：
 * - 始终以斜杠 '/' 开头。
 * - 两个目录名之间必须只有一个斜杠 '/' 。
 * - 最后一个目录名（如果存在）不能 以 '/' 结尾。
 * - 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * 
 * 返回简化后得到的 规范路径 。
 * 
 * 示例 1：
 * 输入：path = "/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。 
 * 
 * 示例 2：
 * 输入：path = "/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
 * 
 * 示例 3：
 * 输入：path = "/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 
 * 示例 4：
 * 输入：path = "/a/./b/../../c/"
 * 输出："/c"
 * 
 * 提示：
 * 1 <= path.length <= 3000
 * path 由英文字母，数字，'.'，'/' 或 '_' 组成。
 * path 是一个有效的 Unix 风格绝对路径。
 */
public class L0071_SimplifyPath {

    public String simplifyPath(String path) {
        // 使用 StringBuilder 来构建结果
        StringBuilder result = new StringBuilder();
        // 将路径按 "/" 分割成数组
        String[] components = path.split("/");
        // 使用 StringBuilder 数组作为栈来存储有效的目录名
        StringBuilder[] stack = new StringBuilder[components.length];
        int top = -1;  // 栈顶指针

        // 处理每个路径组件
        for (String component : components) {
            // 跳过空字符串和当前目录符号
            if (component.isEmpty() || component.equals(".")) {
                continue;
            }
            // 处理父目录符号
            if (component.equals("..")) {
                // 如果栈不为空，弹出栈顶元素（返回上一级目录）
                if (top >= 0) {
                    top--;
                }
            } else {
                // 将有效的目录名入栈
                stack[++top] = new StringBuilder(component);
            }
        }

        // 如果栈为空，返回根目录
        if (top == -1) {
            return "/";
        }

        // 构建规范路径
        for (int i = 0; i <= top; i++) {
            result.append("/").append(stack[i]);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        L0071_SimplifyPath solution = new L0071_SimplifyPath();

        // 测试用例 1
        String path1 = "/home/";
        System.out.println("Input: path = \"" + path1 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path1) + "\"");
        System.out.println();

        // 测试用例 2
        String path2 = "/../";
        System.out.println("Input: path = \"" + path2 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path2) + "\"");
        System.out.println();

        // 测试用例 3
        String path3 = "/home//foo/";
        System.out.println("Input: path = \"" + path3 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path3) + "\"");
        System.out.println();

        // 测试用例 4
        String path4 = "/a/./b/../../c/";
        System.out.println("Input: path = \"" + path4 + "\"");
        System.out.println("Output: \"" + solution.simplifyPath(path4) + "\"");
    }
} 