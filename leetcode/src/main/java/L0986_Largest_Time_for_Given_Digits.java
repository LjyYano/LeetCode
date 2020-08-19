
// https://leetcode-cn.com/problems/largest-time-for-given-digits/
class L0986_Largest_Time_for_Given_Digits {
    public String largestTimeFromDigits(int[] A) {
        int[] ans = new int[]{-1};
        timeDfs(A, ans, 0, 0, new boolean[A.length]);
        if (ans[0] == -1) {
            return "";
        }
        return getRes(ans[0]);
    }

    private String getRes(int time) {
        int hour = time / 100;
        int minute = time % 100;
        return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
    }

    private void timeDfs(int[] A, int[] ans, int num, int count, boolean[] used) {
        if (count == A.length) {
            ans[0] = Math.max(ans[0], num);
            return;
        }

        for (int i = 0; i < A.length; i++) {
            if (!used[i]) {
                int cal = num * 10 + A[i];
                if (count == 1 && (cal < 0 || cal >= 24)) {
                    continue;
                }
                if (count == 3 && (cal % 100 < 0 || cal % 100 >= 60)) {
                    continue;
                }
                used[i] = true;
                timeDfs(A, ans, cal, count + 1, used);
                used[i] = false;
            }
        }
    }
}