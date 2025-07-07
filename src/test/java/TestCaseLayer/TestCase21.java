package TestCaseLayer;

import BaseLayer.BaseClass;
import PagesLayer.Case21page;
import org.testng.annotations.Test;

@Test
public class TestCase21 extends BaseClass
{
    //WebDriver driver;
    public void addreview_forprod()
    {
        Case21page cp=new Case21page(driver);
        cp.clickprodlink();
        cp.verifyallprodpage();
        cp.clickviewprod();
        cp.verify_write_your_review();
        cp.enter_details();
        cp.success_msg();
    }
}
