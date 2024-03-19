package rightClickMe;

import java.io.File;
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
	    
    public static String selectedText;
    
//    public static int sumOfRandomValues;	
    
    	
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
				
					    
//				    String num = ""; 
				    
				    String data = randomTestData(method);
	
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
						    variableAssignments.append("int ").append(variableName).append(" = ").append(number).append(";\n");
						}
						 methodCall.append(");");
	
						 // Combine everything
						 String ans = methodCall.toString();// + "\n" + variableAssignments.toString();
					
						 

						 
				    
	                String testerQuestion = JOptionPane.showInputDialog(null, "Method you picked: " + selectedText + "\n" + "What should be the expected result from these numbers: " + data + "?", "Provide Expected Result",  JOptionPane.QUESTION_MESSAGE);
//	                JOptionPane.showMessageDialog(null, "A test has been automatically generated.");
	    	        int convert = Integer.parseInt(testerQuestion);	        

	    	        
	    	        
	    	        Package pkg = selectText.class.getPackage();
	    	        String packageName = pkg.getName();
	               
	    	        
	    	        
//	    	        int sum = sumOfRandomValues + 1;
//	    	        
//	    	        JOptionPane.showMessageDialog(null, sum + 1);
	    	        
//	    	        switch (sum) {
//	    	          case 1:
//	    	            if(sum == sum + 0) {
//	    	            	sum += 0;
//	    	            	JOptionPane.showMessageDialog(null, "Passed!");
//	    	            }
//	    	            break;
//	    	          case 2:
//	    	            if(sum == sum + 1) {
//	    	            	sum += 1;
//	    	            	JOptionPane.showMessageDialog(null, "Failed!");
//	    	            }
//	    	        	 break;
//	    	        }
	    	        	    	 
	    	        
//	    	        if(sumOfRandomValues == sumOfRandomValues + 1) {
//	    	        	//fail
//	    	        }
//	    	        else {
//	    	        	//pass
//	    	        }

	    	        


	    	        
	    	       String fileName = "";
	    	       
	    	        try {
	    	        	
	    	        	// need to update my code to NOT OVER-WRITE the file that is made.
	    	        	fileName = "testing" + selectedText + "Method";
	                	FileWriter myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\" + fileName + ".java");
							       
//	                	FileWriter myWriter = new FileWriter("C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\TEST.java");

//	                	String directoryPath = "C:\\Users\\Kylek\\newGBT\\rightClickMe\\src\\rightClickMe\\"; //C:\\TESTDIR
//	                	String filePath = directoryPath + fileName + ".java";
//
//	                	// Create the directory if it does not exist
//	                	File directory = new File(directoryPath);
//	                	if (!directory.exists()){
//	                	    directory.mkdirs();
//	                	    JOptionPane.showMessageDialog(null, "Directory created.");
//	                	} else {
//	                	    JOptionPane.showMessageDialog(null, "Dir already exists");
//	                	}
	                	
	                	
	                	
	                	
	                	
	                	
	                	
	                	
//	    	        	String yORn = JOptionPane.showInputDialog(null, "Do you want to make more than one test? " + "" + ":", "Make Test's",  JOptionPane.QUESTION_MESSAGE);
//
//	    	        	if ("Yes".equalsIgnoreCase(yORn)) {
//	    	        	    // Code to execute if user says "Yes"
//	    	        	    JOptionPane.showMessageDialog(null, "You selected Yes.");
//	    	        	} 
//	    	        	// Checking if the user input is "No"
//	    	        	else if ("No".equalsIgnoreCase(yORn)) {
//	    	        	    // Code to execute if user says "No"
//	    	        	    JOptionPane.showMessageDialog(null, "You selected No.");
//	    	        	} 
	    	        	
	                	
	                	
	                	
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
		 								+ "" + "int ans = " + ans + "\n"
		 															
		 								
		 								
		 								+ "\n"
		 								+ "	//check if the answer is correct\n"										
		 								+ "	assertEquals" + "(" + convert + ", " + "ans" + ");  \n"								
		 								+ "	} \n"
//		 								+"}"
		 								);
	                    	 
	                    	 
	                    	 
	                    	 
	                    	 
	                    	 
	                    	 
	                    	 
	                    	 
                			 //(null, "How many tests do you want to make?" + "Enter a number" + "",  JOptionPane.QUESTION_MESSAGE);
	                  
	                    	 String question = JOptionPane.showInputDialog(
	                    			 null, 
	                    			 "How many tests do you want to make?", 
	                    			 "Enter a number", 
	                    			 JOptionPane.QUESTION_MESSAGE		
	                    			 );
	     
	                    	 
	                    	 int testsToMake = Integer.parseInt(question);

	                		
	                				for(int i=1; i<=testsToMake; i++) {
	                					
	                					
	                					StringBuilder methodCall2 = new StringBuilder(selectText.class.getName() + "." + selectedText + "(");
	            						StringBuilder variableAssignments2 = new StringBuilder();

	            						
	            					    Random randomNumber = new Random();
	            					    int convert2 = convert + randomNumber.nextInt(60); 		
	            					
	            		    	    	int number2 = 0;

	            						 for (int j = 0; j < parts.length; j++) {
	            							 
	            							 	String newLine = "\n";
	            							 	
	            							 	methodCall2.append(newLine);
	            							 
	            							    number2 = Integer.parseInt(parts[j].trim());
	            							    
	            						
	            							    number2 += randomNumber.nextInt(60); 	
	            							    
	            							    
	            							    // Construct variable name
	            							    String variableName2 = "num" + (j + 1);

	            							    // Add to the method call
	            							    if (j > 0) {
	            							        methodCall2.append(", ");
	            							    }
	            							    methodCall2.append(variableName2);

	            							    // Add to variable assignments
	            							    variableAssignments2.append("int ").append(variableName2).append(" = ").append(number2).append(";\n");
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
		    								+ "" + "int ans = " + ans2 + "\n"
		    															
		    								
		    								
		    								
		    								+ "\n"
		    								+ "	//check if the answer is correct\n"										
		    								+ "	assertEquals" + "(" + convert2 + ", " + "ans" + ");  \n"								
		    								+ "	} \n"
//		    									+"}\n"	
//	            							+ "}"
		    								);
//		                				String end = "}";
//		                				myWriter.write(end);
		                				}
	                				String end = "}";
	                				myWriter.write(end);
	                
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
	 								+ "" + "int ans = " + ans + "\n"
	 															
	 								
	 								
	 								+ "\n"
	 								+ "	//check if the answer is correct\n"										
	 								+ "	assertEquals" + "(" + convert + ", " + "ans" + ");  \n"								
	 								+ "	} \n"
//	 								+"}"
	 								);
	                    	 String end2 = "}";
             				 myWriter.write(end2);
	                     }
	    	        	
	    	        	
	    	        	
	    	        	

                		
                		
                		
                		
                		
                		
    	    	        	
                				
                				
                				
                		

	                		
                		
						myWriter.close();
			            JOptionPane.showMessageDialog(null, "Your Java file has been created");			             
	    	         
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
		int para = method.getParameterCount();
		int[] randomParameters = new int[para];
        
	
		for(int i = 0; i < para; i++) {
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

    
//	public static int addRandomValues(int[] randomValues) {
//    int sum = 0;
//    for (int value : randomValues) {
//        sum += value;
//    }
//    return sum;
//}
    
    
    public static int squareNumber(int number) {
        return (int) (number * number);
    }
    
        
}
