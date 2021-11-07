package adapter;
import java.util.ArrayList;
import java.util.Iterator;
import domain.Covid19Pacient;
import domain.Symptom;

public class Main {

	public static void main(String[] args) {
		
		//Covid19ko paziente bat sortu 5 sintomekin.
		Covid19Pacient p=new Covid19Pacient("Itsaso",19);
		p.addSymptomByName("fiebre", 1);
		p.addSymptomByName("disnea", 2);
		p.addSymptomByName("cefalea", 3);
		p.addSymptomByName("diarrea", 1);
		p.addSymptomByName("astenia", 2);
		
		//Bi konparadoreak.
		SeverityIndex severityIndex = new SeverityIndex();
		SymptomName symptomName = new SymptomName();
		
		//Covid19PacientIterator motako objektua sortzeko, lehenik eta behin, Covid19ko pazienteak duen iterator metodoa erabili behar da. Ondoren, iterator honek itzultzen duen iteratorra (syntomez osatuta) korritu behar da sintomak Symptom objektuez osatutako ArrayListean gehitzeko, azken hau parametro moduan pasatzeko.	
		Iterator<Symptom> itSymptom = p.iterator();
		ArrayList<Symptom> symptom = new ArrayList<>();
		while(itSymptom.hasNext()) {
			Symptom s = itSymptom.next();
			symptom.add(s);
		}
		
		//Adaptadorea  eta Sortint.sort metodoak severity eta namearen bitartez sintomak ordenatzeko.
		Covid19PacientIterator adapter = new Covid19PacientIterator(symptom);
		Iterator<Object> itSeverity=Sorting.sortedIterator(adapter, severityIndex);
		Iterator<Object> itName=Sorting.sortedIterator(adapter, symptomName);
		
		//SymotomName bitartez ordenatzeko.
		System.out.println("Ordenatu symptomName bitartez: ");
		while(itName.hasNext()) {
			System.out.println(itName.next().toString());
		}
		
		System.out.println("");
		
		//ServerityIndex bitartez ordenatzeko.
		System.out.println("Ordenatu severityIndex bitartez: ");
		while(itSeverity.hasNext()) {
			Symptom s=(Symptom)itSeverity.next();
			System.out.println("Izena: "+ s.getName()+ ", Severity: " +s.getSeverityIndex());
		}
		
	}

}
