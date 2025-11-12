public class L0482_LicenseKeyFormatting {
    public String licenseKeyFormatting(String s, int k) {
        // 移除破折号并转为大写
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c != '-') {
                sb.append(Character.toUpperCase(c));
            }
        }
        
        // 如果没有有效字符，返回空字符串
        if (sb.length() == 0) {
            return "";
        }
        
        // 从后往前构造结果
        StringBuilder result = new StringBuilder();
        int count = 0;
        
        for (int i = sb.length() - 1; i >= 0; i--) {
            if (count == k) {
                result.append('-');
                count = 0;
            }
            result.append(sb.charAt(i));
            count++;
        }
        
        // 反转结果
        return result.reverse().toString();
    }
} 