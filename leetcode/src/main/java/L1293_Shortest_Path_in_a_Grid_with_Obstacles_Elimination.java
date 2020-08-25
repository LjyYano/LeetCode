
// https://leetcode-cn.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/
class L1293_Shortest_Path_in_a_Grid_with_Obstacles_Elimination {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int n : arr) {
            if (n % 2 == 0) {
                count = 0;
            } else {
                count++;
                if (count >= 3) {
                    return true;
                }
            }
        }
        return false;
    }
}