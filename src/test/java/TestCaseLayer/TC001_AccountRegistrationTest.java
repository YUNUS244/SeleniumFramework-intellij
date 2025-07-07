package TestCaseLayer;

import BaseLayer.BaseClass;
import PagesLayer.Homepage;
import PagesLayer.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TC001_AccountRegistrationTest extends BaseClass
{

    @Test
    public void verify_accountregister()
    {
        try {

            Homepage hp = new Homepage(driver);
            logger.info("test execution started");
            hp.clickAccount();
            logger.info("clicked on account ");
            hp.clickRegister();
            logger.info("clicked on register ");

            RegistrationPage rp = new RegistrationPage(driver);
            logger.info("providing details");
            rp.setFirstname();
            rp.setLastname();
            rp.setEmail();
            rp.setPhonenumber();
            rp.setPassword();
            rp.setPasswordconfirm();
            rp.setNewsletter();
            rp.setAgree();
            rp.setContinuebtn();
            logger.info("validating expected message ");
            String msgconfirm = rp.getconfirmationmsg();
            Assert.assertEquals(msgconfirm, "Your Account Has Been Created!");
        } catch (Exception e)
        {
            logger.error("Test failed");
            logger.debug("Debug logs");
            Assert.fail();
        }
    }


}
