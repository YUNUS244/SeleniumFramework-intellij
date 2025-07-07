package PagesLayer;

import UtilsLayer.Utilityclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Case21page {
    WebDriver driver;
    Utilityclass uc;

    public Case21page(WebDriver driver) {
        this.driver = driver;
        this.uc = new Utilityclass(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/products']")
    WebElement prodlink;

    @FindBy(xpath = "//h2[@class='title text-center']")
    WebElement allprodpage;

    @FindBy(xpath = "//a[contains(text(),'View Product')]/ancestor::div[@class='choose']")
    WebElement viewprod;

    @FindBy(xpath = "//a[normalize-space()='Write Your Review']")
    WebElement writereview;

    @FindBy(xpath = "//input[@id='name']")
    WebElement name;

    @FindBy(xpath = "//input[@id='email']")
    WebElement email;

    @FindBy(xpath = "//textarea[@id='review']")
    WebElement add_review;

    @FindBy(xpath = "//button[@id='button-review']")
    WebElement submit_btn;

    @FindBy(xpath = "//span[contains(text(),'Thank you for your review.')]")
    WebElement success;

    public void clickprodlink() {
        uc.elementtobeClickable(prodlink).click();
    }

    public void verifyallprodpage() {
        String expectedtext = "ALL PRODUCTS";
        String actualtext = allprodpage.getText();
        Assert.assertEquals(actualtext, expectedtext, "Not navigated to all products page");
    }

    public void clickviewprod() {
        uc.elementtobeClickable(viewprod).click();
    }

    public void verify_write_your_review() {
        String expectedText = "WRITE YOUR REVIEW";
        String actualText = writereview.getText();
        Assert.assertEquals(actualText, expectedText, "Write review section not visible");
    }

    public void enter_details() {
        uc.visibilityofelement(name).sendKeys("shaik");
        uc.visibilityofelement(email).sendKeys("baba90@ae.com");
        uc.visibilityofelement(add_review).sendKeys("Product is good, can buy without any doubt");
        uc.elementtobeClickable(submit_btn).click();
    }

    public void success_msg() {
        String expectedText = "Thank you for your review.";
        String actualText = success.getText();
        Assert.assertEquals(actualText, expectedText, "Review not submitted successfully");
    }
}
