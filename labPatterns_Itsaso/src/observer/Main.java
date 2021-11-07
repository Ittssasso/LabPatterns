package observer;

import java.util.Observable;
import domain.Covid19Pacient;

public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		//Covid19ko bi paziente sortu.
		Observable pacient1=new Covid19Pacient("Aitor", 35);
		Observable pacient2=new Covid19Pacient("Itsaso", 27);
		Observable pacient3=new Covid19Pacient("Maitena", 17);
		
		//1go pazientearen GUIak.
		PacientSymptomGUI frame1 = new PacientSymptomGUI ((Covid19Pacient) pacient1);
		PacientObserverGUI pacientGUI1= new PacientObserverGUI (pacient1);	
		PacientThermometerGUI thermometerGUI1 = new PacientThermometerGUI(pacient1);
		SemaphorGUI semaphorGUI1 = new SemaphorGUI(pacient1);
		
	
		//2. pazientearen GUIak.
		PacientSymptomGUI frame2 = new PacientSymptomGUI ((Covid19Pacient) pacient2);
		PacientObserverGUI pacientGUI2= new PacientObserverGUI (pacient2);
		PacientThermometerGUI thermometerGUI2 = new PacientThermometerGUI(pacient2);
		SemaphorGUI semaphorGUI2 = new SemaphorGUI(pacient2);
		
		//2. pazientearen GUIak.
		PacientSymptomGUI frame3 = new PacientSymptomGUI ((Covid19Pacient) pacient3);
		PacientObserverGUI pacientGUI3= new PacientObserverGUI (pacient3);
		PacientThermometerGUI thermometerGUI3 = new PacientThermometerGUI(pacient3);
		SemaphorGUI semaphorGUI3 = new SemaphorGUI(pacient3);
		
	
	}

}


