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
import static org.junit.Assert.assertNull;

public class ShopTest {

    private Shop shop;
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
        instruments.put(drum, 0);

        drumStickCompatibleInstruments.add(drum);
        guitarStringCompatibleInstruments.add(guitar);
        drumStick = new DrumStick(2.00, 7.00, drumStickCompatibleInstruments);
        guitarString = new GuitarString(2.00, 7.00, guitarStringCompatibleInstruments);
        instrumentAccessories.put(drumStick, 25);

        inventory = new Inventory();
        inventory.addInstrumentAccessories(instrumentAccessories);
        inventory.addSheetMusic(sheetMusics);
        inventory.addInstruments(instruments);

        shop = new Shop("Music", inventory, 500.00);
    }

    @Test
    public void getName(){
        assertEquals("Music", shop.getName());
    }

    @Test
    public void getInventory(){
        assertEquals(inventory, shop.getInventory());
    }

    @Test
    public void getTill(){
        assertEquals(500.00, shop.getTill(), 0.001);
    }

    @Test
    public void increaseTill(){
        shop.increaseTill(20.50);
        assertEquals(520.50, shop.getTill(), 0.001);
    }

    @Test
    public void decreaseTill(){
        shop.decreaseTill(20.50);
        assertEquals(479.50, shop.getTill(), 0.001);
    }

    @Test
    public void sellAnItem() throws NotInStockException {
        assertEquals(guitar, shop.sell(guitar));
        int numberOfGuitars = shop.getInventory().getAllInventory().get(guitar);
        assertEquals(9, numberOfGuitars);
        assertEquals(515.00, shop.getTill(), 0.001);
    }

    @Test(expected = NotInStockException.class)
    public void cantSellAnItemThatIsntInStock() throws NotInStockException {
        shop.sell(drum);
    }

    @Test (expected = NotInStockException.class)
    public void cantSellAnItemThatIsntOnTheInventoryList() throws NotInStockException {
        shop.sell(guitarString);
    }

}
