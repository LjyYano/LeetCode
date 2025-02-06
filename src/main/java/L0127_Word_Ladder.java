import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/word-ladder/
class L0127_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visitSet = new HashSet<>();
        Deque<String> deque = new LinkedList<>();
        deque.addLast(beginWord);
        int curLevelLeft = 1;
        int count = 2;
        while (!deque.isEmpty()) {
            List<String> children = findChildren(deque.remove(), wordList, visitSet);
            for (String child : children) {
                if (child.equals(endWord)) {
                    return count;
                }
                deque.addLast(child);
            }
            visitSet.addAll(children);
            curLevelLeft--;
            if (curLevelLeft == 0) {
                curLevelLeft = deque.size();
                count++;
            }
        }
        return 0;
    }

    private List<String> findChildren(String source, List<String> wordList, Set<String> visitSet) {
        List<String> ans = new ArrayList<>();
        for (String word : wordList) {
            if (visitSet.contains(word)) {
                continue;
            }
            if (count(source, word) == 1) {
                ans.add(word);
            }
        }
        wordList.removeAll(ans);
        return ans;
    }

    private int count(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return 0;
        }

        int ans = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ans++;
            }
            if (ans > 1) {
                return 0;
            }
        }
        return ans;
    }
}