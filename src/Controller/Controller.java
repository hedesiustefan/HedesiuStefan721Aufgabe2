package Controller;

import Models.Character;
import Models.Product;

import java.util.Collections;
import java.util.Comparator;
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

    public void addCharacter(Character character) {
        characters.add(character);
    }

    public void deleteCharacter(Integer characterId) {
        characters.removeIf(character -> character.getId() == characterId);
    }

    public void updateCharacter(int id, String newName, String newOrigin, List<Product> newProducts) {
        for (Character character : characters) {
            if (character.getId() == id) {
                character.setName(newName);
                character.setOrigin(newOrigin);
                character.setProducts(newProducts);
                return;
            }
        }
    }

    public List<Character> listCharacters() {
        return characters;
    }

    public Character getCharacter(Integer characterId) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                return character;
            }
        }
        return null;
    }

    public List<Product> getCharactersProducts(int characterId) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                return character.getProducts();
            }
        }
        return null;
    }

    public void charactersByOrigin(String origin) {
        for (Character character : characters) {
            if (character.getOrigin().equals(origin)) {
                System.out.println(character.getName());
            }
        }
    }

    public void filterCharactersByProductOrigin(String origin) {
        for (Character character : characters) {
            for (Product product : character.getProducts()) {
                if (product.getOrigin().equals(origin)) {
                    System.out.println(character.getName());
                }
            }
        }
    }

    public void sortCharacterProducts(int characterId, boolean ascending) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                List<Product> products = character.getProducts();
                products.sort(Comparator.comparingDouble(Product::getPrice));
                if (!ascending) {
                    Collections.reverse(products);
                }
                System.out.println("Products for " + character.getName() + ":");
                for (Product product : products) {
                    System.out.println(product);
                }
                return;
            }
        }
    }

}
