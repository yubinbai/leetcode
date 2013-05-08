package leetcode.problem.matchStar;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class MatchStarTest extends TestCase {

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(MatchStar.isMatch("aa", "aa"));
		assertFalse(MatchStar.isMatch("aa", "a"));
		assertTrue(MatchStar.isMatch("aa", "a*"));
		assertTrue(MatchStar.isMatch("aab", ".*a*b"));
		assertTrue(MatchStar.isMatch("aab", ".*"));
	}
}
