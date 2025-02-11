---
title: Fizz Buzz
date: 2024-02-11
---

## 题目描述

**🔗 题目**：[Fizz Buzz](https://leetcode.cn/problems/fizz-buzz/description/)  
**🏷️ 标签**：`数学` `字符串` `模拟`  
**🟢 难度**：`简单`  

给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果，其中：
- answer[i] == "FizzBuzz" 如果 i 同时是 3 和 5 的倍数。
- answer[i] == "Fizz" 如果 i 是 3 的倍数。
- answer[i] == "Buzz" 如果 i 是 5 的倍数。
- answer[i] == i （以字符串形式）如果上述条件全不满足。

示例 1：
输入：n = 3
输出：["1","2","Fizz"]

示例 2：
输入：n = 5
输出：["1","2","Fizz","4","Buzz"]

示例 3：
输入：n = 15
输出：["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]

---

## 解题思路

### 条件判断法

#### 📝 核心思想
这是一个经典的编程问题，核心思想是根据数字的特性（是否能被 3 和 5 整除）来决定输出的字符串。我们需要按照优先级顺序检查每个数字：
1. 首先检查是否同时能被 3 和 5 整除
2. 然后检查是否能被 3 整除
3. 再检查是否能被 5 整除
4. 最后，如果都不满足，则输出数字本身

#### 🛠️ 实现步骤
1. 创建一个字符串列表用于存储结果
2. 遍历从 1 到 n 的每个数字
3. 对每个数字进行条件判断：
   - 如果能被 3 和 5 整除，添加 "FizzBuzz"
   - 如果能被 3 整除，添加 "Fizz"
   - 如果能被 5 整除，添加 "Buzz"
   - 否则，添加数字的字符串形式
4. 返回结果列表

#### 🧩 示例分析
以 n = 15 为例，分析处理过程：

| 数字 | 是否被3整除 | 是否被5整除 | 输出 | 说明 |
|-----|------------|------------|------|------|
| 1 | 否 | 否 | "1" | 不满足任何条件 |
| 2 | 否 | 否 | "2" | 不满足任何条件 |
| 3 | 是 | 否 | "Fizz" | 被 3 整除 |
| 4 | 否 | 否 | "4" | 不满足任何条件 |
| 5 | 否 | 是 | "Buzz" | 被 5 整除 |
| 6 | 是 | 否 | "Fizz" | 被 3 整除 |
| 7 | 否 | 否 | "7" | 不满足任何条件 |
| 8 | 否 | 否 | "8" | 不满足任何条件 |
| 9 | 是 | 否 | "Fizz" | 被 3 整除 |
| 10 | 否 | 是 | "Buzz" | 被 5 整除 |
| 11 | 否 | 否 | "11" | 不满足任何条件 |
| 12 | 是 | 否 | "Fizz" | 被 3 整除 |
| 13 | 否 | 否 | "13" | 不满足任何条件 |
| 14 | 否 | 否 | "14" | 不满足任何条件 |
| 15 | 是 | 是 | "FizzBuzz" | 同时被 3 和 5 整除 |

---

## 代码实现

完整的可运行代码：[L0412_FizzBuzz.java](../src/main/java/L0412_FizzBuzz.java)

```java
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
```

---

## 复杂度分析

- **时间复杂度**：O(n)，需要遍历从 1 到 n 的每个数字。
- **空间复杂度**：O(1)，除了返回值所需的空间外，只使用了常数额外空间。

---

## LeetCode 题解

本题解是 LeetCode 系列题解的一部分。该系列题解致力于帮助程序员更好地理解和掌握算法思维，内容包含详细的解题思路分析、图文并茂的示例讲解和完整的代码实现。

<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" alt="GitHub" width="20" style="vertical-align: middle; margin-right: 5px"> [LeetCode 最全题解](https://github.com/LjyYano/LeetCode)：持续更新中，欢迎 Star ⭐️ 关注，一起探讨算法之美。 