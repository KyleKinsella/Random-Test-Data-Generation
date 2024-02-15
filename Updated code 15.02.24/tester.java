package learningTesting.learningTesting;

public class tester {
	
	
	public static int add(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}


	public static int sub(int num1, int num2) {
		return num1 - num2;
	}


	public static int mul(int num1, int num2) {
		return num1 * num2;
	}


	public static int div(int num1, int num2) throws ArithmeticException {
		
		if(num1 / num2 == 0) {
			try {
				System.out.println("Cannot Divide by Zero");
			}
			catch(ArithmeticException e) {
				e.printStackTrace();
			}
		}
		
		return num1 / num2;
	}
}
