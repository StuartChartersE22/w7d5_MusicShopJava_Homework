package MusicShop.InstumentAccessories.Instances;

import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessories;

import java.util.ArrayList;

public class DrumStick extends InstrumentAccessories {

    public DrumStick(double suppliersPrice, double retailPrice, ArrayList<Instrument> usedWith) {
        super(suppliersPrice, retailPrice, usedWith);
    }
}
