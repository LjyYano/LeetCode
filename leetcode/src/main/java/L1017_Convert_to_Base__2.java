
// https://leetcode-cn.com/problems/convert-to-base-2/
class L1017_Convert_to_Base__2 {
    public int oddEvenJumps(int[] A) {
        int ans = 1;

        for (int i = 0; i < A.length; i++) {
            // 从每个索引分别开始

            int j = -1;
            int jump = 1;
            while (j != A.length - 1) {
                int tmp = 0;
                int tmpI = j == -1 ? i : j;

                // 奇数跳
                if (jump % 2 == 1) {
                    // 找比A[i]大的最小的索引
                    tmp = Integer.MAX_VALUE;
                    int c = -1;
                    for (int k = tmpI + 1; k < A.length; k++) {
                        if (A[tmpI] <= A[k]) {
                            if (tmp > A[k]) {
                                j = k;
                                c = k;
                                tmp = A[k];
                            }
                        }
                    }
                    if (c == -1) {
                        break;
                    }
                } else {
                    // 偶数跳
                    tmp = Integer.MIN_VALUE;
                    int c = -1;
                    // A[j] <= A[i]，A[j] 要最大，如果多个，取最小的j
                    for (int k = tmpI + 1; k < A.length; k++) {
                        if (A[tmpI] >= A[k]) {
                            if (tmp < A[k]) {
                                tmp = A[k];
                                c = k;
                                j = k;
                            }
                        }
                    }
                    if (c == -1) {
                        break;
                    }
                }

                jump++;

                if (j >= A.length - 1) {
                    ans++;
                    break;
                } else if (j == -1) {
                    break;
                }
            }
        }

        return ans;
    }
}