package others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Outline {

	static class Building {

		int x1;
		int x2;
		int height;

		Building(int x1, int x2, int height) {
			this.x1 = x1;
			this.x2 = x2;
			this.height = height;
		}

	}

	static class Wall {

		int x;
		int height;
		boolean start;

		Wall(int x, int height, boolean start) {
			this.x = x;
			this.height = height;
			this.start = start;
		}

	}

	static class Point {

		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return String.format("(%d, %d)", x, y);
		}

	}

	List<Point> genOutline(List<Building> buildings) {
		List<Point> ret = new ArrayList<>();
		Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		queue.offer(0);
		List<Wall> walls = genWalls(buildings);
		for (int i = 0; i < walls.size(); ++i) {
			Wall wall = walls.get(i);
			int oldPeek = queue.peek();
			if (wall.start) {
				queue.offer(wall.height);
				while (i + 1 < walls.size() && walls.get(i + 1).start && walls.get(i + 1).x == wall.x) {
					queue.offer(walls.get(++i).height);
				}
				if (queue.peek() > oldPeek) {
					ret.add(new Point(wall.x, oldPeek));
					ret.add(new Point(wall.x, queue.peek()));
				}
			} else {
				queue.remove(wall.height);
				while (i + 1 < walls.size() && !walls.get(i + 1).start && walls.get(i + 1).x == wall.x) {
					queue.remove(walls.get(++i).height);
				}
				if (oldPeek > queue.peek()) {
					ret.add(new Point(wall.x, oldPeek));
					ret.add(new Point(wall.x, queue.peek()));
				}
			}
		}
		return ret;
	}

	List<Wall> genWalls(List<Building> buildings) {
		List<Wall> walls = new ArrayList<>();
		for (Building building : buildings) {
			walls.add(new Wall(building.x1, building.height, true));
			walls.add(new Wall(building.x2, building.height, false));
		}
		Collections.sort(walls, new Comparator<Wall>() {
			public int compare(Wall w1, Wall w2) {
				if (w1.x == w2.x) {
					if (w1.start == w2.start) {
						return 0;
					} else {
						return w1.start ? -1 : 1;
					}
				} else {
					return w1.x - w2.x;
				}
			}
		});
		return walls;
	}

	public static void main(String[] args) {
		List<Building> buildings = new ArrayList<>();
		buildings.add(new Building(1, 4, 3));
		buildings.add(new Building(2, 5, 4));
		buildings.add(new Building(6, 7, 1));
		buildings.add(new Building(8, 15, 4));
		buildings.add(new Building(8, 11, 5));
		buildings.add(new Building(9, 12, 3));
		buildings.add(new Building(13, 16, 5));
		System.out.println(new Outline().genOutline(buildings));
	}

}
