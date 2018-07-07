package MusicShop;

import MusicShop.Behaviours.ISell;
import MusicShop.Behaviours.NotInStockException;
import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.HashMap;

public class Inventory {


    private HashMap<Instrument, Integer> instruments;
    private HashMap<InstrumentAccessory, Integer> instrumentAccessories;
    private HashMap<SheetMusic, Integer> sheetMusics;

    public Inventory(){
        instruments = new HashMap<>();
        instrumentAccessories = new HashMap<>();
        sheetMusics = new HashMap<>();
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

    public HashMap<ISell, Integer> getAllInventory(){
        HashMap<ISell, Integer> totalInventory = new HashMap<>();
        totalInventory.putAll(instruments);
        totalInventory.putAll(instrumentAccessories);
        totalInventory.putAll(sheetMusics);
        return totalInventory;
    }

    public double getPotentialProfit() {
        double totalPotentialProfit = 0;
        totalPotentialProfit += profitOfTypeOfStock(instruments);
        totalPotentialProfit += profitOfTypeOfStock(instrumentAccessories);
        totalPotentialProfit += profitOfTypeOfStock(sheetMusics);
        return totalPotentialProfit;
    }

    private <I extends ISell> double profitOfTypeOfStock(HashMap<I, Integer> typeOfStock){
        double profitOfTypeOfStock = 0;
        for(I item : typeOfStock.keySet()){
            int numberOfItem = typeOfStock.get(item);
            profitOfTypeOfStock += item.calculateMarkup() * numberOfItem;
        }
        return profitOfTypeOfStock;
    }

    public boolean isInStock(ISell item){
        if(getAllInventory().keySet().contains(item) && getAllInventory().get(item) != 0){
            return true;
        }
        return false;
    }

    private <I extends ISell> void decreaseStockOfItem(ISell item, HashMap<I, Integer> inventoryOfItem){
        for(I itemType : inventoryOfItem.keySet()){
            if(item == itemType){
                inventoryOfItem.put(itemType, inventoryOfItem.get(itemType) - 1);
            }
        }
    }

    private <I extends ISell> void increaseStockOfItem(ISell item, HashMap<I, Integer> inventoryOfItem){
        for(I itemType : inventoryOfItem.keySet()){
            if(item == itemType){
                inventoryOfItem.put(itemType, inventoryOfItem.get(itemType) + 1);
            }
        }
    }

    public <I extends ISell> I removeItem(I item) throws NotInStockException {
        if(!isInStock(item)){throw new NotInStockException(item);
        }
        if(instruments.keySet().contains(item)){decreaseStockOfItem(item, instruments);}
        if(instrumentAccessories.keySet().contains(item)){decreaseStockOfItem(item, instrumentAccessories);}
        if(sheetMusics.keySet().contains(item)){decreaseStockOfItem(item, sheetMusics);}
        return item;
    }

    public void addAnItemAlreadyOnStockList(ISell item) throws NotInStockException {
        if(!getAllInventory().keySet().contains(item)){
            throw new NotInStockException(item);
        }
        if(instruments.keySet().contains(item)){increaseStockOfItem(item, instruments);}
        if(instrumentAccessories.keySet().contains(item)){increaseStockOfItem(item, instrumentAccessories);}
        if(sheetMusics.keySet().contains(item)){increaseStockOfItem(item, sheetMusics);}
    }
}
