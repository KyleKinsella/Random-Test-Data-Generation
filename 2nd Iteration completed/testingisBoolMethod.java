package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingisBoolMethod{ 
 @Test 
 public void testingisBool() { 
	// variables initalized 
boolean num1 = true;
boolean num2 = false;
boolean num3 = true;

	//do something with the variables 
boolean ans = rightClickMe.selectText.isBool(num1, num2, num3);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
}