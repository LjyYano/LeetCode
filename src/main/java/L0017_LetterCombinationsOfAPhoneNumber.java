import java.util.ArrayList;
import java.util.List;

/**
 * 题目链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * 
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2: abc
 * 3: def
 * 4: ghi
 * 5: jkl
 * 6: mno
 * 7: pqrs
 * 8: tuv
 * 9: wxyz
 */
public class L0017_LetterCombinationsOfAPhoneNumber {

    // 数字到字母的映射
    private static final String[] MAPPING = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        // 处理空字符串的情况
        if (digits == null || digits.length() == 0) {
            return result;
        }
        // 开始回溯
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    /**
     * 回溯方法
     * @param digits 输入的数字字符串
     * @param index 当前处理的数字索引
     * @param current 当前构建的字母组合
     * @param result 结果列表
     */
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // 如果当前索引等于数字字符串的长度，说明已经处理完所有数字
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // 获取当前数字对应的字母字符串
        String letters = MAPPING[digits.charAt(index) - '0'];
        // 遍历当前数字对应的所有字母
        for (char letter : letters.toCharArray()) {
            // 添加当前字母
            current.append(letter);
            // 递归处理下一个数字
            backtrack(digits, index + 1, current, result);
            // 回溯，删除当前字母
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {
        L0017_LetterCombinationsOfAPhoneNumber solution = new L0017_LetterCombinationsOfAPhoneNumber();

        // 测试用例 1
        String digits1 = "23";
        System.out.println("Input: " + digits1);
        System.out.println("Output: " + solution.letterCombinations(digits1));
        // 预期输出：[ad, ae, af, bd, be, bf, cd, ce, cf]

        // 测试用例 2
        String digits2 = "";
        System.out.println("\nInput: " + digits2);
        System.out.println("Output: " + solution.letterCombinations(digits2));
        // 预期输出：[]

        // 测试用例 3
        String digits3 = "2";
        System.out.println("\nInput: " + digits3);
        System.out.println("Output: " + solution.letterCombinations(digits3));
        // 预期输出：[a, b, c]
    }
} 