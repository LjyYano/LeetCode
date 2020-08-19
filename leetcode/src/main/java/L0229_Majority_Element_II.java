import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/majority-element-ii/
class L0229_Majority_Element_II {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null || nums.length == 0) return ans;
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;
        
        for(int v : nums) {
            if(v == n1) c1++;
            else if(v == n2) c2++;
            else if(c1 == 0) {
                c1 = 1;
                n1 = v;
            }
            else if(c2 == 0) {
                c2 = 1;
                n2 = v;
            }
            else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0; c2 = 0;
        
        for(int v : nums) {
            if(v == n1) c1++;
            else if(v == n2) c2++;
        }
        
        if(c1 > nums.length / 3) ans.add(n1);
        if(c2 > nums.length / 3) ans.add(n2);
        
        return ans;
    }
}