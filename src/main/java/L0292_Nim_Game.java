
// https://leetcode-cn.com/problems/nim-game/
public class L0292_Nim_Game {
    public boolean canWinNim(int n) {
        return !(n % 4 == 0);
    }
}