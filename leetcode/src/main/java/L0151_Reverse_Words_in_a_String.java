import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class L0151_Reverse_Words_in_a_String {

	public String reverseWords(String s) {

		List<String> words = Arrays.asList(s.trim().split(" +"));

		Collections.reverse(words);

		return String.join(" ", words);
	}

}
