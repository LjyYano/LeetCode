import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
public class WordDictionary {
    Set<String> dict = new HashSet<String>();
    // Adds a word into the data structure.
    public void addWord(String word) {
        dict.add(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        if(dict.contains(word) ) return true;
        else if(!word.contains(".")) return false;
        
        for(int c='a'; c<='z'; c++) {
            int i=0;
            while(word.charAt(i++) != '.'){}
            StringBuilder sb = new StringBuilder(word);
            sb.setCharAt(i-1, (char)c);
            if( search(sb.toString()) ) return true;
        }
        return false;
    }
}
