package MusicShop.InstumentAccessories.Instances;

import MusicShop.Instruments.Instances.Guitar;
import MusicShop.Instruments.Instrument;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GuitarStringTest {

    private GuitarString guitarString;
    private Guitar guitar;
    private ArrayList<Instrument> compatibleInstruments = new ArrayList<>();

    @Before
    public void setUp() {
        guitar = new Guitar(10.00, 15.00);
        compatibleInstruments.add(guitar);
        guitarString = new GuitarString(2.00, 7.00, compatibleInstruments);
    }

    @Test
    public void calculateMarkup() {
        assertEquals(5.00, guitarString.calculateMarkup(), 0.001);
    }

    @Test
    public void getRetailPrice() {
        assertEquals(7.00, guitarString.getRetailPrice(), 0.001);
    }

    @Test
    public void getSuppliersPrice() {
        assertEquals(2.00, guitarString.getSuppliersPrice(), 0.001);
    }

    @Test
    public void getUsedWith() {
        assertEquals(1, guitarString.getUsedWith().size());
    }
}