package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;


public class Project{
	
	private String projectName;
	private String customerName;
	private String greenManagerName;
	private String greenManagerPhone;
	private String cusManagerName;
	private String cusManagerPhone;
	private Calendar calendarStart;
	private Calendar calendarEnd;
	private double budget;
	private Stage[] listStages;
	private DateFormat formatter;
	

	public Project(String projectName, String customerName,Calendar initialDate, Calendar finalDate , double budget,String greenManagerName, String greenManagerPhone, String cusManagerName, String cusManagerPhone){
		
		this.formatter = new SimpleDateFormat("dd/M/yy");

		this.projectName = projectName;	
		this.customerName = customerName;
		this.budget = budget; 
		this.greenManagerName = greenManagerName;
		this.greenManagerPhone = greenManagerPhone;
		this.cusManagerName = cusManagerName;
		this.cusManagerPhone = cusManagerPhone;
		listStages = new Stage[6];
		
		
        Calendar startPlannedDate = Calendar.getInstance();
        Calendar finalPlannedDate = Calendar.getInstance();
        Calendar startRealDate = Calendar.getInstance();
        Calendar finalRealDate = Calendar.getInstance();

		listStages[0] = new Stage(Phase.START_UP,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.ACTIVE);
        listStages[1] = new Stage(Phase.ANALYSIS,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.INACTIVE);
        listStages[2] = new Stage(Phase.DESIGN,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.INACTIVE);
        listStages[3] = new Stage(Phase.EXECUTION,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.ACTIVE);
        listStages[4] = new Stage(Phase.FOLLOW_UP,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.INACTIVE);
        listStages[5] = new Stage(Phase.CLOSING,startPlannedDate, finalPlannedDate, startRealDate, finalRealDate, State.INACTIVE);
	}	
	public Stage[] getliStages() {
		return listStages;
	}

	public String getProjectName(){
		return projectName;
	}
	
	public String getCustomerName(){
		return customerName;
	}
	
	public String getGreenManagerName() {
		return greenManagerName;
	}
	public void setGreenManagerName(String greenManagerName) {
		this.greenManagerName = greenManagerName;
	}
	public String getGreenManagerPhone() {
		return greenManagerPhone;
	}
	public void setGreenManagerPhone(String greenManagerPhone) {
		this.greenManagerPhone = greenManagerPhone;
	}
	public String getCusManagerName() {
		return cusManagerName;
	}
	public void setCusManagerName(String cusManagerName) {
		this.cusManagerName = cusManagerName;
	}
	public String getCusManagerPhone() {
		return cusManagerPhone;
	}
	public void setCusManagerPhone(String cusManagerPhone) {
		this.cusManagerPhone = cusManagerPhone;
	}
	public double getBudget(){
		return budget;
	}
	public Calendar getCalendarStart(){
		return calendarStart;
	}
	
	public String getInitialDateFormated() throws ParseException{
		return formatter.format(this.calendarStart.getTime());
	}

	public Calendar getCalendarEnd(){
		return calendarEnd;
	}

	public String getFinalDateFormated() throws ParseException{
		return formatter.format(this.calendarEnd.getTime());
	}		

	public Calendar addDaysCalendar (Calendar calendaron, int days) {
		calendaron.add(Calendar.DAY_OF_YEAR, days);
		return calendaron;
	}

	public String getProjectInfo() throws ParseException{
		String msg = "";

		msg = "\nName: " + projectName + "\nClient: " + customerName + "\nInitial Date: " + getInitialDateFormated() + 
		"\nFinal Date: " + getFinalDateFormated() + "\nTotalBudget: " + budget + ".\n";
		
		return msg;
	}
	public int getActiveStage(){
        int nActive=-1;
        for(int i=0; i<listStages.length;i++){
            if(listStages[i].getState()==State.ACTIVE){
                nActive=i;  
                return nActive;
            }
          
        }
        return nActive;
        
    }
	public String toStringProject() throws ParseException{
		String msg="";
		msg ="Nombre del proyecto: "+ projectName + "\nNombre del cliente: " + customerName + "\nFecha planeada inicio: "+ getInitialDateFormated() +"\nFecha planeada fin: "+ getFinalDateFormated()+"\nPresupuesto proyecto: "+ budget+ "\nNombre gerente Green: "+ greenManagerName+"\nTelefono gerente Green: "+greenManagerPhone+"\nNombre gerente cliente: "+cusManagerName+"\nTelefono gerente cliente: "+cusManagerPhone;
		return msg;
	}
}


