package rightClickMe;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Method;
import javax.swing.JOptionPane;

import org.eclipse.jface.dialogs.MessageDialog;
import org.junit.Test;

public class maketests {
	
	@Test
	public void add() {
		
        try {
            
        	selectText t = new selectText();
            	
        	Method testMethod = selectText.class.getMethod("add", int.class, int.class);
        	
        	String text = testMethod.getName();
        	
        	String data = t.randomTestData(testMethod);

        	
        	MessageDialog.openInformation(null, 
        			"You have selected",
        			"Method: " + text + "\n" + 
        			"Generated Random Test Data" + " " + data
        			);
     
        	
        	int ans = selectText.sumOfRandomValues;
        	        	
        	

            String testerQuestion = JOptionPane.showInputDialog(null, "What should be the expected result from the previous popup window?", "Provide Expected Result", JOptionPane.QUESTION_MESSAGE);
	        int convert = Integer.parseInt(testerQuestion);	        
            
	        
	        boolean passed = false;
	        
	        if(convert == ans) {
	        	
	        	passed = true;
	        	JOptionPane.showMessageDialog(null, "Test Passed");
	        }
	        else {
	        	passed = false;
	        	JOptionPane.showMessageDialog(null, "Test Failed");
	        }
	        
            
            assertEquals(convert, ans);
            
            
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
