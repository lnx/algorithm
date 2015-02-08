package practice.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import practice.CommonAncester;

public class CommonAncesterTest {

	@Test
	public void testGetCommonAncester() {
		CommonAncester o = new CommonAncester();
		assertEquals(12, o.getCommonAncestor(13, 15));
		assertEquals(1, o.getCommonAncestor(16, 10));
		assertEquals(0, o.getCommonAncestor(13, 9));
		assertEquals(0, o.getCommonAncestor(0, 1));
		assertEquals(4, o.getCommonAncestor(4, 4));
		assertEquals(3, o.getCommonAncestor(3, 6));
	}

}
