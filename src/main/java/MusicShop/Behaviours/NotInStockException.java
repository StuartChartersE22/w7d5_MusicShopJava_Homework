package MusicShop.Behaviours;

public class NotInStockException extends Exception {

    private ISell item;

    public NotInStockException(ISell item){
        this.item = item;
    }

    public ISell getItem(){
        return this.item;
    }
}
