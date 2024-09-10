import static org.junit.Assert.assertEquals;

import org.example.Attente;
import org.example.TriageType;
import org.junit.Test;

public class AttenteTest {
	
    @Test
    public void givenAFifoAttente_whenAddingPersones_thenAttenteSizeIsTwo() {
    	Attente attente = new Attente(TriageType.FIFO);

    	attente.addPersone("John", 4);
    	attente.addPersone("Mark", 6);

        assertEquals(2, attente.getSize());
    }
    
    @Test
    public void givenAGravityAttente_whenAddingTwoPersones_thenAttenteSizeIsTwo() {
    	Attente attente = new Attente(TriageType.GRAVITY);

    	attente.addPersone("John", 4);
    	attente.addPersone("Mark", 6);

        assertEquals(2, attente.getSize());
    }
    
    @Test
    public void givenAFifoAttente_whenOnePersone_thenPersoneIsFirst() {
    	Attente attente = new Attente(TriageType.FIFO);

    	attente.addPersone("John", 4);

        assertEquals("John", attente.getElement(0));
    }
    
    @Test
    public void givenAFifoAttenteWithOnePersone_whenAddingSecondPersone_thenNewPersoneIsSecond() {
    	Attente attente = new Attente(TriageType.FIFO);
    	attente.addPersone("John", 4);
    	
    	attente.addPersone("Mark", 4);
    	
    	assertEquals("Mark", attente.getElement(1));
    }
    
    @Test
    public void givenAFifoAttenteWithOnePersone_whenAddingSecondPersoneWithLowGravity_thenNewPersoneIsSecond() {
    	Attente attente = new Attente(TriageType.GRAVITY);
    	attente.addPersone("John", 4);
    	
    	attente.addPersone("Mark", 4);
    	
    	assertEquals("Mark", attente.getElement(1));
    }
    
    @Test
    public void givenAFifoAttenteWithOnePersone_whenAddingSecondPersoneWithHighGravity_thenNewPersoneIsFirst() {
    	Attente attente = new Attente(TriageType.GRAVITY);
    	attente.addPersone("John", 4);
    	
    	attente.addPersone("Mark", 6);
    	
    	assertEquals("Mark", attente.getElement(0));
    }
    
}
