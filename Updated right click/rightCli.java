package plugin.handlers;


import java.lang.reflect.Method;
import javax.swing.JOptionPane;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class rightCli {
	
    
	
	public static int add(int num1, int num2) {
    	return num1 + num2;
    }
    
    
		
    public static void main(String[] args) {
        Display display = new Display();

        /// map to every method in the .java file
        Shell shell = new Shell(display);

        shell.addMouseListener(new MouseListener() {
            @Override
            public void mouseDoubleClick(MouseEvent e) {
               
            }

            @Override
            public void mouseDown(MouseEvent e) {
                if (e.button == 3) { // Right button
//                    System.out.println("Right click detected.");
                    
                    try {
						Method method = test.class.getMethod("add", int.class, int.class);
						
				        JOptionPane.showMessageDialog(null, method.getName(), "You have right clicked on", JOptionPane.PLAIN_MESSAGE);
						
		
				        String message = "Method name: " + method.getName() + "\n" +
		                         "Return type: " + method.getReturnType() + "\n" +
		                         "Parameters: " + method.getParameterCount();
				        
				        
						//Extract everything
						System.out.println("Method name: " + method.getName());	
			            System.out.println("Return type: " + method.getReturnType());
			            System.out.println("Parameters: " + method.getParameterCount());
			            

				        JOptionPane.showMessageDialog(null, message, "Here is some information", JOptionPane.PLAIN_MESSAGE);

			            
				        String data = "Method name: " + method.getName() + "\n" +
				        "Generated Random Test Data: " + "40, 56";  		//randomTestData(method);
				   
				        JOptionPane.showMessageDialog(null, data, "Data you need to know", JOptionPane.PLAIN_MESSAGE);

				   
				        
				        String testerQuestion = JOptionPane.showInputDialog(null, "What should be the expected result from the previous popup window?", "Provide Expected Result", JOptionPane.QUESTION_MESSAGE);
				        JOptionPane.showMessageDialog(null, testerQuestion);
				        
					} catch (NoSuchMethodException | SecurityException e1) {
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
