/**
 * https://leetcode.cn/problems/utf-8-validation/
 * 
 * 给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。
 * 
 * UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则：
 * 1. 对于 1 字节的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。
 * 2. 对于 n 字节的字符 (n > 1)，第一个字节的前 n 位都设为 1，第 n+1 位设为 0，后面字节的前两位一律设为 10。
 *    剩下的没有提及的二进制位，全部为这个符号的 unicode 码。
 * 
 * 这是 UTF-8 编码的工作方式：
 *    Char. number range  |        UTF-8 octet sequence
 *       (hexadecimal)    |              (binary)
 *    --------------------+---------------------------------------------
 *    0000 0000-0000 007F | 0xxxxxxx
 *    0000 0080-0000 07FF | 110xxxxx 10xxxxxx
 *    0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
 *    0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
 * 
 * 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。
 * 
 * 示例 1：
 * 输入：data = [197,130,1]
 * 输出：true
 * 解释：数据表示字节序列:11000101 10000010 00000001。
 * 这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
 * 
 * 示例 2：
 * 输入：data = [235,140,4]
 * 输出：false
 * 解释：数据表示 8 位的序列: 11101011 10001100 00000100。
 * 前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
 * 下一个字节是开头为 10 的延续字节，这是正确的。
 * 但第二个延续字节不以 10 开头，所以是不符合规则的。
 * 
 * 提示:
 * - 1 <= data.length <= 2 * 10⁴
 * - 0 <= data[i] <= 255
 */
public class L0393_UTF8Validation {
    
    public boolean validUtf8(int[] data) {
        // 遍历数组
        int i = 0;
        while (i < data.length) {
            // 获取当前字节的前导 1 的个数
            int n = getLeadingOnes(data[i]);
            
            // 如果前导 1 的个数大于 4 或等于 1，则不是有效的 UTF-8 编码
            if (n > 4 || n == 1) {
                return false;
            }
            
            // 如果是单字节字符，继续处理下一个字节
            if (n == 0) {
                i++;
                continue;
            }
            
            // 检查是否有足够的后续字节
            if (i + n > data.length) {
                return false;
            }
            
            // 检查后续字节是否都以 10 开头
            for (int j = 1; j < n; j++) {
                if (!isFollowingByte(data[i + j])) {
                    return false;
                }
            }
            
            // 移动到下一个字符
            i += n;
        }
        
        return true;
    }
    
    // 获取一个字节的前导 1 的个数
    private int getLeadingOnes(int num) {
        // 只考虑最低 8 位
        num = num & 0xFF;
        
        if ((num & 0x80) == 0) {
            return 0;
        }
        if ((num & 0xE0) == 0xC0) {
            return 2;
        }
        if ((num & 0xF0) == 0xE0) {
            return 3;
        }
        if ((num & 0xF8) == 0xF0) {
            return 4;
        }
        return -1;
    }
    
    // 检查是否是后续字节（以 10 开头）
    private boolean isFollowingByte(int num) {
        // 只考虑最低 8 位，检查是否以 10 开头
        return (num & 0xC0) == 0x80;
    }

    public static void main(String[] args) {
        L0393_UTF8Validation solution = new L0393_UTF8Validation();
        
        // 测试用例 1
        int[] data1 = {197, 130, 1};
        System.out.println("测试用例 1：");
        System.out.println("输入：data = [197,130,1]");
        System.out.println("输出：" + solution.validUtf8(data1));
        System.out.println();
        
        // 测试用例 2
        int[] data2 = {235, 140, 4};
        System.out.println("测试用例 2：");
        System.out.println("输入：data = [235,140,4]");
        System.out.println("输出：" + solution.validUtf8(data2));
        System.out.println();
        
        // 测试用例 3：4 字节字符
        int[] data3 = {240, 162, 138, 147};
        System.out.println("测试用例 3：");
        System.out.println("输入：data = [240,162,138,147]");
        System.out.println("输出：" + solution.validUtf8(data3));
    }
} 