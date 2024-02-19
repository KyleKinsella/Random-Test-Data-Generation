package learningTesting.learningTesting;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;

import learningTesting.learningTesting.App.test;


public class testing {
	
	
	public static String getFileName(String args[]) {
		// Check if a file path is provided as a command-line argument
        if (args.length == 0) {
            String programName = System.getProperty("sun.java.command").split(" ")[0];
            System.out.println("You are currently working in: " + programName);
            return programName;
        }

        // Get the file path from the command-line arguments
        String filePath = args[0];

        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Or you can process the line as needed
            }

            // Close the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
		return filePath;
	}
	
	
	
	
	

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
	
	
	
	
    public static void main(String[] args) throws ClassNotFoundException {
    	
    	String className = getFileName(args);    	
    	Class<?> testerClass = Class.forName(className);


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
        }
    }
}
