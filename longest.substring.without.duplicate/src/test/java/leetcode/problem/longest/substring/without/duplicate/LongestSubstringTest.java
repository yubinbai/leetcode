package leetcode.problem.longest.substring.without.duplicate;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class LongestSubstringTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertEquals(3, LongestSub.longest("abcabcbb"));
		assertEquals(1, LongestSub.longest("bbbbb"));
	}
}
