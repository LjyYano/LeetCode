---
title: Excel 表列名称
date: 2025-02-09
---

## 题目描述

**🔗 题目**：[Excel 表列名称](https://leetcode.cn/problems/excel-sheet-column-title/)  
**🏷️ 标签**：`数学` `字符串`  
**🟡 难度**：`中等`  

给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称。

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
输入：columnNumber = 1
输出："A"
```

示例 2：
```
输入：columnNumber = 28
输出："AB"
```

示例 3：
```
输入：columnNumber = 701
输出："ZY"
```

示例 4：
```
输入：columnNumber = 2147483647
输出："FXSHRXW"
```

提示：
- 1 <= columnNumber <= 2³¹ - 1

---

## 解题思路
### 从 1 开始的 26 进制转换

#### 📝 核心思想
这道题本质上是一个进制转换问题，但有两个特殊点：
1. 是 26 进制（A-Z 共 26 个字母）
2. 是从 1 开始而不是从 0 开始（A 代表 1，B 代表 2，...，Z 代表 26）

正是因为是从 1 开始的，所以我们需要在每次计算前将数字减 1，这样就转换成了标准的 26 进制问题。例如：
- 1 -> A：1-1=0 -> 'A'+0 -> 'A'
- 26 -> Z：26-1=25 -> 'A'+25 -> 'Z'
- 27 -> AA：(27-1)/26=1，(27-1)%26=0 -> "AA"

#### 🛠️ 实现步骤
1. 创建 StringBuilder 用于构建结果字符串
2. 当输入数字大于 0 时，循环执行：
   - 将数字减 1（转换为从 0 开始的 26 进制）
   - 用 数字%26 得到当前位的字母（'A' + remainder）
   - 将字母插入到结果字符串的开头
   - 数字除以 26，继续处理下一位
3. 返回结果字符串

#### 🧩 示例分析
让我们以 columnNumber = 28 为例，详细分析转换过程：

| 步骤 | 当前数字 | 减 1 后 | 除以 26 的余数 | 对应字母 | 当前结果 | 下一个数字 |
|-----|---------|---------|--------------|---------|----------|-----------|
| 1 | 28 | 27 | 1 | 'A'+1='B' | "B" | 1 |
| 2 | 1 | 0 | 0 | 'A'+0='A' | "AB" | 0 |

再看一个更大的数 701：

| 步骤 | 当前数字 | 减 1 后 | 除以 26 的余数 | 对应字母 | 当前结果 | 下一个数字 |
|-----|---------|---------|--------------|---------|----------|-----------|
| 1 | 701 | 700 | 24 | 'A'+24='Y' | "Y" | 26 |
| 2 | 26 | 25 | 25 | 'A'+25='Z' | "ZY" | 0 |

为什么要减 1？让我们看一个简单的对比：

| 数字 | 不减 1 的结果 | 减 1 后的结果 | 正确答案 |
|-----|-------------|--------------|----------|
| 1 | 'A'+1='B' | 'A'+0='A' | A |
| 26 | 'A'+0='A' | 'A'+25='Z' | Z |
| 27 | 'A'+1='B' | 'A'+0='A' | AA |

可以看到，如果不减 1，结果会整体偏移一位，导致错误。减 1 的操作让我们可以正确地将 1-26 映射到 A-Z。

---

## 代码实现

完整的可运行代码：[L0168_ExcelSheetColumnTitle.java](../src/main/java/L0168_ExcelSheetColumnTitle.java)

```java
public String convertToTitle(int columnNumber) {
    StringBuilder result = new StringBuilder();
    
    while (columnNumber > 0) {
        // 因为是从 1 开始的 26 进制，所以要先减 1
        columnNumber--;
        // 获取当前位的字母（A 的 ASCII 码是 65）
        char currentChar = (char) ('A' + columnNumber % 26);
        // 将字母添加到结果的开头
        result.insert(0, currentChar);
        // 处理下一位
        columnNumber /= 26;
    }
    
    return result.toString();
}
```

---

## 复杂度分析

- **时间复杂度**：O(log₂₆n)
  - 每次循环将数字除以 26，直到数字变为 0
  - 循环次数等于结果字符串的长度，即 log₂₆n

- **空间复杂度**：O(1)
  - 只使用了一个 StringBuilder 来存储结果
  - StringBuilder 的大小与输入数字的对数成正比，可以视为常数

---

## LeetCode 题解

本题解是 LeetCode 系列题解的一部分。该系列题解致力于帮助程序员更好地理解和掌握算法思维，内容包含详细的解题思路分析、图文并茂的示例讲解和完整的代码实现。

<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" alt="GitHub" width="20" style="vertical-align: middle; margin-right: 5px"> [LeetCode 最全题解](https://github.com/LjyYano/LeetCode)：持续更新中，欢迎 Star ⭐️ 关注，一起探讨算法之美。 