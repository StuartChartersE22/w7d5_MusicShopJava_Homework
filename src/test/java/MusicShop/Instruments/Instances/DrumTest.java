package MusicShop.Instruments.Instances;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DrumTest {

    private Drum drum;

    @Before
    public void setUp() {
        drum = new Drum(10.00, 15.00);
    }

    @Test
    public void play() {
        assertEquals("Bang", drum.play());
    }

    @Test
    public void calculateMarkup() {
        assertEquals(5.00, drum.calculateMarkup(), 0.001);
    }

    @Test
    public void getRetailPrice() {
        assertEquals(15.00, drum.getRetailPrice(), 0.001);
    }

    @Test
    public void getSuppliersPrice() {
        assertEquals(10.00, drum.getSuppliersPrice(), 0.001);
    }
}