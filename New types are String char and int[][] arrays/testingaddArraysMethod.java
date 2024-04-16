package rightClickMe;

import static org.junit.Assert.assertEquals; 
import org.junit.Test; 
import java.util.Arrays;

public class testingaddArraysMethod{ 
 @Test 
 public void testingaddArrays() { 
	// variables initalized 
int[] array0 = {14, 108};
int[] array1 = {119, 10};

	//do something with the variables 
int[] ans = rightClickMe.selectText.addArrays(array0, array1);

	//check if the answer is correct
	assertEquals("[133, 118]", Arrays.toString(ans));  
	} 
 @Test 
 public void testingaddArrays1() { 
	// variables initalized 
int[] array0 = {50, 100};
int[] array1 = {98, 104};

	//do something with the variables 
int[] ans = rightClickMe.selectText.addArrays(array0, array1);

	//check if the answer is correct
	assertEquals("[148, 204]", Arrays.toString(ans));  
	} 
 @Test 
 public void testingaddArrays2() { 
	// variables initalized 
int[] array0 = {0, 108};
int[] array1 = {82, 114};

	//do something with the variables 
int[] ans = rightClickMe.selectText.addArrays(array0, array1);

	//check if the answer is correct
	assertEquals("[82, 222]", Arrays.toString(ans));  
	} 
 @Test 
 public void testingaddArrays3() { 
	// variables initalized 
int[] array0 = {87, 18};
int[] array1 = {52, 44};

	//do something with the variables 
int[] ans = rightClickMe.selectText.addArrays(array0, array1);

	//check if the answer is correct
	assertEquals("[139, 62]", Arrays.toString(ans));  
	} 
}