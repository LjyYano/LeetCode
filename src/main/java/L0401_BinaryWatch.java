/**
 * https://leetcode.cn/problems/binary-watch/
 * 
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。
 * 每个 LED 代表一个 0 或 1，最低位在右侧。
 * 
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。
 * 你可以 按任意顺序 返回答案。
 * 
 * 小时不会以零开头：
 * - 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 
 * 分钟必须由两位数组成，可能会以零开头：
 * - 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * 
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 * 
 * 提示：
 * - 0 <= turnedOn <= 10
 */
import java.util.*;

public class L0401_BinaryWatch {
    
    /**
     * 枚举所有可能的时间，检查其二进制表示中 1 的个数
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();
        
        // 枚举所有可能的小时（0-11）和分钟（0-59）
        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                // 统计小时和分钟二进制表示中 1 的个数
                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                }
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        L0401_BinaryWatch solution = new L0401_BinaryWatch();
        
        // 测试用例 1
        System.out.println(solution.readBinaryWatch(1));
        // 预期输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
        
        // 测试用例 2
        System.out.println(solution.readBinaryWatch(9));
        // 预期输出：[]
    }
}
