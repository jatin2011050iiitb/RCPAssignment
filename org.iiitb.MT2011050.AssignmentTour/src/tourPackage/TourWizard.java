package tourPackage;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.ui.handlers.HandlerUtil;


public class TourWizard extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		
		WizardDialog dialog = new WizardDialog(HandlerUtil.getActiveShell(event), new TourWizardMain());
		 dialog.open();
		 return null;
	}

}
