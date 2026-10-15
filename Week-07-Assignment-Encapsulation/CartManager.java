class Cart {
    private final String cartId;
    private final double[] prices;
    private int itemCount;

    public Cart(String cartId, int maxCapacity) {
        this.cartId = cartId;
        this.prices = new double[maxCapacity];
        this.itemCount = 0;
    }

    public void addItem(double price) {
        if (price >= 0 && itemCount < prices.length) prices[itemCount++] = price;
    }

    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) total += prices[i];
        return total;
    }
}

public class CartManager {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        System.out.println("Total: " + cart.getTotal());
    }
}