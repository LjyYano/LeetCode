package LeetCode;

import java.util.HashMap;

public class L208_Implement_Trie {

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

	public class Trie {

		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {

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

		// Returns if the word is in the trie.
		public boolean search(String word) {

			HashMap<Character, TrieNode> children = root.children;

			for (int i = 0; i < word.length(); i++) {

				char c = word.charAt(i);
				if (!children.containsKey(c)) {
					return false;
				}

				if (i == word.length() - 1) {
					if (children.get(c).isLeaf == true) {
						return true;
					}
					return false;
				}

				children = children.get(c).children;
			}

			// useless
			return false;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			HashMap<Character, TrieNode> children = root.children;

			for (int i = 0; i < prefix.length(); i++) {

				char c = prefix.charAt(i);
				if (!children.containsKey(c)) {
					return false;
				}

				if (i == prefix.length() - 1) {
					return true;
				}

				children = children.get(c).children;
			}

			// useless
			return false;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
