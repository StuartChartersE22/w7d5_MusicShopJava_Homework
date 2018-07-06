package MusicShop;

import MusicShop.Instruments.Instances.Drum;
import MusicShop.Instruments.Instances.Guitar;
import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.Instances.DrumStick;
import MusicShop.InstumentAccessories.Instances.GuitarString;
import MusicShop.InstumentAccessories.InstrumentAccessory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ShopTest {

    private Shop shop;
    private Drum drum;
    private Guitar guitar;
    private DrumStick drumStick;
    private GuitarString guitarString;
    private SheetMusic sheetMusic;
    private ArrayList<Instrument> drumStickCompatibleInstruments = new ArrayList<>();
    private ArrayList<Instrument> guitarStringCompatibleInstruments = new ArrayList<>();
    private HashMap<Instrument, Integer> instruments = new HashMap<>();
    private HashMap<InstrumentAccessory, Integer> instrumentAccessories = new HashMap<>();
    private HashMap<SheetMusic, Integer> sheetMusics = new HashMap<>();


    @Before
    public void before(){
        sheetMusic = new SheetMusic("4:33", 1.00, 12.50);
        sheetMusics.put(sheetMusic, 20);

        guitar = new Guitar(10.00, 15.00);
        drum = new Drum(10.00, 15.00);
        instruments.put(guitar, 10);
        instruments.put(drum, 3);

        drumStickCompatibleInstruments.add(drum);
        guitarStringCompatibleInstruments.add(guitar);
        drumStick = new DrumStick(2.00, 7.00, drumStickCompatibleInstruments);
        guitarString = new GuitarString(2.00, 7.00, guitarStringCompatibleInstruments);
        instrumentAccessories.put(drumStick, 25);
        instrumentAccessories.put(guitarString, 10);

        shop = new Shop("Music");
    }

    @Test
    public void getName(){
        assertEquals("Music", shop.getName());
    }

    @Test
    public void addInstruments(){
        shop.addInstruments(instruments);
        assertEquals(2, shop.getInventory().size());
    }

    @Test
    public void addSheetMusic(){
        shop.addSheetMusic(sheetMusics);
        assertEquals(1, shop.getInventory().size());
    }

    @Test
    public void addInstrumentAccessories(){
        shop.addInstrumentAccessories(instrumentAccessories);
        assertEquals(2, shop.getInventory().size());
    }

    @Test
    public void getPotentialProfit(){
        shop.addInstrumentAccessories(instrumentAccessories);
        shop.addSheetMusic(sheetMusics);
        shop.addInstruments(instruments);
        assertEquals(470.00, shop.getPotentialProfit(), 0.001);
    }

}
