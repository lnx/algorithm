package solutions;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	List<String> fullJustify(String[] words, int wide) {
		List<String> ret = new ArrayList<>();
		List<String> line = new ArrayList<>();
		int tlen = 0;
		for (String word : words) {
			int wlen = word.length();
			if (wlen + tlen + line.size() > wide) {
				ret.add(getWide(line, tlen, wide));
				line.clear();
				tlen = 0;
			}
			line.add(word);
			tlen += wlen;
		}
		ret.add(getLeft(line, wide));
		return ret;
	}

	String getWide(List<String> line, int tlen, int wide) {
		for (int spaces = wide - tlen, i = 0, size = line.size() - 1; spaces > 0 && i < size; --spaces, i = ++i % size) {
			line.set(i, line.get(i) + " ");
		}
		StringBuilder sb = new StringBuilder();
		for (String s : line) {
			sb.append(s);
		}
		String ret = sb.toString();
		int rlen = ret.length();
		return rlen < wide ? ret + repeat(" ", wide - rlen) : ret;
	}

	String getLeft(List<String> line, int wide) {
		for (int i = 0, size = line.size() - 1; i < size; ++i) {
			line.set(i, line.get(i) + " ");
		}
		StringBuilder sb = new StringBuilder();
		for (String s : line) {
			sb.append(s);
		}
		String ret = sb.toString();
		int rlen = ret.length();
		return rlen < wide ? ret + repeat(" ", wide - rlen) : ret;
	}

	String repeat(String s, int times) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < times; ++i) {
			sb.append(s);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] words = { "Listen", "to", "many,", "speak", "to", "a", "few." };
		int l = 6;
		List<String> ret = new TextJustification().fullJustify(words, l);
		for (String s : ret) {
			System.out.println(s);
		}
	}

}
