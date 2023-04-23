package ui;

import java.text.ParseException;
import java.util.Scanner;
import model.Controller;


public class Executable {

	private Scanner reader;
	private Controller controller;

	public Executable() {

		reader = new Scanner(System.in);
		controller = new Controller();
	}

	public static void main(String[] args) throws ParseException {

		Executable exe = new Executable();
		exe.menu();

	}


	/**
	 * @throws ParseException
	 * 
	 */
	public void menu() throws ParseException {
		System.out.println("\nWelcome to GreenSQA ");
		boolean cond=false;

		while(!cond){
            System.out.println("\n-  type a number  -");
            System.out.println("\n1. Create Project");
            System.out.println("2. Edit stages of a project");
            System.out.println("3. Complete stage of a project");
			System.out.println("4. register capsule");
			System.out.println("5. approve capsule");
			System.out.println("6. Check Capsules created");
			System.out.println("7. Post Capsule");
			System.out.println("8. General information");
			System.out.println("\n9. exit");
            int opcion=reader.nextInt();

            switch(opcion){
                case 1:
					RegisterProject();
                 break;

                case 2:
					editStage();
                break;

                case 3:
					CulminateStage();
                break;
      
                case 4:
					registerUnits();
                break;

				case 5:
					approveKnowledgeUnit();
				break;

				case 6:
					SearchPSU();
				break;

				case 7:
					publishKnowledgeUnit();
				break;

				case 8:
					numberTypeUnit();
				break;
					
				case 9:
				System.out.println("bye ");
                cond=true;
				break;


          }
		}
	}

	  /**
     * This method prompts the user to enter the information about a project and calls the RegisterProject method in the Controller class.
     * If the project is registered successfully, a success message is displayed. Otherwise, an error message is displayed.
    */
	public void RegisterProject() {
		System.out.println("Type the information needed to register a new project: ");
		reader.nextLine();

		System.out.println("Type the name of the project: ");
		String projectName = reader.nextLine();
		
		System.out.println("Type the name of the customer: ");
		String customerName = reader.nextLine();

		System.out.println("Type the planned start date of the project");
		System.out.println("Day: ");
		int startDay = reader.nextInt();
		System.out.println("Month: ");
		int startMonth = reader.nextInt();
		System.out.println("Year: ");
		int startYear = reader.nextInt();
		
		System.out.println("Type the planned finish date of the project");
		System.out.println("Day: ");
		int finishDay = reader.nextInt();
		System.out.println("Month: ");
		int finishMonth = reader.nextInt();
		System.out.println("Year: ");
		int finishYear = reader.nextInt();
		
		reader.nextLine();

		System.out.println("Type GreenSQA Manager Name");
		String greenManagerName = reader.nextLine();
		System.out.println("Type GreenSQA Manager Phone");
		String greenManagerPhone =reader.nextLine();
		System.out.println("Type Customer Manager Name");
		String cusManagerName = reader.nextLine();
		System.out.println("Type Customer Manager Phone");
		String cusManagerPhone = reader.nextLine();

		System.out.println("Type the budget");
		double budget = reader.nextDouble();




		if(controller.RegisterProject(projectName, customerName,startDay,startMonth-1,startYear,finishDay,finishMonth-1,finishYear,budget,greenManagerName,greenManagerPhone,cusManagerName, cusManagerPhone)) {
			System.out.println("Project registered correctly");
		} else {
			System.out.println("Full memory, cant register the project");
		}
	}

	private void editStage() throws ParseException{
		reader.nextLine();
		String Consulta=controller.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controller.showProjects());
			System.out.println("Enter with a number to which project you want to edit the stage");
			int opcionStage=reader.nextInt();
			opcionStage=opcionStage-1;
			System.out.println("\n-This is the current stage of that project:");
			System.out.println(controller.showStagesActive(opcionStage)); 
		
			System.out.println("Enter the number of months the stage will take");
			int meses=reader.nextInt();
	
