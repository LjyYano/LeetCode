#!/bin/bash

# https://leetcode.cn/problems/word-frequency/
# 
# 写一个 bash 脚本以统计一个文本文件 words.txt 中每个单词出现的频率。
# 
# 为了简单起见，你可以假设：
# - words.txt只包括小写字母和空格
# - 每个单词只由小写字母组成
# - 单词间由一个或多个空格字符分隔
# 
# 示例:
# 假设 words.txt 内容如下：
# the day is sunny the the
# the sunny is is
# 
# 你的脚本应当输出（以词频降序排列）：
# the 4
# is 3
# sunny 2
# day 1

# 使用 tr 命令将换行符转换为空格，然后使用 awk 统计单词频率并排序
cat words.txt | tr '\n' ' ' | awk '{
    # 遍历每个单词
    for(i=1;i<=NF;i++) {
        # 统计单词出现次数
        count[$i]++
    }
}
END {
    # 输出结果
    for(word in count) {
        print word, count[word]
    }
}' | sort -rn -k2 