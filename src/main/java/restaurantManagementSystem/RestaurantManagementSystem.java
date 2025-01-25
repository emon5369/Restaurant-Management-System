package restaurantManagementSystem;
import java.util.*;
public class RestaurantManagementSystem {

    public static void main(String[] args) {      
        Scanner sc = new Scanner(System.in);

        Category starters = new Category("Starters");
        starters.addItem(new FoodItem("Salad        ", 250, "Fresh Garden Salad"));
        starters.addItem(new FoodItem("Soup         ", 300, "Homemade Vegetable Soup"));
        starters.addItem(new FoodItem("Spring Rolls ", 150, "Crispy Spring Rolls"));

        Category mainCourse = new Category("Main Course");
        mainCourse.addItem(new FoodItem("Pasta      - Creamy Alfredo     ", 350, "Creamy Alfredo Pasta"));
        mainCourse.addItem(new FoodItem("Pasta      - Spaghetti Bolognese", 300, "Spaghetti with Bolognese sauce"));
        mainCourse.addItem(new FoodItem("Pasta      - Pesto Penne        ", 400, "Penne Pasta with Basil Pesto"));
        mainCourse.addItem(new FoodItem("Steak      - Ribeye             ", 1200, "Grilled Ribeye Steak"));
        mainCourse.addItem(new FoodItem("Steak      - Filet Mignon       ", 1350, "Tender Filet Mignon Steak"));
        mainCourse.addItem(new FoodItem("Steak      - T-Bone             ", 1050, "T-Bone Steak"));
        mainCourse.addItem(new FoodItem("Fried Rice - Veg Fried Rice     ", 350, "Veg Fried Rice"));
        mainCourse.addItem(new FoodItem("Fried Rice - Chicken Fried Rice ", 450, "Chicken Fried Rice"));
        mainCourse.addItem(new FoodItem("Fried Rice - Mixed Fried Rice   ", 550, "Mixed Fried Rice"));

        Category drinks = new Category("Soft Drinks");
        drinks.addItem(new FoodItem("Coca-Cola - Regular ", 40, "Coca-Cola (Regular)"));
        drinks.addItem(new FoodItem("Coca-Cola - Large   ", 60, "Coca-Cola (Large)"));
        drinks.addItem(new FoodItem("Sprite    - Large   ", 30, "Sprite (Regular)"));
        drinks.addItem(new FoodItem("Sprite    - Large   ", 50, "Sprite (Large)"));
        drinks.addItem(new FoodItem("Iced Tea  - Regular ", 100, "Iced Tea (Regular)"));
        drinks.addItem(new FoodItem("Iced Tea  - Large   ", 120, "Iced Tea (Large)"));
        
        System.out.println("********************************************");
        System.out.println("*        Welcome to the Restaurant         *");
        System.out.println("********************************************");

        List<Menu> selectedItems = new ArrayList<>();

        boolean choosingItems = true;
        while (choosingItems) {
            System.out.println(" ");
            System.out.println("Choose a category:");
            System.out.println("1. Starters");
            System.out.println("2. Main Course");
            System.out.println("3. Soft Drinks");
            System.out.println("0. Finish and calculate bill");

            System.out.print("Enter your choice: ");
            int categoryChoice = sc.nextInt();

            if (categoryChoice == 0) {
                choosingItems = false;
            } else if (categoryChoice >= 1 && categoryChoice <= 3) {
                Category selectedCategory = null;
                if (categoryChoice == 1) {
                    selectedCategory = starters;
                } else if (categoryChoice == 2) {
                    selectedCategory = mainCourse;
                } else if (categoryChoice == 3) {
                    selectedCategory = drinks;
                }
                if (selectedCategory != null) {
                    selectedCategory.displayMenu();

                    System.out.print("Enter the item number (0 to finish this category): ");
                    int itemChoice = sc.nextInt();

                    while (itemChoice != 0) {
                        Menu selectedMenu = selectedCategory.getItem(itemChoice - 1);
                        if (selectedMenu != null) {
                            System.out.print("Enter quantity: ");
                            int quantity = sc.nextInt();
                            double subtotal = selectedMenu.getItemPrice() * quantity;
                            ((FoodItem) selectedMenu).setQuantity(quantity);
                            selectedItems.add(selectedMenu);
                            
                            System.out.println("Subtotal: Tk " + subtotal + "/=");
                        } else {
                            System.out.println("Invalid item choice.");
                        }
                        System.out.print("Enter another item number (0 to finish this category): ");
                        itemChoice = sc.nextInt();
                    }
                } else {
                    System.out.println("Invalid choice.");
                }
            } else {
                System.out.println("Invalid choice.");
            }
        }

        if (!selectedItems.isEmpty()) {
            System.out.println(" ");
            
            System.out.println(" You selected the following items: ");
            System.out.println("-----------------------------------");
            double totalBill = 0.0;
            for (Menu item : selectedItems) {
                item.displayItemDetails();
                totalBill += (item.getItemPrice() * item.getQuantity());
            }
            
            System.out.println("Total Bill: Tk " + totalBill + "/= ");
            double Vat = totalBill * 0.15;
            System.out.println("Vat: Tk " + Vat + "/=");
            totalBill += Vat;
            System.out.println("Total Bill(Including VAT): Tk " + totalBill + "/= ");
            System.out.println("Thank you for dining with us!");
        } else {
            System.out.println("No items selected.");
        }
    }
}
