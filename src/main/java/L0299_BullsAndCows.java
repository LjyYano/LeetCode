/**
 * https://leetcode.cn/problems/bulls-and-cows/
 * 
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * 
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就要给他一个包含下述信息的提示：
 * - 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls"，公牛），
 * - 有多少位属于数字猜对了但是位置不对（称为 "Cows"，奶牛）。
 * - 也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。
 * 
 * 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字。
 * 
 * 示例 1：
 * 输入：secret = "1807", guess = "7810"
 * 输出："1A3B"
 * 解释：数字和位置都对（公牛）用 '|' 标记：
 * "1807"
 *   |
 * "7810"
 * 
 * 示例 2：
 * 输入：secret = "1123", guess = "0111"
 * 输出："1A1B"
 * 解释：数字和位置都对（公牛）用 '|' 标记：
 * "1123"        "1123"
 *   |      or     |
 * "0111"        "0111"
 * 注意，两个不匹配的 1 中，只有一个会算作奶牛（数字猜对位置错误）。通过重新排列非公牛数字，其中仅有一个 1 可以成为公牛数字。
 * 
 * 示例 3：
 * 输入：secret = "1", guess = "0"
 * 输出："0A0B"
 * 
 * 示例 4：
 * 输入：secret = "1", guess = "1"
 * 输出："1A0B"
 * 
 * 提示：
 * - 1 <= secret.length, guess.length <= 1000
 * - secret.length == guess.length
 * - secret 和 guess 仅由数字组成
 */
public class L0299_BullsAndCows {
    
    public String getHint(String secret, String guess) {
        // 统计每个数字在 secret 和 guess 中出现的次数
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        
        // 统计公牛（位置和数字都正确）的数量
        int bulls = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                // 只统计不是公牛的数字
                secretCount[secret.charAt(i) - '0']++;
                guessCount[guess.charAt(i) - '0']++;
            }
        }
        
        // 统计奶牛（数字正确但位置错误）的数量
        int cows = 0;
        for (int i = 0; i < 10; i++) {
            // 对于每个数字，取在 secret 和 guess 中出现次数的较小值
            cows += Math.min(secretCount[i], guessCount[i]);
        }
        
        // 返回结果字符串
        return bulls + "A" + cows + "B";
    }

    public static void main(String[] args) {
        L0299_BullsAndCows solution = new L0299_BullsAndCows();
        
        // 测试用例
        System.out.println("Test Case 1:");
        System.out.println("Input: secret = \"1807\", guess = \"7810\"");
        System.out.println("Output: " + solution.getHint("1807", "7810"));
        System.out.println();
        
        System.out.println("Test Case 2:");
        System.out.println("Input: secret = \"1123\", guess = \"0111\"");
        System.out.println("Output: " + solution.getHint("1123", "0111"));
        System.out.println();
        
        System.out.println("Test Case 3:");
        System.out.println("Input: secret = \"1\", guess = \"0\"");
        System.out.println("Output: " + solution.getHint("1", "0"));
        System.out.println();
        
        System.out.println("Test Case 4:");
        System.out.println("Input: secret = \"1\", guess = \"1\"");
        System.out.println("Output: " + solution.getHint("1", "1"));
    }
} 