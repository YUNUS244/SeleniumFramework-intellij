package PagesLayer;

import UtilsLayer.Utilityclass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.File;

public class Case22page
{
    WebDriver driver;
    Utilityclass uc;

    public Case22page(WebDriver driver)
    {
        this.driver=driver;
        this.uc=new Utilityclass(driver);
        PageFactory.initElements(driver,this);

    }

    @FindBy(xpath = "//h2[normalize-space()='recommended items']")
    WebElement recommended_items;

    @FindBy(xpath = "//h2[contains(text(),\"recommended items\")]/following::div/a[contains(text(),\"Add to cart\")]")
    WebElement add_to_cart;

    @FindBy(xpath = "//button[@class='btn btn-success close-modal btn-block']")
    WebElement cont_shop;

    @FindBy(xpath = "//a[@href=\"/view_cart\"]")
    WebElement cart_link;

    @FindBy(xpath = "//a[normalize-space()='Blue Top']")
    WebElement verify_cart;

    //3. Scroll to bottom of page
    public void scroolpage()
    {
        System.out.println("*********TEST STARTED********");
        uc.scrooltoview(recommended_items);
        System.out.println("1 method completed");
    }
    //4. Verify 'RECOMMENDED ITEMS' are visible
    public void verify_recommended_visible()
    {
        //String expected_text="RECOMMENDED ITEMS";
        //String actual=recommended_items.getText();
        Assert.assertTrue(recommended_items.isDisplayed(),"recommended page not displayed");
       // Assert.assertEquals(actual, expected_text,"both are not same");
        System.out.println("2 method completed");
    }
    //5. Click on 'Add To Cart' on Recommended product
    public void addtocart()
    {

        uc.elementtobeClickable(add_to_cart).click();
        uc.elementtobeClickable(cont_shop).click();
        System.out.println("3 method completed");

    }
    //6. Click on 'View Cart' button
    public void click_on_cart()
    {
        uc.elementtobeClickable(cart_link).click();
        System.out.println("4 method completed");

    }
    //7. Verify that product is displayed in cart page
    public void verifycart()
    {
        Assert.assertTrue(verify_cart.isDisplayed(),"recommended prdo not displayed");
        System.out.println("5 method completed");
        System.out.println("*********TEST PASSED********");


    }
    public void takescreenshot(WebDriver driver,String filename)
    {
        try{
            File srcfile=recommended_items.getScreenshotAs(OutputType.FILE);
            File targetfile=new File(System.getProperty("user.dir")+"\\screenshots\\logo.png");
            srcfile.renameTo(targetfile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
