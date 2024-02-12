package learningTesting.learningTesting;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class App {


	public interface test {
	    void performOperation(String a, Class<?> b, int c);
	}
	
	
	
	///////////////////////////////////////////
	
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	
	public static int sub(int num1, int num2) {
		return num1 - num2;
	}
	
	
	public static int mul(int num1, int num2) {
		return num1 * num2;
	}
	
	
	public static int div(int num1, int num2) {
		return num1 / num2;
	}
	
	///////////////////////////////////////////
	
	
    public static void main( String[] args ) throws NoSuchMethodException, IOException {
    	
    	
    	System.out.println("Enter a number between 1 and 4");
    	
    	Scanner scan = new Scanner(System.in);
    	int val = scan.nextInt();
    	
    	String m = "";
    	
    	switch (val) {
    	
    	case 1:
	    	m = "add";
	    	break;
	    	
    	case 2:
	    	m = "sub";
	    	break;
	    	
    	case 3:
	    	m = "mul";
	    	break;
	    	
    	case 4:
	    	m = "div";
	    	break;
    	}
    	
    	if(val > 4) {
    		System.out.println("An Error has Occured.");
    	}
    	
    	scan.close();
    	
    	Method method = getMethod(App.class, m);
    	System.out.println("Method: " + method.toString());
    	
    	
    	
        String name = method.getName();
		Class <?> type = method.getReturnType();
		int para = method.getParameterCount();

		
		
		test k = new test() {
			@Override
			public void performOperation(String name, Class<?> type, int para) {
				
				System.out.println("Name: " + name);
				System.out.println("Type: " + type);
				System.out.println("Para: " + para);
				
			}
		};

		
		k.performOperation(name, type, para);
		
		
		int[] randomNumbers = random(method);
	    System.out.println("Random numbers generated: " + Arrays.toString(randomNumbers));
		}	   
    
    
    public static int[] random(Method method) {
    	Random rand = new Random();
		int para2 = method.getParameterCount();
		int[] randomParameters = new int[para2];
		
	
		for(int i = 0; i < para2; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;
		
    }
    
    
    
    
	public static Method getMethod(Class<?> clazz, String methodName) throws NoSuchMethodException {
        // Get all methods declared in the class
        Method[] methods = clazz.getDeclaredMethods();

        // Iterate through each method to find the one with the specified name
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                // Found the method, return it
                return method;
            }
        }

        // If the method with the specified name is not found, throw NoSuchMethodException
        throw new NoSuchMethodException("Method " + methodName + " not found in class " + clazz.getName());
    }
}
            