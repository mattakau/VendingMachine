import java.util.*;

class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getPriceFormatted() {
        return "Rp" + String.format("%,.0f", price);
    }
}

class VendingMachine {
    private List<Item> items;
    private double balance;

    public VendingMachine() {
        items = new ArrayList<>();
        balance = 0.0;
    }

    public void addItem(String name, double price) {
        Item item = new Item(name, price);
        items.add(item);
    }

    public void displayItems() {
        System.out.println("Available Items:");
        for (int i = 0; i < items.size(); i++) {
            Item item = items.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPriceFormatted());
        }
    }

    public void insertCoin(double coin) {
        balance += coin;
        System.out.println("Coin inserted: Rp" + String.format("%,.0f", coin));
    }

    public void purchaseItem(int itemNumber) {
        if (itemNumber >= 1 && itemNumber <= items.size()) {
            Item item = items.get(itemNumber - 1);
            if (balance >= item.getPrice()) {
                System.out.println("Item purchased: " + item.getName());
                balance -= item.getPrice();
            } else {
                System.out.println("Insufficient balance. Please insert more coins.");
            }
        } else {
            System.out.println("Item not found.");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: Rp" + String.format("%,.0f", balance));
    }

    public void searchItem(String itemName) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                foundItems.add(item);
            }
        }

        if (foundItems.isEmpty()) {
            System.out.println("Item not found.");
        } else {
            System.out.println("Search results for '" + itemName + "':");
            for (Item item : foundItems) {
                System.out.println(item.getName() + " - " + item.getPriceFormatted());
            }
        }
    }

    public void sortItemsByName() {
        items.sort(Comparator.comparing(Item::getName));
        System.out.println("Items sorted by name.");
    }

    public void sortItemsByPrice() {
        items.sort(Comparator.comparing(Item::getPrice));
        System.out.println("Items sorted by price.");
    }
}
