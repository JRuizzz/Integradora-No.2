package model;

import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class Controller {

	private Project[] projects;

	public Controller() {

		projects = new Project[10];
	
	}

	public boolean RegisterProject(String projectName, String customerName, int startDay, int startMonth, int startYear,int finishDay, int finishMonth, int finishYear, double budget,String greenManagerName, String greenManagerPhone, String cusManagerName, String cusManagerPhone) {
		Calendar initialDate =	newDate(startDay,startMonth, startYear);
        Calendar finalDate=	newDate(finishDay, finishMonth, finishYear);

		Project newProject = new Project(projectName, customerName,initialDate,finalDate,budget,greenManagerName,greenManagerPhone,cusManagerName, cusManagerPhone);
		
		for(int i = 0; i<projects.length;i++){
			if(projects[i]==null){
				projects[i] = newProject;
				return true;
			}
		}
		return false;
	}
	public static Calendar newDate(int dayDate, int monthDate, int yearDate){
        Calendar fecha = new GregorianCalendar(dayDate,monthDate,yearDate);
        return fecha;
    }

	public String showProjects() throws ParseException{
        String msg="";
        for (int i=0; i<projects.length;i++){
            if(projects[i] == null){
				return msg;
			} else {
				msg +="\n"+(i+1)+". "+ projects[i].toStringProject();
			}
			} 
            return msg;
        }
        

    public boolean editStage(int opcionStage, int meses){
            
		boolean indicador3=false;
    
            if(indicador3==false){
                int StageActive=projects[opcionStage].getActiveStage();
                Calendar mesI=projects[opcionStage].getliStages()[StageActive].getStartPlannedDate();
                Calendar mesF=new GregorianCalendar();
                mesF.setTime(mesI.getTime());
                mesF.add(Calendar.MONTH, meses);
                projects[opcionStage].getliStages()[StageActive].setFinalPlannedDate(mesF);
    
                indicador3=true;
            }
    
            return indicador3;
    
    }
    
    public boolean CulminateStage(int opcionStage, int dateDIR, int dateMIR, int dateAIR, int dateDFR,int dateMFR, int dateAFR){
        boolean indicador4=false;
            
    
        Calendar newStartRealDate= newDate(dateDIR, dateMIR,dateAIR);
        
		Calendar newFinalRealDate = newDate(dateDFR, dateMFR,dateAFR);
    
        if (indicador4==false){
            int StageActive=projects[opcionStage].getActiveStage();
            projects[opcionStage].getliStages()[StageActive].setStartPlannedDate(newStartRealDate);
            projects[opcionStage].getliStages()[StageActive].setFinalPlannedDate(newFinalRealDate);
            projects[opcionStage].getliStages()[StageActive].setState(State.INACTIVE);
            projects[opcionStage].getliStages()[StageActive+1].setState(State.ACTIVE);
            indicador4=true;
        }

        return indicador4;
    }
        
    public String showStagesActive(int opcionStage){
        String msg="";
               
        int StageActive=projects[opcionStage].getActiveStage();
        msg=projects[opcionStage].getliStages()[StageActive].toStringStage();
       
        return msg;
       }
    
       public String showLastStages(int opcionStage){
           String msg="";
           int StageActive=projects[opcionStage].getActiveStage();
           msg=projects[opcionStage].getliStages()[StageActive-1].toStringStage();
    
           return msg;
       }

       public String showStagesHistorial(int opcionStage){
            String msg="";
            int StageActive=projects[opcionStage].getActiveStage();
            for (int i=0;i<StageActive+1;i++){
                msg+="\n"+(i+1)+"."+projects[opcionStage].getliStages()[i].toStringStage();
            }
            return msg;
       }
 

    public boolean registerUnit(String id, String description, int type, String learnedLessons, String colaboratorName, String charge, int opcionProject) {
        Project unit=projects[opcionProject];
        String projectUnit=unit.getProjectName();
		String URL="None";
		String Publicate="NO";
        boolean indicador5=false;
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50;i++){
            if (projects[opcionProject].getliStages()[StageActive].getUnits()[i]==null){
                if(type==1){
                    projects[opcionProject].getliStages()[StageActive].getUnits()[i]=new KnowledgeUnit(id, description, Type.TECHNICAL, learnedLessons, colaboratorName, charge ,Status.TO_BE_DEFINED, Calendar.getInstance(), projectUnit, Publicate, URL);
                } else if(type==2){
                    projects[opcionProject].getliStages()[StageActive].getUnits()[i]=new KnowledgeUnit(id, description, Type.EXPERIENCES, learnedLessons, colaboratorName, charge ,Status.TO_BE_DEFINED, Calendar.getInstance(), projectUnit, Publicate, URL);
                }else if(type==3){
                    projects[opcionProject].getliStages()[StageActive].getUnits()[i]=new KnowledgeUnit(id, description, Type.MANAGEMENT, learnedLessons, colaboratorName, charge ,Status.TO_BE_DEFINED, Calendar.getInstance(), projectUnit, Publicate, URL);
                }else{
                    projects[opcionProject].getliStages()[StageActive].getUnits()[i]=new KnowledgeUnit(id, description, Type.DOMAIN, learnedLessons, colaboratorName, charge ,Status.TO_BE_DEFINED, Calendar.getInstance(), projectUnit, Publicate, URL);
                }
                indicador5=true;
                return indicador5;
            }
            
        }
   
		
		return indicador5;
	}

    public String showAllUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (projects[opcionProject].getliStages()[StageActive].getUnits()[i]==null){
                return msg;
            }else{
                msg+="\n"+(i+1)+"."+projects[opcionProject].getliStages()[StageActive].getUnits()[i].toStringUMm();
            }
        }
        return msg;
    }
    
    public String showLastUnit(int opcionProject){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        for (int i=0; i<50; i++){
            if (i>0 && projects[opcionProject].getliStages()[StageActive].getUnits()[i]==null){
                msg+=projects[opcionProject].getliStages()[StageActive].getUnits()[i-1].toStringU();
                return msg;
            }
        }
        return msg;
    }

    public String showUnitSelect(int opcionProject, int numUnit){
        String msg="";
        int StageActive=projects[opcionProject].getActiveStage();
        msg=projects[opcionProject].getliStages()[StageActive].getUnits()[numUnit].toStringUMmF();
        return msg;
    }

    public boolean approveKnowledgeUnit(int opcionProject, int opcionStage,int numUnit ) {
		boolean indicador=false;
        
        if(indicador==false){
            projects[opcionProject].getliStages()[opcionStage].getUnits()[numUnit].setStatus(Status.APPROVED);
            projects[opcionProject].getliStages()[opcionStage].getUnits()[numUnit].setDateProject(Calendar.getInstance());
            indicador=true;
        }

        return indicador;
	}

    public boolean publishKnowledgeUnit(int opcionProject, int opcionStage, int numUnit, String URL){
        boolean indicador=false;
        if(indicador==false){
            projects[opcionProject].getliStages()[opcionStage].getUnits()[numUnit].setURL(URL);
            projects[opcionProject].getliStages()[opcionStage].getUnits()[numUnit].setPublish("-SI");
            
            indicador=true;
        }
       return indicador;
    }

    public String showLastpublisUnit(int opcionProject, int opcionStage){
        String msg="";
        for(int i=0; i<50; i++){
            if(projects[opcionProject].getliStages()[opcionStage].getUnits()[i]==null){
                return msg;
            }else{
                String consulta=projects[opcionProject].getliStages()[opcionStage].getUnits()[i].getPublish();
                if(consulta.equals("-SI")){
                    msg=projects[opcionProject].getliStages()[opcionStage].getUnits()[i].toStringUMmF();
                }
            }
        }
        return msg;
    }

    public String showApproveUnit(int opcionProject, int opcionStage){
        String msg="";
        boolean indicador=false;
        if(indicador==false){
            for(int i=0; i<50; i++){
                if(projects[opcionProject].getliStages()[opcionStage].getUnits()[i]==null){
                    return msg;
                }else if(projects[opcionProject].getliStages()[opcionStage].getUnits()[i].getStatus()==Status.APPROVED){
                    msg+=(i+1)+". "+projects[opcionProject].getliStages()[opcionStage].getUnits()[i].toStringUMmF();
                }else{
                    return msg;
                }     
            }
            indicador=true;
        }
        return msg;
    }


    public String searchPSU(String wordSearch){
        String msg="";
        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getliStages()[j].getUnits()[s]!=null){
                                if(projects[i].getliStages()[j].getUnits()[s].getDescription().contains(wordSearch)){
                                    msg+="\nWord founded \n";
                                    msg+="Proyect: "+projects[i].getProjectName()+"\n";
                                    msg+="Stage: "+projects[i].getliStages()[j].getStagePhase()+"\n";
                                    msg+="ID: "+projects[i].getliStages()[j].getUnits()[s].getId()+"\n";
                                }
                            }
                        }
                    }
                    
        
                } 
        }
    
        return msg;
    }

    public String numberTypeUnit(){
        String msg="";
        int ContadorT=0;
        int ContadorG=0;
        int ContadorD=0;
        int ContadorE=0;

        for(int i=0; i<projects.length; i++){
            if(projects[i]!=null){
                for (int j=0; j<6;j++){
                        for(int s=0; s<50;s++){
                            if(projects[i].getliStages()[j].getUnits()[s]!=null){
                                if(projects[i].getliStages()[j].getUnits()[s].getType()==Type.TECHNICAL){
                                   ContadorT++;
                                }else if(projects[i].getliStages()[j].getUnits()[s].getType()==Type.MANAGEMENT){
                                    ContadorG++;
                                }else if(projects[i].getliStages()[j].getUnits()[s].getType()==Type.EXPERIENCES){
                                    ContadorE++;
                                }else if(projects[i].getliStages()[j].getUnits()[s].getType()==Type.DOMAIN){
                                    ContadorD++;
                                }

                                msg+="\nCantidad Tipo de Capsulas creadas\n";
                                msg+="-Tecnico: "+ContadorT+"\n";
                                msg+="-Gestion: "+ContadorG+"\n";
                                msg+="-Dominio: "+ContadorD+"\n";
                                msg+="-Experiencias: "+ContadorE+"\n";
                            }
                        }
                    }
                    
        
                } 
        }
    
        return msg;
    }
}