package PagesLayer;

import UtilsLayer.Utilityclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class Case2page
{
    WebDriver driver;
    Utilityclass uc;

    public Case2page(WebDriver driver)
    {
        this.driver=driver;
        this.uc=new Utilityclass(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[normalize-space()='Signup / Login']")
    WebElement signup;
    @FindBy(xpath = "//input[@data-qa='login-email']")
    WebElement email;
    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement loginBtn;

    public void loginpage()
    {
        uc.elementtobeClickable(signup).click();
        uc.visibilityofelement(email).sendKeys("baba90@ae.com");
        uc.visibilityofelement(password).sendKeys("90909090");
        uc.elementtobeClickable(loginBtn).click();

        //assert whether login page is visible

        WebElement actout=driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
        String expout="Logout";
        String actout1=actout.getText();
        Assert.assertEquals(actout1, expout,"login failed");
    }
}
