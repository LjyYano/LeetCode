---
title: 实现 Trie (前缀树)
date: 2024-02-09
---

## 题目描述

**🔗 题目**：[实现 Trie (前缀树)](https://leetcode.cn/problems/implement-trie-prefix-tree/)  
**🏷️ 标签**：`设计` `字典树` `哈希表` `字符串`  
**🟡 难度**：`中等`  

Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：
- Trie() 初始化前缀树对象。
- void insert(String word) 向前缀树中插入字符串 word 。
- boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
- boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

示例：
```
输入
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
输出
[null, null, true, false, true, null, true]

解释
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // 返回 True
trie.search("app");     // 返回 False
trie.startsWith("app"); // 返回 True
trie.insert("app");
trie.search("app");     // 返回 True
```

提示：
- 1 <= word.length, prefix.length <= 2000
- word 和 prefix 仅由小写英文字母组成
- insert、search 和 startsWith 调用次数 总计 不超过 3 * 10⁴ 次

---

## 解题思路

### Trie 前缀树实现

#### 📝 核心思想
Trie 前缀树是一种多叉树结构，每个节点包含以下部分：
1. 子节点数组（对于小写字母，是一个大小为 26 的数组）
2. 是否为单词结尾的标记（isEnd）

主要操作的核心思想：
- 插入：逐个字符构建节点路径，最后标记结尾
- 查找：沿着字符路径查找，检查结尾标记
- 前缀查找：沿着字符路径查找，不检查结尾标记

#### 🛠️ 实现步骤

1. 定义节点结构：
   ```java
   class TrieNode {
       TrieNode[] children = new TrieNode[26];
       boolean isEnd = false;
   }
   ```

2. 插入操作：
   - 从根节点开始
   - 对单词的每个字符：
     - 计算字符对应的索引
     - 如果子节点不存在，创建新节点
     - 移动到子节点
   - 标记最后一个节点为单词结尾

3. 查找操作：
   - 从根节点开始
   - 对单词的每个字符：
     - 如果子节点不存在，返回 false
     - 移动到子节点
   - 检查最后一个节点是否为单词结尾

4. 前缀查找：
   - 与查找操作类似
   - 不需要检查最后一个节点的结尾标记

#### 🧩 示例分析
以插入 "apple" 和 "app" 为例：

1. 初始状态：
```
root
```

2. 插入 "apple"：
```
root
 |
 a
 |
 p
 |
 p
 |
 l
 |
 e*
```

3. 插入 "app"：
```
root
 |
 a
 |
 p
 |
 p*
 |
 l
 |
 e*
```
（* 表示单词结尾）

操作分析：

| 操作 | 输入 | 过程 | 结果 |
|-----|------|-----|------|
| insert | "apple" | 创建路径：a->p->p->l->e，标记 e 为结尾 | 成功 |
| search | "apple" | 找到完整路径，且 e 标记为结尾 | true |
| search | "app" | 找到路径，但 p 未标记为结尾 | false |
| startsWith | "app" | 找到路径即可，不检查结尾标记 | true |
| insert | "app" | 复用已有路径，标记第二个 p 为结尾 | 成功 |
| search | "app" | 找到路径，且 p 已标记为结尾 | true |

---

## 代码实现

完整的可运行代码：[L0208_Trie.java](../src/main/java/L0208_Trie.java)

```java
public class L0208_Trie {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;
        
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }
    
    private TrieNode root;
    
    public L0208_Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchNode(prefix) != null;
    }
    
    private TrieNode searchNode(String str) {
        TrieNode node = root;
        for (char c : str.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
```

---

## 复杂度分析

- **时间复杂度**：
  - insert：O(m)，m 是单词长度
  - search：O(m)，m 是单词长度
  - startsWith：O(m)，m 是前缀长度
  - 每个操作都需要遍历输入字符串的所有字符

- **空间复杂度**：O(T)
  - T 是所有插入字符串的字符总数
  - 每个节点占用固定空间（26 个指针）
  - 最坏情况下需要为每个字符创建新节点

---

## LeetCode 题解

本题解是 LeetCode 系列题解的一部分。该系列题解致力于帮助程序员更好地理解和掌握算法思维，内容包含详细的解题思路分析、图文并茂的示例讲解和完整的代码实现。

<img src="https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png" alt="GitHub" width="20" style="vertical-align: middle; margin-right: 5px"> [LeetCode 最全题解](https://github.com/LjyYano/LeetCode)：持续更新中，欢迎 Star ⭐️ 关注，一起探讨算法之美。 