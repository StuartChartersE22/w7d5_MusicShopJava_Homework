package MusicShop.Instruments;

import MusicShop.Behaviours.IPlay;
import MusicShop.Behaviours.ISell;

public abstract class Instrument implements ISell, IPlay {

    private InstrumentType type;
    private String noise;
    private double suppliersPrice;
    private double retailPrice;

    public Instrument(InstrumentType type, double suppliersPrice, double retailPrice, String noise){
        this.type = type;
        this.noise = noise;
        this.suppliersPrice = suppliersPrice;
        this.retailPrice = retailPrice;
    }

    @Override
    public String play(){
        return this.noise;
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
}
