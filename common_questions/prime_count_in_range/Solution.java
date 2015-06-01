import java.util.*;

class Solution {
	static int MAXL = (int) 1e6;
	public int primeCounts(long a, long b) {
		boolean[] is_prime = new boolean[MAXL];
		boolean[] is_prime2 = new boolean[MAXL];
		Arrays.fill(is_prime, true);
		Arrays.fill(is_prime2, true);
		for (int i = 2; (long)i * i < b; i++) {
			if (is_prime[i]) {
				for (int j = 2 * i; (long) j * j < b; j += i) {
					is_prime[i] = false;
				}
				for (long j = Math.max(2L, (a + i - 1) / i) * i; j < b; j += i) {
					is_prime2[(int) (j - a)] = false;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < b - a; i++) {
			if (is_prime2[i]) result++;
		}
		return result;
	}
	public static void main(String[] args) {
		Solution s = new Solution();
		long a = 22801763489L, b = 22801787297L;
		System.out.println(s.primeCounts(a, b));
	}
}