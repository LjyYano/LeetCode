import java.util.Arrays;
import java.util.List;

// https://leetcode-cn.com/problems/reverse-words-in-a-string/
public class L0151_Reverse_Words_in_a_String {
    public String reverseWords(String s) {
        
    	List<String> words = Arrays.asList(s.trim().split(" +"));
    	
    	Collections.reverse(words);
    	
    	return String.join(" ", words);
    
        
    }
}