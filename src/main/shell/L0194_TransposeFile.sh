#!/bin/bash

# https://leetcode.cn/problems/transpose-file/
# 
# 给定一个文件 file.txt，转置它的内容。
# 
# 你可以假设每行列数相同，并且每个字段由空格分隔。
# 
# 示例：
# 假设 file.txt 内容如下：
# name age
# alice 21
# ryan 30
# 
# 应当输出：
# name alice ryan
# age 21 30

# 使用 awk 命令实现文件转置
awk '
{
    # 遍历当前行的每个字段
    for (i = 1; i <= NF; i++) {
        # 如果是第一行，初始化结果数组
        if (NR == 1) {
            result[i] = $i;
        } else {
            # 否则，将当前字段添加到对应的结果中
            result[i] = result[i] " " $i;
        }
    }
}
END {
    # 输出转置结果
    for (i = 1; i <= NF; i++) {
        print result[i];
    }
}' file.txt 