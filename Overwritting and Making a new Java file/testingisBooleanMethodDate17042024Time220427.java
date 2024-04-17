package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 

public class testingisBooleanMethodDate17042024Time220427{ 
  @Test 
 public void testingisBooleanDate17042024Time220429() { 
	// variables initalized 

	boolean booleanVariable1 = false;
	boolean booleanVariable2 = true;
	//do something with the variables 
boolean ans = rightClickMe.selectText.isBoolean(booleanVariable1, booleanVariable2);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
 @Test 
 public void testingisBooleanDate17042024Time220433() { 
	// variables initalized 

	boolean booleanVariable1 = true;
	boolean booleanVariable2 = true;
	//do something with the variables 
boolean ans = rightClickMe.selectText.isBoolean(booleanVariable1, booleanVariable2);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
 @Test 
 public void testingisBooleanDate17042024Time220435() { 
	// variables initalized 

	boolean booleanVariable1 = true;
	boolean booleanVariable2 = true;
	//do something with the variables 
boolean ans = rightClickMe.selectText.isBoolean(booleanVariable1, booleanVariable2);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
 @Test 
 public void testingisBooleanDate17042024Time220438() { 
	// variables initalized 

	boolean booleanVariable1 = false;
	boolean booleanVariable2 = true;
	//do something with the variables 
boolean ans = rightClickMe.selectText.isBoolean(booleanVariable1, booleanVariable2);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
 @Test 
 public void testingisBooleanDate17042024Time220440() { 
	// variables initalized 

	boolean booleanVariable1 = false;
	boolean booleanVariable2 = false;
	//do something with the variables 
boolean ans = rightClickMe.selectText.isBoolean(booleanVariable1, booleanVariable2);

	//check if the answer is correct
	assertEquals(false, ans);  
	} 
}