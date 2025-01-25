# Restaurant Management System

A simple Java-based console application for managing a restaurant's menu, allowing customers to browse categories, select items, specify quantities, and calculate the total bill with VAT included.

## Features

- Organized menu structure using categories (Starters, Main Course, Soft Drinks).
- Ability to browse menu items and view details such as price and description.
- Customers can select items, specify quantities, and view their selections.
- Calculates total bill including VAT.
- Ensures smooth user interaction via the console.

## Technologies Used

- **Programming Language**: Java
- **Concepts Utilized**: Object-Oriented Programming (OOP)
  - **Abstraction**: Abstract class `Menu` as the blueprint for menu items.
  - **Inheritance**: `FoodItem` class extends `Menu` to provide specific item details.
  - **Encapsulation**: Controlled access to item properties using getters and setters.
  - **Polymorphism**: Abstract methods implemented in the `FoodItem` class.

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/restaurant-management-system.git
   ```
2. Navigate to the project directory:
   ```bash
   cd restaurant-management-system
   ```
3. Open the project in your preferred Java IDE (e.g. NetBeans).
4. Compile and run the `RestaurantManagementSystem.java` file.

## Usage

1. Launch the application.
2. Choose a category (Starters, Main Course, Soft Drinks) by entering the corresponding number.
3. Browse items within the selected category.
4. Select items by their number and specify the quantity.
5. View the subtotal for each selection.
6. Complete the selection process by entering `0` for the category menu.
7. View the final bill, including VAT, upon completing the selection.

## Contributing

Contributions are welcome! To contribute:

1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature-name
   ```
3. Make your changes and commit them:
   ```bash
   git commit -m "Add feature-name"
   ```
4. Push to the branch:
   ```bash
   git push origin feature-name
   ```
5. Open a pull request.

---

Feel free to fork, modify, and enhance this project as per your requirements.
```
