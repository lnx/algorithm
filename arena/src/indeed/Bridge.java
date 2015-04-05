package indeed;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Bridge {

	static final String YES = "YES", NO = "NO";

	static int N = 0, Q = 0;

	static int[][] map;

	static void build(int a, int b, int day) {
		if (!hasBridge(a, b)) {
			map[a][b] = day;
			map[b][a] = day;
		}
	}

	static void check(int a, int b) {
		if (bfs(a, b)) {
			List<List<Integer>> paths = new ArrayList<>();
			Stack<Integer> stack = new Stack<>();
			stack.push(a);
			dfs(a, b, stack, paths);
			List<Integer> oldest = getOldest(paths);
			System.out.println(String.format("%s %d", YES, map[oldest.get(0)][oldest.get(1)]));
			demolish(oldest.get(0), oldest.get(1));
		} else {
			System.out.println(NO);
		}
	}

	static List<Integer> getOldest(List<List<Integer>> paths) {
		int a = 0, b = 0;
		for (List<Integer> path : paths) {
			int curA = path.get(0), curB = path.get(1);
			for (int i = 1; i < path.size() - 1; ++i) {
				if (map[curA][curB] > map[path.get(i)][path.get(i + 1)]) {
					curA = path.get(i);
					curB = path.get(i + 1);
				}
			}
			if (a == 0 || map[a][b] < map[curA][curB]) {
				a = curA;
				b = curB;
			}
		}
		List<Integer> oldest = new ArrayList<>();
		oldest.add(a);
		oldest.add(b);
		return oldest;
	}

	static boolean bfs(int a, int b) {
		int[] visit = new int[N + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(a);
		visit[a] = 1;
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur == b) {
				return true;
			}
			for (int i = 1; i <= N; ++i) {
				if (hasBridge(cur, i) && visit[i] == 0) {
					queue.offer(i);
					visit[i] = 1;
				}
			}
		}
		return false;
	}

	static void dfs(int a, int b, Stack<Integer> stack, List<List<Integer>> paths) {
		if (stack.peek() == b) {
			paths.add(new ArrayList<>(stack));
		} else {
			for (int i = 1; i <= N; ++i) {
				if (hasBridge(stack.peek(), i) && !stack.contains(i)) {
					stack.push(i);
					dfs(a, b, stack, paths);
					stack.pop();
				}
			}
		}
	}

	static boolean hasBridge(int a, int b) {
		return map[a][b] != 0;
	}

	static void demolish(int a, int b) {
		map[a][b] = 0;
		map[b][a] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Q = sc.nextInt();
		map = new int[N + 1][N + 1];
		for (int day = 1; day <= Q; ++day) {
			String op = sc.next();
			int a = sc.nextInt(), b = sc.nextInt();
			if (op.equals("build")) {
				build(a, b, day);
			} else if (op.equals("check")) {
				check(a, b);
			}
		}
		sc.close();
	}

}
