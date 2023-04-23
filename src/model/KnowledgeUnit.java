package model;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
/**
 * The class that have the information of the knowledge units and interacts with Controller.
 */
public class KnowledgeUnit {
	private DateFormat formatter;
	private String id;
	private String description;
	private Type type;
	private String learnedLessons;
	private Status status;
	private String colaboratorName;
	private String charge;
	private Calendar dateProject;
	private String projectUnit ;
	private String Publish;
	private String URL;
	/**
	 * The method that register a new knowledge Unit
	 * @param id String
	 * @param description String
	 * @param type String
	 * @param learnedLessons String
	 */
	public KnowledgeUnit(String id, String description, Type type, String learnedLessons, String colaboratorName, String charge, Status Status, Calendar dateProject,String projectUnit, String Publish, String URL) {

		this.id = id;
		this.description = description;
		this.type = type;
		this.learnedLessons = learnedLessons;
		this.status = Status;
		this.colaboratorName = colaboratorName;
		this.charge=charge;
		this.dateProject=dateProject;
		this.projectUnit=projectUnit;
		this.URL=URL;
		this.Publish=Publish;

		this.formatter = new SimpleDateFormat("dd/MM/yyyy");
	}
	/**
	 * The method that gets the information of id.
	 * @return id String
	 */
	public String getId() {
		return id;
	}
	/**
	 * The method that sets the information of id.
	 * @param id String
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * The method that gets the information of description.
	 * @return description String
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * The method that sets the information of description.
	 * @param description String
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * The method that gets the information of learned lessons.
	 * @return learnedLessons String
	 */
	public String getLearnedLessons() {
		return learnedLessons;
	}
	/**
	 * The method that sets the information of learned lessons.
	 * @param learnedLessons String
	 */
	public void setLearnedLessons(String learnedLessons) {
		this.learnedLessons = learnedLessons;
	}
	/**
	 * The method that gets the information of status.
	 * @return status Strings
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * The method that sets the information of status.
	 * @param status String
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public String getURL(String URL){
		return URL;
	}

	public void setURL(String URL){
		this.URL=URL;
	}

	public String getPublish(){
		return Publish;
	}

	public void setPublish(String Publish){
		this.Publish=Publish;
	}

	public String getProjectUnit(String projectUnit){
		return projectUnit;
	}

	public void setProjectUnit(String projectUnit){
		this.projectUnit=projectUnit;
	}

	public String getColaboratorName() {
		return colaboratorName;
	}

	public void setColaboratorName(String colaboratorName) {
		this.colaboratorName = colaboratorName;
	}


	public String getCharge(){
		return charge;
	}

	public void setCargo(String Charge){
		this.charge=Charge;
	}
	public void setDateProject(Calendar dateProject) {
		this.dateProject = dateProject;
	}
	public Calendar getDateProject(){
		return getDateProject();
	}

	public String getDateProjectFormated(){
		return formatter.format(this.dateProject.getTime());
	}

	public void setDateProjectFormated(Calendar dateProject){
		this.dateProject=dateProject;
	}
	
	public String toStringU(){
		String msg="";
		msg ="Proyecto: "+projectUnit+"\nIdentificador: "+ id + "\nDescripion: " + description+ "\nTipo: "+ type+"\nAprendizaje obtenido:"+learnedLessons+"\nEstado: "+status+"\nNombre del colaborador: "+colaboratorName+"\nCargo del colaborador: "+charge;
		return msg;
	}

	public String toStringUM(){
		String msg="";
		msg ="Project: "+projectUnit+"\nPublicate: "+Publish+"\nURL: "+URL+"\n"+"\n-ID: "+ id + "\nDescription: " + description+ "\n-Type: "+ type+"\nLearned Lessons:"+learnedLessons+"\n-Status: "+ status+"\nColaborator Name: "+ colaboratorName+"\n-Charge: "+charge+"\nApprove date: "+getDateProjectFormated();
		return msg;
	}
	
	public String toStringUMm(){
		String msg="";
		msg ="Project: "+projectUnit+"\nPublicate: "+Publish+"\nID: "+ id+ "\nType: "+ type +"\nStatus: "+status+"\n";
		return msg;
	}

	public String toStringUMmF(){
		String msg="";
		msg ="Project: "+projectUnit+"\nPublicate: "+Publish+"\nURL: "+URL+"\nID "+ id+ "\nType "+ type+"\nStatus "+ status +"\nApprove Date: "+getDateProjectFormated();
		return msg;
	}
	public String getProjectUnit() {
		return projectUnit;
	}
	
}


	
	

