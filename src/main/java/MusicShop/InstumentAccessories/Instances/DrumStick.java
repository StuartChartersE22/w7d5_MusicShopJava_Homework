package MusicShop.InstumentAccessories.Instances;

import MusicShop.Instruments.Instrument;
import MusicShop.InstumentAccessories.InstrumentAccessory;

import java.util.ArrayList;

public class DrumStick extends InstrumentAccessory {

    public DrumStick(double suppliersPrice, double retailPrice, ArrayList<Instrument> usedWith) {
        super(suppliersPrice, retailPrice, usedWith);
    }
}
