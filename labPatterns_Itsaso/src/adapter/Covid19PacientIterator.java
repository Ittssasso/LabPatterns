package adapter;

import java.util.ArrayList;
import domain.Symptom;

public class Covid19PacientIterator implements InvertedIterator {

	ArrayList<Symptom> symptoms;	
	int posizioa;
	
	public Covid19PacientIterator (ArrayList<Symptom> s) {
		this.symptoms=s;
		posizioa=symptoms.size()-1;
	}
	
	@Override
	public Object previous() {
		Symptom s = symptoms.get(posizioa);
		posizioa=posizioa-1;
		return s;
	}

	@Override
	public boolean hasPrevious() {
		if(posizioa >= 0) 
			return true;
		else 
			return false;
	}

	@Override
	public void goLast() {
		posizioa=symptoms.size()-1;
	}

}

