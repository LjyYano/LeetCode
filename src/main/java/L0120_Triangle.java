import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/triangle/
class L0120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int k = triangle.size();
        if(k == 0) return 0;
        List<Integer> pre = triangle.get(0);
        List<Integer> ans = new ArrayList<>();
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> now = triangle.get(i);
            for(int j = 0; j < now.size(); j++) {
                if(j == 0) ans.add(now.get(j) + pre.get(0));
                else if(j == now.size() - 1) ans.add(now.get(j) + pre.get(j - 1));
                else ans.add(now.get(j) + Math.min(pre.get(j), pre.get(j - 1)));
            }
            pre = new ArrayList(ans);
            ans.clear();
        }
        return Collections.min(pre);
    }
}