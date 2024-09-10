package org.example;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private final TriageType doctorTriageType;
    private final TriageType radiologyTriageType;
    
    private List<String> doctorList;
    private List<String> radiologieList;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
        
        this.radiologieList = new ArrayList<>();
        this.doctorList = new ArrayList<>();
    }

	public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
		
		if (doctorTriageType == TriageType.GRAVITY && gravity > 5) {
			this.doctorList.addFirst(name);
		} else {
			this.doctorList.add(name);
		}
		
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
