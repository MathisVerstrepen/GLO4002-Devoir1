import static org.junit.Assert.assertEquals;

import org.example.Clinic;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Test;

public class ClinicTest {
	
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasMigraine_thenDoctorSizeIsOne() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        assertEquals(1, clinic.getDoctorAttenteSize());
    }
    
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasMigraine_thenRadiologieSizeIsZero() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        assertEquals(0, clinic.getRadiologieAttenteSize());
    }
    
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasSprain_thenDoctorSizeIsOne() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        assertEquals(1, clinic.getDoctorAttenteSize());
    }
    
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasSprain_thenRadiologieSizeIsOne() {
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        clinic.triagePatient("John", 4, VisibleSymptom.SPRAIN);

        assertEquals(1, clinic.getRadiologieAttenteSize());
    }
    
    
}
