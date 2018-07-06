package MusicShop.Instruments.Instances;

import MusicShop.Instruments.Instrument;
import MusicShop.Instruments.InstrumentType;

public class Guitar extends Instrument {
    public Guitar(double suppliersPrice, double retailPrice) {
        super(InstrumentType.STRING, suppliersPrice, retailPrice, "whockah");
    }
}
