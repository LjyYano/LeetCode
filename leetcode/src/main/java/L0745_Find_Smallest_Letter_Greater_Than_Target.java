
// https://leetcode-cn.com/problems/find-smallest-letter-greater-than-target/
class L0745_Find_Smallest_Letter_Greater_Than_Target {
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