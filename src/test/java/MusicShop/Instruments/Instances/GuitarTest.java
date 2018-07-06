package MusicShop.Instruments.Instances;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class GuitarTest {

    private Guitar guitar;

    @Before
    public void setUp() {
        guitar = new Guitar(10.00, 15.00);
    }

    @Test
    public void play() {
        assertEquals("whockah", guitar.play());
    }

    @Test
    public void calculateMarkup() {
        assertEquals(5.00, guitar.calculateMarkup(), 0.001);
    }

    @Test
    public void getRetailPrice() {
        assertEquals(15.00, guitar.getRetailPrice(), 0.001);
    }

    @Test
    public void getSuppliersPrice() {
        assertEquals(10.00, guitar.getSuppliersPrice(), 0.001);
    }

}