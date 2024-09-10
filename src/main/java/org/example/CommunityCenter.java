package org.example;

public class CommunityCenter {
    private Attente patientAttente;

    public CommunityCenter(TriageType patientTriageType) {
        this.patientAttente = new Attente(patientTriageType);
    }

	public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
		if(visibleSymptom != VisibleSymptom.CORONAVIRUS) {
			this.patientAttente.addPersone(name, gravity);
		}
	}
	
	public String getPatient(int index) {
		return this.patientAttente.getElement(index);
	}
	
	public int getPatientAttentSize() {
		return this.patientAttente.getSize();
	}
}
