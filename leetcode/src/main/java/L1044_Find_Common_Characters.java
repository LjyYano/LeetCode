import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/find-common-characters/
class L1044_Find_Common_Characters {
    public List<String> commonChars(String[] A) {
        int[][] counts = new int[A.length][26];
        for (int i = 0; i < A.length; i++) {
            String s = A[i];
            for (Character c : s.toCharArray()) {
                counts[i][c - 'a']++;
            }
        }

        List<String> ans = new ArrayList<>();

        // 找到counts中，所有位相同且不为0的部分
        for (int i = 0; i < 26; i++) {
            int init = counts[0][i];
            boolean same = true;
            if (init == 0) {
                continue;
            }
            for (int j = 1; j < counts.length; j++) {
                init = Math.min(init, counts[j][i]);
                if (init == 0) {
                    same = false;
                    break;
                }
            }
            if (same) {
                for (int j = 0; j < init; j++) {
                    ans.add((char) (i + 'a') + "");
                }
            }
        }

        return ans;
    }
}