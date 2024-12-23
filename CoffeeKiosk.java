import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    private ArrayList<Item> menu;
    private ArrayList<Order> orders;

    // Constructeur
    public CoffeeKiosk() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
    }

    // Méthodes
    public void addMenuItem(String name, double price) {
        Item newItem = new Item(name, price);
        newItem.setIndex(menu.size());
        menu.add(newItem);
    }

    public void displayMenu() {
        for (Item item : menu) {
            System.out.println(item.getIndex() + " " + item.getName() + " -- $" + item.getPrice());
        }
    }

    public void newOrder() {
        // Vérification si System.console() est disponible
        if (System.console() == null) {
            System.out.println("No console available. Please run the program in a terminal.");
            return;
        }
    
        // Demande du nom du client pour la nouvelle commande
        System.out.println("Please enter customer name for new order:");
        String name = System.console().readLine();
    
        // Création de la nouvelle commande
        Order newOrder = new Order(name);
    
        // Affichage du menu pour permettre au client de choisir
        displayMenu();
    
        System.out.println("Please enter a menu item index or q to quit:");
        String item = System.console().readLine();
    
        // Boucle pour collecter les articles de la commande du client
        while (!item.equalsIgnoreCase("q")) {
            try {
                // Conversion de l'entrée utilisateur en index
                int index = Integer.parseInt(item);
    
                // Vérification de la validité de l'index
                if (index >= 0 && index < menu.size()) {
                    // Ajout de l'article sélectionné à la commande
                    Item selectedItem = menu.get(index);
                    newOrder.addItem(selectedItem);
                    System.out.println(selectedItem.getName() + " added to order.");
                } else {
                    System.out.println("Invalid index. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or 'q' to quit.");
            }
    
            // Demande d'un nouvel article ou de quitter
            System.out.println("Please enter a menu item index or q to quit:");
            item= System.console().readLine();
        }
    
        // Ajout de la commande à la liste des commandes
        orders.add(newOrder);
    
        // Affichage des détails de la commande
        System.out.println("Thank you , " + name + ".  Here are your order details :");
        newOrder.displayOrder();
    }
    

    public void addMenuItemByInput() {
        // Vérifier si la console est disponible
        if (System.console() == null) {
            System.out.println("Console not available.");
            return;
        }
        
        
        System.out.println("Enter the name of the new menu item:");
        String name = System.console().readLine();
        System.out.println("Enter the price of the new menu item:");
        String priceInput = System.console().readLine();
    
        try {
            double price = Double.parseDouble(priceInput); 
            addMenuItem(name, price);
            System.out.println(name + " has been added to the menu.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid price format. Please try again.");
        }
    }
    

    
}


