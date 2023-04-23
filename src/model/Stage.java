package model;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Stage {

    private Phase stagePhase;
    private DateFormat formatter;
	private Calendar startPlannedDate;
	private Calendar finalPlannedDate;
	private Calendar startRealDate;
	private Calendar finalRealDate;
	private KnowledgeUnit[] units;
	private State state;

	public Stage(Phase stagePhase, Calendar startPlannedDate, Calendar finalPlannedDate,Calendar startRealDate, Calendar finalRealDate, State state) {
		this.stagePhase = stagePhase;
		this.formatter = new SimpleDateFormat("dd/MM/yyyy");
		this.startPlannedDate = startPlannedDate;
		this.finalPlannedDate = finalPlannedDate;
		this.startRealDate = startRealDate;
		this.finalRealDate = finalRealDate;
		this.state= state;
		units = new KnowledgeUnit[50];
	}
	public KnowledgeUnit[] getUnits() {
		return units;
	}
	public Phase getStagePhase() {
		return stagePhase;
	}
	public void setStagePhase(Phase stagePhase) {
		this.stagePhase = stagePhase;
	}

	public Calendar getStartPlannedDate() {
		return startPlannedDate;
	}

	public String getStartPlannedDateFormated(){
        return formatter.format(this.startPlannedDate.getTime());
    }
	
	public void setStartPlannedDate(Calendar startPlannedDate) {
		this.startPlannedDate = startPlannedDate;
	}

	public Calendar getFinalPlannedDate() {
		return finalPlannedDate;
	}

	public String getFinalPlannedDateFormated(){
        return formatter.format(this.finalPlannedDate.getTime());
    }

	public void setFinalPlannedDate(Calendar finalPlannedDate) {
		this.finalPlannedDate = finalPlannedDate;
	}

	public Calendar getStartRealDate() {
		return startRealDate;
	}
	
	public String getStartRealDateFormated(){
        return formatter.format(this.startRealDate.getTime());
    }
	
	public void setStartRealDate(Calendar startRealDate) {
		this.startRealDate = startRealDate;
	}

	public Calendar getFinalRealDate() {
		return finalRealDate;
	}

	public String getFinalRealDateFormated(){
        return formatter.format(this.finalRealDate.getTime());
    }

	public void setFinalRealDate(Calendar finalRealDate) {
		this.finalRealDate = finalRealDate;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public String toStringStage(){
		String msg="";
		msg ="       Phase: "+ stagePhase +"\n: " + state +"\nStart Planned Date: "+ getStartPlannedDateFormated() +"\nFinal Planned Date: "+ getFinalPlannedDateFormated()+"\nStart Real Date: "+getStartRealDateFormated()+"\nFinal Real Date: "+getFinalRealDateFormated()+"\n";
		return msg;
	}


}