			if(controller.editStage(opcionStage, meses)){
				System.out.println("\nstage edited successfully");
				System.out.println(controller.showStagesActive(opcionStage)); 
			}
		}
	

	}

	private void CulminateStage() throws ParseException{
		String Consulta=controller.showProjects();
		if(Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("These are the projects created:");
			System.out.println(controller.showProjects());
			System.out.println("\nEnter with a number to which project you want to complete the stage ");
			int opcionStage=reader.nextInt();
			System.out.println("\n-This is the current stage of that project:");
			System.out.println(controller.showStagesActive(opcionStage-1)); 
			
			System.out.println("CULMINATION SPACE");
			System.out.println("Enter the starting actual date");
			System.out.println("Enter the day");
			int dateDIR=reader.nextInt();
			System.out.println("Enter the month");
			int dateMIR=reader.nextInt();
			System.out.println("Enter the year");
			int dateAIR=reader.nextInt();
	
			System.out.println("Enter actual end date");
			System.out.println("Enter the day");
			int dateDFR=reader.nextInt();
			System.out.println("Enter the month");
			int dateMFR=reader.nextInt();
			System.out.println("Enter the year");
			int dateAFR=reader.nextInt();
	
	
			if (controller.CulminateStage((opcionStage-1), dateDIR, (dateMIR-1), dateAIR, dateDFR, (dateMFR-1), dateAFR)){
				System.out.println("\n  -Stage completed successfully-");
				System.out.println("    This is how the stage ended");
				System.out.println("\n"+controller.showLastStages(opcionStage-1));
				System.out.println("-The next stage is now available-");
			}
		}
	
	}
	

	private void registerUnits() throws ParseException {
		String Consulta=controller.showProjects();
		if (Consulta.equals("")){
			System.out.println("No projects created yet");
		}else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controller.showProjects());
			System.out.println("To which project do you want to register the capsule?");
			int opcionProject=reader.nextInt();
			System.out.println("\nThe capsule will be registered to the next stage:");
			System.out.println(controller.showStagesActive((opcionProject-1)));
			System.out.println("\nKNOWLEDGE CAPSULE CREATION");
			System.out.println("Enter the capsule identifier (ej B06)");
			reader.nextLine();
			String id=reader.nextLine();
			System.out.println("Add a description of the capsule");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword");
			String description=reader.nextLine();
			System.out.println("\nEnter the type of capsule with a number");
			System.out.println("1.Technical\n2.Management\n3.Domain\n4.Experiences");
			int typeUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter learning obtained");
			System.out.println("Mark with a ¨#¨ at the beginning and end of each keyword");
			String learnedLessons=reader.nextLine();
			System.out.println("Enter the name of the collaborator");
			String nameColabo=reader.nextLine();
			System.out.println("Enter the charge for "+nameColabo);
			String cargo=reader.nextLine();
			

			if (controller.registerUnit(id, description, typeUnit, learnedLessons,nameColabo,cargo, opcionProject-1)){
				System.out.println("\n-Capsule registered successfully-");
				System.out.println("     -This is how your capsule was-");
				System.out.println("\n"+controller.showLastUnit(opcionProject-1)); 
			}
		}


	}	

//*TERMINAR */
	private void approveKnowledgeUnit() throws ParseException {
		String consulta= controller.showProjects();
		

		if(consulta.equals("")){
            System.out.println("There is nothing created");
        }else{
			System.out.println("Enter the following information:");
			System.out.println(controller.showProjects());
			System.out.println("What project do you want to approve the capsule for?");
			int opcionProject=reader.nextInt();
			System.out.println(controller.showStagesHistorial(opcionProject-1));
			System.out.println("At what stage do you want to approve the capsule?");
			int opcionStage=reader.nextInt();
			String consulta1=controller.showAllUnit(opcionProject-1);
			if(consulta1.equals("")){
				System.out.println("\nThis stage has no registered capsules");
			}else{
				System.out.println(controller.showAllUnit(opcionProject-1));
			System.out.println("\nWhat capsule do you want to approve?");
			int numUnit=reader.nextInt();
			reader.nextLine();
            
            if(controller.approveKnowledgeUnit(opcionProject-1, opcionStage-1,numUnit-1)){
				System.out.println("\n-Capsule edited correctly-");
				System.out.println("    This is how your capsule was:");
			System.out.println("\n"+controller.showUnitSelect(opcionProject-1, numUnit-1));
			}
			}
			
        }

	}

	private void publishKnowledgeUnit() throws ParseException{
		String consulta= controller.showProjects();
		if(consulta.equals("")){
            System.out.println("there is nothing created");
        }else{
			System.out.println("\n- Enter the following information:");
			System.out.println(controller.showProjects());
			System.out.println("What project is the capsule in?");
			int opcionProject=reader.nextInt();
			System.out.println(controller.showStagesHistorial(opcionProject-1));
			System.out.println("What stage is the capsule in?");
			int opcionStage=reader.nextInt();
			String consulta1=controller.showApproveUnit(opcionProject-1, opcionStage-1);
			if(consulta1.equals("")){
				System.out.println("That stage does not have approved capsules");
			}else{
				System.out.println("\n"+controller.showApproveUnit(opcionProject-1, opcionStage-1));
			System.out.println("\nWhat capsule do you want to publish?");
			int numUnit=reader.nextInt();
			reader.nextLine();
			System.out.println("Enter URL");
			String URL=reader.nextLine();
			if(controller.publishKnowledgeUnit(opcionProject-1, opcionStage-1, numUnit-1, URL)){
				System.out.println("\n-Capsule published correctly-");
				System.out.println("This is how your capsule was:");
				System.out.println("\n"+controller.showLastpublisUnit(opcionProject-1, opcionStage-1));
			}
		
        }
	}
	}


	private void SearchPSU() {
		System.out.println("Please enter the word to search for");
		reader.nextLine();
		String wordSearch=reader.nextLine();
		String consulta=controller.searchPSU(wordSearch);
        if(consulta.equals("")){
            System.out.println("-Can't find that word-");
        }else{
            System.out.println(controller.searchPSU(wordSearch));
        }
	}

	private void numberTypeUnit(){
		String Consulta=controller.numberTypeUnit();

		if(Consulta.equals("")){
			System.out.println("No capsules created");
		}else{
			System.out.println(controller.numberTypeUnit());
		}
	}

}