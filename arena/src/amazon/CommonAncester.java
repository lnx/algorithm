package amazon;

public class CommonAncester {

	public int getCommonAncestor(int id1, int id2) {
		if (id1 < 0 || id2 < 0) {
			return -1;
		}
		if (id1 == id2) {
			return id1;
		}
		int layer1 = getLayer(id1);
		int layer2 = getLayer(id2);
		if (layer1 < layer2) {
			return getCommonAncestor(id2, id1);
		}
		for (int i = 0; i < layer1 - layer2; ++i) {
			id1 = getAncestor(id1);
		}
		while (id1 != id2) {
			id1 = getAncestor(id1);
			id2 = getAncestor(id2);
		}
		return id1;
	}

	int getAncestor(int id) {
		if (id == 0) {
			return -1;
		}
		int layer = getLayer(id);
		int curStart = ((int) Math.pow(3, layer) - 1) / 2;
		int preStart = ((int) Math.pow(3, layer - 1) - 1) / 2;
		int preIndex = (id - curStart) / 3;
		return preStart + (int) Math.pow(3, layer - 1) - 1 - preIndex;
	}

	int getLayer(int id) {
		return (int) (Math.log(2 * id + 1) / Math.log(3));
	}

	public static void main(String[] args) {
		CommonAncester o = new CommonAncester();
		System.out.println(o.getCommonAncestor(13, 15));
		System.out.println(o.getCommonAncestor(16, 10));
		System.out.println(o.getCommonAncestor(13, 9));
	}

}
