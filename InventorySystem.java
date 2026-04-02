
import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    double price;

    Item(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class InventorySystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<>();

        int choice;
        double totalBill = 0;

        do {
            System.out.println("\n--- INVENTORY MENU ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Buy Item");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    items.add(new Item(id, name, price));
                    System.out.println("Item Added!");
                    break;

                case 2:
                    System.out.println("\n--- ITEM LIST ---");
                    for (Item i : items) {
                        System.out.println(i.id + " - " + i.name + " - ₹" + i.price);
                    }
                    break;

                case 3:
                    System.out.print("Enter Item ID to Buy: ");
                    int buyId = sc.nextInt();

                    boolean found = false;
                    for (Item i : items) {
                        if (i.id == buyId) {
                            System.out.print("Enter Quantity: ");
                            int qty = sc.nextInt();

                            double cost = i.price * qty;
                            totalBill += cost;

                            System.out.println("Added to cart: " + i.name + " x" + qty);
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Item Not Found!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- TOTAL BILL ---");
                    System.out.println("Total Amount: ₹" + totalBill);
                    break;

                case 5:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
