package LeetCode;

import java.util.HashMap;

public class L211_Add_and_Search_Word_Data_structure_design {

	class TrieNode {

		boolean isLeaf;
		char c;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();

		// Initialize your data structure here.
		public TrieNode() {
		}

		public TrieNode(char c) {
			this.c = c;
		}
	}

	public class WordDictionary {

		private TrieNode root;

		public WordDictionary() {
			root = new TrieNode();
		}

		// Adds a word into the data structure.
		public void addWord(String word) {

			HashMap<Character, TrieNode> children = root.children;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				TrieNode t;

				if (children.containsKey(c)) {
					t = children.get(c);
				} else {
					t = new TrieNode(c);
					children.put(c, t);
				}

				children = t.children;
				if (i == word.length() - 1) {
					t.isLeaf = true;
				}
			}

		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return searchNode(word, root);
		}

		private boolean searchNode(String word, TrieNode t) {

			if (t == null) {
				return false;
			}

			if (word.length() == 0) {
				return t.isLeaf;
			}

			HashMap<Character, TrieNode> children = t.children;
			char c = word.charAt(0);

			if (c == '.') {
				for (char key : children.keySet()) {
					if (word.length() == 1 && children.get(key).isLeaf) {
						return true;
					}
					if (searchNode(word.substring(1), children.get(key))) {
						return true;
					}
				}
				return false;
			} else if (!children.containsKey(c)) {
				return false;
			} else {
				return searchNode(word.substring(1), children.get(c));
			}

		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");

}
