package SwagLabs_Product_Sorting.Product;

import java.util.Objects;

//@Data
//@Accessors(chain = true)
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

    public void setName(String name) {
        Name = name;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
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
