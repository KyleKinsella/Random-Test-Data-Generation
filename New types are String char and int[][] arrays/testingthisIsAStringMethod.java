package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingthisIsAStringMethod{ 
 @Test 
 public void testingthisIsAString() { 
	// variables initalized 
String num1 = "f6";
String num2 = "WA";

	//do something with the variables 
String ans = rightClickMe.selectText.thisIsAString(num1, num2);

	//check if the answer is correct
	assertEquals("f6 WA", ans);  
	} 
}