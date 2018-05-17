package com.recursion;

public class RecursionTest {

	int COUNT = 0;
	int POS = 0;

	public static void main(String[] args) {
		// System.out.println(fun(99));
		RecursionTest test = new RecursionTest();
		System.out.println(test.summation(11));
		/*System.out.println(test.funTrace(50));*/
	}

	static int fun(int n) {
		System.out.println("Entering f(n)=f(" + n + ")");
		if (n > 100) {
			// System.out.println(" Endpoint=" + (n-10));
			if ((n - 10) >= 100)
				System.out.println("  return fun(fun(n+11)) = fun(" + (n - 10)
						+ ")");

			return n - 10;
		}
		System.out
				.println("return fun(fun(n+11)) = fun(fun(" + (n + 11) + "))");
		return fun(fun(n + 11));
	}

	int funTrace(int n) {

		if (n > 100) {
			printSpace();
			POS--;
			System.out.println(" funTrace(" + n + ") = return "
					+ (n - 10));
			return n - 10;
		}
		COUNT++;
		printSpace();
		POS++;POS++;
		System.out.println(" funTrace(" + n + ") = funTrace(funTrace("
				+ (n + 11) + "))");
		return funTrace(funTrace(n + 11));
	}

	int summation(int n) {
		if (n <= 1) {
			printSpace();
			System.out.println("summation(" + n + ")=return " + n);
			return n;
		} else {
			COUNT++;
			printSpace();
			System.out.println("summation(" + n + ")=return " + n
					+ "+ summation(" + (n - 1) + ")");
			return n + summation(n - 1);
		}
		
	}

	void printSpace() {
		for (int i = 1; i <= COUNT; i++) {
			System.out.print("   ");
		}
	}

}
