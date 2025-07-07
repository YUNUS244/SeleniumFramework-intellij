package PagesLayer;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage
{
    WebDriver driver;
    public RegistrationPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement firstname;

    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement lastname;

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement email;

    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement phonenumber;

    @FindBy(xpath = "//input[@id='input-password']")
    WebElement password;

    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement passwordconfirm;

    @FindBy(xpath = "//input[@value='0']")
    WebElement newsletter;

    @FindBy(xpath = " //input[@name='agree']")
    WebElement agree;

    @FindBy(xpath = " //input[@value='Continue']")
    WebElement continuebtn;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement actcreationmsg;

    public void setFirstname()
    {
        firstname.sendKeys("yunus");
    }
    public void setLastname()
    {
        lastname.sendKeys("s");
    }
    public void setEmail()
    {
        email.sendKeys(generateEmail()+"@opencart.com");
    }
    public void setPhonenumber()
    {
        phonenumber.sendKeys("8989898989");
    }
    public void setPassword()
    {
        password.sendKeys("1111");
    }
    public void setPasswordconfirm()
    {
        passwordconfirm.sendKeys("1111");
    }
    public void setNewsletter()
    {
        newsletter.click();
    }
    public void setAgree()
    {
        agree.click();
    }
    public void setContinuebtn()
    {
        continuebtn.click();
    }



    public String getconfirmationmsg()
    {
    try
    {
      return   (actcreationmsg.getText());
    }
    catch (Exception e)
    {
        return (e.getMessage());
    }
    }
    public String generateEmail()
    {
        String randomEmail=RandomStringUtils.randomAlphabetic(5);
        return randomEmail;
    }



}
