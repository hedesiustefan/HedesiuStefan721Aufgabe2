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
            System.out.println("6. Add Character");
            System.out.println("7. Update Character");
            System.out.println("8. Delete Character");
            System.out.println("9. List Characters");
            System.out.println("10. Get Character by id");
            System.out.println("11. Filter Characters by origin");
            System.out.println("12. Filter d)");


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
                case 6 -> {
                    System.out.println("Enter character id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    List<Product> emptyProductList = new ArrayList<>();
                    Character character = new Character(id, name, origin, emptyProductList);
                    controller.addCharacter(character);
                }
                case 7 -> {
                    System.out.println("Enter character id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter character name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter origin: ");
                    String origin = scanner.nextLine();
                    List<Product> productList = controller.getCharactersProducts(id);
                    controller.updateCharacter(id, name, origin, productList);
                }
                case 8 -> {
                    System.out.println("Enter character id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    controller.deleteCharacter(id);
                }
                case 9 -> {
                    List<Character> characterList = controller.listCharacters();
                    for (Character character : characterList) {
                        System.out.println(character.toString());
                    }
                }
                case 10 -> {
                    System.out.println("Enter character id:");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println(controller.getCharacter(id).toString());
                }
                case 11 -> {
                    System.out.println("Enter origin:");
                    String origin = scanner.nextLine();
                    controller.charactersByOrigin(origin);
                }
                case 12 -> {
                    System.out.println("Enter origin:");
                    String origin = scanner.nextLine();
                    controller.filterCharactersByProductOrigin(origin);
                }



                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
