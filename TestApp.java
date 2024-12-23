public class TestApp {
    public static void main(String[] args) {
        CoffeeKiosk kiosk = new CoffeeKiosk();

        // Ajouter des éléments au menu
        kiosk.addMenuItem("banana", 2.00);
        kiosk.addMenuItem("coffee", 1.50);
        kiosk.addMenuItem("latte", 4.50);
        kiosk.addMenuItem("capuccino", 3.00);
        kiosk.addMenuItem("muffin", 4.00);
        
        kiosk.addMenuItemByInput();
        // Prendre une nouvelle commande
        kiosk.newOrder();
    }
}
