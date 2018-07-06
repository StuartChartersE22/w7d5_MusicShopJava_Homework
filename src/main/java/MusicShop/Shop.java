package MusicShop;

import MusicShop.Behaviours.ISell;
import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.ArrayList;
import java.util.BitSet;

public class Shop {

    private String name;
    private ArrayList<Instrument> instruments;
    private ArrayList<InstrumentAccessory> instrumentAccessories;
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

    public void addInstruments(ArrayList<Instrument> instruments){
        this.instruments.addAll(instruments);
    }

    public void addSheetMusic(ArrayList<SheetMusic> sheetMusics){
        this.sheetMusics.addAll(sheetMusics);
    }

    public void addInstrumentAccessories(ArrayList<InstrumentAccessory> instrumentAccessories){
        this.instrumentAccessories.addAll(instrumentAccessories);
    }

    public ArrayList<ISell> getInventory() {
        ArrayList<ISell> inventory = new ArrayList<>();
        inventory.addAll(instruments);
        inventory.addAll(instrumentAccessories);
        inventory.addAll(sheetMusics);
        return inventory;
    }
}
