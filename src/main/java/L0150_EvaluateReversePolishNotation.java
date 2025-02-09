import java.util.Stack;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 * 
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 
 * 注意：
 * - 有效的算符为 '+'、'-'、'*' 和 '/'
 * - 每个操作数（运算对象）都可以是一个整数或者另一个表达式
 * - 两个整数之间的除法总是 向零截断
 * - 表达式中不含除零运算
 * - 输入是一个根据逆波兰表示法表示的算术表达式
 * - 答案及所有中间计算结果可以用 32 位 整数表示
 * 
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 
 * 提示：
 * - 1 <= tokens.length <= 10⁴
 * - tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 */
public class L0150_EvaluateReversePolishNotation {
    
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
            // 如果是运算符，从栈中弹出两个数进行运算
            if (isOperator(token)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = calculate(num1, num2, token);
                stack.push(result);
            } else {
                // 如果是数字，直接入栈
                stack.push(Integer.parseInt(token));
            }
        }
        
        // 最后栈中只剩下一个数，就是结果
        return stack.pop();
    }
    
    // 判断是否是运算符
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || 
               token.equals("*") || token.equals("/");
    }
    
    // 根据运算符进行计算
    private int calculate(int num1, int num2, String operator) {
        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/": return num1 / num2;
            default: throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    public static void main(String[] args) {
        L0150_EvaluateReversePolishNotation solution = new L0150_EvaluateReversePolishNotation();
        
        // 测试用例 1
        String[] tokens1 = {"2","1","+","3","*"};
        System.out.println(solution.evalRPN(tokens1)); // 预期输出：9
        
        // 测试用例 2
        String[] tokens2 = {"4","13","5","/","+"};
        System.out.println(solution.evalRPN(tokens2)); // 预期输出：6
        
        // 测试用例 3
        String[] tokens3 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(solution.evalRPN(tokens3)); // 预期输出：22
    }
} 