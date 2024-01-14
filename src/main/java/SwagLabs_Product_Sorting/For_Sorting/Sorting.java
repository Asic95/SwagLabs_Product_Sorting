package SwagLabs_Product_Sorting.For_Sorting;

import SwagLabs_Product_Sorting.Product.Product;

import java.util.Comparator;

public class Sorting {
    public static Comparator<Product> getComparatorForSorting(SortingRules sortDirection) {
        switch (sortDirection) {
            case PRICE_LOW_TO_HIGH:
                return Comparator.comparing(Product::getPrice).thenComparing(Product::getName);
            case PRICE_HIGH_TO_LOW:
                return Comparator.comparing(Product::getPrice).reversed().thenComparing(Product::getName);
            case NAME_A_TO_Z:
                return Comparator.comparing(Product::getName).thenComparing(Product::getPrice);
            case NAME_Z_TO_A:
                return Comparator.comparing(Product::getName).reversed().thenComparing(Product::getPrice);
        }
        return null;
    }
}
