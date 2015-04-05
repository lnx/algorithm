package indeed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Balls {

	static int[] balls = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };

	static void operate(List<List<Integer>> abList) {
		for (List<Integer> ab : abList) {
			swap(ab.get(0), ab.get(1));
		}
	}

	static void swap(int i, int j) {
		int t = balls[i];
		balls[i] = balls[j];
		balls[j] = t;
	}

	static int getCycleSize(List<List<Integer>> abList) {
		int cycleSize = 0;
		do {
			++cycleSize;
			operate(abList);
		} while (!restored());
		return cycleSize;
	}

	static boolean restored() {
		for (int i = 1; i <= 8; ++i) {
			if (balls[i] != i) {
				return false;
			}
		}
		return true;
	}

	static void printBalls() {
		for (int i = 1; i <= 8; ++i) {
			System.out.print(balls[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k = sc.nextInt();
		
		List<List<Integer>> abList = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			List<Integer> ab = new ArrayList<>();
			ab.add(sc.nextInt());
			ab.add(sc.nextInt());
			abList.add(ab);
		}
		
		int cycleSize = getCycleSize(abList);
		k %= cycleSize;
		for (int i = 0; i < k; ++i) {
			operate(abList);
		}
		printBalls();
		
		sc.close();
	}

}
