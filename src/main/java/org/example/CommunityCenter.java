package org.example;

public class CommunityCenter {
    private Attente patientAttente;

    public CommunityCenter(TriageType patientTriageType) {
        this.patientAttente = new Attente(patientTriageType);
    }

	public void triagePatient(String name, int gravity) {
		this.patientAttente.addPersone(name, gravity);
	}
	
	public String getPatient(int index) {
		return this.patientAttente.getElement(index);
	}
}
