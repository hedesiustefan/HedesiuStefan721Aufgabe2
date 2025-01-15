package Models;

import java.util.List;

public class Character {
    private int id;
    private String name;
    private String origin;
    private List<Product> products;

    public Character(int id, String name, String origin, List<Product> products) {
        this.id = id;
        this.name = name;
        this.origin = origin;
        this.products = products;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", origin='" + origin + '\'' +
                ", products=" + products +
                '}';
    }
}
