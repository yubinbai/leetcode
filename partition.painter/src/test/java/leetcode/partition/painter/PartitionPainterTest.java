package leetcode.partition.painter;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class PartitionPainterTest extends TestCase {
	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		int[] data = { 100, 200, 300, 400, 500, 600, 700, 800, 900 };
		assertEquals(1700, PartitionPainter.shortestTime(data, 3));

		assertEquals(1700, PartitionPainter.shortestTime2(data, 3));
	}
}
