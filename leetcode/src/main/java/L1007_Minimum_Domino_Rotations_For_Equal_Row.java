import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/minimum-domino-rotations-for-equal-row/
class L1007_Minimum_Domino_Rotations_For_Equal_Row {
    public int[] numsSameConsecDiff(int N, int diff) {
        if (N == 1) return new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> ans = new ArrayList<>();
        // 第一位不为0
        for (int i = 1; i <= 9; i++) {
            numsDfs(i, diff, N, ans);
        }

        //return ans.stream().mapToInt(p->p).toArray();
        int[] array = new int[ans.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = ans.get(i);
        }
        return array;
    }

    private void numsDfs(int tmp, int diff, int N, List<Integer> ans) {
        if (N == 1) {
            ans.add(tmp);
            return;
        }

        int last = tmp % 10;
        if (diff > 0 && last - diff >= 0) {
            numsDfs(tmp * 10 + (last - diff), diff, N - 1, ans);
        }

        if (last + diff <= 9) {
            numsDfs(tmp * 10 + (last + diff), diff, N - 1, ans);
        }
    }

}