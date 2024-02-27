package rightClickMe;

import java.lang.reflect.Method;
import java.util.Random;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.texteditor.ITextEditor;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;


public class selectText extends AbstractHandler {
	
	@Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
	
        ITextEditor editor = (ITextEditor) HandlerUtil.getActiveEditor(event);
        if (editor != null) {
            ISelection selection = editor.getSelectionProvider().getSelection();
            if (selection instanceof ITextSelection) {
                ITextSelection textSelection = (ITextSelection) selection;
                //IDocument document = editor.getDocumentProvider().getDocument(editor.getEditorInput());
                String selectedText = textSelection.getText();
                
                // Now you have the selected text, you can display it or use it as needed                
                MessageDialog.openInformation(null, 
                		"You have clicked on", 
                		selectedText
                		);
                }            
            }
        return null;
	}



	
	
	public static int[] random(Method method) {
    	Random rand = new Random();
		int para2 = method.getParameterCount();
		int[] randomParameters = new int[para2];
		
	
		for(int i = 0; i < para2; i++) {
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

	
	
	
	
    public static int add(int num1, int num2) {
        return num1 + num2;
    } 
    
    
}

