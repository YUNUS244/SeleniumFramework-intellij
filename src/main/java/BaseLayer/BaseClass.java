package BaseLayer;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {
    public WebDriver driver;
    public Properties p;
    public Logger logger;

    @BeforeClass
    public void openBrowser() throws IOException {
        // Load properties
        FileReader fr = new FileReader("./src/test/resources/config.properties");
        p = new Properties();
        p.load(fr);

        logger = LogManager.getLogger(this.getClass());

        // ✅ Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        // ✅ Browser configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(p.getProperty("appURL"));

        logger.info("Launching browser");
        logger.info("Navigating to URL: " + p.getProperty("appURL"));
    }

    @AfterClass
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
