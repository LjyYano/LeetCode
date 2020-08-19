import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/number-of-squareful-arrays/
class L1038_Number_of_Squareful_Arrays {
    int ansNumSquarefulPerms = 0;

    public int numSquarefulPerms(int[] A) {
        // 找数组的排列组合，剪枝
        Arrays.sort(A);
        numSquarefulPermsDfs(A, new ArrayList<>(), new boolean[A.length]);
        return ansNumSquarefulPerms;
    }

    private void numSquarefulPermsDfs(int[] A, ArrayList<Integer> tmp, boolean[] used) {
        if (tmp.size() == A.length) {
            ansNumSquarefulPerms++;
        } else {
            for(int i = 0; i < A.length; i++){
                if(used[i] || i > 0 && A[i] == A[i-1] && !used[i - 1]) continue;
                if (tmp.size() > 0) {
                    long add = tmp.get(tmp.size() - 1) + A[i];
                    if (!isSquare(add)) {
                        continue;
                    }
                }
                used[i] = true;
                tmp.add(A[i]);
                numSquarefulPermsDfs(A, tmp, used);
                used[i] = false;
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isSquare(long num) {
        return Math.pow((int) Math.sqrt(num), 2) == num;
    }
}