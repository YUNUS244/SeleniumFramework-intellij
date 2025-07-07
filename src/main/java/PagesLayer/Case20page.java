package PagesLayer;

import UtilsLayer.Utilityclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.Properties;

public class Case20page
{
    Properties p;
    WebDriver driver;
    Utilityclass uc;
    public Case20page(WebDriver driver, Properties p)
    {
        this.driver=driver;
        this.p=p;
        PageFactory.initElements(driver, this);
        this.uc=new Utilityclass(driver);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement productslink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement allproductstext;

    @FindBy(xpath = "//input[@id='search_product']")
    WebElement searchprodbox;

    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement search;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement searchedprodtext;

    @FindBy(xpath = "//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']")
    WebElement cartbtn;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    WebElement contshop;

    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement loginsignup;

    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement loginEmail;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;


    //click on products

    public void prodlink()
    {
        uc.elementtobeClickable( productslink).click();
    }

    //verify all products are visible
    public void verifyAllprodtext()
    {
        String expectedtext = "ALL PRODUCTS";
        String actualtext = uc.visibilityofelement(allproductstext).getText();
        Assert.assertEquals(expectedtext, actualtext);
    }

    //search products
    public void searchprod()
    {
        uc.elementtobeClickable(searchprodbox).sendKeys("Jeans");
        uc.elementtobeClickable(search).click();
    }


    //verify all products are visible
    public void verifySearchedprods()
    {
        String expectedtext = "SEARCHED PRODUCTS";
        String actualtext = uc.visibilityofelement(searchedprodtext).getText();
        Assert.assertEquals(expectedtext, actualtext);
    }
    //7. Verify all the products related to search are visible // 8. Add those products to cart

    public void seachedprodvisible()
    {
        List<WebElement> elements=driver.findElements(By.xpath("//p[contains(text(),'Jeans')]/ancestor::div[@class='productinfo text-center']//a[@class='btn btn-default add-to-cart']"));

        for(WebElement results:elements)
        {
            uc.elementtobeClickable(results).click();
            uc.elementtobeClickable(contshop).click();
        }
    }

    //9. Click 'Cart' button and verify that products are visible in cart

    public void clickcartandverify()
    {
        uc.elementtobeClickable(cartbtn).click();
        List<WebElement> cartitems=driver.findElements(By.xpath("//p[contains(text(),\"Jeans\")]"));
        Assert.assertTrue(cartitems.size()>0,"No jeans in cart");
        int count=0;
        for(WebElement cart:cartitems)
        {
            System.out.println(cart.getText());
            count=count+1;
        }
        System.out.println(count);
    }
    //10. Click 'Signup / Login' button and submit login details

    public void login()
    {
        uc.elementtobeClickable(loginsignup).click();
        uc.visibilityofelement(loginEmail).sendKeys("baba90@ae.com");
        uc.visibilityofelement(password).sendKeys("90909090");
        uc.elementtobeClickable(loginBtn).click();
    }

    //11. Again, go to Cart page 12. Verify that those products are visible in cart after login as well
    public void checkclickcartandverify()
    {
        uc.elementtobeClickable(cartbtn).click();
        List<WebElement> cartitems=driver.findElements(By.xpath("//p[contains(text(),\"Jeans\")]"));
        Assert.assertTrue(cartitems.size()>0,"No jeans in cart");
        int count=0;
        for(WebElement cart:cartitems)
        {
            System.out.println(cart.getText());
            count=count+1;
        }
        System.out.println(count);
    }
}
