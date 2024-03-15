package rightClickMe;

//import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;


import javax.swing.JOptionPane;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.text.ITextSelection;



public class selectText extends AbstractHandler {
	
	// A global variable to be able to use whenever I need it.
//    public static int sumOfRandomValues;	
    
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

					
			
					
//					String name = method.getName();
//	                Class<?> returnType = method.getReturnType();
//	                int parameterCount = method.getParameterCount();
	                
	                
	                
//	                if(returnType.equals(float.class)) {
//	                	floatingPointNumbers flo = new floatingPointNumbers();
//	                	flo.main(null);
//	                }
	               
	                

	              	                
//	                String message = "Method name: " + name + "\n" +
//	                        "Return type: " + returnType + "\n" +
//	                        "Parameters: " + parameterCount + "\n" + 
//	                        "Type of result: " + returnType; 
//	                
//
//						       
//	                	                
//	                MessageDialog.openInformation(null, 
//			     		  "Here is some info about the method you have clicked on", 
//			     		  message
//			     		  );	
	                
	                
	                
	                
	                
	                
	                
	              
	                
	                
	                
//	                String info = "Method you clicked on: " + selectedText + "\n" +
//	                "Generated Random Test Data: " + data;
//	               	                
//	                
//	                MessageDialog.openInformation(null, 
//	                		"Method Name and Test Data",
//	                		info
//	                		);
	                	             
	              
					    
					    
					    
					    
				    String num = ""; 

					    
				    String data = randomTestData(method);
	
					 
					 // Split the data string into parts
					String[] parts = data.split(", ");


					StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
					StringBuilder variableAssignments = new StringBuilder();

//					 int sum = 0;
					 
					 
					 /// below code works to get the numbers within the variables ///
//					 for (int i = 0; i < parts.length; i++) {
//					     int number = Integer.parseInt(parts[i].trim());
//
//					     // Add to the method call
//					     if (i > 0) {
//					         methodCall.append(", ");
//					     }
//					     methodCall.append(number);
//
//					     // Add to variable assignments
//					     variableAssignments.append("int num").append(i + 1).append(" = ").append(number).append(";\n");
//					 }
					 
					 
					 for (int i = 0; i < parts.length; i++) {
						    int number = Integer.parseInt(parts[i].trim());
						    
						    // adds all of the variables together and is stored in "sum"

//						    sum += number;
						    
						    // Construct variable name
						    String variableName = "num" + (i + 1);

						    // Add to the method call
						    if (i > 0) {
						        methodCall.append(", ");
						    }
						    methodCall.append(variableName);

						    // Add to variable assignments
						    variableAssignments.append("int ").append(variableName).append(" = ").append(number).append(";\n");
						}

						// Now you have both the variable names and the assignments


					 methodCall.append(");");

					 // Combine everything
					 String ans = methodCall.toString();// + "\n" + variableAssignments.toString();
					
					 
					 				    
				    
 
//				    String result = selectedText + "(" + Arrays.toString(parts) + ")"; 
				    
//				    String t = num;
				    
//				    String result = selectedText + "(" + data + ")"; 
				    
//				    int result = add(num1, num2);
				    
//				    JOptionPane.showMessageDialog(null, "Result: " + result);
				    
	                String testerQuestion = JOptionPane.showInputDialog(null, "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + data + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
	                JOptionPane.showMessageDialog(null, "A test has been automatically generated.");
	    	        int convert = Integer.parseInt(testerQuestion);	        

	    	        
	    	        Package pkg = selectText.class.getPackage();
	    	        String packageName = pkg.getName();
	               
	    	        

	    	        
//	    	        String ans = selectText.class.getName() + "." + selectedText + "(" + num1 + ", " + num2 + ")" + ";" + "\n";
	    	        
//	    	        String question = JOptionPane.showInputDialog(null, "Enter a number to generate multiple tests" + "" + ":", "Make Test's",  JOptionPane.QUESTION_MESSAGE);
//	    	        int testsToMake = Integer.parseInt(question);
	    	        
//	    	        for(int i=1; i<= testsToMake; i ++) {
//	    	        	System.out.println("Test " + i + ": ");

	    	        
	    	        
	    	       
	    	        try {
	                	FileWriter myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\TEST.java");
						
//	                	myWriter.write("");
	                	

                		myWriter.write("package " + packageName + ";" + "\n\n" +
								"import static org.junit.Assert.assertEquals; \n"
								+ "import org.junit.Test; \n\n"
								+ "public class " + "test "  + "{ \n"
								+ " @Test \n"
								+ " public void " + "testing" + selectedText + "Method" + "() { \n"
								
								
								+ "	// variables initalized \n"
								+ variableAssignments + "\n"
								
								
		
								+ "	//do something with the variables \n"
								+ "" + "int ans = " + ans + "\n"
															
								
								
								+ "\n"
								+ "	//check if the answer is correct\n"										
								+ "	assertEquals" + "(" + convert + ", " + "ans" + ");  \n"								
								+ "	} \n"
									+"}"
								);
	                		
                		
                		
                		
                		
	                		
//	                		myWriter.write(" \n @Test \n" 
//	                		+ " public void " + "testing" + selectedText + "Method" + 1 + "() { \n"
//	                		+ "	// variables initalized \n"
//	                		
//							+ "	\n //do something with the variables \n"
//
//							+ "\n"
//							+ "	//check if the answer is correct\n"										
//							+"	}\n"
//							+"}"
//	                		
//               				);
	                		
							
	                		
						
						
						
						
						

						
						
						myWriter.close();
			            JOptionPane.showMessageDialog(null, "Your Java file has been created");			             
//			            String filePath = "C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\TEST.java";
//			             
//			            File file = new File(filePath);
//			            if (file.exists()) {
//			                ProcessBuilder pb = new ProcessBuilder("Notepad.exe", filePath);
//			                pb.start();
//			            }
			             
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
//		sumOfRandomValues = 0;
		
	
		for(int i = 0; i < para2; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;	
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
			
			
//			sumOfRandomValues = addRandomValues(randomParameters);
		}
	     
//	    System.out.println("Sum of random values: " + sumOfRandomValues);    
	       
	    
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
	
	
	
	
//	public static int addRandomValues(int[] randomValues) {
//	    int sum = 0;
//	    for (int value : randomValues) {
//	        sum += value;
//	    }
//	    return sum;
//	}
	
	
	
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
    public static int addition(int num1, int num2) {
        return num1 + num2;
    }
    

    
    public static int subtraction(int num1, int num2, int num3) {
        return num1 - num2 - num3;
    }
    
    
    public static int multiply(int num1, int num2) {
    	return num1 * num2;
    }
    
    
    
    public static int divide(int num1, int num2, int num3, int num4) {
    	return num1 / num2 / num3 / num4;
    }
    
    
    public static int squareRoot(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number must be non-negative");
        }
        return (int) Math.sqrt(number);
    }

    
    
    public static int squareNumber(int number) {
        return (int) (number * number);
    }
    
    
        
    
//    public static float floatClass() {
//    	return 0.0f;
//    }
    
    
}

