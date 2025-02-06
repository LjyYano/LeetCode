import java.util.List;
import java.util.ArrayList;

// https://leetcode-cn.com/problems/generate-parentheses/
class L0022_Generate_Parentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generateParenthesisHelper(n, n, "", ans);
        return ans;
    }

    private void generateParenthesisHelper(int left, int right, String gen, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(gen);
            return;
        }

        if (left > 0) {
            generateParenthesisHelper(left - 1, right, gen + "(", ans);
        }

        if (right > left) {
            generateParenthesisHelper(left, right - 1, gen + ")", ans);
        }
    }
}