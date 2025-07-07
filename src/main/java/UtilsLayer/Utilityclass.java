package UtilsLayer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utilityclass
{
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;

    public Utilityclass(WebDriver driver)
    {
        this.driver=driver;
        this.js=(JavascriptExecutor) driver;
        this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    public WebElement visibilityofelement(By locator)
    {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement elementtobeClickable( By locator)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public WebElement visibilityofelement(WebElement element)
    {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement elementtobeClickable(WebElement element)
    {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrooltoview(WebElement element)
    {
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public void clickthroughjs(WebElement element)
    {
        js.executeScript("arguments[0].click();",element);
    }


}
