package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class test { 
 @Test 
 public void testingsubtractionMethod() { 
	// variables initalized 
int num1 = 12;
int num2 = 15;
int num3 = 69;

	//do something with the variables 
int ans = rightClickMe.selectText.subtraction(num1, num2, num3);

	//check if the answer is correct
	assertEquals(-15, ans);  
	} 
}