import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/pascals-triangle-ii/
class L0119_Pascal's_Triangle_II {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> tmp = new ArrayList<>();
        if(rowIndex < 0) return tmp;
        
        List<Integer> pre = new ArrayList<>();        
        int k = 0;
        while(k <= rowIndex) {
            for(int i = 0; i <= k; i++) {
                if(i == 0 || i == k) tmp.add(1);
                else tmp.add(pre.get(i - 1) + pre.get(i));
            }
            pre = new ArrayList(tmp);
            tmp.clear();
            k++;
        }
            
        return pre;
    }
}