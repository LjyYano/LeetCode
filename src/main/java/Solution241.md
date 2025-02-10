# 241. 为运算表达式设计优先级

## 题目描述

给你一个由数字和运算符组成的字符串 `expression`，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以按任意顺序返回答案。

生成的测试用例满足其对应输出值符合 32 位整数范围，不同结果的数量不超过 10^4。

示例 1：
```
输入：expression = "2-1-1"
输出：[0,2]
解释：
((2-1)-1) = 0 
(2-(1-1)) = 2
```

示例 2：
```
输入：expression = "2*3-4*5"
输出：[-34,-14,-10,-10,10]
解释：
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10
```

## 解题思路

这道题可以使用分治法（Divide and Conquer）来解决。主要思路如下：

1. 基本情况：如果表达式中只包含数字（没有运算符），则直接返回该数字。

2. 递归步骤：
   - 遍历表达式中的每个字符
   - 当遇到运算符时，将表达式分成左右两部分
   - 递归计算左右两部分的所有可能结果
   - 根据当前运算符，将左右两部分的结果进行组合计算

3. 具体实现：
   - 使用 ArrayList 存储所有可能的计算结果
   - 通过 substring 方法分割字符串
   - 使用嵌套循环组合左右两部分的结果

## 复杂度分析

- 时间复杂度：O(2^n)，其中 n 是表达式的长度。每个运算符都可以作为最后一个运算符，因此时间复杂度是指数级的。
- 空间复杂度：O(n)，主要是递归调用栈的开销。

## 代码实现

```java
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
}
```

## 优化思路

1. 可以使用记忆化搜索（Memoization）来优化重复计算：
   - 使用 HashMap 存储已经计算过的表达式及其结果
   - 在递归之前先查找是否已经计算过
   - 如果已经计算过，直接返回结果

2. 可以预处理表达式：
   - 将数字和运算符分别存储
   - 避免重复的字符串分割操作

这些优化可以在实际应用中根据具体情况选择使用。 