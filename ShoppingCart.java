import java.util.Scanner;

class Cart {
    private double[] prices;
    private int itemCount;
    private final String cartId;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        }
    }

    public double getTotal() {
        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public String getCartId() {
        return cartId;
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String id = sc.nextLine();

        System.out.print("Enter maximum number of items: ");
        int maxItems = sc.nextInt();

        Cart cart = new Cart(id, maxItems);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            cart.addItem(price);
        }

        System.out.println("Total = " + cart.getTotal());
        System.out.println("Item Count = " + cart.getItemCount());

        sc.close();
    }
}
