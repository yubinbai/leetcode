package leetcode.minWindow.allElements;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class MinWindowTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertEquals("BANC", MinWindow.getWindow("ADOBECODEBANC", "ABC"));
	}
}
