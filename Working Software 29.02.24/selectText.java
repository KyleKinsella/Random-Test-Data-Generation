package rightClickMe;

import java.lang.reflect.Method;
import java.util.Random;
import javax.swing.JOptionPane;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;


public class selectText extends AbstractHandler {
	
	// A global variable to be able to use whenever I need it.
    private static int sumOfRandomValues;	
	
	@Override
	// Indicates method overrides a method in a superclass or interface
    public Object execute(ExecutionEvent event) throws ExecutionException {
		
		ITextEditor editor = (ITextEditor) HandlerUtil.getActiveEditor(event);
		// Retrieves the active text editor in the Eclipse environment
        if (editor != null) {
            ISelection selection = editor.getSelectionProvider().getSelection();
            // Gets the current selection from the editor
            
            if (selection instanceof ITextSelection) {  
                ITextSelection textSelection = (ITextSelection) selection;
                // Casts the selection to a text selection
                
                String selectedText = textSelection.getText();
                // now in a variable called "selectedText" I have the selected text.
                
                
                Class<?> cls = null;
				try {
					cls = Class.forName("rightClickMe.selectText");
					
					Method method;

					method = cls.getMethod(selectedText, int.class, int.class);
					String name = method.getName();
	                Class<?> returnType = method.getReturnType();
	                int parameterCount = method.getParameterCount();

	                
	                String message = "Method name: " + name + "\n" +
	                        "Return type: " + returnType + "\n" +
	                        "Parameters: " + parameterCount;
	       
	                
	                MessageDialog.openInformation(null, 
			     		  "Here is some info about the method you have clicked on", 
			     		  message
			     		  );
	                
	                MessageDialog.openInformation(null, 
	                		"You have selected", 
	                		"Method: " + selectedText + "\n" //+ 
	                		//"Generated Random Test Data" + " " + randomTestData(method)
	                		);
	                
	                
	                /// instantiate the "maketests" class, to be able to call the .add @test.
	                maketests make = new maketests();
	                make.add();
	              
			        
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
                }            
            }
        return null;
	}



	
	
	/// this method will generate a random number depending on how many parametere's there is for the selected method that you chose.
	public static int[] random(Method method) {
    	Random rand = new Random();
		int para2 = method.getParameterCount();
		int[] randomParameters = new int[para2];
		
		// variable to store the sum of the random values added together
		sumOfRandomValues = 0;
		
	
		for(int i = 0; i < para2; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;	
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");	
			
			sumOfRandomValues = addRandomValues(randomParameters);
		}
	     
//	    System.out.println("Sum of random values: " + sumOfRandomValues);    
	        
	    return randomParameters;		
	}
	 	
	
	
	
	public static int addRandomValues(int[] randomValues) {
	    int sum = 0;
	    for (int value : randomValues) {
	        sum += value;
	    }
	    return sum;
	}
	
	

	public static String randomTestData(Method method) {
	    int[] rand = random(method);
	    StringBuilder sb = new StringBuilder();

	    for (int i = 0; i < rand.length; i++) {
	        sb.append(rand[i]);
	        if (i < rand.length - 1) {
	            sb.append(", ");
	        }
	    }
	    return sb.toString();
	}

	
	
	
	public static int sumOfRandomValues(Method method) {
        int[] randomValues = random(method);
        return addRandomValues(randomValues);
    }

    
	
	
    public static int add(int num1, int num2) {
        return num1 + num2;
    } 
    
    
}

