package SwagLabs_Product_Sorting.Product;

import java.util.Objects;

public class Product {
    private String Name;
    public Double Price;

    public Product(String name, Double price) {
        Name = name;
        Price = price;
    }

    public String getName() {
        return Name;
    }

    public Double getPrice() {
        return Price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(Name, product.Name) && Objects.equals(Price, product.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
