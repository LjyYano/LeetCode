/**
 * https://leetcode.cn/problems/validate-ip-address/
 * 
 * 给定一个字符串 queryIP。如果是有效的 IPv4 地址，返回 "IPv4" ；如果是有效的 IPv6 地址，返回 "IPv6" ；如果不是上述类型的 IP 地址，返回 "Neither" 。
 * 
 * 有效的IPv4地址 是 "x1.x2.x3.x4" 形式的IP地址。 其中 0 <= xi <= 255 且 xi 不能包含 前导零。例如: "192.168.1.1" 、 "192.168.1.0" 为有效IPv4地址， "192.168.01.1" 为无效IPv4地址; "192.168.1.00" 、 "192.168@1.1" 为无效IPv4地址。
 * 
 * 一个有效的IPv6地址 是一个格式为"x1:x2:x3:x4:x5:x6:x7:x8" 的IP地址，其中:
 * 1. 1 <= xi.length <= 4
 * 2. xi 是一个 十六进制字符串 ，可以包含数字、小写英文字母( 'a' 到 'f' )和大写英文字母( 'A' 到 'F' )。
 * 3. 在 xi 中允许前导零。
 * 
 * 例如 "2001:0db8:85a3:0000:0000:8a2e:0370:7334" 和 "2001:db8:85a3:0:0:8A2E:0370:7334" 是有效的 IPv6 地址，而 "2001:0db8:85a3::8A2E:037j:7334" 和 "02001:0db8:85a3:0000:0000:8a2e:0370:7334" 是无效的 IPv6 地址。
 * 
 * 示例 1：
 * 输入：queryIP = "172.16.254.1"
 * 输出："IPv4"
 * 解释：有效的 IPv4 地址，返回 "IPv4"
 * 
 * 示例 2：
 * 输入：queryIP = "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * 输出："IPv6"
 * 解释：有效的 IPv6 地址，返回 "IPv6"
 * 
 * 示例 3：
 * 输入：queryIP = "256.256.256.256"
 * 输出："Neither"
 * 解释：既不是 IPv4 地址，又不是 IPv6 地址
 */
public class L0468_ValidateIPAddress {
    
    public String validIPAddress(String queryIP) {
        if (queryIP == null || queryIP.length() == 0) {
            return "Neither";
        }
        
        // 检查是否是 IPv4
        if (queryIP.contains(".")) {
            return validateIPv4(queryIP);
        }
        // 检查是否是 IPv6
        else if (queryIP.contains(":")) {
            return validateIPv6(queryIP);
        }
        
        return "Neither";
    }
    
    private String validateIPv4(String ip) {
        // 不能以 . 开头或结尾
        if (ip.startsWith(".") || ip.endsWith(".")) {
            return "Neither";
        }
        
        // 按 . 分割
        String[] parts = ip.split("\\.");
        
        // IPv4 必须恰好有 4 部分
        if (parts.length != 4) {
            return "Neither";
        }
        
        // 检查每一部分
        for (String part : parts) {
            // 检查长度
            if (part.length() == 0 || part.length() > 3) {
                return "Neither";
            }
            
            // 检查是否包含非数字字符
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c)) {
                    return "Neither";
                }
            }
            
            // 检查前导零
            if (part.length() > 1 && part.charAt(0) == '0') {
                return "Neither";
            }
            
            // 检查数值范围
            int value = Integer.parseInt(part);
            if (value < 0 || value > 255) {
                return "Neither";
            }
        }
        
        return "IPv4";
    }
    
    private String validateIPv6(String ip) {
        // 不能以 : 开头或结尾
        if (ip.startsWith(":") || ip.endsWith(":")) {
            return "Neither";
        }
        
        // 按 : 分割
        String[] parts = ip.split(":");
        
        // IPv6 必须恰好有 8 部分
        if (parts.length != 8) {
            return "Neither";
        }
        
        // 检查每一部分
        for (String part : parts) {
            // 检查长度
            if (part.length() == 0 || part.length() > 4) {
                return "Neither";
            }
            
            // 检查每个字符是否合法
            for (char c : part.toCharArray()) {
                if (!Character.isDigit(c) && 
                    !(c >= 'a' && c <= 'f') && 
                    !(c >= 'A' && c <= 'F')) {
                    return "Neither";
                }
            }
        }
        
        return "IPv6";
    }

    public static void main(String[] args) {
        L0468_ValidateIPAddress solution = new L0468_ValidateIPAddress();
        
        // 测试用例 1
        System.out.println("测试用例 1 结果：" + solution.validIPAddress("172.16.254.1"));  // 预期输出：IPv4
        
        // 测试用例 2
        System.out.println("测试用例 2 结果：" + solution.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));  // 预期输出：IPv6
        
        // 测试用例 3
        System.out.println("测试用例 3 结果：" + solution.validIPAddress("256.256.256.256"));  // 预期输出：Neither
    }
} 