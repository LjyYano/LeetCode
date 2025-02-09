import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/text-justification/
 * 
 * 给定一个单词数组 words 和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 * 
 * 你应该使用 "贪心算法" 来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 * 
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * 
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * 
 * 注意:
 * - 单词是指由非空格字符组成的字符序列
 * - 每个单词的长度大于 0，小于等于 maxWidth
 * - 输入单词数组 words 至少包含一个单词
 * 
 * 示例 1：
 * 输入: words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 
 * 示例 2：
 * 输入:words = ["What","must","be","acknowledgment","shall","be"], maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。       
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 
 * 示例 3：
 * 输入:words = ["Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"], maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 * ]
 */
public class L0068_TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int currentLineStart = 0;

        while (currentLineStart < words.length) {
            // 找出当前行可以容纳的单词数
            int currentLineEnd = findLineEnd(words, currentLineStart, maxWidth);
            
            // 生成当前行的文本
            String line = createLine(words, currentLineStart, currentLineEnd, maxWidth, currentLineEnd == words.length);
            result.add(line);
            
            // 移动到下一行的起始位置
            currentLineStart = currentLineEnd;
        }

        return result;
    }

    // 找出当前行可以容纳的单词数
    private int findLineEnd(String[] words, int start, int maxWidth) {
        int currentWidth = words[start].length();
        int end = start + 1;
        
        // 尽可能多地添加单词，每个单词之间至少需要一个空格
        while (end < words.length && currentWidth + 1 + words[end].length() <= maxWidth) {
            currentWidth += 1 + words[end].length();
            end++;
        }
        
        return end;
    }

    // 生成当前行的文本
    private String createLine(String[] words, int start, int end, int maxWidth, boolean isLastLine) {
        StringBuilder line = new StringBuilder();
        int wordCount = end - start;
        int totalWordsLength = 0;
        
        // 计算所有单词的总长度
        for (int i = start; i < end; i++) {
            totalWordsLength += words[i].length();
        }
        
        // 计算需要填充的空格总数
        int totalSpaces = maxWidth - totalWordsLength;
        
        // 处理最后一行或只有一个单词的情况
        if (isLastLine || wordCount == 1) {
            // 最后一行左对齐
            for (int i = start; i < end; i++) {
                line.append(words[i]);
                if (i < end - 1) {
                    line.append(" ");
                    totalSpaces--;
                }
            }
            // 在末尾添加剩余的空格
            while (totalSpaces > 0) {
                line.append(" ");
                totalSpaces--;
            }
        } else {
            // 计算单词间的空格数
            int spaceBetweenWords = totalSpaces / (wordCount - 1);
            int extraSpaces = totalSpaces % (wordCount - 1);
            
            // 添加第一个单词
            line.append(words[start]);
            
            // 添加剩余的单词，并在单词间添加空格
            for (int i = start + 1; i < end; i++) {
                // 添加基本空格
                for (int j = 0; j < spaceBetweenWords; j++) {
                    line.append(" ");
                }
                
                // 如果还有额外的空格需要分配，就多加一个空格
                if (extraSpaces > 0) {
                    line.append(" ");
                    extraSpaces--;
                }
                
                // 添加单词
                line.append(words[i]);
            }
        }
        
        return line.toString();
    }

    public static void main(String[] args) {
        L0068_TextJustification solution = new L0068_TextJustification();

        // 测试用例 1
        String[] words1 = {"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth1 = 16;
        System.out.println("Input: words = [\"This\", \"is\", \"an\", \"example\", \"of\", \"text\", \"justification.\"], maxWidth = 16");
        System.out.println("Output:");
        List<String> result1 = solution.fullJustify(words1, maxWidth1);
        for (String line : result1) {
            System.out.println("\"" + line + "\"");
        }
        System.out.println();

        // 测试用例 2
        String[] words2 = {"What","must","be","acknowledgment","shall","be"};
        int maxWidth2 = 16;
        System.out.println("Input: words = [\"What\",\"must\",\"be\",\"acknowledgment\",\"shall\",\"be\"], maxWidth = 16");
        System.out.println("Output:");
        List<String> result2 = solution.fullJustify(words2, maxWidth2);
        for (String line : result2) {
            System.out.println("\"" + line + "\"");
        }
        System.out.println();

        // 测试用例 3
        String[] words3 = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        int maxWidth3 = 20;
        System.out.println("Input: words = [\"Science\",\"is\",\"what\",\"we\",\"understand\",\"well\",\"enough\",\"to\",\"explain\",\"to\",\"a\",\"computer.\",\"Art\",\"is\",\"everything\",\"else\",\"we\",\"do\"], maxWidth = 20");
        System.out.println("Output:");
        List<String> result3 = solution.fullJustify(words3, maxWidth3);
        for (String line : result3) {
            System.out.println("\"" + line + "\"");
        }
    }
} 