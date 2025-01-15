package Controller;

import Models.Character;
import Models.Product;

import java.util.List;

public class Controller {
    private final List<Product> products;
    private final List<Models.Character> characters;

    public Controller(List<Product> products, List<Character> characters) {
        this.products = products;
        this.characters = characters;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(String name) {
        products.removeIf(product -> product.getName().equals(name));
    }

    public void updateProduct(String oldName, String newName, double newPrice, String newOrigin) {
        for (Product product : products) {
            if (product.getName().equals(oldName)) {
                product.setName(newName);
                product.setPrice(newPrice);
                product.setOrigin(newOrigin);
                return;
            }
        }
    }

    public List<Product> listProducts() {
        return products;
    }

    public Product getProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }
}
