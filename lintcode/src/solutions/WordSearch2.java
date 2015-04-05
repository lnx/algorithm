package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WordSearch2 {

	ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
		ArrayList<String> ret = new ArrayList<>();
		for (String word : words) {
			word = word.toLowerCase();
			if (exist(board, word)) {
				ret.add(word);
			}
		}
		Collections.sort(ret);
		return ret;
	}

	boolean exist(char[][] board, String word) {
		int rows = board.length, cols = rows > 0 ? board[0].length : 0;
		boolean[][] visit = new boolean[rows][cols];
		for (int i = 0; i < rows; ++i) {
			for (int j = 0; j < cols; ++j) {
				if (exist(board, visit, word, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean exist(char[][] board, boolean[][] visit, String word, int i, int j) {
		if (word.length() == 0) {
			return true;
		}
		boolean ret = false;
		int rows = board.length, cols = rows > 0 ? board[0].length : 0;
		if (i >= 0 && i < rows && j >= 0 && j < cols && !visit[i][j] && board[i][j] == word.charAt(0)) {
			visit[i][j] = true;
			String sub = word.substring(1);
			ret = exist(board, visit, sub, i - 1, j) || exist(board, visit, sub, i, j + 1) || exist(board, visit, sub, i + 1, j) || exist(board, visit, sub, i, j - 1);
			visit[i][j] = false;
		}
		return ret;
	}

	public static void main(String[] args) {
		char[][] board = { "doaf".toCharArray(), "agai".toCharArray(), "dcan".toCharArray() };
		String[] array = { "dog", "dad", "dgdg", "can", "again" };
		ArrayList<String> words = new ArrayList<>(Arrays.asList(array));
		System.out.println(new WordSearch2().wordSearchII(board, words));
	}

}
