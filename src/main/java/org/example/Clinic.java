package org.example;

public class Clinic {
	private Attente doctorAttente;
	private Attente radiologieAttente;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorAttente = new Attente(doctorTriageType);
        this.radiologieAttente = new Attente(radiologyTriageType);
    }

	public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
		
		if(visibleSymptom == VisibleSymptom.CORONAVIRUS) return;
		
		doctorAttente.addPersone(name, gravity);
		
		if(visibleSymptom == VisibleSymptom.SPRAIN) {
			radiologieAttente.addPersone(name, gravity);
		}
	}
	
	public String getDoctorPatient(int index) {
		return this.doctorAttente.getElement(index);
	}
	
	public String getRadiologiePatient(int index) {
		return this.radiologieAttente.getElement(index);
	}
	
	public int getDoctorAttenteSize() {
		return this.doctorAttente.getSize();
	}
	
	public int getRadiologieAttenteSize() {
		return this.radiologieAttente.getSize();
	}
	
}
