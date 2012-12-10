package tourPackage;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class TourNamePage extends WizardPage {

	private Text tourNameText;
	private Label tourNameLabel;
	private Composite container;
	
	
	public TourNamePage(String pageName) {
		super(pageName);
		setTitle("MT2011050 - Tour Wizard");
		setDescription("This Wizard will guide you through a tour plan");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		
		container = new Composite(parent, SWT.NULL);
		setControl(container);
		
		//Setting the layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		
		container.setLayout(gridLayout);
		
		//Setting label and text fields
		
		tourNameLabel = new Label(container,SWT.NONE);
		tourNameLabel.setText("Tour Name :");
		
		tourNameText = new Text(container, SWT.BORDER|SWT.SINGLE);
		tourNameText.setToolTipText("Enter the Tour Name here");
		tourNameText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (tourNameText.getText().isEmpty() == false) {
					setPageComplete(true);
					System.out.println(tourNameText.getText());
				}
				else
					setPageComplete(false);
			}
			
		});
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		tourNameText.setLayoutData(gd);
		
		setPageComplete(false);
		

	}

	/**
	 * @return the tourNameText
	 */
	public String getTourNameText() {
		return tourNameText.getText();
	}

	
	

	

}
