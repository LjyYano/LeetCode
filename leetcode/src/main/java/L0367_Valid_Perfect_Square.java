
// https://leetcode-cn.com/problems/valid-perfect-square/
class L0367_Valid_Perfect_Square {
    public boolean isPerfectSquare(int x) {
        int mod = x % 10;
        if(mod == 2 || mod == 3 || mod == 7 || mod == 8) return false;
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return r * r == x;
    }
}