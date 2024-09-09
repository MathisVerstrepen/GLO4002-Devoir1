package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    
    private List<String> doctorList;
    private List<String> radiologieList;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.radiologieList = new ArrayList<>();
        this.doctorList = new ArrayList<>();
    }

	public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
		this.doctorList.add(name);
		
		if(visibleSymptom == VisibleSymptom.SPRAIN) {
			this.radiologieList.add(name);
		}
	}
	
	public List<String> getPatientList() {
		return this.doctorList;
	}

	public List<String> getRadiologieList() {
		return this.radiologieList;
	}
}
