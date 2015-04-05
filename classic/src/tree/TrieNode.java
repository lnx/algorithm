package tree;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	static final int ALPHABET_SIZE = 26;

	char val;
	boolean isWord;
	TrieNode[] children;

	TrieNode(char ch, boolean isWrd) {
		val = ch;
		isWord = isWrd;
		children = new TrieNode[ALPHABET_SIZE];
	}

	void add(String word) {
		if (word != null && word.length() > 0) {
			word = word.toLowerCase();
			int pos = word.charAt(0) - 'a';
			if (children[pos] == null) {
				children[pos] = new TrieNode(word.charAt(0), word.length() == 1);
			}
			children[pos].add(word.substring(1));
		}
	}

	boolean isPrefix(String prefix) {
		if (prefix == null) {
			return false;
		}
		if (prefix.length() == 0) {
			return true;
		}
		prefix = prefix.toLowerCase();
		int pos = prefix.charAt(0) - 'a';
		return children[pos] != null && children[pos].isPrefix(prefix.substring(1));
	}

	boolean contains(String word) {
		if (word == null) {
			return false;
		}
		if (word.length() == 0) {
			return isWord;
		}
		word = word.toLowerCase();
		int pos = word.charAt(0) - 'a';
		return children[pos] != null && children[pos].contains(word.substring(1));
	}

	List<String> getWords(String prefix) {
		List<String> ret = new ArrayList<>();
		if (prefix != null) {
			prefix = prefix.toLowerCase();
			TrieNode cur = this;
			for (int i = 0, len = prefix.length(); i < len && cur != null; ++i) {
				cur = cur.children[prefix.charAt(i) - 'a'];
			}
			if (cur != null) {
				List<String> list = cur.getWords();
				for (String s : list) {
					ret.add(prefix + s.substring(1));
				}
			}
		}
		return ret;
	}

	List<String> getWords() {
		List<String> ret = new ArrayList<>();
		if (isWord) {
			ret.add(String.valueOf(val));
		}
		for (TrieNode node : children) {
			if (node != null) {
				List<String> list = node.getWords();
				for (String s : list) {
					ret.add(val + s);
				}
			}
		}
		return ret;
	}

	public String toString() {
		return String.valueOf(val);
	}

	public static void main(String[] args) {
		TrieNode root = new TrieNode('#', false);
		root.add("b");
		root.add("abc");
		root.add("bcd");
		root.add("abcd");
		root.add("efg");
		root.add("hii");
		System.out.println(root.getWords("b"));
		System.out.println(root.getWords("bc"));
		System.out.println(root.getWords("ab"));
		System.out.println(root.getWords("abc"));
	}

}
