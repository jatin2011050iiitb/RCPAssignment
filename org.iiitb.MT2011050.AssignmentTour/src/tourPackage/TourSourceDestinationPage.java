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

public class TourSourceDestinationPage extends WizardPage {

	
	Text sourceNameText;
	Text destinationNameText;
	Text viaPoint1Text;
	Text viaPoint2Text;
	
	Label sourceNameLabel;
	Label destinationNameLabel;
	Label viaPoint1Label;
	Label viaPoint2Label;
	
	Composite container;
	
	
	
	protected TourSourceDestinationPage(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
		setTitle("MT2011050 - Tour Plan Page");
		setDescription("Please Enter you Tour Details here " + '\n' + "(The Via Points are optional)");
	}

	@Override
	public void createControl(Composite parent) {
		// TODO Auto-generated method stub
		
		container = new Composite(parent,SWT.NULL);
		setControl(container);
		
		//Setting the layout
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
				
		container.setLayout(gridLayout);
				
		//Setting label and text fields
		sourceNameLabel = new Label(container, SWT.NONE);
		sourceNameLabel.setText("Enter Source Point");
		sourceNameText = new Text(container, SWT.BORDER|SWT.SINGLE);
		sourceNameText.setToolTipText("Enter the source here");
		sourceNameText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if ((sourceNameText.getText().isEmpty() == false)&& (destinationNameText.getText().isEmpty() == false))   {
					setPageComplete(true);
					System.out.println(sourceNameText.getText() + "              " + destinationNameText.getText());
				}
				else
					setPageComplete(false);
			}
			
		});
		
		
		
		destinationNameLabel = new Label(container, SWT.NONE);
		destinationNameLabel.setText("Enter Destination Point");
		destinationNameText = new Text(container, SWT.BORDER|SWT.SINGLE);
		destinationNameText.setToolTipText("Enter the destination here");
		destinationNameText.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				if ((sourceNameText.getText().isEmpty() == false)&& (destinationNameText.getText().isEmpty() == false))   {
					setPageComplete(true);
					System.out.println(sourceNameText.getText() + "              " + destinationNameText.getText());
				}
				else
					setPageComplete(false);
			}
			
		});
		
		
		
		viaPoint1Label = new Label(container, SWT.NONE);
		viaPoint1Label.setText("Via Point 1:");
		
		viaPoint1Text = new Text(container, SWT.BORDER|SWT.SINGLE);
		viaPoint1Text.setToolTipText("Enter the via point here (optional)");
		
		
		viaPoint2Label= new Label(container, SWT.NONE);
		viaPoint2Label.setText("Via Point 2:");
		
		viaPoint2Text = new Text(container, SWT.BORDER|SWT.SINGLE);
		viaPoint2Text.setToolTipText("Enter the via point here (optional)");
		
		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		sourceNameText.setLayoutData(gd);
		destinationNameText.setLayoutData(gd);
		viaPoint1Text.setLayoutData(gd);
		viaPoint2Text.setLayoutData(gd);
		
		
		
		setPageComplete(false);
	
	}

	
	
	
	
	/**
	 * @return the sourceName
	 */
	public String getSourceNameText() {
		return sourceNameText.getText();
	}

	/**
	 * @return the destinationName
	 */
	public String getDestinationNameText() {
		return destinationNameText.getText();
	}

	/**
	 * @return the viaPoint1
	 */
	public String getViaPoint1Text() {
		return viaPoint1Text.getText();
	}

	/**
	 * @return the viaPoint2
	 */
	public String getViaPoint2Text() {
		return viaPoint2Text.getText();
	}


}
