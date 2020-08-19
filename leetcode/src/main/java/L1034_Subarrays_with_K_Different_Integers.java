import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/subarrays-with-k-different-integers/
class L1034_Subarrays_with_K_Different_Integers {
public int subarraysWithKDistinct(int[] A, int K) {
        int N = A.length;
        if (N == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        int start = 0, end = 0;
        int res = 0;
        while (end < N) {
			//add next element if it's not already in the set
            int endEl = A[end];
            if (!set.contains(endEl))
                set.add(endEl);
			
            int size = set.size();
            //if we over the K - need to reset set and increase start pointer
			if (size > K) {
                set.clear();
                start++;
                end = start;
            } else if (size == K) {
				//if we reach K unique elements - increment res by 1 
                res++;
                end++;
                if (end == N) {
                    set.clear();
                    start++;
                    end = start;
                }
            } else
				//default - increment end pointer
                end++;
        }
        return res;
    }
}