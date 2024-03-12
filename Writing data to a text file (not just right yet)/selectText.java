package rightClickMe;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
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
    public static int sumOfRandomValues;	
    
    public static String selectedText;
	
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
			
					
					Method dynamicMethod = dynamic(selectedText);
					if (dynamicMethod != null) {
					    Class<?>[] parameterTypes = dynamicMethod.getParameterTypes();
					    Method method = cls.getMethod(selectedText, parameterTypes);
					    // Now you can use 'method' as needed
					
//
//					MessageDialog.openInformation(null, 
//							"You have selected - " + selectedText + "\n", 
//							"Method Specification: "+ method.toString()
//							);

					
			
					
					String name = method.getName();
	                Class<?> returnType = method.getReturnType();
	                int parameterCount = method.getParameterCount();
	                
	                
	                
//	                if(returnType.equals(float.class)) {
//	                	floatingPointNumbers flo = new floatingPointNumbers();
//	                	flo.main(null);
//	                }
	               
	                

	              	                
	                String message = "Method name: " + name + "\n" +
	                        "Return type: " + returnType + "\n" +
	                        "Parameters: " + parameterCount + "\n" + 
	                        "Type of result: " + returnType; 
	                

						       
	                	                
	                MessageDialog.openInformation(null, 
			     		  "Here is some info about the method you have clicked on", 
			     		  message
			     		  );	
	                
	                
	                String data = randomTestData(method);
	                
	                String info = "Method you clicked on: " + selectedText + "\n" +
	                "Generated Random Test Data: " + data;
	               	                
	                
	                MessageDialog.openInformation(null, 
	                		"Method Name and Test Data",
	                		info
	                		);
	                	             
	                
	                
	                
//	                Method meh = selectText.class.getMethod(selectedText, parameterTypes);
	                String nums = "";
	              	             
	                
	                nums = data;
	                
	                String testerQuestion = JOptionPane.showInputDialog(null, "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + data + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
	                JOptionPane.showMessageDialog(null, "A test has been automatically generated.");
					
	                
	    	        int convert = Integer.parseInt(testerQuestion);	        

	    	        
	    	       
//	    	        
//	    	        boolean passed = false;
//	    	        boolean failed = false;
//	    	        
//	    	        if(convert == sumOfRandomValues) {
//	   	        	
//	    	        	JOptionPane.showMessageDialog(null, "Test Passed");
//	                	passed = true;
//	                }
//	                else {
//	                	JOptionPane.showMessageDialog(null, "Test Failed");
//	                	failed = false;
//	                }
	    	        
	    	        
	    	        Package pkg = selectText.class.getPackage();
	    	        String packageName = pkg.getName();
	                
	                
	                try {
	                	FileWriter myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\mangoLoco.java");
						
						myWriter.write( "Tester Input / Expected number entered: " + testerQuestion + "\n"
								+ "The actual answer is: " + sumOfRandomValues + "\n"
								+ ".................................................................. \n" +
								
								
								
								"package " + packageName + ";" + "\n\n" +
								"import static org.junit.Assert.assertEquals; \n"
								+ "import org.junit.Test; \n\n"
								+ "public class " + selectedText + "Method" +  "{ \n"
								+ " @Test \n"
								
								
								+ " public void " + "testing" + selectedText + "Method" + "() { \n"
								+ "	// variables initalized \n"
																
								
								+ "	int nums = " + nums + ";"
								
								+ "	\n"
								+ "	//do something with the variables \n"
								
								
								+ "	int ans = " + sumOfRandomValues + ";"




								
								
								+ "	\n"
								+ "	//check if the answer is correct\n"
								
								
																
								+ "	assertEquals" + "(" + convert + ", " + sumOfRandomValues + ");  \n"
								
								
								
								
								+ "	} \n"
								+"}"
								);
						
						

						
						

						
						
						myWriter.close();
			            System.out.println("Successfully created TEST.java.");
			             
			            String filePath = "C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\mangoLoco.java";
			             
			            File file = new File(filePath);
			            if (file.exists()) {
			                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", filePath);
			                pb.start();
			            }
			             
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					}

			        
				} catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
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
	     
	    System.out.println("Sum of random values: " + sumOfRandomValues);    
	       
	    
	   
//	    System.out.println("Array with Generated Random Test Data: " + Arrays.toString(randomParameters));
//	    
//	    for(int i=0; i<randomParameters.length; i++) {
//	        System.out.println("Number: " + i + " = " + randomParameters[i]);
//	    }
//	    	    
	    return randomParameters;		
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
	
	
	
	public static int addRandomValues(int[] randomValues) {
	    int sum = 0;
	    for (int value : randomValues) {
	        sum += value;
	    }
	    return sum;
	}
	
	
	
	public static Method dynamic(String selectedText) {
	    try {
	        Class<?> cls = Class.forName("rightClickMe.selectText");
	        Method[] methods = cls.getDeclaredMethods();
	        Method selectedMethod = null;
	        
	        for (Method method : methods) {
	            if (method.getName().equals(selectedText)) {
	                selectedMethod = method;
	                break;
	            }
	        }

	        if (selectedMethod != null) {
	            Class<?>[] parameterTypes = selectedMethod.getParameterTypes();
	            return cls.getMethod(selectedText, parameterTypes);
	        } else {
	            // Handle the case where the method is not found
	            JOptionPane.showMessageDialog(null, "Method not found.");
	        }
	    } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
	        JOptionPane.showMessageDialog(null, "Exception occurred: " + e.getMessage());
	    }
	    return null;
	}


	

	
	
	///// methods to test my code on //////
    public static int add(int num1, int num2) {
        return num1 + num2;
    }
    

    
    public static int sub(int num1, int num2, int num3) {
        return num1 - num2 - num3;
    }
    
    
    public static int mul(int num1) {
    	return num1 * num1;
    }
    
    
    
//    public static float floatClass() {
//    	return 0.0f;
//    }
    
    
}

