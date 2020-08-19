import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/pascals-triangle/
class L0118_Pascal's_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows <= 0) return ans;
        int count = 0;
        while(count < numRows) {
            List<Integer> last = count > 0 ? ans.get(count - 1) : new ArrayList<>();
            List<Integer> tmp = new ArrayList();
            for(int i = 0; i <= count; i++) {
                if(i == 0 || i == count) tmp.add(1);
                else tmp.add(last.get(i - 1) + last.get(i));
            }
            ans.add(tmp);
            count++;
        }
        return ans;
    }
}