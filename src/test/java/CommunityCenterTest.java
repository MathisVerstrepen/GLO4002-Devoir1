import static org.junit.Assert.assertEquals;

import org.example.CommunityCenter;
import org.example.TriageType;
import org.example.VisibleSymptom;
import org.junit.Test;

public class CommunityCenterTest {
	
	@Test
	public void givenAFifoComunityCenter_whenOnePatientHasntCovid_thenPatientAttenteSizeIsOne() {
		CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
		
		communityCenter.triagePatient("John", 4, VisibleSymptom.FLU);
		
		assertEquals(1, communityCenter.getPatientAttentSize());
	}
	
	@Test
	public void givenAFifoComunityCenter_whenOnePatientHasCovid_thenPatientAttenteSizeIsZero() {
		CommunityCenter communityCenter = new CommunityCenter(TriageType.FIFO);
		
		communityCenter.triagePatient("John", 4, VisibleSymptom.CORONAVIRUS);
		
		assertEquals(0, communityCenter.getPatientAttentSize());
	}
}
