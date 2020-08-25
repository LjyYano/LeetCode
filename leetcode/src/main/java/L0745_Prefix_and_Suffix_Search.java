
// https://leetcode-cn.com/problems/prefix-and-suffix-search/
class L0745_Prefix_and_Suffix_Search {
    public char nextGreatestLetter(char[] letters, char target) {
		int index = 0;
		for (int i = 0; i < letters.length; i++) {
			if (letters[i] > target) {
				index = i;
				break;
			}
		}
		return letters[index];
	
    }
}