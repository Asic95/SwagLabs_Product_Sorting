package SwagLabs_Product_Sorting;

import SwagLabs_Product_Sorting.For_Sorting.Sorting;
import SwagLabs_Product_Sorting.For_Sorting.SortingRules;
import SwagLabs_Product_Sorting.Pages.ProductPage;
import SwagLabs_Product_Sorting.Product.Product;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class Product_sorting_test extends BaseTestClass {

    @DataProvider
    public Object[][] sorting_methods() {
        return new Object[][]{{"NAME_A_TO_Z"}, {"NAME_Z_TO_A"}, {"PRICE_LOW_TO_HIGH"}, {"PRICE_HIGH_TO_LOW"}};
    }

    @Test(testName = "Перевірка сортування товарів", dataProvider = "sorting_methods")
    public void Check_product_sorting(String sorting_methods) throws InterruptedException {
        ProductPage productPage = new ProductPage(driver);

        List<Product> List_1 = productPage.get_inventory_list();

        productPage.sortBy((SortingRules.valueOf(sorting_methods)));    // виконуємо сортування на сайті
        List<Product> List_2 = productPage.get_inventory_list();        // зчитуємо відсортовані дані

        List_1.sort(Sorting.getComparatorForSorting(SortingRules.valueOf(sorting_methods)));
        Assert.assertEquals(List_1, List_2, sorting_methods);
    }

}
