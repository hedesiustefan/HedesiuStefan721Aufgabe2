package View;
import Controller.*;
import Models.Character;
import Models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Provides the console-based user interface.
 */
public class View {
    public static void main(String[] args) {
        List<Character> characters = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Controller controller = new Controller(products, characters);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Sports Store Management ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. List Products");
            System.out.println("5. Get Product by name");


            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    Product product = new Product(name, price, origin);
                    controller.addProduct(product);
                }
                case 2 -> {
                    System.out.print("Enter current product name: ");
                    String oldName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new origin: ");
                    String newOrigin = scanner.nextLine();
                    controller.updateProduct(oldName, newName, newPrice, newOrigin);
                }
                case 3 -> {
                    System.out.print("Enter product name to delete: ");
                    String name = scanner.nextLine();
                    controller.deleteProduct(name);
                }
                case 4 -> {
                    List<Product> productList = controller.listProducts();
                    for (Product product : productList) {
                        System.out.println(product.toString());
                    }
                }
                case 5 -> {
                    System.out.print("Enter Product name to view: ");
                    String name = scanner.nextLine();
                    System.out.println(controller.getProduct(name).toString());

                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
