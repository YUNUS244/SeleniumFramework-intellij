package TestCaseLayer;

import BaseLayer.BaseClass;
import PagesLayer.Case22page;
import org.testng.annotations.Test;

@Test
public class TestCase22 extends BaseClass
{
    public void executeTest()
    {
        Case22page cp=new Case22page(driver);
        cp.scroolpage();
        cp.takescreenshot(driver,"logo");
        cp.verify_recommended_visible();
        cp.addtocart();
        cp.click_on_cart();
        cp.verifycart();
    }
}
