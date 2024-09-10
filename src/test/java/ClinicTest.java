import static org.junit.Assert.assertEquals;

import org.example.Clinic;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Test;

public class ClinicTest {
	
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasMigraine_thenRadiologieSizeIsZero() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        assertEquals(0, clinic.getRadiologieList().size());
    }
    
    @Test
    public void givenAFullFifoClinic_whenTwoPatient_thenQueueSizeIsTwo() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        
        clinic.triagePatient("Mark", 4, VisibleSymptom.FLU);

        assertEquals(2, clinic.getPatientList().size());
    }
    
    @Test
    public void givenAFullFifoClinic_whenTwoPatient_thenPatientOrderInDoctorQueue() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);
        
        clinic.triagePatient("Mark", 4, VisibleSymptom.FLU);

        assertEquals("John", clinic.getPatientList().get(0));
        assertEquals("Mark", clinic.getPatientList().get(1));
    }
    
    @Test
    public void givenAFullFifoClinic_whenPatientHasSprain_thenRadiologieQueueSizeIsOne() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        assertEquals(1, clinic.getRadiologieList().size());
    }
    
    @Test
    public void givenAFullFifoClinic_whenPatientHasSprain_thenPatientIsFirstInRadiologieQueue() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        assertEquals("John", clinic.getRadiologieList().get(0));
    }
    
    @Test
    public void givenADoctorGravityClinicWithLowGravityClient_whenSecondPatientHaveHighGravity_thenHighGravityPatientIsFirstInDoctorList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        clinic.triagePatient("Mark", 6, VisibleSymptom.MIGRAINE);

        assertEquals("Mark", clinic.getPatientList().get(0));
    }
    
    @Test
    public void givenADoctorGravityClinicWithLowGravityClient_whenSecondPatientHaveHighGravity_thenTwoPatientInDoctorList() {
        Clinic clinic = new Clinic(TriageType.GRAVITY, TriageType.FIFO);
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        clinic.triagePatient("Mark", 6, VisibleSymptom.MIGRAINE);

        assertEquals(2, clinic.getPatientList().size());
    }
    
    @Test
    public void givenARadiologieGravityClinicWithLowGravityClient_whenSecondPatientHaveHighGravity_thenHighGravityPatientIsFirstInRadiologieList() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.GRAVITY);
        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        clinic.triagePatient("Mark", 6, VisibleSymptom.SPRAIN);

        assertEquals("Mark", clinic.getRadiologieList().get(0));
    }
    
    @Test
    public void givenARadiologieGravityClinicWithLowGravityClient_whenSecondPatientHaveHighGravity_thenTwoPatientInRadiologieList() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.GRAVITY);
        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        clinic.triagePatient("Mark", 6, VisibleSymptom.SPRAIN);

        assertEquals(2, clinic.getRadiologieList().size());
    }
    
}
