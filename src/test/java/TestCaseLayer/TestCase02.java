package TestCaseLayer;

import BaseLayer.BaseClass;
import PagesLayer.Case2page;
import org.testng.annotations.Test;

@Test
public class TestCase02 extends BaseClass
{
    public void execute()
    {
        Case2page c2=new Case2page(driver);
        c2.loginpage();
    }
}
