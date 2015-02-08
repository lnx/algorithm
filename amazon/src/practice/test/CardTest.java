package practice.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import practice.Card;

public class CardTest {

	@Test
	public void testCompare() {
		Card o = new Card();
		assertEquals(-2, o.compare("3,3,6,7", "3,3,3,4"));
		assertEquals(-1, o.compare("6,3,4,5", "7,7,7,7"));
		assertEquals(0, o.compare("6,3,4,5", "3,4,5,6"));
		assertEquals(1, o.compare("3,3,4,4", "6,6,2,3"));
	}

}
