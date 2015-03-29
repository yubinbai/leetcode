public class Replace {
	public String replace(String orig, String find, String repl) {

		StringBuilder sb = new StringBuilder();
		int prev = 0, curr = 0;
		while (curr < orig.length() && curr >= 0) {
			curr = orig.indexOf(find, prev);
			// System.out.format("%d %d\n", prev + find.length(), curr);
			if (curr < 0) {
				sb.append(orig.substring(prev, orig.length()));
				break;
			} else {
				sb.append(orig.substring(prev, curr));
				sb.append(repl);
				prev = curr + find.length();
			}
			// System.out.println(sb);
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Replace r = new Replace();
		System.out.println(r.replace("aaaabbb", "b", "c"));
	}
}
