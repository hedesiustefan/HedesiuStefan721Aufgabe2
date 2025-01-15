package Models;

public class Product {
    private String name;
    private double price;
    private String origin;

    public Product(String name, double price, String origin) {
        this.name = name;
        this.price = price;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", origin='" + origin + '\'' +
                '}';
    }
}
