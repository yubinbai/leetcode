package leetcode.subset;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class SubsetTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		Subset s = new Subset();

		int[] data = { 1, 2, 3, 4, 5 };
		assertEquals((int) Math.pow(2, data.length), s.countSubsets(data));
	}
}
