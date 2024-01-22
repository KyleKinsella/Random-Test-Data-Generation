package learningTesting.learningTesting;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest 
{
   
    @Test
    public void addUp() {

    	int num1 = 1;
    	int num2 = 3;

    	
    	int ans = App.add(num1, num2);

        // Then
    	assertEquals(6, ans);
    	
        assertTrue(true);
    }
}
