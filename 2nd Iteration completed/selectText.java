package rightClickMe;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
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
	    
    public static String selectedText;    
    public static Method dynamicMethod;
    public static FileWriter myWriter;

     
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
                	

				
					
	            	dynamicMethod = dynamic(selectedText);


		    	    
	    	        String fileName = "testing" + selectedText + "Method";

	    	        
	    	        
	    	        
	    	        
	            	
	    	     	Package pkg = selectText.class.getPackage();
		    	    String packageName = pkg.getName();
		    	    
		    	    
		    	    
		    	    
		    	    FileWriter myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\" + fileName + ".java");
					
					if (dynamicMethod != null) {
					    Class<?>[] parameterTypes = dynamicMethod.getParameterTypes();
					    Method method = cls.getMethod(selectedText, parameterTypes);
					    // Now you can use 'method' as needed
				
					    
					    Class<?> returnType = dynamicMethod.getReturnType();
					    
					    
					    
					    
					    

					    
					    if(returnType.equals(long.class)) {
					    	
					    	long[] longVariable = randomLong(dynamicMethod);
					    	
					    	// Convert the float array to a comma-separated string
					        StringBuilder sb = new StringBuilder();
					        for (int i = 0; i < longVariable.length; i++) {
					            sb.append(longVariable[i]);
					            if (i < longVariable.length - 1) {
					                sb.append(", "); // Append a comma after each element except the last
					            }
					        }
					        String longArrayAsString = sb.toString();
					    
					        String[] splitArray = longArrayAsString.split(",\\s*");
					        
					        
					        String longQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these long values: " + longArrayAsString + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					    	long convertLong = Long.parseLong(longQuestion);
					    	
					    	
					    	
					    	StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
							StringBuilder variableAssignments = new StringBuilder();
							
							 for (int i = 0; i < splitArray.length; i++) {
								 
								    long value = Long.parseLong(splitArray[i].trim());

								    							    
								    // Construct variable name
								    String variableName = "num" + (i + 1);
								    
		
								    // Add to the method call
								    if (i > 0) {
								        methodCall.append(", ");
								    }
								    methodCall.append(variableName);
		
								    // Add to variable assignments
								    variableAssignments.append(returnType + " ").append(variableName).append(" = ").append(value).append("L;\n");
								 
							 	}
								 methodCall.append(");");
			
								 // Combine everything
								 String ans = methodCall.toString();
					    	
								 
								 					    	
					    	 int response = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);		
							 
					    	 
					    	
					    	 if(response == JOptionPane.NO_OPTION) {
					    		 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								
			 								
											+ "public class " +  fileName + "{ \n"
											+ " @Test \n"
										 
											+ " public void " + "testing" + selectedText + "() { \n"
	
	
											+ "	// variables initalized \n"
											+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertLong + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								+"}"
										 	);
					    		 
							 }					    	 					    	 
					    	 
							 if(response == JOptionPane.YES_OPTION) {
					    		 
					    		 String enter = JOptionPane.showInputDialog(
		                    			 null, 
		                    			 "How many tests do you want to make?", 
		                    			 "Enter a number", 
		                    			 JOptionPane.QUESTION_MESSAGE		
		                    			 );
					    		 
		                    	 int enteredValue = Integer.parseInt(enter);
					    	
					    	
		                    	 
								 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertLong + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								);
								 
								 
								 
						    		 
								 
								 for(int i=1; i<=enteredValue; i++) {
						    			
									    long[] callLongMethod = randomLong(dynamicMethod);
									    String arrayString = Arrays.toString(callLongMethod);
									    arrayString = arrayString.substring(1, arrayString.length() - 1);
									    
									    
									    
										StringBuilder variableAssignments1 = new StringBuilder();

										for (int j = 0; j < callLongMethod.length; j++) {
									        long value = callLongMethod[j];
									        String variableName = "num" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append("L;\n");
										}
						    			 
																				
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

				 	     	             int q2Answer = Integer.parseInt(q);

						    			 
										 myWriter.write(
			 								" @Test \n"
			 								+ " public void " + "testing" + selectedText + i +"() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments1 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								);	 
						    		 }
								 myWriter.write("}");
					    	 }
					    }

					    
					    
					    if(returnType.equals(double.class)) {
					    	double[] doubleVariable = randomDouble(dynamicMethod);					    	
					    	
					    	// Convert the float array to a comma-separated string
					        StringBuilder sb = new StringBuilder();
					        for (int i = 0; i < doubleVariable.length; i++) {
					            sb.append(doubleVariable[i]);
					            if (i < doubleVariable.length - 1) {
					                sb.append(", "); // Append a comma after each element except the last
					            }
					        }
					        String doubleArrayAsString = sb.toString();
					    
					        String[] splitArray = doubleArrayAsString.split(",\\s*");
					        
					        
					        String doubleQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these double values: " + doubleArrayAsString + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					    	double convertDouble = Double.parseDouble(doubleQuestion);
					    	
					    	
					    	
					    	StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
		
							
							StringBuilder variableAssignments = new StringBuilder();							
							 for (int i = 0; i < splitArray.length; i++) {
								 
								    double value = Double.parseDouble(splitArray[i].trim());

								    							    
								    // Construct variable name
								    String variableName = "num" + (i + 1);
								    
		
								    // Add to the method call
								    if (i > 0) {
								        methodCall.append(", ");
								    }
								    methodCall.append(variableName);
		
								    // Add to variable assignments
								    variableAssignments.append(returnType + " ").append(variableName).append(" = ").append(value).append(";\n");
								 
							 	}
								 methodCall.append(");");
			
								 // Combine everything
								 String ans = methodCall.toString();
					    	
					    	
					    	
					    	 int response = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);		
							 
					    	
					    	 
					    	 if(response == JOptionPane.NO_OPTION) {
					    		 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								
											+ "public class " +  fileName + "{ \n"
											+ " @Test \n"
										 
											+ " public void " + "testing" + selectedText + "() { \n"
	
	
											+ "	// variables initalized \n"
											+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertDouble + ", " + "ans" + ", " + "0.0001" +");  \n"								
			 								+ "	} \n"
			 								+"}"
										 	);
					    		 
							 }					    
					    	 
					    	 
							 if(response == JOptionPane.YES_OPTION) {
					    		 
					    		 String enter = JOptionPane.showInputDialog(
		                    			 null, 
		                    			 "How many tests do you want to make?", 
		                    			 "Enter a number", 
		                    			 JOptionPane.QUESTION_MESSAGE		
		                    			 );
					    		 
		                    	 int enteredValue = Integer.parseInt(enter);
					    	
					    	
					    	

								 
								 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertDouble + ", " + "ans" + ", " + "0.0001" +");  \n"								
			 								+ "	} \n"
			 								);
								 
								 
								 
						    		 
								 
								 for(int i=1; i<=enteredValue; i++) {
						    			
									    double[] callDoubleMethod = randomDouble(dynamicMethod);
									    String arrayString = Arrays.toString(callDoubleMethod);
									    arrayString = arrayString.substring(1, arrayString.length() - 1);
									    
										StringBuilder variableAssignments1 = new StringBuilder();

										for (int j = 0; j < callDoubleMethod.length; j++) {
									        double value = callDoubleMethod[j];
									        String variableName = "num" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append(";\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

				 	     	             double q2Answer = Double.parseDouble(q);

						    			 
										 myWriter.write(
			 								" @Test \n"
			 								+ " public void " + "testing" + selectedText + i +"() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments1 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ", " + "0.0001" + ");  \n"								
			 								+ "	} \n"
			 								);	 
						    		 }
								 myWriter.write("}");
								 } 
					    }
					    

					    
					    if(returnType.equals(float.class)) {
					    	
					    	float[] floatVariable = randomFloat(dynamicMethod);

					    	
					    	// Convert the float array to a comma-separated string
					        StringBuilder sb = new StringBuilder();
					        for (int i = 0; i < floatVariable.length; i++) {
					            sb.append(floatVariable[i]);
					            if (i < floatVariable.length - 1) {
					                sb.append(", "); // Append a comma after each element except the last
					            }
					        }
					        String floatArrayAsString = sb.toString();
					        

					        // Split the string based on commas
					        String[] splitArray = floatArrayAsString.split(",\\s*");
					        
					       
					        String floatQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these float values: " + floatArrayAsString + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					    	float convertFloat = Float.parseFloat(floatQuestion);
					    	
					    	
					    	
					    	StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
		
							
							StringBuilder variableAssignments = new StringBuilder();
							
							 for (int i = 0; i < splitArray.length; i++) {
								 
								    float value = Float.parseFloat(splitArray[i].trim());

								    							    
								    // Construct variable name
								    String variableName = "num" + (i + 1);
								    
		
								    // Add to the method call
								    if (i > 0) {
								        methodCall.append(", ");
								    }
								    methodCall.append(variableName);
		
								    // Add to variable assignments
								    variableAssignments.append(returnType + " ").append(variableName).append(" = ").append(value).append("f;\n");
								 
							 	}
								 methodCall.append(");");
			
								 // Combine everything
								 String ans = methodCall.toString();

					    	
					    	
					    	
					    	int response = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);		
							 
					    	
					    	
					    	 if(response == JOptionPane.NO_OPTION) {
					    		 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								
											+ "public class " +  fileName + "{ \n"
											+ " @Test \n"
										 
											+ " public void " + "testing" + selectedText + "() { \n"
	
	
											+ "	// variables initalized \n"
											+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertFloat + ", " + "ans" + ", " + "0.0001" +");  \n"								
			 								+ "	} \n"
			 								+"}"
										 	);
					    		 
							 }					   
					    	
					    	
					    	
							 if(response == JOptionPane.YES_OPTION) {
					    		 
					    		 String enter = JOptionPane.showInputDialog(
		                    			 null, 
		                    			 "How many tests do you want to make?", 
		                    			 "Enter a number", 
		                    			 JOptionPane.QUESTION_MESSAGE		
		                    			 );
					    		 
		                    	 int enteredValue = Integer.parseInt(enter);
					    	
					    	
					    	
								 
								 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertFloat + ", " + "ans" + ", " + "0.001" + ");  \n"								
			 								+ "	} \n"
			 								);
								 
								 
								 
						    		 
								 
								 for(int i=1; i<=enteredValue; i++) {
						    			
									    float[] callFloatMethod = randomFloat(dynamicMethod);
									    String arrayString = Arrays.toString(callFloatMethod);
									    arrayString = arrayString.substring(1, arrayString.length() - 1);
									    
									    
										StringBuilder variableAssignments1 = new StringBuilder();

										for (int j = 0; j < callFloatMethod.length; j++) {
									        float value = callFloatMethod[j];
									        String variableName = "num" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append("f;\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

				 	     	             float q2Answer = Float.parseFloat(q);

						    			 
										 myWriter.write(
			 								" @Test \n"
			 								+ " public void " + "testing" + selectedText + i +"() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments1 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ", " + "0.0001" + ");  \n"								
			 								+ "	} \n"
			 								);	 
						    		 }
								 myWriter.write("}");						    		
								 } 
					    }
					        
					    
					    

					    if(returnType.equals(boolean.class)) {
						    
					    	boolean[] boolVal = randomBoolean(dynamicMethod);
					    
					    	// Convert the float array to a comma-separated string
					        StringBuilder sb = new StringBuilder();
					        for (int i = 0; i < boolVal.length; i++) {
					            sb.append(boolVal[i]);
					            if (i < boolVal.length - 1) {
					                sb.append(", "); // Append a comma after each element except the last
					            }
					        }
					        String booleanArrayAsString = sb.toString();
					        

					        // Split the string based on commas					        
					        String[] splitArray = booleanArrayAsString.split(",\\s*");
					    	
					        					    	
					    	String boolQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these boolean values: " + booleanArrayAsString + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					    	boolean convertBoolean = Boolean.parseBoolean(boolQuestion);
				
					    	
					    	
					    	StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
							StringBuilder variableAssignments1 = new StringBuilder();

							 for (int i = 0; i < splitArray.length; i++) {
								 
								    boolean value = Boolean.parseBoolean(splitArray[i].trim());

								    							    
								    // Construct variable name
								    String variableName = "num" + (i + 1);
								    
		
								    // Add to the method call
								    if (i > 0) {
								        methodCall.append(", ");
								    }
								    methodCall.append(variableName);
		
								    // Add to variable assignments
								    variableAssignments1.append(returnType + " ").append(variableName).append(" = ").append(value).append(";\n");
								 
							 	}
								 methodCall.append(");");
			
								 // Combine everything
								 String ans = methodCall.toString();// + "\n" + variableAssignments.toString();
					    	
					    	
					    	int response = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);		
							 
					    	
					    	
					    	if(response == JOptionPane.NO_OPTION) {
					    		 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments1 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertBoolean + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								+"}"
			 								);
					    	}
					    	
							 if(response == JOptionPane.YES_OPTION) {
					    		 
					    		 String enter = JOptionPane.showInputDialog(
		                    			 null, 
		                    			 "How many tests do you want to make?", 
		                    			 "Enter a number", 
		                    			 JOptionPane.QUESTION_MESSAGE		
		                    			 );
					    		 
		                    	 int enteredValue = Integer.parseInt(enter);
					    	
					    	
					    	

								 
								  myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments1 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convertBoolean + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
//			 								+"}"
			 								);
								 
								 
								 for(int i=1; i<=enteredValue; i++) {
						    			
									    boolean[] callBooleanMethod = randomBoolean(dynamicMethod);
									    String arrayString = Arrays.toString(callBooleanMethod);
									    arrayString = arrayString.substring(1, arrayString.length() - 1);
									    
										StringBuilder variableAssignments11 = new StringBuilder();

										for (int j = 0; j < callBooleanMethod.length; j++) {
									        boolean value = callBooleanMethod[j];
									        String variableName = "num" + (j + 1);
									        variableAssignments11.append(returnType).append(" ").append(variableName).append(" = ").append(value).append(";\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

				 	     	             boolean q2Answer = Boolean.parseBoolean(q);

						    			 
										 myWriter.write(
			 								" @Test \n"
			 								+ " public void " + "testing" + selectedText + i +"() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments11 + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								);	 
						    		 }
								 myWriter.write("}");
								 } 
					    }
					    
					    
					    
					    
					    
					    if(returnType.equals(int.class)) {
					    	
					    	// data stores int's
						    String data = randomTestData(method);
						    
						    String testerQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + data + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
							int convert = Integer.parseInt(testerQuestion);
					    
						    // Split the data string into parts
							String[] parts = data.split(", ");
		
							StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
							StringBuilder variableAssignments = new StringBuilder();
		
							 for (int i = 0; i < parts.length; i++) {
								    int number = Integer.parseInt(parts[i].trim());
								    							    
								    // Construct variable name
								    String variableName = "num" + (i + 1);
		
								    // Add to the method call
								    if (i > 0) {
								        methodCall.append(", ");
								    }
								    methodCall.append(variableName);
		
								    // Add to variable assignments
								    variableAssignments.append(returnType + " ").append(variableName).append(" = ").append(number).append(";\n");
								}
								 methodCall.append(");");
			
								 // Combine everything
								 String ans = methodCall.toString();// + "\n" + variableAssignments.toString();
					    

								 
	    	        
		    	        try {
		    	        	
		    	        	// need to update my code to NOT OVER-WRITE the file that is made.
		    	        	
//			                	myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\" + fileName + ".java");
							
	
		                	
		                	 int yORn = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	
		                     // Check the user's response
		                     if (yORn == JOptionPane.YES_OPTION) {
		                    	 
		                    	 myWriter.write("package " + packageName + ";" + "\n\n" +
			 								"import static org.junit.Assert.assertEquals; \n"
			 								+ "import org.junit.Test; \n\n"
			 								+ "public class " +  fileName + "{ \n"
			 								+ " @Test \n"
			 								+ " public void " + "testing" + selectedText + "() { \n"
			 								
			 								
			 								+ "	// variables initalized \n"
			 								+ variableAssignments + "\n"
			 								
			 								
			 		
			 								+ "	//do something with the variables \n"
			 								+  returnType + " ans = " + ans + "\n"
			 															
			 								
			 								
			 								+ "\n"
			 								+ "	//check if the answer is correct\n"										
			 								+ "	assertEquals" + "(" + convert + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								);
		                    	 
		                    	 
	
		                    	 String question = JOptionPane.showInputDialog(
		                    			 null, 
		                    			 "How many tests do you want to make?", 
		                    			 "Enter a number", 
		                    			 JOptionPane.QUESTION_MESSAGE		
		                    			 );
		                    	 
		                    	 
		                    	 int testsToMake = Integer.parseInt(question);
		                    	 
		                    	 String newNums = "";
		                    	 int q2Answer = 0;
		                    	 
		                    	 
		                    	 for(int i=1; i<= testsToMake; i++) {
	
				                    	newNums = randomTestData(dynamicMethod).toString();
				                    	
	
				                    	String question2 = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + newNums + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);
	
			 	     	                
			 	     	                q2Answer = Integer.parseInt(question2);
			 	     	                
			 	          
			 	     	                String[] newNumsParts = newNums.split(", ");
	
			 	     	                
	                					StringBuilder methodCall2 = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
	            						StringBuilder variableAssignments2 = new StringBuilder();
	
		            						
		            					
		            		    	    int number2 = 0;
	
		            					for (int j = 0; j < newNumsParts.length; j++) {
		            						
		            						String newLine = "\n";
		            							 	
		            						methodCall2.append(newLine);
		            							 
		            						number2 = Integer.parseInt(newNumsParts[j].trim());
		            							    
		            							    	            							    
	        							    // Construct variable name
	        							    String variableName2 = "num" + (j + 1);
	
	        							    // Add to the method call
	        							    if (j > 0) {
	        							        methodCall2.append(", ");
	        							    }
	        							    methodCall2.append(variableName2);
	
	        							    // Add to variable assignments
	        							    variableAssignments2.append(returnType + " ").append(variableName2).append(" = ").append(number2).append(";\n");
	        							}
	            							 methodCall2.append(");");
	            		
	            							 // Combine everything
	            							 String ans2 = methodCall.toString();			// + "\n" + variableAssignments.toString();
	                					
	            							 
	            							 //////////////////////////////////////////
	            							 
		                					myWriter.write(" \n @Test \n"
		                    				+ " public void " + "testing" + selectedText + i + "() { \n"
		    								
		    								
		    								+ "	// variables initalized \n"
		    								+ variableAssignments2 + "\n"
		    								
		    								
		    		
		    								+ "	//do something with the variables \n"
		    								+ "" + returnType + " ans = " + ans2 + "\n"
		    															
		    								
		    								
		    								
		    								+ "\n"
		    								+ "	//check if the answer is correct\n"										
		    								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ");  \n"								
		    								+ "	} \n"
		    								);
			                				}
//		                				String end = "}";
//		                				myWriter.write(end);
		                     } 
		                     else {
		                    	 myWriter.write("package " + packageName + ";" + "\n\n" +
		 								"import static org.junit.Assert.assertEquals; \n"
		 								+ "import org.junit.Test; \n\n"
		 								+ "public class " + fileName + "{ \n"
		 								+ " @Test \n"
		 								+ " public void " + "testing" + selectedText + "() { \n"
		 								
		 								
		 								+ "	// variables initalized \n"
		 								+ variableAssignments + "\n"
		 								
		 								
		 		
		 								+ "	//do something with the variables \n"
		 								+ returnType + " ans = " + ans + "\n"
		 															
		 								
		 								
		 								+ "\n"
		 								+ "	//check if the answer is correct\n"										
		 								+ "	assertEquals" + "(" + convert + ", " + "ans" + ");  \n"								
		 								+ "	} \n"
		 								);	      
//		 	                	 String end2 = "}";
//	             				 myWriter.write(end2);
		                     }
		                     
		                     
		                     int doYouWantBoundaryValues = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
							

						   	 if(doYouWantBoundaryValues == JOptionPane.YES_OPTION) {
						   		int[] bound = boundaryValue(dynamicMethod);
						  		 
						  		 // Convert the float array to a comma-separated string
							     StringBuilder sb = new StringBuilder();
							     for (int i = 0; i < bound.length; i++) {
							           sb.append(bound[i]);
							           if (i < bound.length - 1) {
							               sb.append(", "); // Append a comma after each element except the last
							           }
							       }
							       String boundArrayAsString = sb.toString();
							    
							       String[] splitArray = boundArrayAsString.split(",\\s*");
							       
							       //show message
							       
							       String boundaryValue = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these boundary values: " + boundArrayAsString + "?", "Boundary Value's", JOptionPane.QUESTION_MESSAGE);
							       int boundaryVal = Integer.parseInt(boundaryValue);
							       
							       
							       StringBuilder methodCall1 = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
							       StringBuilder variableAssignments1 = new StringBuilder();
									
							       
									 for (int i = 0; i < splitArray.length; i++) {
										 
										    int value = Integer.parseInt(splitArray[i].trim());

										    							    
										    // Construct variable name
										    String variableName = "num" + (i + 1);
										    

										    // Add to the method call
										    if (i > 0) {
										        methodCall1.append(", ");
										    }
										    methodCall1.append(variableName);

										    // Add to variable assignments
										    variableAssignments1.append(returnType + " ").append(variableName).append(" = ").append(value).append(";\n");
																	    
									 	}
										 methodCall1.append(");");

										 // Combine everything
										 String ans1 = methodCall1.toString();
										 
										 
										 
										 
										 myWriter.write("\n" + "@Test \n"
													+ " public void " + "testing" + selectedText + "BoundaryValue" + "() { \n"
													
													
													+ "	// variables initalized \n"
													+ variableAssignments1 + "\n"
													
													
							
													+ "	//do something with the variables \n"
													+  returnType + " ans = " + ans1 + "\n"
																				
													
													
													+ "\n"
													+ "	//check if the answer is correct\n"										
													+ "	assertEquals" + "(" + boundaryVal + ", " + "ans" + ");  \n"								
													+ "	} \n"
													+ "}"
													);  	
										 
										 
					                   int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to make more than one boundary test?", "Boundary Test's?", JOptionPane.YES_NO_CANCEL_OPTION);
						   	 
									
					                   StringBuilder variableAssignments2 = null;
				                	   String ans2 = "";
										 
					                   if(yesORno == JOptionPane.YES_OPTION) {
					                	   String howManyBoundarys = JOptionPane.showInputDialog(null, "How many tests do you want to make?", "Enter a number", JOptionPane.YES_NO_CANCEL_OPTION);
					                	   int boundaryTestsToMake = Integer.parseInt(howManyBoundarys);
					                	   
//					                	   String newNums = "";
					                	   int q2Answer = 0;
					                	   
					                    	 
					                    	 for(int i=1; i<= boundaryTestsToMake; i++) {
					                    		 int[] t = boundaryValue(dynamicMethod);
					                    		 	
					                    		 // Convert the float array to a comma-separated string
												 StringBuilder sb1 = new StringBuilder();
												 for (int i1 = 0; i1 < t.length; i1++) {
												       sb1.append(t[i1]);
												           if (i1 < t.length - 1) {
												               sb1.append(", "); // Append a comma after each element except the last
												           }
												       }
												       String total = sb1.toString();
												    
												       String[] tSplitArray = total.split(",\\s*");
					                    		 	
					                    		 
//							                    	newNums = boundaryValue(dynamicMethod).toString();
							                    	
				
							                    	String question2 = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + total + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);
				
						 	     	                
						 	     	                q2Answer = Integer.parseInt(question2);
						 	     	                
						 	          
//						 	     	                String[] newNumsParts = newNums.split(", ");
				
						 	     	                
				                					StringBuilder methodCall2 = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
				            						variableAssignments2 = new StringBuilder();
				
					            						
					            					
					            		    	    int number2 = 0;
				
					            					for (int j = 0; j < tSplitArray.length; j++) {
					            						
					            						String newLine = "\n";
					            							 	
					            						methodCall2.append(newLine);
					            							 
					            						number2 = Integer.parseInt(tSplitArray[j].trim());
					            							    
					            							    	            							    
				        							    // Construct variable name
				        							    String variableName2 = "num" + (j + 1);
				
				        							    // Add to the method call
				        							    if (j > 0) {
				        							        methodCall2.append(", ");
				        							    }
				        							    methodCall2.append(variableName2);
				
				        							    // Add to variable assignments
				        							    variableAssignments2.append(returnType + " ").append(variableName2).append(" = ").append(number2).append(";\n");
				        							}
				            							 methodCall2.append(");");
				            		
				            							 // Combine everything
				            							 ans2 = methodCall2.toString();			// + "\n" + variableAssignments.toString();
				                					
				            							 
				            							 //////////////////////////////////////////
				            							 
					                					myWriter.write(" \n @Test \n"
														+ " public void " + "testing" + selectedText + "BoundaryValue" + i + "() { \n"
					    							
					    								
					    								+ "	// variables initalized \n"
					    								+ variableAssignments2 + "\n"
					    								
					    								
					    		
					    								+ "	//do something with the variables \n"
					    								+ "" + returnType + " ans = " + ans2 + "\n"
					    															
					    													    								
					    								+ "\n"
					    								+ "	//check if the answer is correct\n"										
					    								+ "	assertEquals" + "(" + q2Answer + ", " + "ans" + ");  \n"								
					    								+ "	} \n"
					    								);
						                				}
					                				String end = "}";
					                				myWriter.write(end);
										 }
						   	 }
						   	 
						   	 
						   	 else {
						   		 // you picked the no option for "do you want a boundary value pop-up"
						   		 String end2 = "}";
	             				 myWriter.write(end2);
						   	 }
		                     
		                     
	
			    	        } catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					
						}
					   
					 myWriter.close();
			         JOptionPane.showMessageDialog(null, "Your Java file has been created");	
					
					} catch (NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
                }            
            }
        return null;
	}



	
	
	
	
	
	
	
	
	////////////////// below is the code that makes my software run //////////////////


	/// this method will generate a random number depending on how many parametere's there is for the selected method that you chose.
	public static int[] random(Method method) {	
    	Random rand = new Random();
		int para = method.getParameterCount();
		int[] randomParameters = new int[para];
        
		System.out.println("Random method has been called");	
		for(int i = 0; i < para; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;	
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
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
		

	
	
	public static Method dynamic(String selectedText) throws ClassNotFoundException {
	    
		Class<?> cls = null;
		
		try {
			
			cls = Class.forName("rightClickMe.selectText");

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
	    } catch (NoSuchMethodException | SecurityException e) {
	        JOptionPane.showMessageDialog(null, "Exception occurred: " + e.getMessage());
	    }
	    return null;
	}

	

	
	public static boolean[] randomBoolean(Method method) {
		Random rand = new Random();
		int para = method.getParameterCount();
		boolean[] randomParameters = new boolean[para];

		for(int i = 0; i < para; i++) {
			
			randomParameters[i] = rand.nextBoolean();
		}
		return randomParameters;
	}
	
	
	
	public static float[] randomFloat(Method method) {	
    	Random rand = new Random();
		int para = method.getParameterCount();
		float[] randomParameters = new float[para];
        
		System.out.println("Float[] method has been called");
		for(int i = 0; i < para; i++) {
			float min = 0.0f;
			float max = 120.0f;
			
			
			float floatFormula = rand.nextFloat() * (max - min) + min;
			
			// Use BigDecimal to round it to two decimal places
	        BigDecimal bd = new BigDecimal(Float.toString(floatFormula));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);

	        // Store the rounded value in the array
	        randomParameters[i] = bd.floatValue();  
	        
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;		
	}
	 
	
	
	
	
	public static double[] randomDouble(Method method) {	
    	Random rand = new Random();
		int para = method.getParameterCount();
		double[] randomParameters = new double[para];
        
		System.out.println("Double[] method has been called");	
		for(int i = 0; i < para; i++) {
			double min = 0.0;
			double max = 120.0;
			
			
			double doubleFormula = rand.nextDouble() * (max - min) + min;
			BigDecimal bd = new BigDecimal(Double.toString(doubleFormula));
	        bd = bd.setScale(2, RoundingMode.HALF_UP);
	        
	        randomParameters[i] = bd.doubleValue();  
			
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;		
	}
	
	
	
	
	public static long[] randomLong(Method method) {
		Random rand = new Random();
		int para = method.getParameterCount();
		long[] randomParameters = new long[para];
        
		System.out.println("Long[] method has been called");		
		for(int i = 0; i < para; i++) {
			long min = 0L;
			long max = 120L;
			
					
			randomParameters[i] = rand.nextLong(max - min + 1) + min;	
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;	
	}


	
	
	
	public static int[] boundaryValue(Method method) {
		Random rand = new Random();
		int para = method.getParameterCount();
		int[] randomParameters = new int[para];

		
		System.out.println("boundaryValue[] method has been called");	
		for(int i=0; i<para; i++) {
			int positiveNumber = rand.nextInt(120);
			//negativeValue = rand.nextInt(120);		
	        int negativeNumber = -rand.nextInt(positiveNumber);
		
	        randomParameters[i] = rand.nextInt(positiveNumber - negativeNumber + 1) + negativeNumber;
			System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
		}
		return randomParameters;
	}
	
	
	
	public static String scanDir() {
		
		
		
		
		return "";
	}
	
	

	
	
	///// methods to test my code on //////
    public static int Addition(int num1, int num2) {
        return num1 + num2;
    }
    
    
    
    public static int Subtraction(int num1, int num2, int num3) {
        return num1 - num2 - num3;
    }
    
    
    public static int Multiply(int num1, int num2) {
    	return num1 * num2;
    }
    
    
    
    public static int Divide(int num1, int num2, int num3, int num4) {
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
    
    public static boolean isBool(boolean yes, boolean no, boolean b) {
    	return yes && no && b;
    }
    
    
    public static float floatClass(float a, float b, float c) {
    	return a + b + c;
    }
    
    
    public static double addDoubleNumsTogether(double one, double two) {
    	return one + two;
    }
    
    public static long addLongValsTogether(long num1, long num2) {
    	return num1 + num2;
    }
    
    
    
    public static float divideFloatNumbers(float number1, float number2) {
    	return number1 / number2;
    }
    
      
}
