package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingthisIsACharMethod{ 
 @Test 
 public void testingthisIsAChar() { 
	// variables initalized 
char num1 = 'h';

	//do something with the variables 
char ans = rightClickMe.selectText.thisIsAChar(num1);

	//check if the answer is correct
	assertEquals('h', ans);  
	} 
 @Test 
 public void testingthisIsAChar1() { 
	// variables initalized 
char num1 = 'm';

	//do something with the variables 
char ans = rightClickMe.selectText.thisIsAChar(num1);

	//check if the answer is correct
	assertEquals('m', ans);  
	} 
 @Test 
 public void testingthisIsAChar2() { 
	// variables initalized 
char num1 = 'v';

	//do something with the variables 
char ans = rightClickMe.selectText.thisIsAChar(num1);

	//check if the answer is correct
	assertEquals('v', ans);  
	} 
 @Test 
 public void testingthisIsAChar3() { 
	// variables initalized 
char num1 = 'n';

	//do something with the variables 
char ans = rightClickMe.selectText.thisIsAChar(num1);

	//check if the answer is correct
	assertEquals('n', ans);  
	} 
}