package PagesLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Homepage
{
    WebDriver driver;
    public Homepage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath =" //span[normalize-space()='My Account']")
    WebElement MyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement Register;

    public void clickAccount()
    {

        MyAccount.click();
    }

    public void clickRegister()
    {
        Register.click();
    }
}