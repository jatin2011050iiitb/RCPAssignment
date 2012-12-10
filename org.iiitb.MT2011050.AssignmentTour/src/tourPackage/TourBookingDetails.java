package tourPackage;

import java.util.Vector;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;

public class TourBookingDetails extends WizardPage {

	private DateTime travelDate;
	private Composite container;
	private ListViewer agentListViewer;
	
	private Label travelDateLabel;
	private Label agentNameLabel;
	
	private String agentSelected;
	private String dateSelected;
	
	private boolean dateFlag;
	private boolean agentFlag;
	
	protected TourBookingDetails(String pageName) {
		super(pageName);
		// TODO Auto-generated constructor stub
		setTitle("MT2011050 - Tour Booking Page");
		setDescription("Please Enter you Date and Agent Details here");	
		
		
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
		
		travelDateLabel = new Label(container, SWT.NONE);
		travelDateLabel.setText("Select your Travel Date");
		
		travelDate = new DateTime(container, SWT.CALENDAR);
		travelDate.addSelectionListener(new SelectionAdapter(){

			/* (non-Javadoc)
			 * @see org.eclipse.swt.events.SelectionAdapter#widgetSelected(org.eclipse.swt.events.SelectionEvent)
			 */
			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				if(travelDate.getEnabled()){
					dateFlag = true;
					
					dateSelected = travelDate.getDay()+"-"+travelDate.getMonth()+"-"+travelDate.getYear();
				}
				
				if(dateFlag == true && agentFlag == true){
					setPageComplete(true);
				}
				
			}
			
			
			
		});
		
		
		
		agentNameLabel = new Label(container, SWT.NONE);
		agentNameLabel.setText("Select agent for Booking");
		
		Vector<String> agents = new Vector<>();
		agents.add("IRCTC");
		agents.add("ClearTrip");
		agents.add("MakeMyTrip");
		agents.add("Yatra.com");
		agents.add("Others");
		
		agentListViewer = new ListViewer(container,SWT.SINGLE);
		agentListViewer.setContentProvider(new ArrayContentProvider());
		agentListViewer.setInput(agents);
		
		agentListViewer.addSelectionChangedListener(new ISelectionChangedListener(){

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub
				
				IStructuredSelection selection =(IStructuredSelection) event.getSelection();
				agentSelected = selection.getFirstElement().toString();
				agentFlag = true;
				
				if(dateFlag == true && agentFlag == true){
					setPageComplete(true);
				}
				
			}
			
		});
		
		
		setPageComplete(true);
	}

	/**
	 * @return the agentSelected
	 */
	public String getAgentSelected() {
		return agentSelected;
	}

	/**
	 * @return the dateSelected
	 */
	public String getDateSelected() {
		return dateSelected;
	}

}
