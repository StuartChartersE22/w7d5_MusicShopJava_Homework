package MusicShop;

import MusicShop.Behaviours.NotInStockException;
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

public class InventoryTest {

    private Inventory inventory;
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

        inventory = new Inventory();
    }

    @Test
    public void addInstruments(){
        inventory.addInstruments(instruments);
        assertEquals(2, inventory.getAllInventory().size());
    }

    @Test
    public void addSheetMusic(){
        inventory.addSheetMusic(sheetMusics);
        assertEquals(1, inventory.getAllInventory().size());
    }

    @Test
    public void addInstrumentAccessories(){
        inventory.addInstrumentAccessories(instrumentAccessories);
        assertEquals(2, inventory.getAllInventory().size());
    }

    @Test
    public void getPotentialProfit(){
        inventory.addInstrumentAccessories(instrumentAccessories);
        inventory.addSheetMusic(sheetMusics);
        inventory.addInstruments(instruments);
        assertEquals(470.00, inventory.getPotentialProfit(), 0.001);
    }

    @Test
    public void removeAnItem() throws NotInStockException {
        inventory.addInstruments(instruments);
        assertEquals(drum, inventory.removeItem(drum));
        int stockOfDrums = inventory.getAllInventory().get(drum);
        assertEquals(2, stockOfDrums);
    }

    @Test(expected = NotInStockException.class)
    public void cantRemoveAnItemThatIsntInStock() throws NotInStockException {
        inventory.removeItem(guitar);
    }

    @Test
    public void addItemAlreadyOnStockList() throws NotInStockException {
        inventory.addInstruments(instruments);
        inventory.addAnItemAlreadyOnStockList(drum);
        int stockOfDrums = inventory.getAllInventory().get(drum);
        assertEquals(4, stockOfDrums);
    }

    @Test(expected = NotInStockException.class)
    public void cantAddItemIfNotOnStockList() throws NotInStockException {
        inventory.addInstruments(instruments);
        inventory.addAnItemAlreadyOnStockList(guitarString);
    }
}
