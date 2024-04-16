package rightClickMe;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
	    
    public static String selectedText; // the method you picked     
    public static Method dynamicMethod;
//    public static FileWriter myWriter;

    
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
                            
                
                FileWriter myWriter = null;   
                Class<?> cls = null;
                try {
        
                	cls = Class.forName("rightClickMe.selectText");
	            	dynamicMethod = dynamic(selectedText);


		    	    
	    	        String fileName = "testing" + selectedText + "Method";
	    	     	Package pkg = selectText.class.getPackage();
		    	    String packageName = pkg.getName();
		    	    myWriter = new FileWriter("E:\\test\\rightClickMe\\src\\rightClickMe\\" + fileName + ".java");
					

		    	    
					if (dynamicMethod != null) {
					    Class<?>[] parameterTypes = dynamicMethod.getParameterTypes();
					    Method method = cls.getMethod(selectedText, parameterTypes);
					    // Now I can use "method" whenever I need it//
				
					    
					    
					    Class<?> returnType = dynamicMethod.getReturnType();
					    
					    
					    
					    
					    if (returnType.equals(int[][].class) || returnType.isArray() && returnType.getComponentType() == int.class) {
				            
				            int[][] generateArrays = generateArrays(dynamicMethod);
				            
				            
				            StringBuilder allArrays = new StringBuilder();
				            if (generateArrays != null) {
				                for (int i = 0; i < generateArrays.length; i++) {
				                    StringBuilder arrayString = new StringBuilder("int[] array" + i + " = {");

				                    for (int j = 0; j < generateArrays[i].length; j++) {
				                        arrayString.append(generateArrays[i][j]);

				                        if (j < generateArrays[i].length - 1) {
				                            arrayString.append(", ");
				                        }
				                    }
				                    arrayString.append("};");

				                    allArrays.append(arrayString).append("\n"); // Append arrayString to allArrays
				                    }
				            }

					            	
					            	
					            	
					            	
					            	String arrayQuestion = JOptionPane.showInputDialog(null, "Return type is: " + "int[][]" + "\n" + "Method you picked: " + selectedText + "\n" + "Input a number for each column combined then followed by a comma, from the below arrays:" + "\n" + allArrays.toString(), "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					            
					            	
					            	arrayQuestion = "\"[" + arrayQuestion + "]\"";
					            
					            
					            StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
								StringBuilder variableAssignments = new StringBuilder();
								
								
								 for (int k = 0; k < generateArrays.length; k++) {
									 
									    int value = generateArrays[k].length;
									    
									    
									    							    
									    // Construct variable name
									    String variableName = "array" + (k + 0);
									    
			
									    // Add to the method call
									    if (k > 0) {
									        methodCall.append(", ");
									    }
									    methodCall.append(variableName);
			
									    // Add to variable assignments
									    variableAssignments.append("int[] " + " ").append(variableName).append(" = \'").append(value + "\'").append(";\n");
									 
								 	}
									 methodCall.append(");");
				
									 // Combine everything
									 String ans = methodCall.toString();
									 
									 
									 int response = JOptionPane.showConfirmDialog(null, "Do you want to make more than one test?", "Make Test's",
				                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);		
									 
							    	 

							    	 if(response == JOptionPane.NO_OPTION) {
							    		 myWriter.write("package " + packageName + ";" + "\n\n" +
					 								"import static org.junit.Assert.assertEquals; \n"
					 								+ "import org.junit.Test; \n"
					 								+ "import java.util.Arrays;\n\n"
					 								
					 								
					 								
													+ "public class " +  fileName + "{ \n"
													+ " @Test \n"
												 
													+ " public void " + "testing" + selectedText + "() { \n"
			
			
													+ "	// variables initalized \n"
													+ allArrays + "\n"
					 								
					 								
					 		
					 								+ "	//do something with the variables \n"
					 								+  "int[]" + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + arrayQuestion + ", " + "Arrays.toString(ans)" + ");  \n"								
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
					 								+ "import org.junit.Test; \n"
					 								+ "import java.util.Arrays;\n\n"
					 								
					 								+ "public class " +  fileName + "{ \n"
					 								+ " @Test \n"
					 								+ " public void " + "testing" + selectedText + "() { \n"
					 								
					 								
					 								+ "	// variables initalized \n"
					 								+ allArrays + "\n"
					 								
					 								
					 		
					 								+ "	//do something with the variables \n"
					 								+  "int[]" + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + arrayQuestion + ", " + "Arrays.toString(ans)" + ");  \n"								
					 								+ "	} \n"
					 								);

										 
										 
										 for(int i=1; i<=enteredValue; i++) {
								    			
									         	int[][] arrayMethod = generateArrays(dynamicMethod);
											    
											    StringBuilder buildNewArrays = new StringBuilder();
												StringBuilder variableAssignments1 = new StringBuilder();

												for (int j = 0; j < arrayMethod.length; j++) {
											        int[] value = arrayMethod[j];
											        String variableName = "array" + (j + 0);
											        String arrayString = "int[] " + variableName + " = {" + arrayToString(value) + "};\n";
											        buildNewArrays.append(arrayString);
											        
											        variableAssignments1.append("int[] ").append(variableName).append(" = ").append(Arrays.toString(value)).append(";\n");
												}
								    			 

								    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + "int[][]" + "\n" + "Method you picked: " + selectedText + "\n" + "Input a number for each column combined then followed by a comma, from the below arrays:" + "\n" + buildNewArrays, "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

								    			 q = "\"[" + q + "]\"";

								    			 
												 myWriter.write(
					 								" @Test \n"
					 								+ " public void " + "testing" + selectedText + i +"() { \n"
					 								
					 								
					 								+ "	// variables initalized \n"
					 								+ buildNewArrays + "\n"
					 								
					 								
					 		
					 								+ "	//do something with the variables \n"
					 								+  "int[]" + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + q + ", " + "Arrays.toString(ans)" + ");  \n"								
					 								+ "	} \n"
					 								);	 
								    		 }
										 myWriter.write("}");
							    	 }
					    }
				           
					        
					       
			

					    if(returnType.equals(char.class)) {
					    	
					    	char[] charVariable = generateRandomChar(dynamicMethod);
					         
					    	
					         // Convert the float array to a comma-separated string
						        StringBuilder sb = new StringBuilder();
						        for (int i = 0; i < charVariable.length; i++) {
						            sb.append(charVariable[i]);
						            if (i < charVariable.length - 1) {
						                sb.append(", "); // Append a comma after each element except the last
						            }
						        }
						        String charArrayAsString = sb.toString();
						    
						        String[] splitArray = charArrayAsString.split(",\\s*");
					         
						        
						        String charQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "Type in the following that is on the right hand side: \'" + charArrayAsString + "\'" + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
						        
						        charQuestion = "\'" + charQuestion + "\'";
						        
						        StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
								StringBuilder variableAssignments = new StringBuilder();
								
								 for (int i = 0; i < splitArray.length; i++) {
									 
									    String value = splitArray[i].trim();

									    							    
									    // Construct variable name
									    String variableName = "charVariable" + (i + 1);
									    
			
									    // Add to the method call
									    if (i > 0) {
									        methodCall.append(", ");
									    }
									    methodCall.append(variableName);
			
									    // Add to variable assignments
									    variableAssignments.append(returnType + " ").append(variableName).append(" = \'").append(value + "\'").append(";\n");
									 
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
					 								+ "	assertEquals" + "(" + charQuestion + ", " + "ans" + ");  \n"								
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
					 								+ "	assertEquals" + "(" + charQuestion + ", " + "ans" + ");  \n"								
					 								+ "	} \n"
					 								);
										 

										 
										 for(int i=1; i<=enteredValue; i++) {
								    			
									         	char[] charMethod = generateRandomChar(dynamicMethod);
											    String arrayString = Arrays.toString(charMethod);
											    arrayString = arrayString.substring(1, arrayString.length() - 1);
											    
											    
											    
												StringBuilder variableAssignments1 = new StringBuilder();

												for (int j = 0; j < charMethod.length; j++) {
											        char value = charMethod[j];
											        String variableName = "charVariable" + (j + 1);
											        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = \'").append(value + "\'").append(";\n");
												}
								    			 
																						
								    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "Type in the following that is on the right hand side: \'" + arrayString + "\'" + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

								    			 q = "\'" + q + "\'";
								    			 
								    			 
												 myWriter.write(
					 								" @Test \n"
					 								+ " public void " + "testing" + selectedText + i +"() { \n"
					 								
					 								
					 								+ "	// variables initalized \n"
					 								+ variableAssignments1 + "\n"
					 								
					 								
					 		
					 								+ "	//do something with the variables \n"
					 								+  returnType + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + q + ", " + "ans" + ");  \n"								
					 								+ "	} \n"
					 								);	 
								    		 }
										 myWriter.write("}");
							    	 }
					    }
					    
					    
					    if(returnType.equals(String.class)) {
					    	
					    	String returnTypeSimpleName = returnType.getSimpleName();
					    	
					    	
					         String[] stringVariable = generateRandomString(dynamicMethod);
					         
					         // Convert the float array to a comma-separated string
						        StringBuilder sb = new StringBuilder();
						        for (int i = 0; i < stringVariable.length; i++) {
						            sb.append(stringVariable[i]);
						            if (i < stringVariable.length - 1) {
						                sb.append(", "); // Append a comma after each element except the last
						            }
						        }
						        String stringArrayAsString = sb.toString();
						    
						        String[] splitArray = stringArrayAsString.split(",\\s*");
					         
						        
						        String stringQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "Type in the following that is on the right hand side: \"" + stringArrayAsString + "\"" + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
					    
						        stringQuestion = "\"" + stringQuestion + "\"";
						        
						        
						        
						        StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
								StringBuilder variableAssignments = new StringBuilder();
								
								 for (int i = 0; i < splitArray.length; i++) {
									 
									    String value = splitArray[i].trim();

									    							    
									    // Construct variable name
									    String variableName = "stringVariable" + (i + 1);
									    
			
									    // Add to the method call
									    if (i > 0) {
									        methodCall.append(", ");
									    }
									    methodCall.append(variableName);
			
									    // Add to variable assignments
									    variableAssignments.append(returnTypeSimpleName + " ").append(variableName).append(" = \"").append(value + "\"").append(";\n");
									 
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
					 								+  returnTypeSimpleName + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + stringQuestion + ", " + "ans" + ");  \n"								
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
					 								+  returnTypeSimpleName + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + stringQuestion + ", " + "ans" + ");  \n"								
					 								+ "	} \n"
					 								);
										 
										 
										 
										 for(int i=1; i<=enteredValue; i++) {
								    			
									         	String[] stringMethod = generateRandomString(dynamicMethod);
											    String arrayString = Arrays.toString(stringMethod);
											    arrayString = arrayString.substring(1, arrayString.length() - 1);
											    
											    
											    
												StringBuilder variableAssignments1 = new StringBuilder();

												for (int j = 0; j < stringMethod.length; j++) {
											        String value = stringMethod[j];
											        String variableName = "stringVariable" + (j + 1);
											        variableAssignments1.append(returnTypeSimpleName).append(" ").append(variableName).append(" = \"").append(value + "\"").append(";\n");
												}
								    			 
																						
								    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "Type in the following that is on the right hand side: \"" + arrayString + "\"" + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

								    			 q = "\"" + q + "\"";
								    			 
								    			 
												 myWriter.write(
					 								" @Test \n"
					 								+ " public void " + "testing" + selectedText + i +"() { \n"
					 								
					 								
					 								+ "	// variables initalized \n"
					 								+ variableAssignments1 + "\n"
					 								
					 								
					 		
					 								+ "	//do something with the variables \n"
					 								+  returnTypeSimpleName + " ans = " + ans + "\n"
					 															
					 								
					 								
					 								+ "\n"
					 								+ "	//check if the answer is correct\n"										
					 								+ "	assertEquals" + "(" + q + ", " + "ans" + ");  \n"								
					 								+ "	} \n"
					 								);	 
								    		 }
										 myWriter.write("}");
							    	 }
					    }
					    

					    
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
								    String variableName = "longVariable" + (i + 1);
								    
		
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
									        String variableName = "longVariable" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append("L;\n");
										}
						    			 
																				
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these long values: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

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
					    	 }
							 
							 
							 int doYouWantBoundaryValuesBoolean = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					    
							 if(response == JOptionPane.NO_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(response == JOptionPane.YES_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(doYouWantBoundaryValuesBoolean == JOptionPane.YES_OPTION) {
								 
								 myWriter.write("// Below are the boundary tests for the type long \n"); 
			 						
								 
								// Loop to generate boundary tests
								 for (int i = 0; i < 2; i++) {
									    long[] newLongValue = randomLong(dynamicMethod);
									    myWriter.write("@Test \n");
									    myWriter.write("public void " + "BoundaryTest" + (i + 1) + "() { \n");
									    myWriter.write("	// variables initialized \n");

									    long longValue = 0L;
									    for (int j = 0; j < newLongValue.length; j++) {
									        longValue = boundaryValueForLong(); 
									        myWriter.write("	long longVariable" + (j + 1) + " = " + longValue + "L;\n");
									    }

									    myWriter.write("	// do something with the variables \n");
									    myWriter.write("	" + returnType + " ans = " + ans + "\n");
									    myWriter.write("	// check if the answer is correct\n");
									    myWriter.write("	assertEquals" + "(" + longValue + ", " + "ans" + ");\n");
									    myWriter.write("}\n");
									}
								 myWriter.write("}");
							 }
							 else {
								 //do nothing....
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
								    String variableName = "doubleVariable" + (i + 1);
								    
		
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
									        String variableName = "doubleVariable" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append(";\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these double values: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

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
								 } 
							 
							 
							 
							 int doYouWantBoundaryValuesBoolean = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					    
							 if(response == JOptionPane.NO_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(response == JOptionPane.YES_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(doYouWantBoundaryValuesBoolean == JOptionPane.YES_OPTION)  {
								 myWriter.write("// Below are the boundary tests for the type double \n"); 
			 						
								 
									// Loop to generate boundary tests
									 for (int i = 0; i < 2; i++) {
										 	double[] newDoubleValue = randomDouble(dynamicMethod);
										    myWriter.write("@Test \n");
										    myWriter.write("public void " + "BoundaryTest" + (i + 1) + "() { \n");
										    myWriter.write("	// variables initialized \n");

										    double doubleValue = 0.0;
										    for (int j = 0; j < newDoubleValue.length; j++) {
										        doubleValue = boundaryValueForDouble();
										        myWriter.write("	double doubleVariable" + (j + 1) + " = " + doubleValue + ";\n");
										    }

										    myWriter.write("	// do something with the variables \n");
										    myWriter.write("	" + returnType + " ans = " + ans + "\n");
										    myWriter.write("	// check if the answer is correct\n");
										    myWriter.write("	assertEquals" + "(" + doubleValue + ", " + "ans" + ", " + "0.0001" + ");\n");
										    myWriter.write("}\n");
										}
									 myWriter.write("}");
							 }
							 else {
								 //do nothing....
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
								    String variableName = "floatVariable" + (i + 1);
								    
		
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
//			 								+"}"
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
									        String variableName = "floatVariable" + (j + 1);
									        variableAssignments1.append(returnType).append(" ").append(variableName).append(" = ").append(value).append("f;\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these float values: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

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
								 } 
							 
							 
							 
							 
							 int doYouWantBoundaryValuesBoolean = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					    
				 
							 
							 if(response == JOptionPane.NO_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
				
							 
							 if(response == JOptionPane.YES_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 if(doYouWantBoundaryValuesBoolean == JOptionPane.YES_OPTION) {
								 myWriter.write("// Below are the boundary tests for the type float \n"); 
			 						
								 
									// Loop to generate boundary tests
									 for (int i = 0; i < 2; i++) {
										    float[] newFloatValue = randomFloat(dynamicMethod); 
										    myWriter.write("@Test \n");
										    myWriter.write("public void " + "BoundaryTest" + (i + 1) + "() { \n");
										    myWriter.write("	// variables initialized \n");

										    float floatValue = 0.0f;
										    for (int j = 0; j < newFloatValue.length; j++) {
										        floatValue = boundaryValueForFloat();
										        myWriter.write("	float floatVariable" + (j + 1) + " = " + floatValue + "f;\n");
										    }

										    myWriter.write("	// do something with the variables \n");
										    myWriter.write("	" + returnType + " ans = " + ans + "\n");
										    myWriter.write("	// check if the answer is correct\n");
										    myWriter.write("	assertEquals" + "(" + floatValue + ", " + "ans" + ", " + "0.0001" + ");\n");
										    myWriter.write("}\n");
										}
									 myWriter.write("}"); 
							 }
							 else {
								 // do nothing....
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
								    String variableName = "booleanVariable" + (i + 1);
								    
		
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
			 								);
								 
								 
								 for(int i=1; i<=enteredValue; i++) {
						    			
									    boolean[] callBooleanMethod = randomBoolean(dynamicMethod);
									    String arrayString = Arrays.toString(callBooleanMethod);
									    arrayString = arrayString.substring(1, arrayString.length() - 1);
									    
										StringBuilder variableAssignments11 = new StringBuilder();

										for (int j = 0; j < callBooleanMethod.length; j++) {
									        boolean value = callBooleanMethod[j];
									        String variableName = "booleanVariable" + (j + 1);
									        variableAssignments11.append(returnType).append(" ").append(variableName).append(" = ").append(value).append(";\n");
										}
						    			 
						    			 String q = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these boolean values: " + arrayString + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);

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
								 } 
							 
							
							 int doYouWantBoundaryValuesBoolean = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					    
							 if(response == JOptionPane.NO_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(response == JOptionPane.YES_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 if(doYouWantBoundaryValuesBoolean == JOptionPane.YES_OPTION) {
								 
								 myWriter.write("// Below are the boundary tests for the type boolean \n"); 
			 						
								 
								// Loop to generate boundary tests
								 for (int i = 0; i < 2; i++) {
									    boolean[] newboolValue = randomBoolean(dynamicMethod); 
									    myWriter.write("@Test \n");
									    myWriter.write("public void " + "Boundarytest" + (i + 1) + "() { \n");
									    myWriter.write("	// variables initialized \n");

									    
									    for (int j = 0; j < newboolValue.length; j++) {
									        boolean boolValue = boundaryValueForBoolean();
									        myWriter.write("	boolean booleanVariable" + (j + 1) + " = " + boolValue + ";\n");
									    }

									    myWriter.write("	// do something with the variables \n");
									    myWriter.write("	" + returnType + " ans = " + ans + "\n");
									    myWriter.write("	// check if the answer is correct\n");
									    myWriter.write("	assertEquals" + "(" + convertBoolean + ", " + "ans" + ");\n");
									    myWriter.write("}\n");
									}
								 myWriter.write("}");
							 }
							 else {
								 //do nothing....
							 }	
					    }
					    
					    
					    
					    
					    
					    if(returnType.equals(int.class)) {
					    	
					    	// data stores int's
						    String data = randomTestData(method);
						    
						    String testerQuestion = JOptionPane.showInputDialog(null, "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these int values: " + data + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
							int convertInt = Integer.parseInt(testerQuestion);
					    
						    // Split the data string into parts
							String[] parts = data.split(", ");
		
							StringBuilder methodCall = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
							StringBuilder variableAssignments = new StringBuilder();
		
							 for (int i = 0; i < parts.length; i++) {
								    int number = Integer.parseInt(parts[i].trim());
								    							    
								    // Construct variable name
								    String variableName = "intVariable" + (i + 1);
		
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
								 String ans = methodCall.toString();
					    

	    	        
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
			 								+ "	assertEquals" + "(" + convertInt + ", " + "ans" + ");  \n"								
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
				                    	
	
				                    	String question2 = JOptionPane.showInputDialog(null, "This is Test " + i + "\n" + "Return type is: " + returnType + "\n" + "Method you picked: " + selectedText + "\n" + "What should be the expected result from these int values: " + newNums + "?", "Provide Expected Result for Test " + i,  JOptionPane.QUESTION_MESSAGE);
	
			 	     	                
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
	        							    String variableName2 = "intVariable" + (j + 1);
	
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
	            							 String ans2 = methodCall.toString();
	                					
	            							 
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
			 								+ "	assertEquals" + "(" + convertInt + ", " + "ans" + ");  \n"								
			 								+ "	} \n"
			 								);	      	 
		                     }
		                     
							 int doYouWantBoundaryValuesBoolean = JOptionPane.showConfirmDialog(null, "Do you want to have boundary values?", "Boundary Value Testing",
		                             JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	
					    
							 
							 if(yORn == JOptionPane.NO_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 
							 if(yORn == JOptionPane.YES_OPTION && doYouWantBoundaryValuesBoolean == JOptionPane.NO_OPTION) {
								 myWriter.write("}");
							 }
							 
							 
							 
							 if(doYouWantBoundaryValuesBoolean == JOptionPane.YES_OPTION) {
								 myWriter.write("// Below are the boundary tests for the type int \n"); 
			 						
								 
								// Loop to generate boundary tests
								 for (int i = 0; i < 2; i++) {
									    int[] newIntValue = random(dynamicMethod);
									    myWriter.write("@Test \n");
									    myWriter.write("public void " + "BoundaryTest" + (i + 1) + "() { \n");
									    myWriter.write("	// variables initialized \n");
	
									    int value = 0;
									    for (int j = 0; j < newIntValue.length; j++) {
									        value = boundaryValueForInt(); 
									        myWriter.write("	int intVariable" + (j + 1) + " = " + value + ";\n");
									    }
	
									    myWriter.write("	// do something with the variables \n");
									    myWriter.write("	" + returnType + " ans = " + ans + "\n");
									    myWriter.write("	// check if the answer is correct\n");
									    myWriter.write("	assertEquals" + "(" + value + ", " + "ans" + ");\n");
									    myWriter.write("}\n");
								 }
								 myWriter.write("}"); 
							 }
							 else {
								 //do nothing....
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
	
	
	
	
	 public static int[][] generateArrays(Method method) {
	        if (method != null) {
	            int para = method.getParameterCount();
	            int[][] arrays = new int[para][]; // Initialize outer array with para elements
	            Random rand = new Random();
	            for (int i = 0; i < para; i++) {
	                // Initialize each inner array with 5 elements
	                arrays[i] = new int[2];
	                for (int j = 0; j < 2; j++) {
	                    // Generate random non-zero numbers
	                    arrays[i][j] = rand.nextInt(120); // Adjust the range as needed
	                }
	            }
	            return arrays;
	        } else {
	            return null;
	        }
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


	
	
	public String arrayToString(int[] array) {
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < array.length; i++) {
	        sb.append(array[i]);
	        if (i < array.length - 1) {
	            sb.append(", ");
	        }
	    }
	    return sb.toString();
	}

	 
	 
	 public static String[] generateRandomString(Method method) {
	        Random rand = new Random();
	        int para = method.getParameterCount();
	        String[] randomParameters = new String[para];

	        System.out.println("generateRandomString method has been called");
	        for (int i = 0; i < para; i++) {
	            int length = 2; // Length of the random string
	            StringBuilder randomStringBuilder = new StringBuilder();
	            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	            for (int j = 0; j < length; j++) {
	                int randomIndex = rand.nextInt(characters.length());
	                char randomChar = characters.charAt(randomIndex);
	                randomStringBuilder.append(randomChar);
	            }
	            randomParameters[i] = randomStringBuilder.toString();
	            System.out.println("String " + i + ": " + randomParameters[i]);
	        }
	        return randomParameters;
	    }
	 
	 
	 
	 
	 public static char[] generateRandomChar(Method method) {
	        Random rand = new Random();
	        int para = method.getParameterCount();
	        char[] randomParameters = new char[para];

	        System.out.println("generateRandomChar method has been called");
	        for (int i = 0; i < para; i++) {
	            int length = 12; // Length of the random string
	            StringBuilder randomStringBuilder = new StringBuilder();
	            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	            for (int j = 0; j < length; j++) {
	                int randomIndex = rand.nextInt(characters.length());
	                char randomChar = characters.charAt(randomIndex);
	                randomStringBuilder.append(randomChar);
	            }
	            randomParameters[i] = randomStringBuilder.charAt(0);
	            System.out.println("Character " + i + ": " + randomParameters[i]);
	        }
	        return randomParameters;
	    }
	

	 
	
	//////////// Methods for overwriting and appending to a file////////////
	public static String timeStamp() {
		 // Get the current timestamp in UTC
        Instant now = Instant.now();

        // Convert the timestamp to Ireland's time zone
        ZoneId irelandZone = ZoneId.of("Europe/Dublin");
        ZonedDateTime nowInIreland = ZonedDateTime.ofInstant(now, irelandZone);

        // Format the date and time
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Extract and print the date and time separately
        String date = nowInIreland.format(dateFormatter);
        String time = nowInIreland.format(timeFormatter);
        
        date = date.replace("-", "");
        time = time.replace(":", "");
        
        return "Date" + date + "Time" + time;
	}
	

    // Method to write content to the file
    public static void writeContent(String filePath, String packageName, String imports, String className) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write("package " + packageName + ";");
            writer.newLine();
            writer.write(imports);
            writer.newLine();
            writer.write("public class " + className + "{");
            writer.newLine();
        }
    }
	//////////// Methods for overwriting and appending to a file////////////
    
    
    
    
    /////////// Below are my method for my boundary value tests////////////
    public static boolean boundaryValueForBoolean() {
	    Random rand = new Random();
	    return rand.nextBoolean();
	}
	

	public static int boundaryValueForInt() {
	    Random rand = new Random();
	    return rand.nextInt(3) - 1; // Returns a random number between -1 and 1 (inclusive)
	}
	
	
	public static long boundaryValueForLong() {
	    Random rand = new Random();
	    return rand.nextLong(3) - 1; // Returns a random number between -1 and 1 (inclusive)
	}

	
	
	public static float boundaryValueForFloat() {
	    Random rand = new Random();
	    float[] allowedValues = {-0.1f, 0.0f, 0.1f};
	    int randomIndex = rand.nextInt(allowedValues.length);
	    return allowedValues[randomIndex];
	}

	

	public static double boundaryValueForDouble() {
	    Random rand = new Random();
	    double[] allowedValues = {-0.1, 0.0, 0.1};
	    int randomIndex = rand.nextInt(allowedValues.length);
	    return allowedValues[randomIndex];
	}

    
    
	
	///// methods to test my code on //////
    public static int Addition(int num1, int num2, int num3, int num4) {
        return num1 + num2 + num3 + num4;
    }
    
    
    
    public static int Subtraction(int num1, int num2, int num3) {
        return num1 - num2 - num3;
    }
    
    
    public static int Multiply(int num1, int num2) {
    	return num1 * num2;
    }
    
    
    
    public static int Divide(int num1, int num2, int num3) {
    	return num1 / num2 / num3;
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
    
    public static boolean isBoolean(boolean yes, boolean no) {
    	return yes && no;
    }
    
    
    public static float addingFloatNumbersTogether(float a, float b) {
    	return a + b;
    }
    
    
    public static double addDoubleNumbersTogether(double one, double two) {
    	return one + two;
    }
    
    public static long addLongNumbersTogether(long num1, long num2) {
    	return num1 + num2;
    }
    
    
    
    public static float divideFloatNumbers(float number1, float number2) {
    	return number1 / number2;
    }
    
    
    public static String thisIsAString(String a, String b, String c, String d) {
    	return a + b + c + d; 
    }
    
    
    public static char thisIsAChar(char name) {
    	return name;
    }
     
    
    public static int[] addArrays(int[] arr1, int[] arr2) {
        // Check if both arrays have the same length
        if (arr1.length != arr2.length) {
            throw new IllegalArgumentException("Arrays must have the same length");
        }
        
        int[] result = new int[arr1.length];
        
        // Add corresponding elements from arr1 and arr2
        for (int i = 0; i < arr1.length; i++) {
            result[i] = arr1[i] + arr2[i];
        }
        
        return result;
    }
    
}