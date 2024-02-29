package rightClickMe;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import org.junit.Test;

public class maketests {
	
	@Test
	public void add() {
		
        try {
            Method testMethod = selectText.class.getMethod("add", int.class, int.class);
            
            
            int sumOfRandoms = selectText.sumOfRandomValues(testMethod);  
            
            
            String testerQuestion = JOptionPane.showInputDialog(null, "What should be the expected result from the below numbers?", "Provide Expected Result", JOptionPane.QUESTION_MESSAGE);
	        int convert = Integer.parseInt(testerQuestion);	        
            
	        
	        boolean passed = false;
	        
	        if(convert == sumOfRandoms) {
	        	
	        	passed = true;
	        	JOptionPane.showMessageDialog(null, "Test Passed");
	        }
	        else {
	        	passed = false;
	        	JOptionPane.showMessageDialog(null, "Test Failed");
	        }
	        
            
            assertEquals(convert, sumOfRandoms);
            
            
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
