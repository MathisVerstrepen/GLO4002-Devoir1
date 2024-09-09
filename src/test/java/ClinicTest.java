import org.example.Clinic;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Assert;
import org.junit.Test;

public class ClinicTest {
    @Test
    public void givenAFullFifoClinic_whenOnePatientHasMigraine_thenPatientIsFirstInDoctorQueue() {
        // Arrange
        Clinic clinic = new Clinic(TriageType.FIFO, TriageType.FIFO);

        // Act
        clinic.triagePatient("John", 4, VisibleSymptom.MIGRAINE);

        // Assert
        Assert.assertEquals(1, clinic.getDoctorQueue().size());
    }
}
