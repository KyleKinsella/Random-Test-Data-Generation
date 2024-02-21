package plugin.handlers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import javax.swing.JOptionPane;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class rightCli {
	
	
    public static int add(int num1, int num2) {
    	return num1 + num2;
    }
	
    
    
	public static int[] random(Method method) {
    	Random rand = new Random();
		int para2 = method.getParameterCount();
		int[] randomParameters = new int[para2];
		
	
		for(int i = 0; i < para2; i++) {
			int min = 0;
			int max = 120;
			
			randomParameters[i] = rand.nextInt(max - min + 1) + min;
			//System.out.println("Number " + i + ": " +  randomParameters[i] + " ");
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

	
	
	
	public static String getFileName(String args[]) {
		// Check if a file path is provided as a command-line argument
        if (args.length == 0) {
            String programName = System.getProperty("sun.java.command").split(" ")[0];
            System.out.println("You are currently working in: " + programName);
            return programName;
        }

        // Get the file path from the command-line arguments
        String filePath = args[0];

        try {
            // Create a FileReader object
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap FileReader in BufferedReader for efficient reading
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // Read the file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // Or you can process the line as needed
            }

            // Close the BufferedReader and FileReader
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
		return filePath;
	}
	
	
	
	
    public static void main(String[] args) throws NoSuchMethodException {
        Display display = new Display();

        /// map to every method in the .java file
        Shell shell = new Shell(display);

        shell.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
                // Not used in this example
            }

            @Override
            public void mouseDown(MouseEvent e) {
                if (e.button == 3) { // Right button

                    try {
                    	
                    	String className = getFileName(args);    	
                    	Class<?> testerClass;
						try {
							testerClass = Class.forName(className);
							
							
							 // Get all the declared methods of the tester class
	                        Method[] methods = testerClass.getDeclaredMethods();
	                    	
	                    	
	                        // Loop through the methods and print information
	                        for (Method method : methods) {
	         
	                      		String name = method.getName();
	                            Class<?> returnType = method.getReturnType();
	                            int parameterCount = method.getParameterCount();
	                            
	                            
	                            JOptionPane.showMessageDialog(null, name, "You have right clicked on", JOptionPane.PLAIN_MESSAGE);
	                            
	                            
	    				        String message = "Method name: " + name + "\n" +
		                         "Return type: " + returnType + "\n" +
		                         "Parameters: " + parameterCount; 
	                            
	    				        JOptionPane.showMessageDialog(null, message, "Here is some information", JOptionPane.PLAIN_MESSAGE);

	    				        
	    				        String data = "Method name: " + name + "\n" +
	    						"Generated Random Test Data: " + randomTestData(method);
	    						   
	    				        JOptionPane.showMessageDialog(null, data, "Data you need to know", JOptionPane.PLAIN_MESSAGE);  
	                        }
							
							
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
					} catch (SecurityException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
                }
            }

            @Override
            public void mouseUp(MouseEvent e) {
                // Not used in this example
            }
        });

        shell.setSize(200, 200);
        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }
}
