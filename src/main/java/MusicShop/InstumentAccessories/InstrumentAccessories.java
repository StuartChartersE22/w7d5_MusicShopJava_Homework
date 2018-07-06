package MusicShop.InstumentAccessories;

import MusicShop.Behaviours.ISell;
import MusicShop.Instruments.Instrument;
import MusicShop.Instruments.InstrumentType;

import java.util.ArrayList;

public abstract class InstrumentAccessories implements ISell {

    private double suppliersPrice;
    private double retailPrice;
    private ArrayList<Instrument> usedWith;

    public InstrumentAccessories(double suppliersPrice, double retailPrice, ArrayList<Instrument> usedWith){
        this.suppliersPrice = suppliersPrice;
        this.retailPrice = retailPrice;
        this.usedWith = usedWith;
    }

    @Override
    public double calculateMarkup(){
        return this.retailPrice - this.suppliersPrice;
    }

    public double getRetailPrice() {
        return this.retailPrice;
    }

    public double getSuppliersPrice() {
        return this.suppliersPrice;
    }

    public ArrayList<Instrument> getUsedWith() {
        return this.usedWith;
    }
}
