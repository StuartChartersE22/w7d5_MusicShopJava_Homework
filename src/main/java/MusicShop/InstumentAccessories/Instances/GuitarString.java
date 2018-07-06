package MusicShop.InstumentAccessories.Instances;

import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.ArrayList;

public class GuitarString extends InstrumentAccessory {

    public GuitarString(double suppliersPrice, double retailPrice, ArrayList<Instrument> usedWith) {
        super(suppliersPrice, retailPrice, usedWith);
    }
}
