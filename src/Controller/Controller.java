package Controller;

import Models.Character;
import Models.Product;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Controller {
    private final List<Product> products;
    private final List<Models.Character> characters;

    /**
     * Constructor for Controller
     *
     * @param products a list of products
     * @param characters a list of characters
     */
    public Controller(List<Product> products, List<Character> characters) {
        this.products = products;
        this.characters = characters;
    }

    /**
     * Add a new product to the system
     *
     * @param product product to add
     */
    public void addProduct(Product product) {
        products.add(product);
    }

    /**
     * Remove a product from the system
     *
     * @param name name of the product to remove
     */
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

    /**
     * List all products
     *
     * @return products
     */
    public List<Product> listProducts() {
        return products;
    }

    /**
     * get a product by name
     *
     * @param productName name of the product
     * @return the product
     */
    public Product getProduct(String productName) {
        for (Product product : products) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Add a character
     *
     * @param character to add
     */
    public void addCharacter(Character character) {
        characters.add(character);
    }

    /**
     * Delete a character
     *
     * @param characterId id of the character to remove
     */
    public void deleteCharacter(Integer characterId) {
        characters.removeIf(character -> character.getId() == characterId);
    }

    /**
     * Update a character
     *
     * @param id
     * @param newName
     * @param newOrigin
     * @param newProducts
     */
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

    /**
     * List all characters
     *
     * @return a list of characters
     */
    public List<Character> listCharacters() {
        return characters;
    }

    /**
     * get a character by id
     *
     * @param characterId id of the character
     * @return teh character
     */
    public Character getCharacter(Integer characterId) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                return character;
            }
        }
        return null;
    }

    /**
     * get all products from a character
     *
     * @param characterId id of the character
     * @return the list of products
     */
    public List<Product> getCharactersProducts(int characterId) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                return character.getProducts();
            }
        }
        return null;
    }

    /**
     * get characters from the same origin
     *
     * @param origin origin of the characters
     */
    public void charactersByOrigin(String origin) {
        for (Character character : characters) {
            if (character.getOrigin().equals(origin)) {
                System.out.println(character.getName());
            }
        }
    }

    /**
     * get characters with products from the same origin
     *
     * @param origin origin of the products
     */
    public void filterCharactersByProductOrigin(String origin) {
        for (Character character : characters) {
            for (Product product : character.getProducts()) {
                if (product.getOrigin().equals(origin)) {
                    System.out.println(character.getName());
                }
            }
        }
    }

    /**
     * sort products of characters by price
     *
     * @param characterId id of the character
     * @param ascending order of the sort
     */
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

    /**
     * Add products to the product list of a charcter
     *
     * @param characterId id of the character
     * @param newProduct the new product
     */
    public void addProductsToCharactersList(int characterId, Product newProduct) {
        if (getProduct(newProduct.getName()) == null) {
            addProduct(newProduct);
        }
        for (Character character : characters) {
            if (character.getId() == characterId) {
                character.getProducts().add(newProduct);

            }
        }
    }

    /**
     * Remove products from the product list of a character
     *
     * @param characterId id of the character
     * @param newProduct the product to remove
     */
    public void deleteProductsFromCharactersList(int characterId, Product newProduct) {
        for (Character character : characters) {
            if (character.getId() == characterId) {
                character.getProducts().remove(newProduct);
            }
        }
    }

}
