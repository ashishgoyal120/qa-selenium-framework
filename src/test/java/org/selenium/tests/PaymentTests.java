package org.selenium.tests;
import org.selenium.annotations.*;
import org.selenium.base.BaseTest;
import org.selenium.enums.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentTests extends BaseTest {



	@FrameworkAnnotation(author = { AuthorType.ASHISH, AuthorType.ANISHA }, category = { CategoryType.SANITY})
	@Test(groups = { "SANITY"})
	public void verifyUPIPayment() {
        Assert.assertEquals(true, true);	
    }
	
	@FrameworkAnnotation(author = { AuthorType.ASHISH}, category = { CategoryType.REGRESSION })
	@Test(groups = { "REGRESSION" })
	public void verifyCardPayment() {
        Assert.assertEquals(true, true);
    }

    @FrameworkAnnotation(author = { AuthorType.ASHISH }, category = { CategoryType.REGRESSION })
    @Test(groups = { "REGRESSION" })
    public void verifyOnlineBankPayment() {
        Assert.assertEquals(true, true);
    }
	

}