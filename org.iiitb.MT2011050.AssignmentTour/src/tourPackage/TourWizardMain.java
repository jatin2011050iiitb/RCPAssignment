package tourPackage;

import org.eclipse.jface.wizard.Wizard;

public class TourWizardMain extends Wizard{
	
	
	protected TourNamePage firstPage = null;
	protected TourSourceDestinationPage secondPage = null;
	protected TourBookingDetails thirdPage = null;
	
	
	
	

	/**
	 * 
	 */
	public TourWizardMain() {
		super();
		// TODO Auto-generated constructor stub
		
		setNeedsProgressMonitor(true);
		firstPage = new TourNamePage("Page for Tour Name");
		secondPage = new TourSourceDestinationPage("Page for Source - Destination");
		thirdPage = new TourBookingDetails("Page for Tour Date - Agent Selection");
		
	}

	@Override
	public void addPages() {
		
		addPage(firstPage);
		addPage(secondPage);
		addPage(thirdPage);		
		
	}

	@Override
	public boolean performFinish() {
		// TODO Auto-generated method stub
		
		TourModel tour = new TourModel(firstPage.getTourNameText(),secondPage.getSourceNameText(),secondPage.getDestinationNameText(),secondPage.getViaPoint1Text(),secondPage.getViaPoint2Text(),thirdPage.getDateSelected(), thirdPage.getAgentSelected());
		int result = tour.saveInDatabase();
		String message = "";
		
		if(result == 0){
			
			message = message + "Error in Database. Please check credentials and details in RunTimeSettings" + '\n';
		}
		
		message = message + tour.toString();
		
		System.out.println(message);
		
		
		
		return true;
	}

}
