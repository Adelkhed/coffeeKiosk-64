import java.util.ArrayList;

public class Order {
    private String name;
    private ArrayList<Item> items;

    // Constructor
    public Order(String name) {
        this.name = name;
        this.items = new ArrayList<>();
    }

    // Methods
    public void addItem(Item item) {
        items.add(item);
    }

    public void displayOrder() {
        System.out.println("Order for: " + name);
        double total = 0;
        for (Item item : items) {
            System.out.println(item.getName() + " -- $" + item.getPrice());
            total += item.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}