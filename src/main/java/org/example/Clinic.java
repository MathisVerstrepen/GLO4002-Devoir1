package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class Clinic {
    private final TriageType doctorTriageType;
    private final TriageType radiologyTriageType;

    private final Queue<Patient> doctorQueue;
    private final Queue<Patient> radiologyQueue;

    public Clinic(TriageType doctorTriageType, TriageType radiologyTriageType) {
        this.doctorTriageType = doctorTriageType;
        this.radiologyTriageType = radiologyTriageType;
        this.doctorQueue = new LinkedList<>();
        this.radiologyQueue = new LinkedList<>();
    }

    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        Patient patient = new Patient(name, gravity, visibleSymptom);

        if (this.doctorTriageType == TriageType.FIFO) {
            doctorQueue.add(patient);
        }

        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN) {
            if (this.radiologyTriageType == TriageType.FIFO) {
                radiologyQueue.add(patient);
            }
        }
    }

    public Queue<Patient> getDoctorQueue() {
        return doctorQueue;
    }

    public Queue<Patient> getRadiologyQueue() {
        return radiologyQueue;
    }
}
