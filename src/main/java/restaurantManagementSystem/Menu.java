package restaurantManagementSystem;
import java.util.*;

abstract class Menu {

    private String itemName;
    private double itemPrice;

    public Menu(String itemName, double itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public void setName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public abstract int getQuantity();
    public abstract void displayItemDetails();
}

class FoodItem extends Menu {
    private int quantity;
    private String description;

    public FoodItem(String itemName, double itemPrice, String description) {
        super(itemName, itemPrice);
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
    
    @Override
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public void displayItemDetails() {
        System.out.println("Item Description: " + getDescription() + " - (" + getQuantity() + ")");
        System.out.println("Price: Tk " + getItemPrice() * getQuantity() + "/= ");
        System.out.println(" ");
    }
}

class Category {
    private String categoryName;
    private ArrayList<Menu> menuItems;

    public Category(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }
    
    public String getCategoryName() {
        return categoryName;
    }

    public void addItem(Menu item) {
        menuItems.add(item);
    }

    public void displayMenu() {
        System.out.println("Menu for " + getCategoryName() + " category:");
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i).getItemName() + " -   Tk " + 
                    menuItems.get(i).getItemPrice() + "/=");
        }
    }

    public Menu getItem(int i) {
        if (i >= 0 && i < menuItems.size()) {
            return menuItems.get(i);
        }
        return null;
    }
}
