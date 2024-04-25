package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingaddingMethod{ 
 @Test 
 public void testingadding() { 
	// variables initalized 
int intVariable1 = 35;
int intVariable2 = 97;
int intVariable3 = 114;

	//do something with the variables 
int ans = rightClickMe.selectText.adding(intVariable1, intVariable2, intVariable3);

	//check if the answer is correct
	assertEquals(246, ans);  
	} 
 
 @Test 
 public void testingadding1() { 
	// variables initalized 
int intVariable1 = 19;
int intVariable2 = 41;
int intVariable3 = 112;

	//do something with the variables 
int ans = rightClickMe.selectText.adding(intVariable1, intVariable2, intVariable3);

	//check if the answer is correct
	assertEquals(172, ans);  
	} 
 
 @Test 
 public void testingadding2() { 
	// variables initalized 
int intVariable1 = 29;
int intVariable2 = 56;
int intVariable3 = 39;

	//do something with the variables 
int ans = rightClickMe.selectText.adding(intVariable1, intVariable2, intVariable3);

	//check if the answer is correct
	assertEquals(124, ans);  
	} 
}