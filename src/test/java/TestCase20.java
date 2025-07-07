import BaseLayer.BaseClass;
import PagesLayer.Case20page;
import org.testng.annotations.Test;

@Test
public class TestCase20 extends BaseClass
{
    public void checktestcase20()
    {
        Case20page cp=new Case20page(driver,p);
        cp.prodlink();
        cp.verifyAllprodtext();
        cp.searchprod();
        cp.verifySearchedprods();
        cp.seachedprodvisible();
        cp.clickcartandverify();
        cp.login();
        cp.checkclickcartandverify();
    }
}
