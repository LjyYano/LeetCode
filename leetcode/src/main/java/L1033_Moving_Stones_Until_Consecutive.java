
// https://leetcode-cn.com/problems/moving-stones-until-consecutive/
class L1033_Moving_Stones_Until_Consecutive {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while (Y > X) {
            ans++;
            if (Y % 2 == 1)
                Y++;
            else
                Y /= 2;
        }

        return ans + X - Y;
    }
}