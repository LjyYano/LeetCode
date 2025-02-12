/**
 * 459. 重复的子字符串
 * 给定一个非空的字符串 s,检查是否可以通过由它的一个子串重复多次构成。
 * https://leetcode.cn/problems/repeated-substring-pattern/
 */
public class L0459_RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        // 枚举所有可能的子串长度
        for (int i = 1; i <= n / 2; i++) {
            // 如果长度不能被整除,说明不可能由该长度的子串重复构成
            if (n % i != 0) {
                continue;
            }
            // 获取子串
            String pattern = s.substring(0, i);
            // 检查是否可以由该子串重复构成
            boolean match = true;
            for (int j = i; j < n; j += i) {
                if (!s.substring(j, j + i).equals(pattern)) {
                    match = false;
                    break;
                }
            }
            if (match) {
                return true;
            }
        }
        return false;
    }
} 