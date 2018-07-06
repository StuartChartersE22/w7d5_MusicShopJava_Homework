package MusicShop;

import MusicShop.Behaviours.ISell;
import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.HashMap;

public class Shop {

    private String name;
    private HashMap<Instrument, Integer> instruments;
    private HashMap<InstrumentAccessory, Integer> instrumentAccessories;
    private HashMap<SheetMusic, Integer> sheetMusics;

    public Shop(String name){
        this.name = name;
        instruments = new HashMap<>();
        instrumentAccessories = new HashMap<>();
        sheetMusics = new HashMap<>();
    }


    public String getName() {
        return this.name;
    }

    public void addInstruments(HashMap<Instrument, Integer> instruments){
        this.instruments.putAll(instruments);
    }

    public void addSheetMusic(HashMap<SheetMusic, Integer> sheetMusics){
        this.sheetMusics.putAll(sheetMusics);
    }

    public void addInstrumentAccessories(HashMap<InstrumentAccessory, Integer> instrumentAccessories){
        this.instrumentAccessories.putAll(instrumentAccessories);
    }

    public HashMap<ISell, Integer> getInventory() {
        HashMap<ISell, Integer> inventory = new HashMap<>();
        inventory.putAll(instruments);
        inventory.putAll(instrumentAccessories);
        inventory.putAll(sheetMusics);
        return inventory;
    }

    private <I extends ISell> double profitOfTypeOfStock(HashMap<I, Integer> typeOfStock){
        double profitOfTypeOfStock = 0;
        for(I item : typeOfStock.keySet()){
            int numberOfItem = typeOfStock.get(item);
            profitOfTypeOfStock += item.calculateMarkup() * numberOfItem;
        }
        return profitOfTypeOfStock;
    }

    public double getPotentialProfit() {
        double totalPotentialProfit = 0;
        totalPotentialProfit += profitOfTypeOfStock(instruments);
        totalPotentialProfit += profitOfTypeOfStock(instrumentAccessories);
        totalPotentialProfit += profitOfTypeOfStock(sheetMusics);
        return totalPotentialProfit;
    }
}
