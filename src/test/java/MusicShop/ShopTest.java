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
    private ArrayList<Instrument> instruments = new ArrayList<>();
    private ArrayList<InstrumentAccessory> instrumentAccessories = new ArrayList<>();
    private ArrayList<SheetMusic> sheetMusics = new ArrayList<>();


    @Before
    public void before(){
        sheetMusic = new SheetMusic("4:33", 1.00, 12.50);
        sheetMusics.add(sheetMusic);

        guitar = new Guitar(10.00, 15.00);
        drum = new Drum(10.00, 15.00);
        instruments.add(guitar);
        instruments.add(drum);

        drumStickCompatibleInstruments.add(drum);
        guitarStringCompatibleInstruments.add(guitar);
        drumStick = new DrumStick(2.00, 7.00, drumStickCompatibleInstruments);
        guitarString = new GuitarString(2.00, 7.00, guitarStringCompatibleInstruments);
        instrumentAccessories.add(drumStick);
        instrumentAccessories.add(guitarString);

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

}
