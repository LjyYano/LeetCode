import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/restore-ip-addresses/
 * 
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * - 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。你 不能 重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * 
 * 提示：
 * - 1 <= s.length <= 20
 * - s 仅由数字组成
 */
public class L0093_RestoreIPAddresses {
    
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        // 如果字符串长度小于 4 或大于 12，无法构成有效的 IP 地址
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        
        // 回溯生成所有可能的 IP 地址
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String s, int start, int segments, StringBuilder current, List<String> result) {
        // 如果已经找到了 4 个段，且使用完了所有字符，则找到一个有效的 IP 地址
        if (segments == 4 && start == s.length()) {
            // 去掉最后一个点
            result.add(current.substring(0, current.length() - 1));
            return;
        }
        
        // 如果已经有 4 个段但还有剩余字符，或者字符用完了但还没有 4 个段，则返回
        if (segments == 4 || start == s.length()) {
            return;
        }
        
        // 记录当前 StringBuilder 的长度，用于回溯
        int len = current.length();
        
        // 尝试取 1 到 3 个字符作为一个段
        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            // 获取当前段的字符串
            String segment = s.substring(start, start + i);
            // 检查是否是有效的 IP 地址段
            if (isValidSegment(segment)) {
                // 添加当前段和点
                current.append(segment).append('.');
                // 递归处理下一段
                backtrack(s, start + i, segments + 1, current, result);
                // 回溯，删除当前添加的段和点
                current.setLength(len);
            }
        }
    }
    
    private boolean isValidSegment(String segment) {
        // 如果长度大于 1 且以 0 开头，则无效
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        // 将字符串转换为数字
        int value = Integer.parseInt(segment);
        // 检查是否在 0-255 范围内
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
        L0093_RestoreIPAddresses solution = new L0093_RestoreIPAddresses();

        // 测试用例 1
        String s1 = "25525511135";
        System.out.println("测试用例 1：");
        System.out.println("输入：s = \"" + s1 + "\"");
        System.out.println("输出：" + solution.restoreIpAddresses(s1));
        System.out.println();

        // 测试用例 2
        String s2 = "0000";
        System.out.println("测试用例 2：");
        System.out.println("输入：s = \"" + s2 + "\"");
        System.out.println("输出：" + solution.restoreIpAddresses(s2));
        System.out.println();

        // 测试用例 3
        String s3 = "101023";
        System.out.println("测试用例 3：");
        System.out.println("输入：s = \"" + s3 + "\"");
        System.out.println("输出：" + solution.restoreIpAddresses(s3));
    }
} 