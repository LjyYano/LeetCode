import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/combinations/
public class L0077_Combinations {
    
    public void robot(int idx, int n, int k, boolean[] visit, List<Integer> tmp, List<List<Integer>> ans) {
        if(idx >= k) {
            ans.add(new ArrayList(tmp));
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(visit[i] == false) {
                if(tmp.size() != 0 && tmp.get(tmp.size() - 1) > i) continue;
                tmp.add(i);
                visit[i] = true;
                robot(idx + 1, n, k, visit, tmp, ans);
                visit[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        boolean[] visit = new boolean[n + 1];
        robot(0, n, k, visit, tmp, ans);
        return ans;
    }
}