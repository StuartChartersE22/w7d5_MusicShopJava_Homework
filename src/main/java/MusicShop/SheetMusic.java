package MusicShop;

import MusicShop.Behaviours.ISell;

import java.util.ArrayList;

public class SheetMusic implements ISell{

    private double suppliersPrice;
    private double retailPrice;

    public SheetMusic(String name, double suppliersPrice, double retailPrice) {
        this.suppliersPrice = suppliersPrice;
        this.retailPrice = retailPrice;
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
