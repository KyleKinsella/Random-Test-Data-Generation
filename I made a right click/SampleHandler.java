package plugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

public class SampleHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        // Get the active menu selection
        IStructuredSelection selection = HandlerUtil.getCurrentStructuredSelection(event);
        if (selection != null) {
            // Proceed with your logic here
            MessageDialog.openInformation(
                HandlerUtil.getActiveShell(event),
                "Kyle Kinsella - C00273146 - Random Test Data Generation Project",
                "Some Tests have been Generated.");
        }
        return null;
    }
}

