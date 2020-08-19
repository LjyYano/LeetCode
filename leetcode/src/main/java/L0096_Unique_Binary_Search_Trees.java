
// https://leetcode-cn.com/problems/unique-binary-search-trees/
class L0096_Unique_Binary_Search_Trees {
    public int numTrees(int n) {
        // 使用 long 型，int 可能溢出
        long ans = 1;
        for (int i = 0; i < n; i++) {
            ans = ans * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) ans;
    }
}