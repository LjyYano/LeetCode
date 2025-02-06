import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/subsets-ii/
class L0090_Subsets_II {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> tmp = new ArrayList<>();
        subsetsDfsWithDup(0, ans, tmp, nums);
        return new ArrayList<>(ans);
    }

    private void subsetsDfsWithDup(int start, Set<List<Integer>> ans, List<Integer> tmp, int[] nums) {
        if (start == nums.length) {
            ans.add(new ArrayList<>(tmp));
            return;
        }

        tmp.add(nums[start]);
        subsetsDfsWithDup(start + 1, ans, tmp, nums);
        tmp.remove(tmp.size() - 1);
        subsetsDfsWithDup(start + 1, ans, tmp, nums);
    }
}