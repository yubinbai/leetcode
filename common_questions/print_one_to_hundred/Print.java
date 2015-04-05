class Print {
	/**
	 * print 1..10 without using loop and conditional stmts
	 * @param
	 * @return
	 */
	public int print(int a) {
		int b = (a == 1) ? 0 : print(a - 1);
		System.out.println(a);
		return 0;
	}
	public static void main(String[] args) {
		Print p = new Print();
		p.print(10);
	}
}