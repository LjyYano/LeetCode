import java.util.*;

class Solution241 {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        // 如果表达式中只包含数字，直接返回该数字
        if (!expression.contains("+") && !expression.contains("-") && !expression.contains("*")) {
            result.add(Integer.parseInt(expression));
            return result;
        }
        
        // 遍历表达式的每个字符
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // 如果是运算符，则将表达式分成左右两部分，分别计算
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                
                // 根据运算符计算所有可能的结果
                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Solution241 solution = new Solution241();
        
        // 测试用例 1
        String expression1 = "2-1-1";
        System.out.println("Test case 1: " + expression1);
        List<Integer> result1 = solution.diffWaysToCompute(expression1);
        System.out.println("Result 1: " + result1);
        
        // 测试用例 2
        String expression2 = "2*3-4*5";
        System.out.println("\nTest case 2: " + expression2);
        List<Integer> result2 = solution.diffWaysToCompute(expression2);
        System.out.println("Result 2: " + result2);
    }
} 