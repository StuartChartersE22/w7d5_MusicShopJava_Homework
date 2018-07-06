package MusicShop;

import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessories;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<Instrument> instruments;
    private ArrayList<InstrumentAccessories> instrumentAccessories;
    private ArrayList<SheetMusic> sheetMusics;

    public Shop(String name){
        this.name = name;
        instruments = new ArrayList<>();
        instrumentAccessories = new ArrayList<>();
        sheetMusics = new ArrayList<>();
    }


    public String getName() {
        return this.name;
    }
}
