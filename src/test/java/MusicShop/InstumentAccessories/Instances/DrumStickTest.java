package MusicShop.InstumentAccessories.Instances;

import MusicShop.Instruments.Instances.Drum;
import MusicShop.Instruments.Instrument;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DrumStickTest {

    private DrumStick drumstick;
    private Drum drum;
    private ArrayList<Instrument> compatibleInstruments = new ArrayList<>();

    @Before
    public void setUp() {
        drum = new Drum(10.00, 15.00);
        compatibleInstruments.add(drum);
        drumstick = new DrumStick(2.00, 7.00, compatibleInstruments);
    }

    @Test
    public void calculateMarkup() {
        assertEquals(5.00, drumstick.calculateMarkup(), 0.001);
    }

    @Test
    public void getRetailPrice() {
        assertEquals(7.00, drumstick.getRetailPrice(), 0.001);
    }

    @Test
    public void getSuppliersPrice() {
        assertEquals(2.00, drumstick.getSuppliersPrice(), 0.001);
    }

    @Test
    public void getUsedWith() {
        assertEquals(1, drumstick.getUsedWith().size());
    }
}