import java.util.Arrays;

// https://leetcode-cn.com/problems/minimum-number-of-refueling-stops/
class L0902_Minimum_Number_of_Refueling_Stops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (stations == null) return -1;

        int[][] tmp = new int[stations.length + 2][2];
        for (int i = 0; i < stations.length; i++) {
            tmp[i + 1][0] = stations[i][0];
            tmp[i + 1][1] = stations[i][1];
        }
        tmp[stations.length + 1][0] = target;
        tmp[stations.length + 1][1] = 0;
        stations = tmp;

        int n = stations.length;
        int[][] dp = new int[n][n];
        for (int[] array : dp) {
            Arrays.fill(array, -1);
        }
        dp[0][0] = startFuel;

        System.out.println(Arrays.deepToString(stations));
        System.out.println(Arrays.deepToString(dp));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                // 加油站不停
                if (i > 0 && dp[i - 1][j] >= stations[i][0] - stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] - (stations[i][0] - stations[i - 1][0]));
                }

                // 加油站停
                if (j > 0 && dp[i - 1][j - 1] >= stations[i][0] - stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] - (stations[i][0] - stations[i - 1][0]) + stations[i][1]);
                }
            }
        }

        for (int i = 0; i < dp.length; i++) {
            if (dp[dp.length - 1][i] >= 0) {
                return i;
            }
        }

        return -1;
    }
}