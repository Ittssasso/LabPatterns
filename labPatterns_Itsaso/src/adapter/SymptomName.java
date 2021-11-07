package adapter;

import java.util.Comparator;

import domain.Symptom;

public class SymptomName implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Symptom s1 = (Symptom)o1;
		Symptom s2 = (Symptom)o2;
		if(s1.getName().compareTo(s2.getName()) == 0) {
			return 0;
		}else if(s1.getName().compareTo(s2.getName()) > 0) {
			return 1;
		}else if(s1.getName().compareTo(s2.getName()) < 0) {
			return -1;
		}
		return 0;
	}


}
