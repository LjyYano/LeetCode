
// https://leetcode-cn.com/problems/robot-bounded-in-circle/
class L1041_Robot_Bounded_In_Circle {
    public int numRookCaptures(char[][] board) {
        int ans = 0;

        // 找到R的位置
        int rx = 0, ry = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                    break;
                }
            }
        }

        // 上下左右分别找

        // 左
        int tx = rx, ty = ry;
        while (tx >= 0) {
            if (board[tx][ty] == 'p') {
                ans++;
                break;
            }
            if (board[tx][ty] == 'B') {
                break;
            }
            tx--;
        }

        // 右
        tx = rx;
        ty = ry;
        while (tx < board[0].length) {
            if (board[tx][ty] == 'p') {
                ans++;
                break;
            }
            if (board[tx][ty] == 'B') {
                break;
            }
            tx++;
        }

        // 上
        tx = rx;
        ty = ry;
        while (ty >= 0) {
            if (board[tx][ty] == 'p') {
                ans++;
                break;
            }
            if (board[tx][ty] == 'B') {
                break;
            }
            ty--;
        }

        // 下
        tx = rx;
        ty = ry;
        while (ty < board.length) {
            if (board[tx][ty] == 'p') {
                ans++;
                break;
            }
            if (board[tx][ty] == 'B') {
                break;
            }
            ty++;
        }

        return ans;
    }
}