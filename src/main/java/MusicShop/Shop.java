package MusicShop;

public class Shop {

    private String name;
    private Inventory inventory;
    private double till;

    public Shop(String name, Inventory inventory, double till){
        this.name = name;
        this.inventory = inventory;
        this.till = till;
    }


    public String getName() {
        return this.name;
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public double getTill() {
        return this.till;
    }

    public void increaseTill(double amount) {
        this.till += amount;
    }

    public void decreaseTill(double amount) {
        this.till -= amount;
    }
}
