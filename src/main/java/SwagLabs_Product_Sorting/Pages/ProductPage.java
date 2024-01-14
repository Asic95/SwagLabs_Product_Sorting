package SwagLabs_Product_Sorting.Pages;

import SwagLabs_Product_Sorting.For_Sorting.SortingRules;
import SwagLabs_Product_Sorting.Product.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductPage {

    private WebDriverWait wait;

    @FindBy(css = "div[class='inventory_list'] div[class='inventory_item']")
    private List<WebElement> inventory_list;

    @FindBy(css = "div[class='inventory_item_name']")
    private WebElement item_name;

    @FindBy(css = "div[class='inventory_item_price']")
    private WebElement item_price;

    @FindBy(css = "#inventory_filter_container > select")
    private WebElement filter_container;

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public int checkProducts() {
        return inventory_list.size();
    }

    public List<Product> get_inventory_list() throws InterruptedException {

//        List<WebElement> productItems = WebDriverHolder.getInstance().getDriver().findElements(By.xpath("//div[@class='product-container']"));
//        String xpathProductName = "div[class='right-block'] a[class='product-name']";
//        String xpathProductPrice = "div[class='right-block'] div[class='content_price'] span[class='price product-price']";

        List<Product> productList = new ArrayList<>();

        for (WebElement product : inventory_list) {
            String parsedName = product.findElement(By.cssSelector("div[class='inventory_item_name']")).getText();
            String parsedPrice = product.findElement(By.cssSelector("div[class='inventory_item_price']")).getText();

            Double productPrice = Double.parseDouble(parsedPrice.replace("$", "").replace(",", ".").replace(" ", ""));
            Product productModel = new Product(parsedName, productPrice);

            productList.add(productModel);
        }
        return productList;
    }

    public void sortBy(SortingRules SortingRules) throws InterruptedException {
        Select select = new Select(filter_container);
        select.selectByValue(SortingRules.getValue());
        Thread.sleep(1500);
        //sleep(1500);
        //return new ProductPage();
    }
}
