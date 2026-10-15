class InventoryItem {
    String itemCode;
    String name;
    int quantity;
    double pricePerUnit;

    public InventoryItem(String itemCode, String name, int quantity, double pricePerUnit) {
        this.itemCode = itemCode;
        this.name = name;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
    }

    public double getTotalStockValue() {
        return quantity * pricePerUnit;
    }
}

public class InventoryItemManager {
    public static void main(String[] args) {
        InventoryItem item = new InventoryItem("ITEM-01", "Wireless Mouse", 50, 25.5);
        System.out.println(item.name + " Stock Value: $" + item.getTotalStockValue());
    }
}