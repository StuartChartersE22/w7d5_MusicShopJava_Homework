package MusicShop;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SheetMusicTest {

    private SheetMusic sheetMusic;

    @Before
    public void setUp() {
        sheetMusic = new SheetMusic("4:33", 1.00, 12.50);
    }

    @Test
    public void getName(){
        assertEquals("4:33", sheetMusic.getName());
    }

    @Test
    public void calculateMarkup() {
        assertEquals(11.50, sheetMusic.calculateMarkup(), 0.001);
    }

    @Test
    public void getRetailPrice() {
        assertEquals(12.50, sheetMusic.getRetailPrice(), 0.001);
    }

    @Test
    public void getSuppliersPrice() {
        assertEquals(1.00, sheetMusic.getSuppliersPrice(), 0.001);
    }
}