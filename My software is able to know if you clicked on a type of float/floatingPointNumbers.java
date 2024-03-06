package rightClickMe;

import java.lang.reflect.Method;
import java.util.Random;


public class floatingPointNumbers {
	
    public static float sumOfRandomValues;	

	
	/// this method will generate a random number depending on how many parametere's there is for the selected method that you chose.
		public static float[] random(Method method) {
	    	Random rand = new Random();
			int para2 = method.getParameterCount();
			float[] randomParameters = new float[para2];
			
			// variable to store the sum of the random values added together
			sumOfRandomValues = 0;
			
		
			for(int i = 0; i < para2; i++) {
				float min = 0;
				float max = 120;
				
				randomParameters[i] = rand.nextFloat(max - min + 1) + min;	
				System.out.println("Number " + i + ": " +  randomParameters[i] + " ");	
				
				sumOfRandomValues = addRandomValues(randomParameters);
			}
		     
		    System.out.println("Sum of random values: " + sumOfRandomValues);    
		        
		    return randomParameters;		
		}
		
		
		

		public static String randomTestData(Method method) {
		    float[] rand = random(method);
		    StringBuilder sb = new StringBuilder();

		    for (int i = 0; i < rand.length; i++) {
		        sb.append(rand[i]);
		        if (i < rand.length - 1) {
		            sb.append(", ");
		        }
		    }
		    return sb.toString();
		}
		

		
		
		public static float addRandomValues(float[] randomValues) {
		    float sum = 0;
		    for (float value : randomValues) {
		        sum += value;
		    }
		    return sum;
		}
		
		
		
		
		public static float add(float num1, float num2) {
	        return num1 + num2;
	    }
		
		
		
		public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		
			Method method = floatingPointNumbers.class.getDeclaredMethod("add", float.class, float.class);			
			randomTestData(method);

		}
}
