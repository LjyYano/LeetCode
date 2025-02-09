---
title: Excel 表列序号
date: 2025-02-09
---

## 题目描述

**🔗 题目**：[Excel 表列序号](https://leetcode.cn/problems/excel-sheet-column-number/)  
**🏷️ 标签**：`数学` `字符串`  
**🟢 难度**：`简单`  

给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。

例如：
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

示例 1：
```
输入: columnTitle = "A"
输出: 1
```

示例 2：
```
输入: columnTitle = "AB"
输出: 28
```

示例 3：
```
输入: columnTitle = "ZY"
输出: 701
```

提示：
- 1 <= columnTitle.length <= 7
- columnTitle 仅由大写英文组成
- columnTitle 在范围 ["A", "FXSHRXW"] 内

---

## 解题思路
### 26 进制转换

#### 📝 核心思想
这道题本质上是一个 26 进制转换问题。每个字母代表一个 26 进制位，从左到右依次处理每个字母：
1. A-Z 分别对应数值 1-26
2. 每次处理新的字母时，先将已有结果乘以 26（进位），再加上当前字母对应的数值

这个过程类似于我们平时处理十进制数字。例如，对于十进制数字 "123"：
1. 先看 "1"：result = 1
2. 再看 "2"：result = 1 × 10 + 2 = 12
3. 最后看 "3"：result = 12 × 10 + 3 = 123

#### 🛠️ 实现步骤
1. 初始化结果变量 result = 0
2. 从左到右遍历字符串的每个字符：
   - 将已有结果乘以 26（相当于左移一位）
   - 将当前字符转换为对应的数值（A=1, B=2, ..., Z=26）
   - 将转换后的数值加到结果中
3. 返回最终结果

#### 🧩 示例分析
让我们以 columnTitle = "AB" 为例，详细分析转换过程：

| 步骤 | 当前字符 | 字符对应数值 | 计算过程 | 当前结果 |
|------|---------|-------------|-----------|----------|
| 初始状态 | - | - | result = 0 | 0 |
| 处理 'A' | 'A' | 1 | result = 0 × 26 + 1 | 1 |
| 处理 'B' | 'B' | 2 | result = 1 × 26 + 2 | 28 |

再看一个更复杂的例子 "ZY"：

| 步骤 | 当前字符 | 字符对应数值 | 计算过程 | 当前结果 |
|------|---------|-------------|-----------|----------|
| 初始状态 | - | - | result = 0 | 0 |
| 处理 'Z' | 'Z' | 26 | result = 0 × 26 + 26 | 26 |
| 处理 'Y' | 'Y' | 25 | result = 26 × 26 + 25 | 701 |

为什么是这样计算的？让我们用数学公式来理解：
- "AB" = 1 × 26¹ + 2 × 26⁰ = 26 + 2 = 28
- "ZY" = 26 × 26¹ + 25 × 26⁰ = 676 + 25 = 701

---

## 代码实现

完整的可运行代码：[L0171_ExcelSheetColumnNumber.java](../src/main/java/L0171_ExcelSheetColumnNumber.java)

```java
public int titleToNumber(String columnTitle) {
    int result = 0;
    
    // 从左到右遍历字符串的每个字符
    for (char c : columnTitle.toCharArray()) {
        // 将已有结果乘以 26
        result *= 26;
        // 加上当前字符对应的数值（A=1, B=2, ..., Z=26）
        result += c - 'A' + 1;
    }
    
    return result;
}
```

---

## 复杂度分析

- **时间复杂度**：O(n)
  - 其中 n 是字符串的长度
  - 我们需要遍历字符串的每个字符一次

- **空间复杂度**：O(1)
  - 只使用了常数个变量来存储结果
  - 不需要额外的空间

---

## LeetCode 题解

本题解是 LeetCode 系列题解的一部分。该系列题解致力于帮助程序员更好地理解和掌握算法思维，内容包含详细的解题思路分析、图文并茂的示例讲解和完整的代码实现。

<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" alt="GitHub" width="20" style="vertical-align: middle; margin-right: 5px"> [LeetCode 最全题解](https://github.com/LjyYano/LeetCode)：持续更新中，欢迎 Star ⭐️ 关注，一起探讨算法之美。 