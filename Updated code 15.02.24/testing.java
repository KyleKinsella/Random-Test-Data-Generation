package learningTesting.learningTesting;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

import learningTesting.learningTesting.App.test;


public class testing {
	

	public static int[] random(Method method) {
    	Random rand = new Random();
		int para2 = method.getParameterCount();
		int[] randomParameters = new int[para2];
		
	
		for(int i = 0; i < para2; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;
			//System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;	
		
    }
	
	

	public static Method randomTestData(Method method) {
		
		int[] rand = random(method);
    	
    	for (int i = 0; i < rand.length; i++) {
            System.out.println("Random Generated Test Data " + i + ": " + rand[i]);
        }
		return method;
	}
	
	
	
	
	
    public static void performTest(String methodName, Class<?> returnType) {
        // Your testing logic here
        System.out.println("@Test\npublic void " + methodName + "()" + "{");
        System.out.println("    // My testing logic will go in here");
        System.out.println("}");
    }
	
	

	
    public static void main(String[] args) {
        // Get the class object of the tester class
        Class<tester> testerClass = tester.class;

        // Get all the declared methods of the tester class
        Method[] methods = testerClass.getDeclaredMethods();

        // Loop through the methods and print information
        for (Method method : methods) {
        	
            System.out.println("The randomTestData Method has been called:");
     		randomTestData(method);
            
     		
     		String name = method.getName();
            Class<?> returnType = method.getReturnType();
            int parameterCount = method.getParameterCount();
            
            
            System.out.println("Method Name: " + name);
            System.out.println("Return Type: " + returnType.getName());
            System.out.println("Parameter Count: " + parameterCount);
            System.out.println("\n");
            
  
            performTest(name, returnType);
        }
    }
}
