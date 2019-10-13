public class L0096_Unique_Binary_Search_Trees {

    public int numTrees(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 1;
        ans[1] = 1;
        // f(n) = f(0)*f(n-1) + f(1)*f(n-2) + ……
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                ans[i] += ans[j - 1] * ans[i - j];
            }
        }
        return ans[n];
    }

    // 利用卡特兰数公式，空间复杂度O(1)，时间复杂度O(N)
    public int numTrees2(int n) {
        // 使用 long 型，int 可能溢出
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) ans;
    }

}
