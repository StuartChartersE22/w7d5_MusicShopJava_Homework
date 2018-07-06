package MusicShop.Instruments.Instances;

import MusicShop.Instruments.Instrument;
import MusicShop.Instruments.InstrumentType;

public class Drum extends Instrument {
    public Drum(double suppliersPrice, double retailPrice) {
        super(InstrumentType.PERCUSSION, suppliersPrice, retailPrice, "Bang");
    }
}
