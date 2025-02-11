import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * https://leetcode.cn/problems/mini-parser/
 * 
 * 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析器来解析它，并返回解析的 NestedInteger 。
 * 列表中的每个元素只可能是整数或整数嵌套列表
 */
public class L0385_MiniParser {
    // 这个类用于表示嵌套的整数
    public static class NestedInteger {
        private Integer value;
        private List<NestedInteger> list;
        
        public NestedInteger() {
            list = new ArrayList<>();
        }
        
        public NestedInteger(int value) {
            this.value = value;
        }
        
        public boolean isInteger() {
            return value != null;
        }
        
        public Integer getInteger() {
            return value;
        }
        
        public void setInteger(int value) {
            this.value = value;
        }
        
        public void add(NestedInteger ni) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(ni);
        }
        
        public List<NestedInteger> getList() {
            return list;
        }
    }
    
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            // 如果不是列表，直接返回整数
            return new NestedInteger(Integer.parseInt(s));
        }
        
        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int num = 0;
        boolean isNegative = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                // 遇到左括号，创建新的嵌套整数并入栈
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
            } else if (c == ']') {
                // 遇到右括号，处理可能的数字并弹出栈顶
                if (Character.isDigit(s.charAt(i - 1))) {
                    curr.add(new NestedInteger(isNegative ? -num : num));
                }
                if (!stack.isEmpty()) {
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                num = 0;
                isNegative = false;
            } else if (c == '-') {
                isNegative = true;
            } else if (c == ',') {
                // 遇到逗号，处理前面的数字
                if (Character.isDigit(s.charAt(i - 1))) {
                    curr.add(new NestedInteger(isNegative ? -num : num));
                }
                num = 0;
                isNegative = false;
            } else if (Character.isDigit(c)) {
                // 处理数字
                num = num * 10 + (c - '0');
            }
        }
        
        return curr;
    }

    public static void main(String[] args) {
        L0385_MiniParser solution = new L0385_MiniParser();
        
        // 测试用例 1
        String s1 = "[123,[456,[789]]]";
        NestedInteger result1 = solution.deserialize(s1);
        System.out.println("Test case 1: " + s1);
        printNestedInteger(result1, 0);
        
        // 测试用例 2
        String s2 = "324";
        NestedInteger result2 = solution.deserialize(s2);
        System.out.println("\nTest case 2: " + s2);
        printNestedInteger(result2, 0);
        
        // 测试用例 3
        String s3 = "[123,456,[788,799,833],[[]],10,[]]";
        NestedInteger result3 = solution.deserialize(s3);
        System.out.println("\nTest case 3: " + s3);
        printNestedInteger(result3, 0);
    }
    
    // 用于打印 NestedInteger 的辅助方法
    private static void printNestedInteger(NestedInteger ni, int depth) {
        String indent = "  ".repeat(depth);
        if (ni.isInteger()) {
            System.out.println(indent + ni.getInteger());
        } else {
            System.out.println(indent + "[");
            for (NestedInteger child : ni.getList()) {
                printNestedInteger(child, depth + 1);
            }
            System.out.println(indent + "]");
        }
    }
} 