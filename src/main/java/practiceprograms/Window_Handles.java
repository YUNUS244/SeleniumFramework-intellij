package practiceprograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Window_Handles
{
    public static void main(String args[])
    {
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");

        String parentwindow=driver.getWindowHandle();
        System.out.println("parentwindow"+parentwindow);
        //click for a window
        WebElement childwindow= driver.findElement(By.id("newWindowBtn"));
        childwindow.click();
        System.out.println("parentwindow"+childwindow);

        Set<String> handles=driver.getWindowHandles();
        for(String handle:handles)
        {
            if (!handle.equals(parentwindow))
            {
                driver.switchTo().window(handle);
                driver.manage().window().maximize();
                WebElement firstname;
                driver.findElement(By.id("firstName")).sendKeys("HYR");
                WebElement lastname;
                driver.findElement(By.id("lastName")).sendKeys("TUTORIALS");
                WebElement languages;
                driver.findElement(By.id("englishchbx")).click();
                driver.findElement(By.id("hindichbx")).click();
            }
        }
        driver.close();




    }
}
