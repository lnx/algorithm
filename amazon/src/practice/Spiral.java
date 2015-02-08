package practice;

public class Spiral {

	void print(int size) {
		if (size < 1 || size % 2 == 0) {
			return;
		}
		int[][] matrix = genSpiralMatrix(size);
		for (int i = 0; i < size; ++i) {
			System.out.print(matrix[i][0]);
			for (int j = 1; j < size; ++j) {
				System.out.printf("*%d", matrix[i][j]);
			}
			System.out.println();
		}
	}

	int[][] genSpiralMatrix(int size) {
		int[][] matrix = new int[size][size];
		int x = size / 2, y = x, num = 1;
		matrix[x][y++] = num++;
		for (int level = 1; level <= size / 2; ++level) {
			int steps = level * 2;
			for (int i = 0; i < steps; ++i) {
				matrix[x++][y] = num++;
			}
			--x;
			--y;
			for (int i = 0; i < steps; ++i) {
				matrix[x][y--] = num++;
			}
			++y;
			--x;
			for (int i = 0; i < steps; ++i) {
				matrix[x--][y] = num++;
			}
			++x;
			++y;
			for (int i = 0; i < steps; ++i) {
				matrix[x][y++] = num++;
			}
		}
		return matrix;
	}

	public static void main(String[] args) {
		new Spiral().print(3);
	}

}
