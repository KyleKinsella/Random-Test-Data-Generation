package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingAdditionMethod{ 
 @Test 
 public void testingAddition() { 
	// variables initalized 
int num1 = 15;
int num2 = 36;

	//do something with the variables 
int ans = rightClickMe.selectText.Addition(num1, num2);

	//check if the answer is correct
	assertEquals(51, ans);  
	} 
 
 @Test 
 public void testingAddition1() { 
	// variables initalized 
int num1 = 57;
int num2 = 88;

	//do something with the variables 
int ans = rightClickMe.selectText.Addition(num1, num2);

	//check if the answer is correct
	assertEquals(55, ans);  
	} 
 
 @Test 
 public void testingAddition2() { 
	// variables initalized 
int num1 = 54;
int num2 = 64;

	//do something with the variables 
int ans = rightClickMe.selectText.Addition(num1, num2);

	//check if the answer is correct
	assertEquals(54, ans);  
	} 
 
 @Test 
 public void testingAddition3() { 
	// variables initalized 
int num1 = 74;
int num2 = 43;

	//do something with the variables 
int ans = rightClickMe.selectText.Addition(num1, num2);

	//check if the answer is correct
	assertEquals(86, ans);  
	} 
 
 @Test 
 public void testingAddition4() { 
	// variables initalized 
int num1 = 72;
int num2 = 41;

	//do something with the variables 
int ans = rightClickMe.selectText.Addition(num1, num2);

	//check if the answer is correct
	assertEquals(84, ans);  
	} 
}