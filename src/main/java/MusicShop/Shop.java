package MusicShop;

import MusicShop.Behaviours.ISell;
import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.HashMap;

public class Shop {

    private String name;
    private Inventory inventory;

    public Shop(String name, Inventory inventory){
        this.name = name;
        this.inventory = inventory;
    }


    public String getName() {
        return this.name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
