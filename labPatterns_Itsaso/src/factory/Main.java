package factory;

import domain.Covid19Pacient;
import domain.Medicament;

public class Main {

	public static void main(String[] args) {
		
		//Covid19Pacient
		Covid19Pacient p1=new Covid19Pacient("Itsaso", 35);
		new PacientSymptomGUI(p1);
		
		//Medicament
		Medicament m1= new Medicament("Paracetamol");
		new MedicalGUI(m1);	
		
	}

}


