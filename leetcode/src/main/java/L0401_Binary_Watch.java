import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/binary-watch/
class L0401_Binary_Watch {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<>();
        int[] hour = {8, 4, 2, 1};
        int[] minute = {32, 16, 8, 4, 2, 1};
        for(int i = 0; i <= num; i++) {
            List<Integer> hours = gen(hour, i);
            List<Integer> minutes = gen(minute, num - i);
            for(int h : hours) {
                if(h > 11) continue;
                for(int m : minutes) {
                    if(m > 59) continue;
                    result.add(h + ":" + (m < 10 ? "0" : "") + m);
                }
            }
        }
        
        return result;
    }
    
    private List<Integer> gen(int[] nums, int count) {
        List<Integer> res = new ArrayList<>();
        robot(nums, count, 0, 0, res);
        return res;
    }
    
    private void robot(int[] nums, int count, int pos, int out, List<Integer> res) {
        if(count == 0) {
            res.add(out);
            return;
        }
        for(int i = pos; i < nums.length; i++) {
            robot(nums, count - 1, i + 1, out + nums[i], res);
        }
    }
}