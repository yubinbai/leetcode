package leetcode.combination;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class CombinationTest extends TestCase {
	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Combination c = new Combination();

		assertEquals(10, c.countCombinations(5, 2));
		
		assertEquals(6, c.countCombinations(4, 2));
	}
}
