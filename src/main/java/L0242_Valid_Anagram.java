import java.util.HashMap;
import java.util.Map;

// https://leetcode-cn.com/problems/valid-anagram/
class L0242_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            if (!map.containsKey(t.charAt(i))) {
                return false;
            }
            int old = map.get(t.charAt(i));
            if (old == 0) {
                return false;
            }
            map.put(t.charAt(i), old - 1);
        }

        return true;
    }
}